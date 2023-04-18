package com.java.jsf;

import java.util.List;

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


@ManagedBean(name = "cDao")
@SessionScoped
public class CompanyDaoImp implements CompanyDAO {
	
	
	private String companyId;
	private String companyName;
	
	

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	

	@Override
	public List<Company> showCompanyNames() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Company.class);
		criteria.setProjection(Projections.distinct(Projections.property("companyName")));
		List<Company> companies = criteria.list();
		return companies;
	}
	
	public void onNameChanged(ValueChangeEvent e)
	{
		this.companyName= e.getNewValue().toString();
	}
	
	public String searchCompanyToGetId(String companyName)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Company.class);
		cr.add(Restrictions.eq("companyName",companyName ));
		Projection projection = Projections.property("cId");
		cr.setProjection(projection);
		String cId = (String) cr.uniqueResult();
		System.out.println("CompanyId" +cId);
		return cId;
	}
	
	public void companyNameChange(ValueChangeEvent e)
	{
		String cName= e.getNewValue().toString();
		String cId = searchCompanyToGetId(cName);
		this.companyId=cId;
		System.out.println("Valuechanged"+this.companyId);
		this.companyName= cName;
		System.out.println("Value Name"+this.companyName);
		Object sessObject = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cId", this.companyId);
	}
	
	

}
