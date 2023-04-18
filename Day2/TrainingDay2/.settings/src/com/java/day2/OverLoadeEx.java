package com.java.day2;

public class OverLoadeEx {
	public void show(int x)
	{
		System.out.println("int " +x);
	}
	public void show(double x)
	{
	 	System.out.println("double "+x);
		
	}
	public void show(String x)
	{
		System.out.println("String "+x);
	}
	public static void main(String[] args) {
		OverLoadeEx oo = new OverLoadeEx();
		oo.show(12);
		oo.show("String");
		oo.show(14.4);
	}

}
