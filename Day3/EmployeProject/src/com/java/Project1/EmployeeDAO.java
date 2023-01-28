package com.java.Project1;

import java.util.List;

//Data Access Object

// To show the interface out
public interface EmployeeDAO {
	
	List<Employee> showEmployeeDao();
	String addEmployeeDao(Employee employee);	
	List<Employee> searchEmployeeDao();
	//Employee searchEmployeeDao(int empId);
	String deleteEmployeeDao(Employee employee);
	String updateEmployeeListDao();
		
	

}
