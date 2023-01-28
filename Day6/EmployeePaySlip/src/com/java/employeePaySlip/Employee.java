package com.java.employeePaySlip;

public class Employee {
	
	private int empId;
	private String firstName;
	private String lastName;
	private double salary;

	private int leaveAvail;
	//private  int totalLeaves;
	private double hra;
	private double da;
	private double ta;
	private double tax;
	private double pf;
	private double gross;
	private double takeHome;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getLeaveAvail() {
		return leaveAvail;
	}

	public void setLeaveAvail(int leaveAvail) {
		this.leaveAvail = leaveAvail;
	}

	//    public int getTotalLeaves() {
	//        return totalLeaves;
	//    }
	//
	//    public void setTotalLeaves(int totalLeaves) {
	//        this.totalLeaves = totalLeaves;
	//    }

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getDa() {
		return da;
	}

	public void setDa(double da) {
		this.da = da;
	}

	public double getTa() {
		return ta;
	}

	public void setTa(double ta) {
		this.ta = ta;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}

	public double getGross() {
		return gross;
	}

	public void setGross(double gross) {
		this.gross = gross;
	}

	public double getTakeHome() {
		return takeHome;
	}

	public void setTakeHome(double takeHome) {
		this.takeHome = takeHome;
	}

	public Employee(int empId, String firstName, String lastName, double salary, int leaveAvail, int totalLeaves, double hra, double da, double ta, double tax, double pf, double gross, double takeHome) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.leaveAvail = leaveAvail;
		// this.totalLeaves = totalLeaves;
		this.hra = hra;
		this.da = da;
		this.ta = ta;
		this.tax = tax;
		this.pf = pf;
		this.gross = gross;
		this.takeHome = takeHome;
	}

	public Employee(){}

	@Override
	public String toString() {
return  "************************************************\n" +
		"PAY SLIP FOR PROGRAMMER\n" +
		"************************************************\n" +
		"Basic Pay:Rs"+salary+"\n"+
		"DA:Rs "+da+"\n"+
		"PF:Rs "+pf+"\n"+
		"HRA:Rs "+hra+"\n"+
		"TAX:Rs "+tax+"\n"+
		"GROSS PAY:Rs "+gross+"\n"+
		"TAKE HOME:Rs "+takeHome;
	}

}
