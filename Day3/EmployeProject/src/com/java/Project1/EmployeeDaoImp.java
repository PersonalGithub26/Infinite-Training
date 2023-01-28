package com.java.Project1;

import java.util.ArrayList;
import java.util.List;
  
public class EmployeeDaoImp implements EmployeeDAO{
	
	static List<Employee> employeeList;
	
	static
	{
		employeeList = new ArrayList<Employee>();
	}

	@Override
	public List<Employee> showEmployeeDao() {
		return employeeList;
	}

	@Override
	public String addEmployeeDao(Employee employee) {
		employeeList.add(employee);
		return "Employee had Added Successfullyy";
	}
	
	@Override
	public List<Employee> searchEmployeeDao()
	{
		return employeeList;
	}
	@Override
	public String deleteEmployeeDao(Employee employee)
	{
		employeeList.remove(employee);
		return "Employee had Deleted Successfully";
	}
	@Override
	public String updateEmployeeListDao()
	{
		return "Employee List Updated successfully";
	}

	
	

}
