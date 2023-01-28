package com.java.calanderStreams;

import java.util.Calendar;
import java.util.Date;

public class CalEx3 {
	public static void main(String[] args) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		System.out.println(cal.getTime());
	}
}

