package Infinite.EmployeeRealTime;

import java.sql.SQLException;
import java.util.Scanner;

public class AddEmployee {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();
		System.out.println("Enter empoyee name");
		employee.setName(sc.next());
		System.out.println("Enter Department");
		employee.setDept(sc.next());
		System.out.println("Enter Designantion");
		employee.setDept(sc.next());
		System.out.println("Enter Basic");
		employee.setBasic(sc.nextInt());
		EmployeeDAO dao= new EmployeeDaoImp();
		
		try {
			System.out.println(dao.addEmployeeDao(employee));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
				
	}

}
