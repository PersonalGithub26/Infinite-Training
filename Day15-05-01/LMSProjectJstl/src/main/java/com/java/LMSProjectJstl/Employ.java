package com.java.LMSProjectJstl;

import java.util.Date;

/**
 * @author chandud
 *
 */
public class Employ {
	
	private int empId;
	private String name;
	private String mailId;
	private String mobNo;
	private Date joinDte;
	private String dept;
	private int managerId;
	private int leaveAvail;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public Date getJoinDte() {
		return joinDte;
	}
	public void setJoinDte(Date joinDte) {
		this.joinDte = joinDte;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getManager() {
		return managerId;
	}
	public void setManager(int manager) {
		this.managerId = manager;
	}
	public int getLeaveAvail() {
		return leaveAvail;
	}
	public void setLeaveAvail(int leaveAvail) {
		this.leaveAvail = leaveAvail;
	}
	public Employ(int empId, String name, String mail, String mobno, Date joinDte, String dept, int managerId,
			int leaveAvail) {
		
		this.empId = empId;
		this.name = name;
		this.mailId = mail;
		this.mobNo = mobno;
		this.joinDte = joinDte;
		this.dept = dept;
		this.managerId = managerId;
		this.leaveAvail = leaveAvail;
	}
	public Employ() {
		
	}
	@Override
	public String toString() {
		return "Employ [empId=" + empId + ", name=" + name + ", mailId=" + mailId + ", mobNo=" + mobNo + ", joinDte="
				+ joinDte + ", dept=" + dept + ", manager=" + managerId + ", leaveAvail=" + leaveAvail + "]";
	}
	
	
	

}
