package com.java.jsfHib;

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
public class CompanyDaoImpl implements CompanyDAO{

	private String companyName;
	private String companyId;





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
		Criteria cr = session.createCriteria(Company.class);
		cr.setProjection(Projections.distinct(Projections.property("companyName")));
		List<Company> companyNames = cr.list();
		return companyNames;
	}

	public void onNameChanged(ValueChangeEvent e)
	{
		this.companyName = e.getNewValue().toString();
	}

	public String searchCompanyToGetId(String companyName)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Company.class);
		cr.add(Restrictions.eq("companyName", companyName));
		Projection projection = Projections.property("companyId"); 
		cr.setProjection(projection); 
		String cid = (String) cr.uniqueResult();
		System.out.println("company Id " +cid);
		return cid;
	}

	public void companyLocalCodeChange(ValueChangeEvent e)
	{
		String cName = e.getNewValue().toString();
		String cId = searchCompanyToGetId(cName);
		System.out.println(cId);
		this.companyId=cId;
		System.out.println("mapped ID"+this.companyId);
		this.companyName = cName;
		System.out.println(this.companyName);
		Object sesObject = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("companyId", this.companyId);

	}
}


