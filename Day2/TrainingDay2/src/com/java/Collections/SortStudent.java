package com.java.Collections;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortStudent {
	public static void main(String[] args) {
		Comparator c = new cgpComparator();
		SortedSet names = new TreeSet(c);
		
		names.add(new Student(1, "Chandu", "knp", 9.9));
		names.add(new Student(2, "Srinivas", "Atm", 9.0));
		
		names.add(new Student(3, "Srikant", "kpr", 8.7));
		names.add(new Student(4, "Ajay", "lxp",7.4));
		names.add(new Student(5, "Chimtu", "knp", 6.3));
		names.add(new Student(6, "Akhila", "sir", 5.8));
		System.out.println("names are  ");
		for (Object object : names) {
			Student student = (Student)object;
			System.out.println(student);
			
		}
	}

}
