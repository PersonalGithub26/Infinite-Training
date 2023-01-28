package com.java.employ;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface EmployDAO
{
	List<Employ> showEmployDao();
    String addEmployeeDao(Employ employ);
    Employ searchEmployDao(int empno);
    String deleteEmployDao(int empno);
    String updateEmployDao(Employ employ);
    String writeEmployFileDao() throws FileNotFoundException, IOException;
	String readEmployFileDao() throws IOException, ClassNotFoundException;
}
