package com.java.ejb;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


public class EmployDAO {
	
	public List<Employ> showEmploy()
	{
	SessionFactory sf = SessionHelper.getConnection();
	Session session = sf.openSession();
	//Query query = session.createQuery("from Employ");
	Criteria cr = session.createCriteria(Employ.class);
	List<Employ> list = cr.list();
	return list;
	}
	
	
	public Employ searchEmploy(int empno)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		cr.add(Restrictions.eq("empno", empno));
		Employ employ = (Employ) cr.uniqueResult();
		return employ;
	}
	

}
