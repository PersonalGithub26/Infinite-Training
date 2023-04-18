package com.java.abs;

public abstract class Employee {
	int empNo;
	String empName;
	double basic;
	public Employee(int empNo, String empName, double basic) {
		
		this.empNo = empNo;
		this.empName = empName;
		this.basic = basic;
	}
	
	public abstract Employee showEmploy(Employee employee);

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", basic=" + basic + "]";
	}
	
	

}
