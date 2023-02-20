package com.java.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MainCalc {

	public static void main(String[] args) {
		
		try {
			CalculationBeanRemoteRemote remote = (CalculationBeanRemoteRemote) new InitialContext().lookup("CalculationBeanRemote/remote");
			System.out.println("Sum is "+remote.sum(10, 12));
			System.out.println("Sub is "+remote.sub(12, 10));
			System.out.println("Mul is "+remote.mult(2, 3));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
