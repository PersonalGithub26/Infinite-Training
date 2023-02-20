package com.ejb.oyo2;

import java.awt.print.Book;
import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * Session Bean implementation class OyoBean
 */
@Stateless
@Remote(OyoBeanRemote.class)
public class OyoBean implements OyoBeanRemote {

	/**
	 * Default constructor. 
	 */
	public OyoBean() {
		// TODO Auto-generated constructor stub
	}


	//Room Id Generating
	public String RoomIdGenerator() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr=session.createCriteria(Room.class);
		List<Room> roomList=cr.list();
		if(roomList.size()==0) {
			return "R001";
		}
		int id=Integer.parseInt(roomList.get(roomList.size() - 1).getRoomId().substring(1));
		String rid=String.format("R%03d", ++id);
		return rid;
	}

	
	//Adding the Room
	@Override
	public String addRoom(Room room) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		String roomId=RoomIdGenerator();
		Transaction tx=session.beginTransaction();
		room.setRoomId(roomId);
		room.setStatus(Status.AVAILABLE);
		session.save(room);
		tx.commit();
		return "Room Added...";
	}

	
	//Showing Only Available Rooms
	@Override
	public List<Room> showAvailableRooms() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Room.class);
		cr.add(Restrictions.eq("status", Status.AVAILABLE));
		//		Projection projection = Projections.property("roomId");
		//		cr.setProjection(projection);
		List<Room> rooms = cr.list();
		return rooms;
	}


	//Booking Id Generating
	public String bookingIdGenerator() {
		SessionFactory sf=SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Booking.class);
		List<Booking> bookList=cr.list();
		if(bookList.size()==0) {
			return "B001";
		}
		int id=Integer.parseInt(bookList.get(bookList.size() - 1).getBookId().substring(1));
		String bid=String.format("B%03d", ++id);
		return bid;
	}

	
	//Searching for the Room with roomId
	public Room searchByRoomId(String roomId) {
		SessionFactory sFactory = SessionHelper.getConnection();
		Session session = sFactory.openSession();
		Criteria cr = session.createCriteria(Room.class);
		cr.add(Restrictions.eq("roomId", roomId));
		Room room = (Room) cr.uniqueResult();
		return room;
	}

	
	// Bboking the Room
	@Override
	public String addBooking(Booking booking) {
		SessionFactory sFactory=SessionHelper.getConnection();
		Session session=sFactory.openSession();
		String bookId=bookingIdGenerator();
		booking.setBookId(bookId);
		java.util.Date date=new java.util.Date();
		java.sql.Date bookDate=new Date(date.getTime());
		booking.setBookDate(bookDate);
		Transaction tr=session.beginTransaction();
		session.save(booking);
		tr.commit();
		session.close();
		Room room=searchByRoomId(booking.getRoomId());
		room.setStatus(Status.BOOKED);
		session=sFactory.openSession();
		tr=session.beginTransaction();
		session.update(room);
		tr.commit();
		session.close();
		return "Room booked...";
	}

	//Showing the Booked Rooms
	@Override
	public List<Room> showBookedRooms() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Room.class);
		cr.add(Restrictions.eq("status", Status.BOOKED));
		List<Room> rooms = cr.list();
		return rooms;
	}
	
	//Searching for the booking with BookId
	public Booking searchByBookId(String bookId)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Booking.class);
		cr.add(Restrictions.eq("bookId", bookId));
		Booking booking = (Booking) cr.uniqueResult();
		return booking;
	}
	
	//convert sql Date to util Date
	public java.util.Date sqlToUtil(java.sql.Date dt) {
		java.util.Date utilDate=new Date(dt.getTime());
		return utilDate;
	}
	
	//Covert util date to sql Date
	public Date utilToSql(java.util.Date dt) {
		java.sql.Date sqlDate=new Date(dt.getTime());
		return sqlDate;
	}
	
	//Counting Days
	public int days(Date chDate,Date chOutDate) {
		
		Booking booking=new Booking();
		java.util.Date checkInDate=sqlToUtil(chDate);
		java.util.Date checkOutDate=sqlToUtil(chOutDate);
		int days=(int)(((checkOutDate.getTime()-checkInDate.getTime())/(1000*60*60*24))+1);
		return days;
	}
	
	
	//Calculating Total Amount by Number of days
	public int totalBillAmount(String bookId, int days)
	{
		Booking booking = searchByBookId(bookId);
		String roomId = booking.getRoomId();
		Room room = searchByRoomId(roomId);
		int costperDay = room.getCostPerDay();
		int totalAmount = days*costperDay;
		return totalAmount;
	}
	
	//Total Bill Calculation
	@Override
	public String  billCalculation(String bookId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session =sf.openSession();
		Criteria cr = session.createCriteria(Room.class);
		cr.add(Restrictions.eq("status", Status.BOOKED));
		Projection projection = Projections.property("roomId");
		Billing billing = new Billing();
		Booking booking = searchByBookId(bookId);
		billing.setBookId(booking.getBookId());
		billing.setRoomId(booking.getRoomId());
		int noOfDays = days(booking.getCheckInDate(), booking.getCheckOutDate());
		billing.setNoOfDays(noOfDays);
		int amount=totalBillAmount(bookId, noOfDays);
		billing.setBillAmount(amount);
		
		Transaction transaction = session.beginTransaction();
		session.save(billing);
		transaction.commit();
		session.close();
		
		
		return "Total Bill Anount is :" +amount;
	}
	
	



}
