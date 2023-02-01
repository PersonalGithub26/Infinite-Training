package com.java.abs1;

public class MainMobile {
	
	public static void main(String[] args) {
		
		String Value="Iphone";
		MobileDetails md = new MobileFactory();
		Mobile mobile = md.getMobileDetails(Value);
		mobile.name();
		mobile.model();
		mobile.price();
	}

}
