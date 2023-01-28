package com.infinite.day1;

public class ArrayCopy {
	public void show()
	{
		String[] names = new String[] {"Chandu", "Srinivas", "Ajay", "srikanth"};
		String[] cpy = names;
		for(String s : cpy)
		{
			System.out.println(s);
		}
	}
	public static void main(String[] args) {
		new ArrayCopy().show();
	}

}
