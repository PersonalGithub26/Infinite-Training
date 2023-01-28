package com.java.Generics;

public class Employee {
	int empId;
	String name;
	double basic;
	public Employee(int empId, String name, double basic) {
		this.empId = empId;
		this.name = name;
		this.basic = basic;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", basic=" + basic + "]";
	}
	
	
	
	

}
