package com.java.day2;

public class overEx2 {
	public int sum()
	{
		return 5;
	}
	public int sum(int x)
	{
		return x+5;
		
	}
	public int sum(int x, int y)
	{
		return x+y;
	}
	public static void main(String[] args) {
		overEx2 oo = new overEx2();
		System.out.println(oo.sum());
		System.out.println(oo.sum(12));
	}
}
