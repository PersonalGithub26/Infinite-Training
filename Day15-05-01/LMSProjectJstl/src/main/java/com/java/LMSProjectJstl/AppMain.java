//package com.java.LMSProjectJstl;
//
//import java.sql.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Scanner;
//
//public class AppMain {
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		levHistory leave = new levHistory();
//		levHistoryDAO dao = new LevHistoryDaoImp();
//		SimpleDateFormat sd = new SimpleDateFormat("yyyy-mm-dd");
//		
//		
//
//		
//		try {
//			
//		
//		leave.setStDate(sd.parse("2023-01-09"));
//
//		
//		
//			endDate = sd.parse("2023-01-10");
//		
//		
//		leave.setEndDate(endDate);
//		leave.setLevReason("Medical");
//		leave.setLevMngCmts("ok");
//		
//		leave.setLeaveTyp(leaveTyp.EL);
//		leave.setStatus(levStatus.APPROVED);
//		
//			System.out.println(dao.ApplyLeave(leave));
//			//System.out.println(dao.ApplyLeave(leave));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
