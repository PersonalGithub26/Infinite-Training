package com.java.lms;

import java.sql.SQLException;
import java.util.List;

public class test3 {
	
	public static void main(String[] args) {
		
		
		LmsDaoImpl dao=new LmsDaoImpl();
		
		try {
			List<LeaveHistory> leaveList=dao.showLeave(2000);
			for (LeaveHistory leaveHistory : leaveList) {
				System.out.println(leaveHistory);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
