package com.java.day2;

public class Quiz1 {
	public void show(Object ob)
	{
		if(ob == "ABX")
		{
			System.out.println("Correct");
			
		}
		else
		{
			System.out.println("incorrect");
		}
	}
	public static void main(String[] args) {
		String ob = "ABX";
		new Quiz1().show(ob);
	}

}
