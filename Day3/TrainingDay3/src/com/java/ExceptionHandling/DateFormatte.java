package com.java.ExceptionHandling;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatte {
	
	public static void main(String[] args) {
		
		 Date d = new Date();
	      SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy");
	      System.out.println("Date: " +a.format(d));
		
	}

}
