package com.java.calanderStreams;

import java.util.Calendar;

public class CalEx1 {
	
	
		public static void main(String[] args) {
			Calendar cal = Calendar.getInstance();
			System.out.println("The current date is : " + cal.getTime());  
			cal.add(Calendar.DATE, -15);  
			System.out.println("The current date is : " + cal.getTime());  
			System.out.println(cal.get(Calendar.DATE));
			System.out.println(cal.get(Calendar.DAY_OF_MONTH));
			System.out.println(cal.get(Calendar.MONTH));
			System.out.println(cal.get(Calendar.YEAR));
		}
	}



