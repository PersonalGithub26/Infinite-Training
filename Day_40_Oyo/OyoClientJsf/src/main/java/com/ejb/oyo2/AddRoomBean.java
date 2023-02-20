package com.ejb.oyo2;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AddRoomBean {
	
	private String addRoom(String room2) throws NamingException
	{
		Room room = new Room();
		OyoBeanRemote remote = (OyoBeanRemote) new InitialContext().lookup("OyoBean/remote");
		room2 = remote.addRoom(room);
		return "Added";

	}

}
