package com.infinite.day1;

public class Quizz {
	int n;
	public static void main(String[] args) {
		Quizz obj = new Quizz();
		obj.n = 2;
		Quizz obj1 = obj;
		obj1.n = 3;
		System.out.println(obj.n);
		System.out.println(obj.hashCode());
		System.out.println(obj1.hashCode());
		
	}

}
