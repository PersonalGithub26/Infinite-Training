package com.java.Generics;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortEmployee {
	
	public static void main(String[] args) {
		
		Comparator c = new NameComparator();
		SortedSet<Employee>  se= new TreeSet<Employee>(c);
		se.add(new Employee(1, "Chandu", 2000));
		se.add(new Employee(2, "Srinivas", 2000));
		se.add(new Employee(3, "Ajay", 2000));
		se.add(new Employee(4, "akhila", 2000));
		
		for (Employee employee : se) {
			System.out.println(employee);
			
		}
	}

}
