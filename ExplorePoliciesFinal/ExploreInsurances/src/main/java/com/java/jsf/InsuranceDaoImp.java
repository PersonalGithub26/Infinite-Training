package com.java.jsf;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


@ManagedBean(name = "iDao")
@SessionScoped
public class InsuranceDaoImp implements InsuranceDAO {
	
	private String planType;
	private String planId;
	
	

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	
	
	@Override
	public List<Insurance> showPolicies() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Insurance.class);
		List<Insurance> insurances = cr.list();
		return insurances;
	}

	public String searchPolicyTypeToGetId(String policyType)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Insurance.class);
		cr.add(Restrictions.eq("planType", policyType));
		Projection projection = Projections.property("planId");
		cr.setProjection(projection);
		String policyId = (String) cr.uniqueResult();

//		Object sesObject =
//				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
//						"planId", policyId);

		return policyId;
	}
	
	public void onNameChange(ValueChangeEvent e)
	{
		this.planType=e.getNewValue().toString();
	}
	
	public List<Insurance> showPoliciesByCompany()
	{
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Insurance.class);
		Projection projection = Projections.distinct(Projections.property("planType"));
		cr.setProjection(projection);
		String Id=(String) sessionMap.get("cId");
		System.out.println(Id);
		cr.add(Restrictions.eq("cId", Id));
		List<Insurance> insurances = cr.list();
		System.out.println(insurances);
		return insurances;
		
	}
	
	public void policyTypeChangeEvent(ValueChangeEvent e)
	{
		String pName = e.getNewValue().toString();
		String pId = searchPolicyTypeToGetId(pName);
		this.planId=pId;
		this.planType=pName;
	}
	
	public String getInsuranceDetails(String pId)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Insurance.class);
		Projection projection = Projections.property("keyBenifits");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("planId", pId));
		String details = (String) cr.uniqueResult();
		return details;
	}



}
