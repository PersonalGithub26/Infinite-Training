package com.java.day2;

public class EmloyeeCon {
	public static void main(String[] args) {
		Employee e1 =new Employee(1, "chandu", 2000.54);
		Employee e2 =new Employee(1, "chandu", 2000.54);
		Employee e3 =new Employee(1, "chandu", 2000.54);

		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		Employee[] emp = new Employee[]{e1, e2, e3};
		for (Employee employee : emp) {
			System.out.println(employee);
			
		}
	}
	

}
