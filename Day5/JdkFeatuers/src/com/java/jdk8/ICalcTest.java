package com.java.jdk8;

public class ICalcTest {
	
	public int sum(int a, int b)
	{
		return a + b;
	}
	
	public int sub(int a, int b)
	{
		return a - b;
	}
	
	public int mul(int a, int b)
	{
		return a * b;
	}
	
	public static void main(String[] args) {
		
		Icalc obj = new ICalcTest()::sum;
		System.out.println(obj.calc(12, 5));
		
		Icalc obj1 = new ICalcTest()::sub;
		System.out.println(obj1.calc(12, 5));
		
		Icalc obj2 = new ICalcTest()::mul;
		System.out.println(obj2.calc(12, 5));
		
		
		
	}

	
}
