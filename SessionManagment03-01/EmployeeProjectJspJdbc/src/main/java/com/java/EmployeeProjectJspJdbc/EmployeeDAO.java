package com.java.EmployeeProjectJspJdbc;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	
	List<Employee> showEmployeeDao() throws ClassNotFoundException, SQLException;
	Employee searchEmployeeDao(int empId) throws ClassNotFoundException, SQLException;
	String addEmployeeDao(Employee employee) throws ClassNotFoundException, SQLException;
	String updateEmployee(Employee employee) throws ClassNotFoundException, SQLException;
	String deleteEmployeeDao(int empId) throws ClassNotFoundException, SQLException;
	public int authenticate(String user, String pwd) throws ClassNotFoundException, SQLException;

}
