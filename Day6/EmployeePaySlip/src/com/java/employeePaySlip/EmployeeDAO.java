package com.java.employeePaySlip;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface EmployeeDAO {
	
	String addEmployeeDao(Employee employee);
    List<Employee> showEmployee();
    String writeEmployeeFileDao() throws FileNotFoundException, IOException;
    String readEmployeeFileDao() throws FileNotFoundException, IOException, ClassNotFoundException;
    


}
