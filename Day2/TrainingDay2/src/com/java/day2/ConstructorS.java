package com.java.day2;

public class ConstructorS {
	static
	{
		System.out.println("static constructor");
	}
	public ConstructorS() {
		System.out.println("Default constructor..");
		
	}
	public static void main(String[] args) {
		ConstructorS s = new ConstructorS();
		
	}

}
