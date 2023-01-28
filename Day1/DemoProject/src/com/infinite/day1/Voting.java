package com.infinite.day1;

public class Voting {
	public void check(int age)
	{
		if(age > 18)
		{
			System.out.println("you are eleible yo vote");
		}
		else
		{
			System.out.println("you are not elegibl to vote");
		}
			
	}
	public static void main(String[] args) {
		int age = 17;
		new Voting().check(age);
	}

}
