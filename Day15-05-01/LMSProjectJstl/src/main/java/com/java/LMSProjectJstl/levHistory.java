package com.java.LMSProjectJstl;

import java.sql.Date;

public class levHistory {
	
	
	private int leaveId;
	private int noOfDays;
	private String levMngCmts;
	private int empId;
	private Date stDate;
	private Date endDate;
	private leaveTyp leaveTyp;
	private levStatus status;
	private String levReason;
	
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getLevMngCmts() {
		return levMngCmts;
	}
	public void setLevMngCmts(String levMngCmts) {
		this.levMngCmts = levMngCmts;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Date getStDate() {
		return stDate;
	}
	public void setStDate(Date stDate) {
		this.stDate = stDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public leaveTyp getLeaveTyp() {
		return leaveTyp;
	}
	public void setLeaveTyp(leaveTyp leaveTyp) {
		this.leaveTyp = leaveTyp;
	}
	public levStatus getStatus() {
		return status;
	}
	public void setStatus(levStatus status) {
		this.status = status;
	}
	public String getLevReason() {
		return levReason;
	}
	public void setLevReason(String levReason) {
		this.levReason = levReason;
	}
	@Override
	public String toString() {
		return "levHistory [leaveId=" + leaveId + ", noOfDays=" + noOfDays + ", levMngCmts=" + levMngCmts + ", empId="
				+ empId + ", stDate=" + stDate + ", endDate=" + endDate + ", leaveTyp=" + leaveTyp + ", status="
				+ status + ", levReason=" + levReason + "]";
	}
	
	
	

}
