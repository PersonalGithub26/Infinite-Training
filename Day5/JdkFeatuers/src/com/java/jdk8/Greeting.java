package com.java.jdk8;

public class Greeting {
	
	public void greet(){
		System.out.println("Good Morning..");
		
	}
	public static void main(String[] args) {
		IGreetings ig = new Greeting()::greet;// not possible if there is more than one method in 
		//interface
		ig.salution();
	}

}
