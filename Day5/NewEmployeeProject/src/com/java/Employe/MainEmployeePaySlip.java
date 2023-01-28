package com.java.Employe;

import java.util.Scanner;

public class MainEmployeePaySlip {

	static EmployeeDaoImp ed;
	
	static LeaveDetails ld;
	static Scanner sc;

	static 
	{
		ed = new EmployeeDaoImp();
		ld = new LeaveDetails();
		sc = new Scanner(System.in);
	}
	public static void addEmployeeMain()
	{
		Employee employee = new Employee();
		System.out.println(employee.getEmpId());
		System.out.println("Enter Empoyee First Name");
		employee.setFirstName(sc.next());
		System.out.println("Enter Employee Last Name");
		employee.setLastName(sc.next());
		System.out.println("Enter Employee salary per year");
		employee.setSalary(sc.nextInt());
		System.out.println(ed.addEmployeDetails(employee));
		
	}

	public static void showPaySlipMain()
	{
		Employee employee = new Employee();
		ed.showPaySlip(employee.getEmpId());

	}
	public static void main(String[] args) {
		int choice;
		do
		{
			System.out.println("O P T I O N S");
			System.out.println("===============");
			System.out.println("1. Add Employee");
			System.out.println(" 2. show employee paySlip");
			System.out.println("Enter your choice");
			
			choice = sc.nextInt();
			switch(choice) 
			{
			case 1:
				addEmployeeMain();
				break;
			case 2:
				showPaySlipMain();
				break;
			}
		}
		while(true);
	}

}
