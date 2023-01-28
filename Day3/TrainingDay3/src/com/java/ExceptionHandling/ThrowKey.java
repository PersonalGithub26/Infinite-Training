package com.java.ExceptionHandling;

import java.util.Scanner;

public class ThrowKey {
	
	public void show(int n)
	{
		if(n < 0)
		{
			throw new ArithmeticException("Negitive is not allowed..");
		}
		else if( n == 0)
		{
			throw new NumberFormatException(" zero is invalid");
			
		}
		else
		{
			System.out.println("n value is  : "+n);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.println("Enter n value");
		n = sc.nextInt();
		
		ThrowKey t= new ThrowKey();
		try {
			t.show(n);
		} catch(ArithmeticException e)
		{
			System.out.println(e);
		}
		catch(NumberFormatException e)
		{
			System.out.println(e);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
