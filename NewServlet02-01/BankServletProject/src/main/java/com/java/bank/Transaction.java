package com.java.bank;

import java.sql.Timestamp;

public class Transaction {
	
	private int accountNo;
	private String transactionType;
	private int transactionAmount;
    private  Timestamp transactionDate;
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Transaction(int accountNo, String transactionType, int transactionAmount, Timestamp transactionDate) {
		super();
		this.accountNo = accountNo;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
	}
    
	public Transaction() {}
	
    
    
    
    

}
