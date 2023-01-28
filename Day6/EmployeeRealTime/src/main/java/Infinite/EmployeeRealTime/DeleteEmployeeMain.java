package Infinite.EmployeeRealTime;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployeeMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int empId;
		Employee employee = new Employee();
		System.out.println("Enter employee Id to delete");
		empId = sc.nextInt();
		EmployeeDAO dao = new EmployeeDaoImp();
		try {
			System.out.println(dao.deleteEmployeeDao(empId));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
