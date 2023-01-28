package com.infinite.day1;

public class PosNeg {
	public void check(int n)
	{
		if(n % 2 == 0)
		{
			System.out.println("Even");
		}
		else
		{
			System.out.println("Odd");
		}
	}
	public static void main(String[] args) {
		int n = 10;
		new PosNeg().check(n);
	}

}
