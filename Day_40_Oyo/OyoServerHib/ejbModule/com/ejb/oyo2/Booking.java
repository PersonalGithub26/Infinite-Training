package com.ejb.oyo2;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Booking")
public class Booking implements Serializable{
	@Id
	@Column(name = "BookId")
	private String bookId;
	@Column(name = "RoomID")
	private String roomId;
	@Column(name = "CustName")
	private String custName;
	@Column(name = "City")
	private String city;
	@Column(name = "BookDate")
	private Date bookDate;
	@Column(name = "ChkInDate")
	private Date checkInDate;
	@Column(name = "ChkOutDate")
	private Date checkOutDate;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	@Override
	public String toString() {
		return "Booking [bookId=" + bookId + ", roomId=" + roomId + ", custName=" + custName + ", city=" + city
				+ ", bookDate=" + bookDate + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + "]";
	}
	
	
	

}
