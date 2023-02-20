package com.java.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;
public class MainProg {
	public static void main(String[] args)  {
		HelloWorldBeanRemote remote;
		try {
			remote = (HelloWorldBeanRemote) new InitialContext().lookup("HelloWorldBean/remote");
			System.out.println(remote.sayHello());
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}

