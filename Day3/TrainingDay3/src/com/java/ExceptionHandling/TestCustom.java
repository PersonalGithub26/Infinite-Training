package com.java.ExceptionHandling;

import java.util.Scanner;

//crude
//DAO Data access Object
public class TestCustom {
	
	public void check(int age) throws CustomException
	{
		if(age < 18)
		{
			throw new CustomException("You are not elegibile to vote");
		}
		System.out.println("you can vote");
		
	}
	public static void main(String[] args) {
		
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age : ");
		age = sc.nextInt();
		TestCustom T = new TestCustom();
		try {
			T.check(17);
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}

}
