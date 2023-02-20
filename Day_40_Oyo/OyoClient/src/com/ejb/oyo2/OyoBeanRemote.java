package com.ejb.oyo2;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface OyoBeanRemote {
	
	String addRoom(Room room);
	List<Room> showAvailableRooms();
	String addBooking(Booking booking);
	List<Room> showBookedRooms();
	String billCalculation(String bookId);



}
