package com.java.day2;

public class CricketWithStatic {
	static int score;
	
	public void increment(int x)
	{
		score += x;
	}
	public static void main(String[] args) {
		CricketWithStatic s = new CricketWithStatic();
		CricketWithStatic s1 = new CricketWithStatic();
		CricketWithStatic s2 = new CricketWithStatic();
		
		s1.increment(12);
		s2.increment(34);
		s.increment(34);
		
		System.out.println("Total score   "+ CricketWithStatic.score);

	}

}
