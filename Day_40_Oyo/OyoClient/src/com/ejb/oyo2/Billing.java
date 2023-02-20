package com.ejb.oyo2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Billing")
public class Billing {
	
	@Id
	@Column(name = "BookID")
	private String BookId;
	@Column(name = "RoomID")
	private String roomId;
	@Column(name = "NoOfDays")
	private int noOfDays;
	@Column(name = "BillAmt")
	private int billAmount;
	
	
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public int getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}
	@Override
	public String toString() {
		return "Billing [BookId=" + BookId + ", roomId=" + roomId + ", noOfDays=" + noOfDays + ", billAmount="
				+ billAmount + "]";
	}
	
	
	
	

}
