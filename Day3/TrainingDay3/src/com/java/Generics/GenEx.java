package com.java.Generics;

public class GenEx {
	public static void main(String[] args) {
		Data obj = new Data();
		String s = "Chandu";
		obj.swap(3, 5);
		obj.swap(13.5, 1.5);
		obj.swap("Chandu", "Akhila");
		Gen2 g = new Gen2();
		
		Employee e1 = new Employee(1, "Chandu", 15000);
		Employee e2 = new Employee(2, "Srinivas", 10000);
		g.show(e1, s);
		Gen2<String, Employee> ee = new Gen2<String, Employee>();
		//ee.show("", e2);
		
	}

}
