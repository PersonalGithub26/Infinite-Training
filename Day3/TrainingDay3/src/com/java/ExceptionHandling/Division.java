package com.java.ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Division {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		System.out.println("Enter 2 numbers");
		try {
			a = sc.nextInt();
			b = sc.nextInt();
			c = a / b;
			System.out.println("divvisim" + c);
		}
		
		catch(ArithmeticException e)
		{
			System.out.println("Number cannot divided by zero...");
		}catch(InputMismatchException e)
		{
			System.out.println("please enter any number");
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	
		}finally{
			sc.close();
			System.out.println("ipoyindhi poo");
		}

}
}
