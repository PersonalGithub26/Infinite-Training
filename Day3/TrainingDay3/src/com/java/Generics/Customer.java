package com.java.Generics;

public class Customer {
	
	private int cNo;
	private String eName;
	private double premium;
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	@Override
	public String toString() {
		return "Customer [cNo=" + cNo + ", eName=" + eName + ", premium=" + premium + "]";
	}
	
	

}
