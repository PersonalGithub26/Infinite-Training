package com.java.hibjsf;

public interface UserDAO {
	
	String addUserDao(User user);
	String ValidateUser(User user);
	String forgetPasswordDao(User user);
	String resetPasswordDao(User user);

}
