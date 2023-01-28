package com.java.employeeLeave;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LeaveBAL {
	static LeaveDAO ld;
	static StringBuilder sb;
	static SimpleDateFormat sd;

	static 
	{
		ld = new LeaveDaoImp(); 
		sb = new StringBuilder();	
		sd=new SimpleDateFormat();

	}
	public int getNoofDays(Leave1 e) throws ParseException{

		long off=count(e.getLeaveStartDate(),e.getLeaveEndDate());


		return (int) off+1;
	}

	public void autoValues(Leave1 e) throws ParseException{
		int temp=getNoofDays(e);
		e.setLeaveAppliedOn(new Date());
		e.setNoOfDays(temp);

	}

	public boolean doValid(Leave1 leave) throws ParseException
	{

		boolean isValid = true;


		if(leave.getLeaveStartDate() != null)
		{
			String yesterdayDate = null;
			Date date = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, -1);
			yesterdayDate = c.toString();

			//if(sd.format(leave.getLeaveStartDate()).equals(sd.parse(yesterdayDate)))
			if (leave.getLeaveStartDate().before(new Date()))
			{
				sb.append("Leave Start date cannot be yeasterday's date....");
				isValid = false;
			}
			if(leave.getLeaveEndDate().before(new Date()))
			{


				sb.append("Leave end date cannot be yestarday's date....");
				isValid = false;
			}


		}
		if (leave.getLeaveStartDate().after(leave.getLeaveEndDate()))
		{
			sb.append("Leave start date cannot be greater than leave end date.....");
			isValid = false;
		}
		return isValid;

	}

	public String addEmployeeBal(Leave1 leave) throws LeaveExceptionClass, ParseException
	{
		if(doValid(leave) == false)
		{
			throw new LeaveExceptionClass(sb.toString());
		}

		return ld.addLeave(leave);
	}

	public List<Leave1> showLeavesBal()
	{
		return ld.showLeaves();
	}
	public Leave1 searchEmpBal(int empId){
		return ld.searchEmpDao(empId);
	}

	public String deletLeaveBal(int empId){
		return ld.deletLeaveDao(empId);
	}

	public String updateEmployBal(Leave1 employee) throws LeaveExceptionClass, ParseException{

		if(doValid(employee)==false){

			throw new LeaveExceptionClass(sb.toString());
		}
		autoValues(employee);
		return ld.updateLeaveDao(employee);
	}
	
	public long count(Date start, Date end) throws ParseException {

		int TDays=0;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");


		LocalDate localFirst = Instant.ofEpochMilli(start.getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDate();

		LocalDate localLast = Instant.ofEpochMilli(end.getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDate();

		Calendar cc = Calendar.getInstance();
		cc.setTime(start);
		int D1 = cc.get(Calendar.DAY_OF_WEEK);
		cc.add(Calendar.DAY_OF_WEEK, - D1);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(end);
		int D2 = c2.get(Calendar.DAY_OF_WEEK);
		c2.add(Calendar.DAY_OF_WEEK, - D2);

		long days = (c2.getTimeInMillis()-cc.getTimeInMillis())/(1000*60*60*24);
		long daysWithoutWeekendDays = days-(days*2/7);

		if (D1 == Calendar.SUNDAY && D2 != Calendar.SATURDAY) {
			D1 = Calendar.MONDAY;
		} else if (D1 == Calendar.SATURDAY && D2 != Calendar.SUNDAY) {
			D1 = Calendar.FRIDAY;
		} 

		if (D2 == Calendar.SUNDAY) {
			D2 = Calendar.MONDAY;
		} else if (D2 == Calendar.SATURDAY) {
			D2 = Calendar.FRIDAY;
		}


		String [] holidays= new String[]{

				"26-12-2022"

		};
		for (LocalDate date = localFirst; date.isBefore(localLast); date = date.plusDays(1)) {


			for (int i = 0; i < holidays.length; i++) {
				Date temp=sdf.parse(holidays[i]);

				LocalDate localDateTemp = Instant.ofEpochMilli(temp.getTime())
						.atZone(ZoneId.systemDefault())
						.toLocalDate();

				if(date.equals(localDateTemp)){
					TDays++;
				}
			}
		}

		return daysWithoutWeekendDays-D1+D2-TDays;


	}
}
