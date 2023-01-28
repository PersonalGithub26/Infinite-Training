package com.java.ExceptionHandling;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Leave {
	private int empId;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private String leaveReason;
	private int noOfDays;
	private LeaveType leaveType;
	private Date leaveAppliedOn;

	public enum LeaveType {
		EL, PL, ML
	}

	public Leave(int empId, Date leaveStartDate, Date leaveEndDate, String leaveReason, LeaveType leaveType, Date leaveAppliedOn) {
		// Validate input
		if (leaveStartDate.after(new Date())) {
			throw new IllegalArgumentException("Leave start date cannot be in the future");
		}
		if (leaveEndDate.after(new Date())) {
			throw new IllegalArgumentException("Leave end date cannot be in the future");
		}
		if (leaveStartDate.after(leaveEndDate)) {
			throw new IllegalArgumentException("Leave start date cannot be after leave end date");
		}

		this.empId = empId;
		this.leaveStartDate = leaveStartDate;
		this.leaveEndDate = leaveEndDate;
		this.leaveReason = leaveReason;
		this.leaveType = leaveType;
		this.leaveAppliedOn = leaveAppliedOn;

		// Calculate number of days of leave
		int diff = (int) (leaveEndDate.getTime() - leaveStartDate.getTime());
		this.noOfDays = (int) (diff / (1000 * 60 * 60 * 24));
	}

	public int getEmpId() {
		return empId;
	}

	public Date getLeaveStartDate() {
		return leaveStartDate;
	}

	public Date getLeaveEndDate() {
		return leaveEndDate;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public Date getLeaveAppliedOn() {
		return leaveAppliedOn;
	}
}



class LeaveManager {
	private List<Leave> leaves;

	public LeaveManager() {
		leaves = new ArrayList<>();
	}

	public void addLeave(Leave leave) {
		leaves.add(leave);
	}

	public void showLeaves() {
		for (Leave leave : leaves) {
			System.out.println("Employee ID: " + leave.getEmpId());
			System.out.println("Leave start date: " + leave.getLeaveStartDate());
			System.out.println("Leave end date: " + leave.getLeaveEndDate());
			System.out.println("Leave reason: " + leave.getLeaveReason());
			System.out.println("Number of days");

		}
	}
}


