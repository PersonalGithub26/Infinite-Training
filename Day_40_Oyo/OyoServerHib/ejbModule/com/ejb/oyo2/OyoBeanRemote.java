package com.ejb.oyo2;

import java.util.List;

import javax.ejb.Remote;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;

@Remote
public interface OyoBeanRemote {
	
	String addRoom(Room room);
	List<Room> showAvailableRooms();
	String addBooking(Booking booking);
	List<Room> showBookedRooms();
	String billCalculation(String bookId);

}
