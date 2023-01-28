package com.java.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

public class MinMax {
	
	public static void main(String[] args) {
		List<EmployeeForEach> employees = new ArrayList<EmployeeForEach>();
		employees.add(new EmployeeForEach(1, "Chandu", 18000));
		employees.add(new EmployeeForEach(2, "srinivas", 13000));
		employees.add(new EmployeeForEach(3, "Srikanth", 14000));
		employees.add(new EmployeeForEach(4, "Ajay", 10000));
		employees.add(new EmployeeForEach(5, "Pranay", 15000));
		
		System.out.println("Employee List is :");
		employees.forEach(x -> {
			System.out.println(x);
		});
		System.out.println("==========MAX==============");
		EmployeeForEach each = employees.stream().max((m1, m2) -> m1.getBasic() > m2.getBasic() ? 1 : -1).get();
		System.out.println(each);
		System.out.println("==========MIN==============");
		EmployeeForEach each2 = employees.stream().min((m1, m2) -> m2.getBasic() < m1.getBasic() ? 1 : -1).get();
		System.out.println(each2);
		System.out.println("===========SUM==============");
		double s = employees.stream().mapToDouble(EmployeeForEach::getBasic).sum();
		System.out.println("Sum is :" +s);
		System.out.println("===========Average============");
		OptionalDouble a = employees.stream().mapToDouble(EmployeeForEach::getBasic).average();
		System.out.println("Average is :" +a);
		System.out.println("==========Sort=================");
		
		System.out.println("Sorted list by name is :");
		Collections.sort(employees, (e1, e2) -> {
			return e1.getName().compareToIgnoreCase(e2.getName());
		});
		employees.forEach(x -> {
			System.out.println(x);
		});
	}

}
