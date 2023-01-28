package com.java.ExceptionHandling;

import java.util.Calendar;
import java.util.Date;

public class Quiz11 {
	public static void main(String[] args) {
		Date yesterdayDate = null;
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		 c.add(Calendar.DATE, -1);
		 yesterdayDate = c.getTime();
//		 sd.format(yesterdayDate);
		 System.out.println(yesterdayDate);
    }
}


