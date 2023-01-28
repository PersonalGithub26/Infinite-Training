package com.booking;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "aDao")
@SessionScoped
public class AdminDaoImp implements AdminDAO {

	@Override
	public String addAdmin(Admin admin) {
		String pwd = EntryptPassword.getCode(admin.getPassword());
		admin.setPassword(pwd);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.save(admin);
		tx.commit();
		return "Success.xhtml?faces-redirect=true";
	}

	@Override
	public String ValidateMe(Admin admin) {
		String pwd = EntryptPassword.getCode(admin.getPassword());
		Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Admin.class);
		cr.add(Restrictions.eq("adminName", admin.getAdminName()));
		cr.add(Restrictions.eq("password", pwd.trim()));
		cr.setProjection(Projections.rowCount());
		long count = (long) cr.uniqueResult();
		if(count == 1)
		{
			return "AdminMain.xhtml?faces-redirect=true";
		}
		else {
			map.put("error", "Invalid Credentials...");
			return "AdminLogin.xhtml?faces-redirect=true";
		}
		
	}

}
