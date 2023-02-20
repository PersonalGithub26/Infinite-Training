
package com.ejb.trans;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Bean {
	
	public List<Employee> showEmploye() throws NamingException
	{
		EmployeeRemote remote = (EmployeeRemote) new InitialContext().lookup("ManageEmployeeBean/remote");
		List<Employee> employeeList = remote.showEmploy();
		return employeeList;
	}

}
