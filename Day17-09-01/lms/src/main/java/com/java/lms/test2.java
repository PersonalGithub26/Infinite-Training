package com.java.lms;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class test2 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		
		
		
		
		LmsDaoImpl dao=new LmsDaoImpl();
		
		LeaveHistory leave=new LeaveHistory();
		
		System.out.println("enter empid");
		leave.setEmpId(sc.nextInt());
		
		System.out.println("eneter leave start date");
		
		Date sdate;
		try {
			sdate = sdf.parse(sc.next());
			leave.setLeaveStartDate(new java.sql.Date(sdate.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("enter end date");
		
		Date edate;
		try {
			edate = sdf.parse(sc.next());
			leave.setLeaveEndDate(new java.sql.Date(edate.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("enetr leave reson");
		leave.setLeaveReason(sc.next());
		
		System.out.println("enetr leave type");
		leave.setLeaveType(LeaveType.valueOf(sc.next()));
		
		
		
		try {
			System.out.println(dao.leaveApply(leave));
		} catch (ClassNotFoundException | com.google.protobuf.TextFormat.ParseException | SQLException
				| ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
