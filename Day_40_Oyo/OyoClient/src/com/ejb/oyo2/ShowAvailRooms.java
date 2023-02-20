package com.ejb.oyo2;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowAvailRooms {

	public static void main(String[] args) {

		try {
			OyoBeanRemote remote = (OyoBeanRemote) new InitialContext().lookup("OyoBean/remote");
			List<Room> rooms = remote.showAvailableRooms();
			for (Room room : rooms) {
				System.out.println(room);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}


	}

}
