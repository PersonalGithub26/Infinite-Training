package com.java.employeeLeave;

//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeaveDaoImp implements LeaveDAO {
	static List<Leave1> LeaveList;
	static Leave1 leave;
	static 
	{
		LeaveList = new ArrayList<Leave1>();
		leave = new Leave1();
	}
	@Override
	public String addLeave(Leave1 leave) 
	{
		long days = leave.getLeaveEndDate().getTime() - leave.getLeaveStartDate().getTime();	
		int Days = (int) (days / (1000 * 60 * 60 * 24)+1);
		System.out.println(Days);
		leave.setNoOfDays(Days);
		leave.setLeaveAppliedOn(new Date());
		LeaveList.add(leave);
		return "-----Leave added Successfully-----";
	}
	@Override
	public List<Leave1> showLeaves() 
	{
		return LeaveList;
	}
	@Override
	public Leave1 searchEmpDao(int empno) {
		Leave1 empFound=null;

		for (Leave1 leaveDetails : LeaveList) {

			if(leaveDetails.getEmpId()==empno){
				empFound=leaveDetails;
				break;
			}
		}
		return empFound;
	}
	@Override
	public String deletLeaveDao(int empno) {
		Leave1 empFound=searchEmpDao(empno);

		if(empFound!=null){
			LeaveList.remove(empFound);
			return "leave deleted succefully";
		}
		return "record not found";
	}
	@Override
	public String updateLeaveDao(Leave1 update) {
		Leave1 employFound=searchEmpDao(update.getEmpId());
		if(employFound!=null){

			for (Leave1 employ : LeaveList) {

				if(employ.getEmpId()==update.getEmpId()){


					employ.setLeaveStartDate(update.getLeaveStartDate());
					employ.setLeaveEndDate(update.getLeaveEndDate());
					employ.setLeaveReason(update.getLeaveReason());
					employ.setLeaveType(update.getLeaveType());
					employ.setLeaveAppliedOn(update.getLeaveAppliedOn());
					employ.setNoOfDays(update.getNoOfDays());

				}
				break;
			}

			return "employ record updated";
		}
		return "employ record not found";
	}












}
