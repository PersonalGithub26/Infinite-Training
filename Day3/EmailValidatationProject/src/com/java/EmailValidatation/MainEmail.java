package com.java.EmailValidatation;

import java.util.Scanner;

public class MainEmail {
	static EmailBAL eb;
	static Scanner sc;
	
	static
	{
		eb = new EmailBAL();
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		do{
		
		System.out.println("Enter your Email Address");
		String email = sc.nextLine();
		System.out.println(email);
		
		
		try {
			eb.emailValidatation(email);
		} catch (InvalidEmailException | InvalidUserException e) {
			System.err.println(e.getMessage());
			
		}
		}
		while(true);
		
		
	}

}
