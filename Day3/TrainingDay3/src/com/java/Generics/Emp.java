package com.java.Generics;

public class Emp {
	
	private int empID;
	private String Name;
	private double salary;
	
	public Emp(){}

	public Emp(int empID, String name, double salary) {
		
		this.empID = empID;
		Name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [empID=" + empID + ", Name=" + Name + ", salary=" + salary + "]";
	}

	public int getEmpID() {
		return empID;
	}

	public String getName() {
		return Name;
	}

	public double getSalary() {
		return salary;
	}
	
	

}
