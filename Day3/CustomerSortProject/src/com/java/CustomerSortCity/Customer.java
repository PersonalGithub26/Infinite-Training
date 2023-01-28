package com.java.CustomerSortCity;

public class Customer {
	int customerId;
	String customerName;
	String customerCity;
	double premium;
	double installment;
	public Customer(int customerId, String customerName, String customerCity, double premium, double installment) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerCity = customerCity;
		this.premium = premium;
		this.installment = installment;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerCity="
				+ customerCity + ", premium=" + premium + ", installment=" + installment + "]";
	}
	
	

}
