package com.java.lms;

import java.sql.SQLException;

public class Test {
	
	public static void main(String[] args) {
		
		LmsDAO dao=new LmsDaoImpl();
		
	try {
		java.util.List<Employee> empList=dao.showEmployee();
		
		for (Employee employee : empList) {
			System.out.println(employee);
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}

}
