package com.java.abs;

public class DevEmployee extends Employee{

	public DevEmployee(int empNo, String empName, double basic) {
		super(empNo, empName, basic);
	}

	@Override
	public Employee showEmploy(Employee employee) {
		return employee;
	}

}
