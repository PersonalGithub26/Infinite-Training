package com.booking;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "cDao")
@SessionScoped
public class CustomerDaoImp implements CustomerDAO{

	@Override
	public String addCustomerDao(Customer customer) {
		String pwd = EntryptPassword.getCode(customer.getPassword());
		customer.setPassword(pwd);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		return "Success.xhtml?faces-redirect=true";
	}

	@Override
	public String validateMe(Customer customer) {
		String pwd = EntryptPassword.getCode(customer.getPassword());
		Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("userName", customer.getUserName()));
		cr.add(Restrictions.eq("password", pwd.trim()));
		cr.setProjection(Projections.rowCount());
		Long count = (Long) cr.uniqueResult();
		if(count == 1)
		{
			return "Success.xhtml?faces-redirect=true";
		}
		else {
			return "CustomerLogin.xhtml?faces-redirect=true";
		}
		
	}

	@Override
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	    return "CustomerLogin.xhtml?faces-redirect=true";
	}

	
	
	

}
