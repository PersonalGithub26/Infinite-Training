package com.java.infinite.DaoImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.java.hms.SessionHelper;
import com.java.infinite.Dao.LoginDAO;
import com.java.infinite.Recipient.Login;
import com.java.infinite.Recipient.SignUpRecipient;


@ManagedBean(name="lDao")
@SessionScoped
public class LoginDaoImpl implements LoginDAO{
	
	private String newPass;
	
	
	
	public String getNewPass() {
		return newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	public String validateUser(Login login) {
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();	
		String encr = EntryptPassword.getCode(login.getPassword());
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", login.getUserName()));
		cr.add(Restrictions.eq("password", encr.trim()));
		Login loginFound = (Login)cr.uniqueResult();
	  //Login r = searchByLoginid(login.getLoginId());
	  System.out.println("Login Id is "+loginFound.getLoginId());
	  int logid=loginFound.getLoginId();
	  SignUpRecipient r= searchbyloginid(logid);
		sessionMap.put(SearchStrings.getRecipientinfo1(), r);
		SearchStrings.getLogger().info("Login Success IN LOGGER");
		System.out.println("Login Result is " +loginFound);
		if (loginFound!=null) {
			System.out.println("LoginFound");
			long otp = loginFound.getOtp();
			if (otp==0) {
				// call generateOtp method for particular user
				login.setOtp(otp);
				System.out.println(otp);
				System.out.println("No OTP");
				return "LoginOtp.xhtml";
			}else if (otp!=0){
				System.out.println("Login Success");
				SearchStrings.getLogger().info("Login Success IN LOGGER");
				return "buyorreneew.xhtml?faces-redirect=true";
			}
			else {
				// call reset new password method
				System.out.println("Otp Found");
			}
		}
		return "Login.xhtml";
	}
	public SignUpRecipient searchbyloginid(int loginId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(SignUpRecipient.class);
		cr.add(Restrictions.eq("loginId", loginId));
		SignUpRecipient sig = (SignUpRecipient) cr.uniqueResult();
		System.out.println("Searched......");

		return sig;
	}
	
	@Override
	public String ValidateMe(Login login) {
	
			String encr = EntryptPassword.getCode(login.getPassword());
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			Criteria cr = session.createCriteria(Login.class);
			cr.add(Restrictions.eq("userName", login.getPassword()));
			cr.add(Restrictions.eq("password", encr.trim()));
			cr.setProjection(Projections.rowCount());
			long count = (Long) cr.uniqueResult();
			if (count == 1) {
				return "reset.xhtml?faces-redirect=true";
			} else {
				sessionMap.put("error", "Invalid Credentials...");
				return "Login.xhtml?faces-redirect=true";
			}

		

		
	}
	
	public String AutoGen(){
		SessionFactory sf = SessionHelper.getConnection();
		Session session =sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		List<Login> list=cr.list();
		if(list.size()==0){
			return "H001";
		}
		cr.setProjection(Projections.max("healthId"));
		String str= (String) cr.uniqueResult();
		String dId =str.substring(1);
		int Id=Integer.parseInt(dId);
		Id++;
		return String.format("H%03d", Id);
		
	}
	
	
	public static long generateOtp() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}

	public long OtpGenerate(String username) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", username));
		cr.setProjection(Projections.rowCount());
		long count = (Long) cr.uniqueResult();
		System.out.println(count);
		return count;
	}
	
	@Override
	public String validateOtp(Login login) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", login.getUserName()));
		cr.add(Restrictions.eq("otp", login.getOtp()));
		cr.setProjection(Projections.rowCount());
		long count = (long) cr.uniqueResult();

		Date date = new Date();
		Login userFound = searchByLoginUser(login.getUserName());
		 
		Date date2 = userFound.getOtpSendtime();

		long checkTime = date2.getSeconds() - date.getSeconds();
	

		System.out.println("Time diff  " + checkTime);
		
		
		if (checkTime < 60) {
			if (count == 1) {
				return "reset.xhtml?faces-redirect=true";
			} else {
				sessionMap.put("error", "You Entered Wrong OTP....");
				return "You Entered Wrong OTP....";
			}
		}

		else {
			sessionMap.put("error", "Time Out.....");
			return "Time Out.....";
		}


	}


	@Override
	public Login searchByLoginUser(String username) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", username));
		Login user = (Login) cr.uniqueResult();
		System.out.println("Searched......");

		return user;
	}
	public Login searchByLoginid(int loginId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("loginId", loginId));
		Login user = (Login) cr.uniqueResult();
		System.out.println("Searched......");

		return user;
	}




	@Override
	public String otp(Login login) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);

		Login userFound = searchByLoginUser(login.getUserName());
		String email = userFound.getEmail();

		long otpNew = generateOtp();
		System.out.println(generateOtp());
		System.out.println("Email is " + email);
		Sendmail.sendInfo(email, "Your OTP Generated", "Generated Otp is " + otpNew);
		Transaction tr = session.beginTransaction();
		userFound.setOtp(otpNew);
		userFound.setOtpSendtime(new Date());

		session.update(userFound);
		tr.commit();
		return "LoginusingOtp.xhtml?faces-redirect=true";


		

	}

	@Override
	public String Updatepasscode(Login login) {
		SessionFactory sf=SessionHelper.getConnection();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.update(Updatepasscode(login));
		t.commit();
		return "hi.xhtml?faces-redirect=true";
	}
	
	
	public String resetPassword(Login login) {
		        String newEncr = EntryptPassword.getCode(newPass);

		        System.out.println(login.getPassword());//.getPasscode());//.getPassword());
		        //String encr = EntryptPassword.getCode(login.getPasscode());//.getPassword());// .getPassCode());

		        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		        SessionFactory sf = SessionHelper.getConnection();
		        Session session = sf.openSession();
		        Criteria cr = session.createCriteria(Login.class);
		        cr.add(Restrictions.eq("userName", login.getUserName()));//.getUserName()));// .getUserName()));
		        // cr.add(Restrictions.eq("passCode", oldEncr.trim()));
		        List<Login> list=cr.list();
		        Login login2=list.get(0);
		        //    String oldEncr = EntryptPassword.getCode(login2.getPasscode());
		        boolean isFound = false;
		        if (login2.getPassword().equals(newEncr.trim())) {
		        	System.out.println(login.getPassword() + "   " + login2.getPassword().trim());
		        	isFound = true;

		        }
		        if (isFound == true) {
		        	sessionMap.put("err", "Your password cannot be same as old password...");
		        	return "reset.xhtml?faces-redirect=true";
		        }else{
		        	login2.setPassword(newEncr);//.setPassword(encr);//.setPassCode(encr);
		        	//login2.setFlag("No");
		        	Transaction t=session.beginTransaction();
		        	session.update(login2);
		        	t.commit();
		        	return "Login.xhtml?faces-redirect=true";
		        	}
		        }


}
