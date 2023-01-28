package com.jsf;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "Dao")
@SessionScoped
public class EmployDaoImp implements EmployDAO{

	@Override
	public List<Employ> showEmploy() {
		SessionFactory sf =SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Employ.class);
		List<Employ> employs = criteria.list();
		
		return employs;
	}
	
	    private Employ employ = new Employ();
	    private List<Employ> employees = null;
	    
	    

	    public Employ getEmploy() {
			return employ;
		}



		public void setEmploy(Employ employ) {
			this.employ = employ;
		}



		public List<Employ> getEmployees() {
			return employees;
		}



		public void setEmployees(List<Employ> employees) {
			this.employees = employees;
		}

		public String searchEmployee() {
	        SessionFactory sf = SessionHelper.getConnection();
	        Session session = sf.openSession();
	        session.beginTransaction();

	        Criteria criteria = session.createCriteria(Employ.class);
	        criteria.add(Restrictions.eq("empno", employ.getEmpno()));
	        employees = criteria.list();

	        session.getTransaction().commit();
	        session.close();
	        return "employees";
	    }
		
		
	   
	}
	


