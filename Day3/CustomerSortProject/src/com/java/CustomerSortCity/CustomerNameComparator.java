  package com.java.CustomerSortCity;

import java.util.Comparator;

public class CustomerNameComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer c1, Customer c2) {
		if(c1.customerCity.equalsIgnoreCase(c2.customerCity))
		{
			return c1.customerName.compareTo(c2.customerName);
		}
		
		return c1.customerCity.compareToIgnoreCase(c2.customerCity);
	}
	
	

}
