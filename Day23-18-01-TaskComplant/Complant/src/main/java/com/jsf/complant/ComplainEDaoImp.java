package com.jsf.complant;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@ManagedBean(name = "cDao")
@SessionScoped
public class ComplainEDaoImp implements ComplaintEDAO {

	@Override
	public String AddComplaint() {
		
		SessionFactory sf  = SessionHelper.getconnection();
		Session session = sf.openSession();
		
		return null; 
	}

	@Override
	public List<ComplaintE> ShowAllComplaint() {	
		SessionFactory sf = SessionHelper.getconnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(ComplaintE.class);
		List<ComplaintE> list = cr.list();
		return list;
	}
	 
	
	

}
