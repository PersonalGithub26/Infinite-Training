package com.java.Practice;

import java.util.ArrayList;
import java.util.List;

public class ForEachMain {
	
	
		
		public static void main(String[] args) {
			List<EmployeeForEach> employees = new ArrayList<EmployeeForEach>();
			employees.add(new EmployeeForEach(1, "Chandu", 12000));
			employees.add(new EmployeeForEach(2, "srinivas", 13000));
			employees.add(new EmployeeForEach(3, "Srikanth", 14000));
			employees.add(new EmployeeForEach(4, "Ajay", 10000));
			employees.add(new EmployeeForEach(5, "Pranay", 15000));
			
			System.out.println("Employee List is :");
			employees.forEach(x -> {
				System.out.println(x);
			});
			
			
			
	}

}
