package com.java.lms;

import java.text.ParseException;

public class test4 {
	
	public static void main(String[] args) {
		
		LmsDaoImpl dao=new LmsDaoImpl();
		String date="20-1-2023";
		
		try {
			System.out.println(dao.convertDate(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
