package com.java.hibjsf;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "uDao")
@SessionScoped
public class UserDaoImpl implements UserDAO{


	private List<SelectItem> questions;

	private List<SelectItem> gender;

	//private String resetPassword;




	//	public String getResetPassword() {
	//		return resetPassword;
	//	}
	//
	//
	//
	//
	//	public void setResetPassword(String resetPassword) {
	//		this.resetPassword = resetPassword;
	//	}




	public UserDaoImpl()
	{
		questions = Arrays.stream(Questions.values())
				.map(q -> new SelectItem(q, q.name()))
				.collect(Collectors.toList());
		System.out.println(questions);

		gender=Arrays.stream(Gender.values()).map(g -> new SelectItem(g,g.name())).collect(Collectors.toList());
	}




	public List<SelectItem> getGender() {
		return gender;
	}




	public void setGender(List<SelectItem> gender) {
		this.gender = gender;
	}









	public List<SelectItem> getQuestions() {
		return questions;
	}




	public void setQuestions(List<SelectItem> questions) {
		this.questions = questions;
	}




	@Override
	public String addUserDao(User user) {
		String password = EntryptPassword.getCode(user.getPassword());
		String profilePassword = EntryptPassword.getCode(user.getProfilePassword());
		String answer = EntryptPassword.getCode(user.getAnswer());
		user.setPassword(password);
		user.setProfilePassword(profilePassword);
		user.setAnswer(answer);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		return "Thanks.xhtml?faces-redirect=true";
	}

	@Override
	public String forgetPasswordDao(User user) {

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(User.class);
		//cr.add(Restrictions.eq("userName", user.getUserName()));
		cr.add(Restrictions.eq("question", user.getQuestion()));
		String answer = EntryptPassword.getCode(user.getAnswer());
		cr.add(Restrictions.eq("answer", answer));
		cr.setProjection(Projections.rowCount());
		long count = (Long)cr.uniqueResult();
		if (count==1) {
			String resetPassword = EntryptPassword.getCode(user.getPassword());
			user.setPassword(resetPassword);
			Transaction transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
			return "UserLogin.xhtml?faces-redirect=true";
		} else {
			return "UserForgetPassword.xhtml?faces-redirect=true";
		}
	}



	public String verifyProfilePassword(User user) {

		String profilePassword = EntryptPassword.getCode(user.getProfilePassword());
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(User.class);
		// cr.add(Restrictions.eq("userName", user.getUserName()));
		cr.add(Restrictions.eq("profilePassword", profilePassword.trim()));
		cr.setProjection(Projections.rowCount());
		long count = (Long) cr.uniqueResult();
		System.out.println(count);
		if (count == 1) {
			user.setPassword(null);
			return "NewReset.xhtml?faces-redirect=true";
		} else {
			return "Failure.xhtml?faces-redirect=true";
		}
	}






	@Override
	public String ValidateUser(User user) {

		String encr = EntryptPassword.getCode(user.getPassword());
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("userName", user.getUserName()));
		cr.add(Restrictions.eq("password", encr.trim()));
		cr.setProjection(Projections.rowCount());
		long  count =(Long)cr.uniqueResult();
		if (count==1) {
			sessionMap.put("uId", user);
			return "UserDashBoard.xhtml?faces-redirect=true";			
		} else {
			return "UserLogin.xhtml?faces-redirect=true";
		}

	}


	public User findObjectuser(int userid) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("userId", userid));
		User user = (User) cr.uniqueResult();
		return user;
		
	}



	@Override
	public String resetPasswordDao(User user) {


		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(User.class);
		String newEncr = EntryptPassword.getCode(user.getPassword());
		cr.add(Restrictions.eq("password", newEncr));
		cr.setProjection(Projections.rowCount());
		System.out.println(user);
		long count = (Long) cr.uniqueResult();
		if (count == 1) {
			Projection proj = Projections.distinct(Projections.property("userId"));
			cr.setProjection(proj);
			int existiingUserId = (int) cr.list().get(0);
			User updatedUser = findObjectuser(existiingUserId);
			updatedUser.setPassword(EntryptPassword.getCode(user.getPassword()));
			Transaction trans = session.beginTransaction();
			session.update(updatedUser);
			trans.commit();
			return "UserLogin.xhtml?faces-redirect=true";
		} 
		sessionMap.put("error","Invalid Credintials" );

		return  "NewReset.xhtml?facse-redirect=true";



	}
}
