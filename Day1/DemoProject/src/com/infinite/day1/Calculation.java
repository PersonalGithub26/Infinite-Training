package com.infinite.day1;

public class Calculation {
	public void calc(int a, int b) 
	{
		int c = a + b;
		System.out.println("Sum is " +c);
		c = a - b;
		System.out.println("Diff is "+c);
		c =  a * b;
		System.out.println("mul is "+c);
		
	}
	public static void main(String[] args) {
		int a, b;
		a = 5;
		b = 3;
		Calculation c = new Calculation();
		c.calc(a, b);
		
	}

}
