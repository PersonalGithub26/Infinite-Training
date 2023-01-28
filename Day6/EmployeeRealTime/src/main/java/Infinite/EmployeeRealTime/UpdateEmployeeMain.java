package Infinite.EmployeeRealTime;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployeeMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();
		System.out.println("Enter Employee Id");
		employee.setEmpId(sc.nextInt());
		System.out.println("Enter Employee Name");
		employee.setName(sc.next());
		System.out.println("Enter Departmentt");
		employee.setDept(sc.next());
		System.out.println("Enter Designantion");
		employee.setDesg(sc.next());
		System.out.println("Enter employee basic");
		employee.setBasic(sc.nextInt());
		EmployeeDAO dao = new EmployeeDaoImp();
		try {
			System.out.println(dao.updateEmployee(employee));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
