package com.ejb.oyo2;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BookRoom {
	
	public static void main(String[] args) {
		
		
		
		try {
			OyoBeanRemote remote = (OyoBeanRemote) new InitialContext().lookup("OyoBean/remote");
			Booking booking = new Booking();
			//java.util.Date date = new java.util.Date();
			booking.setRoomId("R005");
			booking.setCity("HYD");
			booking.setCustName("chandu");
			String chkIn="2023-02-16";
			Date date2 = Date.valueOf(chkIn);
			booking.setCheckInDate(date2);
			String checkOut = "2023-02-19";
			Date date = Date.valueOf(checkOut);
			booking.setCheckOutDate(date);
			System.out.println(remote.addBooking(booking));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
