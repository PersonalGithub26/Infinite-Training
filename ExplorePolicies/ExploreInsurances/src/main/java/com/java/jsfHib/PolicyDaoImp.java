package com.java.jsfHib;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "pDao")
@SessionScoped
public class PolicyDaoImp {

	private String policyName;
	private ResourceBundle bundle;


	

	public ResourceBundle getBundle() {
		return bundle;
	}



	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}



	public String getPolicyName() {
		return policyName;
	}



	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	
	public List<Policy> showPolicies()
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		List<Policy> list = cr.list();
		return list;
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
		System.out.println(Id);
		cr.add(Restrictions.eq("cId", Id));
		List<Policy> list = cr.list();
		System.out.println(Id);
		return list;
	}

	
	
	
	public String submitPolicy() throws IOException {

		if(policyName.equals("Individual Health Insurance Plan"))
		{

			return "KeyBenifitsWithFile.xhtml?faces-redirect=true";
		}
		else 
		{
			return "AccordionPanel.xhtml?faces-redirect=true";
		}
	}
	
	public void init() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    bundle = context.getApplication().getResourceBundle(context, "project");
	}


	
	public PolicyDaoImp() {
	    bundle = ResourceBundle.getBundle("project");
	}

	public String getMessage(String key) {
	    String str = bundle.getString(key);
	    return str;
	}

}





