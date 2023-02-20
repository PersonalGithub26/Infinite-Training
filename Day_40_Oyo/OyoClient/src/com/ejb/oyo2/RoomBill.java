package com.ejb.oyo2;

import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RoomBill {
	
	public static void main(String[] args) {
		Billing billing = new Billing();
		Scanner sc = new Scanner(System.in);
		try {
			OyoBeanRemote remote = (OyoBeanRemote) new InitialContext().lookup("OyoBean/remote");
			System.out.println(remote.billCalculation("B003"));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
