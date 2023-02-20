package com.java.jsfHib;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

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

@ManagedBean(name = "pdao")
@SessionScoped
public class PolicyDaoImp2 {

	private String policyType;
	private String policyId;


	public String getPolicyId() {
		return policyId;
	}



	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}


	
	
	
	public String getPolicyType() {
		return policyType;
	}



	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}



	public List<Policy> showPolicies()
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		List<Policy> list = cr.list();
		return list;
	}

	public void onNameChanged(ValueChangeEvent e)
	{
		this.policyType=e.getNewValue().toString();
	}
	
	public String searchPolicyByTypeToGetId(String policyType)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		cr.add(Restrictions.eq("planType", policyType ));
		Projection projection = Projections.property("planId");
		cr.setProjection(projection);
		String pId = (String) cr.uniqueResult();
		
		Object sesObject = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("policyId", pId);
		
		return pId;
		
	}
	
	public void policyTypeChangeEvent(ValueChangeEvent e) {
		String pName = e.getNewValue().toString();
		String pId = searchPolicyByTypeToGetId(pName);
		this.policyId = pId;
		this.policyType = pName;

	}
	public String getPolicyDetails(String pId)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		Projection projection = Projections.property("keyBenifits");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("planId", pId));
		String s = (String) cr.uniqueResult();
		return s;
		
	}

	public List<Policy> showPolicyNamesByCompId()
	{
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		Projection projection = Projections.distinct(Projections.property("planType")); 
		cr.setProjection(projection); 
		String Id = (String) sessionMap.get("companyId");
		cr.add(Restrictions.eq("cId", Id));
		List<Policy> list = cr.list();
		return list;
	}

	public String submitPolicy() throws IOException {
		
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String id = (String) sessionMap.get("pId");
		
		System.out.println(this.policyType);
		String s = searchPolicyByTypeToGetId(this.policyType);
		System.out.println(s);
		this.policyId=s;
		return "KeyBenifitsWithFile.xhtml?faces-redirect=true";
	}
	
	

}





