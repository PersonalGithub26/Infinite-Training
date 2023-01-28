package com.java.Practice;

public class GreetingMain {
	
	public void greet()
	{
		System.out.println("Good night");
	}
	
	public static void main(String[] args) {
		
		IGreeting ig = new GreetingMain()::greet;
		ig.solution();
	}

}
