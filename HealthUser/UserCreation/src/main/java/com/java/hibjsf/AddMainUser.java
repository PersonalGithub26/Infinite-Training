package com.java.hibjsf;

public class AddMainUser {
	
	public static void main(String[] args) {
		
		UserDAO dao = new UserDaoImpl();
		User user = new User();
		user.setFullName("Chandu Patel");
		user.setGender(Gender.MALE);
		user.setMobile("9963803713");
		user.setUserName("channdup");
		user.setPassword("chandu");
		user.setProfilePassword("chandu");
		user.setQuestion(Questions.FIRST_SCHOOL);
		user.setGender(Gender.MALE);
		user.setAnswer("Brilliant");
		user.setEmail("chandu@gmail.com");
		dao.addUserDao(user);
		System.out.println("Success");
		System.out.println(user.getProfilePassword());
		
		
	}

}
