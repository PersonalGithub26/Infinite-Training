package Infinite.EmployeeRealTime;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeSearch {
	public static void main(String[] args) {
		
	
	Scanner sc= new Scanner(System.in);
	
		EmployeeDAO dao = new EmployeeDaoImp();
		System.out.println("Enter employeId to search");
		 int empId=sc.nextInt();
			Employee employee;
			try {
				employee = dao.searchEmployeeDao(empId);
				System.out.println(employee);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	}
	
	


