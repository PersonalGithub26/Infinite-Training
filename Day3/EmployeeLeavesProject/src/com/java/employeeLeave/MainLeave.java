package com.java.employeeLeave;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainLeave {

	static LeaveBAL lb;
	static Scanner sc;

	static
	{
		lb = new LeaveBAL();
		sc = new Scanner(System.in);
		//leave = new Leave1();
	}
	public static void addLeaveMain() throws  LeaveExceptionClass, ParseException 
	{
		Leave1 leave = new Leave1();

		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Enter Employee Id");
		leave.setEmpId(sc.nextInt());
		System.out.println("Enter leave start date in dd-MM-YYYY format");
		String leaveStartDate = sc.next();
		Date startDate = sd.parse(leaveStartDate);
		leave.setLeaveStartDate(startDate);
		System.out.println("Enter leave end date in dd-MM-YYYY format");
		String leaveEndDate = sc.next();
		Date endDate = sd.parse(leaveEndDate);
		leave.setLeaveEndDate(endDate);
		System.out.println("Enter Leave reason");
		leave.setLeaveReason(sc.next());
		System.out.println("Enter leave type 'EL, PL, ML'");
		leave.setLeaveType(LeaveType.valueOf(sc.next()));
		System.out.println(lb.addEmployeeBal(leave));
	}
	public static void showLeavesMain()
	{
		List<Leave1> leaves = lb.showLeavesBal();
		for (Leave1 leavess : leaves) 
		{
			System.out.println(leavess);
		}
	}
	public static void searchEmployeeMain(){
		int EmpId;

		System.out.println("enter EmpId");
		EmpId=sc.nextInt();

		Leave1 empFound=lb.searchEmpBal(EmpId);
		if(empFound!=null){
			System.out.println(empFound);
		}else{
			System.out.println("employee record not found");
		}
	}

	public static void deletLeaveMain(){
		int EmpId;
		System.out.println("eneter employeeId");
		EmpId=sc.nextInt();

		System.out.println(lb.deletLeaveBal(EmpId));
	}


	public static void updateEmployeeMain() throws LeaveExceptionClass, ParseException{

		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");

		Leave1 emp=new Leave1();
		System.out.println("Enter Employee Id");
		emp.setEmpId(sc.nextInt());

		System.out.println("Enter Leave Start Date");
		emp.setLeaveStartDate(sdf.parse(sc.next()));

		System.out.println("Enter Leave End Date");
		emp.setLeaveEndDate(sdf.parse(sc.next()));

		System.out.println("Enter Leave Reason");
		emp.setLeaveReason(sc.next());

		System.out.println("Enter LeaveType 'EL, PL, ML'");
		emp.setLeaveType(LeaveType.valueOf(sc.next()));
		System.out.println(lb.updateEmployBal(emp));
	}
	public static void main(String[] args) {
		int choice;
		do{
			System.out.println("================");
			System.out.println(" S E L E C T ");
			System.out.println("================");
			System.out.println("1. Add new leave");
			System.out.println("2. Show total leaves");
			System.out.println("3. search Employee Leaves");
			System.out.println("4. Delelte Leave");
			System.out.println("5. Update the leaves");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				try {
					addLeaveMain();

				} catch (ParseException | LeaveExceptionClass e) {

					System.err.println(e.getMessage());
				}
				break;
			case 2:
				showLeavesMain();
				break;
			case 3:
				searchEmployeeMain();
				break;
			case 4:
				deletLeaveMain();
				break;
			case 5:
				try {
					updateEmployeeMain();
				} catch (LeaveExceptionClass | ParseException e) {
					e.printStackTrace();
				}
				break;

			}

		}while(true);
	}

}
