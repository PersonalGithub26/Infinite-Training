package com.ejb.oyo2;

import java.util.Scanner;

import javax.ejb.Remote;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AddRoom {
	
	public static void main(String[] args) {
		Room room = new Room();
		Scanner sc = new Scanner(System.in);
		String type;
		int costPerDay;
		try {
			OyoBeanRemote remote = (OyoBeanRemote) new InitialContext().lookup("OyoBean/remote");
			System.out.println("Enter Type Of Room");
			type=sc.next();
			room.setType(type);
			System.out.println("Enter CostPerDay");
			costPerDay=sc.nextInt();
			room.setCostPerDay(costPerDay);
			System.out.println(room);
			System.out.println(remote.addRoom(room));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}


//OyoBean/remote - EJB3.x Default Remote Business Interface
//OyoBean/remote-com.ejb.oyo2.OyoBeanRemote - EJB3.x Remote Business Interface

