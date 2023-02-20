package com.java.ejb;

import java.lang.reflect.UndeclaredThrowableException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SearchEmployMain {
	
	public static void main(String[] args) {
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Empno to search :");
		empno = sc.nextInt();
		EmployCrudBeanRemoteRemote remote = null;
		try {
			remote = (EmployCrudBeanRemoteRemote) new InitialContext().lookup("EmployCrudBeanRemote/remote");
			Employ employ = remote.searchEmployBean(empno);
			if(employ!=null)
			{
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
		} catch (UndeclaredThrowableException e) {
		    e.printStackTrace();
		
	}

}
}
