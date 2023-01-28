package com.java.EmailValidatation;

public class EmailBAL {
	
	static EmailDAO ed;
	static StringBuilder sb;
	
	static
	{
		ed = new EmailDAOImp();
		sb = new StringBuilder();
	}
	
	
	public String emailValidatation(String email) throws InvalidEmailException, InvalidUserException
	{
		
		if(!email.contains("@"))
		{
			throw new InvalidEmailException("Email address must contains '@'  ");
		}
		
		String[] uName = email.split("@");
		
		String userName = uName[0];
		if(userName.length() > 12)
		{
			throw new InvalidUserException("Username of an email address must not contains more than 12 Characters");
		}
		
		return ed.showValidEmailDao();
	}

}
