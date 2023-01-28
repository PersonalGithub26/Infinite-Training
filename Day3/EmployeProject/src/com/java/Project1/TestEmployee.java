package com.java.Project1;

import java.util.List;
import java.util.Scanner;

public class TestEmployee {

	static EmployeeBAL bal;
	static Scanner sc;
	
  
	static
	{
		bal = new EmployeeBAL();
		sc = new Scanner(System.in);
	}
	
	public static void searchEmployee()
	{
		int empId;
		System.out.println("Enter employee Id ");
		empId = sc.nextInt();
		Employee employeeFound = bal.searchEmployee(empId);
		if(employeeFound != null)
		{
			System.out.println(employeeFound);
		}
		else
		{
			System.out.println("Employee record not found....");
		}
	}
	public static void finalOne() throws EmployeeException
	{
		int choice;
		do{
			System.out.println(" O P T I O N S");
			System.out.println("================");
			System.out.println("1. Add Employee");
			System.out.println("2. Show Employee");
			System.out.println("3. Search Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Update Employe List");
			System.out.println("6. Exit");
			System.out.println("Enter your Choice");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
//				try {
//					addEmployeeMain();
//				} catch (EmployeeException e) {
//					System.err.println(e.getMessage());
//				}
				addEmployeeMain();
				break;
			case 2:
				showEmployeeMain();
				break;
			case 3:
//				System.out.println("Enter id:");
//				int id = sc.nextInt();
//				Employee e = bal.searchEmployeeBal(id);
//				System.out.println(e.toString());
//				break;
			case 4:
				System.out.println("Enter employee Id");
				int id = sc.nextInt();
				String s1 = bal.deleteEmployeeBal(id);
				System.out.println(s1);
				break;
			case 5:
				
				updatedEmployeeList();
				
				break;
			case 6:
				return;
			}
		}
		
		while(choice != 6);
	}
	
	public static void main(String[] args) {
		try {
			finalOne();
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
	}
	public static void showEmployeeMain()
	{
		List<Employee> employee = bal.showEmployeeBal();
		for (Employee employee2 : employee) {
			System.out.println(employee2);
		}
	}
	public static void addEmployeeMain() throws EmployeeException
	{
		Employee employee = new Employee();
		System.out.println("Enter employe number : ");
		employee.setEmpId(sc.nextInt());
		System.out.println("Enter employee name");
		employee.setName(sc.next());
		System.out.println("Enter gender MALE/FEMALE");
		employee.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter Department");
		employee.setDept(sc.next());
		System.out.println("Enter Designantion");
		employee.setDesig(sc.next());
		System.out.println("Enter Basic");
		employee.setBasic(sc.nextDouble());
		System.out.println(bal.addEmployeeBal(employee));
	}
	public static void updatedEmployeeList() throws EmployeeException
	{
		Employee employee = new Employee();
		System.out.println("Enter employee Id");
		employee.setEmpId(sc.nextInt());
		System.out.println("Enter new Designantion ");
		employee.setDesig(sc.next());
		System.out.println("Enter new basic");
		employee.setBasic(sc.nextDouble());
		
		String employees = bal.updateEmployeBal(employee.getEmpId(),employee.getDesig(),employee.getBasic());
		System.out.println(employees);
		System.out.println("===============");
		System.out.println("Enter options");
		System.out.println("===============");
		System.out.println("1.Show updated List");
		System.out.println("2.upadte List again");
		System.out.println("3.Return main menu");
		int option = sc.nextInt();
		if(option == 1)
		{
			showEmployeeMain();
		}
		if(option == 2)
		{
			updatedEmployeeList();
		}
		if(option == 3)
		{
			finalOne();
		}
	}
}
