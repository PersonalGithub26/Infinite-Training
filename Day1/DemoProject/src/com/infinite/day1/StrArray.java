package com.infinite.day1;

public class StrArray {
	public void show()
	{
		String[] names = new String[] {"Chandu", "Srinivas", "Ajay", "srikanth"};
		for( String  s : names)
		{
			System.out.println(s);
		}
	}
	public static void main(String[] args) {
		new StrArray().show();
		
	}

}

