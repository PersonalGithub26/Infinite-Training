package com.java.abs;

public class MainEmp {
	public static void main(String[] args) {
		Employee[] emp = new Employee[]
				{
						new HrEmployee(1, "chandu", 814591),
						new DevEmployee(2, "AkhilA", 285729),
						new HrEmployee(1, "Srinivas", 814591),
						new DevEmployee(2, "Ajay", 285729), 
						new HrEmployee(1, "Srikanth", 814591),
						new DevEmployee(2, "Abhishek", 285729),
						new HrEmployee(1, "Pardhu", 814591),
						new DevEmployee(2, "patel", 285729)  
				};
		for (Employee employee : emp) {
			String type = employee.getClass().getCanonicalName();
			System.out.println(type);
			
			if(type.equals("DevEmployee"))
			{
				System.out.println(employee.showEmploy(employee));
			}
			
		}
	}

}
