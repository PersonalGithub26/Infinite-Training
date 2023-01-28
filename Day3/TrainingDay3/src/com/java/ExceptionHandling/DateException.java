package com.java.ExceptionHandling;

import java.util.Date;
import java.nio.charset.MalformedInputException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateException {
	
	public void show(String date) throws ParseException
	{
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		// parse is used to convert String to date
		Date d = sd.parse(date);
		System.out.println(d);
		
		
	}
	public static void main(String[] args) {
		String date = "2022-12-12";
		
		DateException de = new DateException();
		
		try {
			de.show(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
