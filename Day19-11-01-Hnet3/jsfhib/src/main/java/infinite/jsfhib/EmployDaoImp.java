package infinite.jsfhib;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
@ManagedBean(name="eDao")
@SessionScoped
public class EmployDaoImp implements EmployDAO{
	SessionFactory sf;
	Session session;
	Query query;
	@Override
	public List<Employ> showEmployDao() {
		 sf = SessionHelper.getConnection();
		 session = sf.openSession();
		 query = session.createQuery("from Employ");
		List<Employ> employList = query.list();
		return employList;
	}

	@Override
	public String searchEmploy(int empno) {
Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		 sf = SessionHelper.getConnection();
		 session=sf.openSession();
		 query = session.createQuery("From Employ where empno="+empno);
		 List<Employ> list = query.list();
		 if(list.size()==0)
			{
				return "Employ Not Found";
			}
			else
			{
				Employ employ = list.get(0);
				map.put("editEmploy", employ);
			}
		 return "UpdateEmploy.xhtml?faces-redirect=true";
	}

	@Override
	public String updateEmploy(Employ employ) {
		
		sf=SessionHelper.getConnection();
		session=sf.openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		session.update(employ);
		t.commit();
			
		return "ShowEmploy.xhtml?faces-redirect=true";
	}

	@Override
	public String deleteEmploy(int empno) {
		sf = SessionHelper.getConnection();
		 session=sf.openSession();
		 Query query= session.createQuery("from Employ where empno="+empno);
			List<Employ> list = query.list();
			if(list.size()==0)
			{
				return "Employ not found.....";
			}
			else
			{
				Employ employ = list.get(0);
				Transaction t = session.beginTransaction();
				session.delete(employ);
				t.commit();
				
			}
		return "ShowEmploy.xhtml?faces-redirect=true";
	}

	@Override
	public String insertEmploy(Employ employ) {
		sf = SessionHelper.getConnection();
		 session=sf.openSession();
		 Transaction t = session.beginTransaction();
		 session.save(employ);
		 t.commit();
		return "ShoWEmploy.xhtml?faces-redirect=true";
	}
	

}
