package com.infinite.day1;

public class CtoF {
	public void calc(double c)
	{
		double f;
		f = ((9*c)/5) + 32;
		System.out.println("fahrenheat " + f);
	}
	public void kelvin(double c)
	{
		
	}
	public static void main(String[] args) {
		double c = 37;
		new CtoF().calc(c);
		
	}

}
