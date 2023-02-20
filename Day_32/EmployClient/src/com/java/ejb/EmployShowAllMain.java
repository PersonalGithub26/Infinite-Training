package com.java.ejb;

import java.lang.reflect.UndeclaredThrowableException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EmployShowAllMain {
	public static void main(String[] args) {
		EmployCrudBeanRemote service = null;


		try {
			service = (EmployCrudBeanRemote)
					new InitialContext().lookup("EmployCrudBean/remote");
			List<Employ> employList = service.showEmployBean();
			for (Employ employ : employList) {
				System.out.println(employ);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (UndeclaredThrowableException e) {
		    e.printStackTrace();
		}



	}
}
