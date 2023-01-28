package com.java.jdk8;

public class LambdaEx {
	
	public static void main(String[] args) {
		
		IHello obj = () -> 
		{
			System.out.println("Welcome to lambda Expression ");
		};
		obj.dispMsg();
		obj.disp();
		
		IHello obj1 = () -> {
			System.out.println("Lambda Exprssion session going on.");
		};
		obj1.dispMsg();
	}

}
