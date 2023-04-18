package com.cap.jsf;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;



@ManagedBean(name = "uDao")
@SessionScoped
public class UserDAO {

	private String userName;
	private String passsword;
	private String captchaInput;
	private String captchaImage;
	private boolean captchaVerified;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public String getCaptchaInput() {
		return captchaInput;
	}

	public void setCaptchaInput(String captchaInput) {
		this.captchaInput = captchaInput;
	}


	public String getCaptchaImage() {
		return captchaImage;
	}

	public void setCaptchaImage(String captchaImage) {
		this.captchaImage = captchaImage;
	}

	public boolean isCaptchaVerified() {
		return captchaVerified;
	}

	public void setCaptchaVerified(boolean captchaVerified) {
		this.captchaVerified = captchaVerified;
	}


	public User getUserByUserName(String userName)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("userName",userName));
		User user = (User) cr.uniqueResult();
		return user;
	}
	
	public List<User> getAllUsers()
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(User.class);
		List<User> users = cr.list();
		return users;
	}

	public String login()
	{
		User user = getUserByUserName(userName);
		if(user == null || !user.getPassword().equals(passsword))
		{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Invalid username or password",
							"Please enter a valid username and password"));
			return "login.xhtml";
		}
		if (!captchaVerified) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Captcha verification failed",
							"Please enter the correct captcha text"));
			return "login.xhtml";
		}
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("user", user);
		return "home.xhtml?faces-redirect=true";
	}
	public void refreshCaptcha()
	{
		captchaImage = CaptchaUtil.generateCaptchaImage();
		captchaInput="";
		captchaVerified=false;
		
		
	}
}


