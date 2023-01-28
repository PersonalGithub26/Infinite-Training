package com.java.abs;

public class HrEmployee extends Employee{

	public HrEmployee(int empNo, String empName, double basic) {
		super(empNo, empName, basic);
	}

	@Override
	public Employee showEmploy(Employee employee) {
		return employee;
	}

}
