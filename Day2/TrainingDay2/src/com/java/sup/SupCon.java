package com.java.sup;

public class SupCon {
	public static void main(String[] args) {
		
	
//	Employee c = new Chandu(1, "chandu", 200000.2725);
//	System.out.println(c);
		
		Employee[] emp = new Employee[]{
				
				new Chandu(1, "chandu", 200000.2725),
				new Akhila(1, "Akhila", 200000.2725)
		};
		for (Employee employee : emp) {
			System.out.println(employee);
		}

	}

}
