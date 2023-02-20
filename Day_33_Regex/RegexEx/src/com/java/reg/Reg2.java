package com.java.reg;

import java.util.regex.Pattern;

public class Reg2 {
	
	public static void main(String[] args) {
		
		String reg = "^[a-zA-Z]+\\d{4}";
		System.out.println(Pattern.matches(reg, "chandu1234"));
		String regex = "^(Mr\\.|Ms\\.)[a-zA-Z]+";
		System.out.println(Pattern.matches(regex, "Mr.Chandu"));
		System.out.println(Pattern.matches(regex, "Ms.Pandey"));
		
	}

}
