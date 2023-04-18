package com.java.sup;

public class Employee {
	int empId;
	String empName;
	double salary;
	
	
	
	public Employee(int empId, String empName, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}

}
