package com.java.LMSProjectJstl;

import java.sql.SQLException;
import java.util.List;

public class M {

	public static void main(String[] args) {
		System.out.println("Hii");
		LevHistoryDaoImp d = new LevHistoryDaoImp();
		try {
			levHistory history = d.searchLeave(3);
			System.out.println(history.toString());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
