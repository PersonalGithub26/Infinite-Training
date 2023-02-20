package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowAllMain {

	public static void main(String[] args) {
		System.out.println("Hi");
		try {
			EmployCrudBeanRemoteRemote remote = (EmployCrudBeanRemoteRemote) new InitialContext().lookup("EmployCrudBeanRemote/remote");
			List<Employ> list = remote.showEmployBean();
			System.out.println("Size  " +list.size());
			for (Employ employ : list) {
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
		}


	}

}
