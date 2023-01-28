package com.java.Demo;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//CRUDE - CREATE,READ,UPDATE
public class DateExs {
	
	public static void main(String[] args) {
		String startDate = "2022-12-19";
		String endDate = "2022-12-20";
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date start = sd.parse(startDate);
			Date end = sd.parse(endDate);
			long ms = end.getTime() - start.getTime();
			int days =(int) ms/(1000 * 60 * 24);
			days++;
			System.out.println(days);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
