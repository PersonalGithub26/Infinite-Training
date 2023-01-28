package com.java.practice;

public class Equality {
	public static void main(String[] args) {
		//String with 
		String s = "Abc";
		String s1 = new String("Abc");
		if(s.equals(s1))
		{
			System.out.println(".equals    Yes");
		}
		if(s==s1)
		{
			System.out.println("==      Yes");
		}
	}

}
