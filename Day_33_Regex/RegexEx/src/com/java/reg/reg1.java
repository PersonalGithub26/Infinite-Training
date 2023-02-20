package com.java.reg;

import java.util.regex.Pattern;

public class reg1 {
	
	public static void main(String[] args) {
		
		System.out.println(Pattern.matches("\\D*", "Chandu"));
		String reg = "^[Mr\\.]\\s";
		System.out.println(Pattern.matches(reg, "Mr.chandu"));
		System.out.println(Pattern.matches(".h", "ch"));
		System.out.println(Pattern.matches("..a..u", "chandu"));
		System.out.println(Pattern.matches("[0-9]{10}","1234567890"));
		System.out.println(Pattern.matches("[0-9]{4}-[0-9]{3}", "1234-123"));
		System.out.println(Pattern.matches("[9][1]-[0-9]{10}", "91-1234567890"));
		System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "9963803713"));
		
	}

}















