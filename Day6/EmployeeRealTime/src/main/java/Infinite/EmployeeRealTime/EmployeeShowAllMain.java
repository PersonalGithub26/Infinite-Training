package Infinite.EmployeeRealTime;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeeShowAllMain {
	
	public static void main(String[] args) {
		
			EmployeeDAO dao = new EmployeeDaoImp();
			List<Employee> employeeList;
			
			try {
				employeeList = dao.showEmployeeDao();
				for (Employee employee : employeeList) {
					System.out.println(employee);
					
					//EmployeeShowAllMain();
					
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
				
			
	}


}
