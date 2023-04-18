package com.java.day2;

public class Employee {
	int empId;
	String empName;
	double salary;
	@Override
	public String toString() {
		return "Employee [empid=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}
	public Employee() {
		
	}
	public Employee(int empId, String empName, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}
	
	

}
