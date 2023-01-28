package com.infinite.day1;

public class MaxOfThree {
	public void show(int a, int b, int c)
	{
//		if(a > b && a > c)
//		{
//			System.out.println("a is greater");
//			
//		}
//		else if( b > a && b > c)
//		{
//			System.out.println("b is greater");
//		}
//		else
//		{
//			System.out.println("c is greater");
//		}
		int m = a;
		if(m < b)
		{
			m = b;
		}
		if(m < c)
		{
			m= c;
		}
		System.out.println("Max is :" +m);
		
		
		
	}
	public static void main(String[] args) {
		int a = 3, b = 4, c = 5;
		new MaxOfThree().show(a, b, c);
	}
	

}
