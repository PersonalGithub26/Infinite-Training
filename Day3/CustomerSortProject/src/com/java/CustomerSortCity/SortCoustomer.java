package com.java.CustomerSortCity;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortCoustomer {
	public static void main(String[] args) {
		Comparator cd = new CustomerNameComparator();
		
		SortedSet<Customer> cc = new TreeSet<Customer>(cd);
		
		cc.add(new Customer(1,"chandu","Hyderabad", 100, 5000));
		cc.add(new Customer(2, "srinivas", "Hyderabad", 200000, 6500));
		cc.add(new Customer(3, "srikanth", "vizag", 300000, 2600));
		cc.add(new Customer(4, "ajay", "Karimnagar", 50000, 2000));
		cc.add(new Customer(5, "pranay", "ramagundam", 10000, 5500));
		cc.add(new Customer(6, "teja", "Karimnagar", 15000, 2000));
		cc.add(new Customer(7, "pavan", "karnool", 150000, 2000));
		cc.add(new Customer(8, "akhila", "Ananthapur", 10000, 4500));
		cc.add(new Customer(9, "vardhini", "Amalapurr", 120000, 2000));
		cc.add(new Customer(9, "ajay", "Amalapurr", 120000, 2000));
		cc.add(new Customer(10, "sindhu", "Hyderabad", 103000, 3500));
		 
		
			
		
		for (Customer customer : cc) {
			System.out.println(customer);
			
		}
	}

}
