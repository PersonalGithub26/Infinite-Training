package com.java.EmailValidatation;

public class EmailDAOImp implements EmailDAO{
	static String email;
	
	static
	{
		email = new String();
	}

	@Override
	public String showValidEmailDao() {
		return email;
		
		
	}
	
	
	

}
