package com.ejb.oyo2;

import javax.ejb.Remote;

@Remote
public interface OyoBeanRemote {
	
	String addRoom(Room room);

}
