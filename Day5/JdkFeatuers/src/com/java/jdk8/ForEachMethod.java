package com.java.jdk8;

public class ForEachMethod {
	
	private int empId;
	private String name;
	private double basic;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public ForEachMethod(int empId, String name, double basic) {
		
		this.empId = empId;
		this.name = name;
		this.basic = basic;
	}
	public ForEachMethod() {
		
	}
	@Override
	public String toString() {
		return "ForEachMethod [empId=" + empId + ", name=" + name + ", basic=" + basic + "]";
	}
	
	
	
	

}
