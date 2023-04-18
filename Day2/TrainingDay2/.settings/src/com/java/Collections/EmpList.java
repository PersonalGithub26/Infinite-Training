package com.java.Collections;

import java.util.ArrayList;
import java.util.List;

public class EmpList {
	public static void main(String[] args) {
		List emp = new ArrayList();
		emp.add(new Employee(1,"Chandu",546));
		emp.add(new Employee(2,"patel",546));
		emp.add(new Employee(3,"hema",546));
		emp.add(new Employee(4,"apatel",546));
		emp.add(new Employee(5,"Srikanth",546));
		emp.add(new Employee(6,"Srinivas",546));
		emp.add(new Employee(7,"akhila",546));
		
		System.out.println("employList   ");
		for (Object object : emp) {
			Employee emp1 = (Employee)object;
			System.out.println(emp1);
			
		}
		
	}

}
