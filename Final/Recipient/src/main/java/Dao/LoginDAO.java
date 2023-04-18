package com.java.infinite.Dao;

import com.java.infinite.Recipient.Login;

public interface LoginDAO {
	
String ValidateMe(Login login);
	
	String validateOtp(Login login);
	
	Login searchByLoginUser(String username);
	
	String otp(Login login);
	
	public String Updatepasscode(Login login);
	
	public String resetPassword(Login login);

}
