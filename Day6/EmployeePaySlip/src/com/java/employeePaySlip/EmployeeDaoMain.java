package com.java.employeePaySlip;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EmployeeDaoMain {

	static Scanner sc;
	//static Employee employee;
	static LeavesDetails ld;
	static EmployeeDAO dao;
	static LeaveDetailsDaoImp ldao;

	static
	{
		sc = new Scanner(System.in);
		//employee = new Employee();
		ld = new LeavesDetails();
		dao = new EmployeeDaoImp();
		ldao = new LeaveDetailsDaoImp();
	}
	public static void readEmployeeMain() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		dao.readEmployeeFileDao();
	}
	public static void writeEmployeeMain() throws FileNotFoundException, IOException
	{
		dao.writeEmployeeFileDao();
	}
	public static void showPaySlip()
	{
		List<Employee> employeeList = dao.showEmployee();
		for (Employee employee1: employeeList) {
			System.out.println(employee1.toString());
		}
	}
	public static void addEmployeeMain()
	{
		Employee employee = new Employee();
		//EmployeeDaoImp ed = new EmployeeDaoImp();
		//double d = ed.TakeHomeWithotLeave(employee);
		//employee.setEmpId(1);
		//int id = employee.getEmpId();
		
		System.out.println("Auto generated employee id is :"+employee.getEmpId());
		System.out.println("Enter employee first name");
		employee.setFirstName(sc.next());
		System.out.println("Enter employee last name");
		employee.setLastName(sc.next());
		System.out.println("Enter employee salary");
		employee.setSalary(sc.nextDouble());
		System.out.println("Enter leaves Available");
		employee.setLeaveAvail(sc.nextInt());
		//employee.setTakeHome(d); 
		System.out.println(dao.addEmployeeDao(employee));
		
	}
	public static void applyLeaveMain()
	{
		System.out.println("Enter employee id to apply leave");
		int id = sc.nextInt();
		ld.setEmpId(id);
		System.out.println("Enter leaves taken");
		ld.setLeaveTaken(sc.nextInt());
		System.out.println(ldao.applyLeave(ld));
		
	}

	public static void main(String[] args) {
		do
		{
			int choice;
			System.out.println("*************");
			System.out.println("O P T I O N S");
			System.out.println("**************");
			System.out.println("choose your Option");
			System.out.println("1. Add Employee");
			System.out.println("2. Add Leave");
			System.out.println("3 show payslip");
			System.out.println("4. Write Employee");
			System.out.println("5. Read Employee");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				addEmployeeMain();
				break;
			case 2:
				applyLeaveMain();
				break;
			case 3:
				showPaySlip();
				break;
			case 4:
				try {
					writeEmployeeMain();
				} catch (IOException e) {
					e.getMessage();
				}
				break;
			case 5:
				try {
					readEmployeeMain();
				} catch (ClassNotFoundException | IOException e) {
					e.getMessage();
				}
				break;
			}
			
		}while(true);
		
	}
}