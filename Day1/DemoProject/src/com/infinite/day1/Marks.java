package com.infinite.day1;

public class Marks {
	public void marks(int suba, int subb,int subc)
	{
		int sum = suba+subb+subc;
		int avg = sum/3;
		System.out.println(sum + " is sum");
		System.out.println(avg +" is avg");
	}
	public static void main(String[] args) {
		Marks m = new Marks();
		m.marks(12, 30, 40);
				
		
	}
	

}
