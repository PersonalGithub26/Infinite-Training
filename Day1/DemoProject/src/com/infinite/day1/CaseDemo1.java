package com.infinite.day1;

public class CaseDemo1 {
	public void show(int sno)
	{
		switch(sno)
		{
		case 1:
			System.out.println("I am chandu");
			break;
		case 2:
			System.out.println("Srinivas");
			break;
		case 3:
			System.out.println("ajay");
			break;
		case 4:
			System.out.println("Srikanth");
			break;
			default:
				System.out.println("Invalid choice");
			
		}
	}
	public static void main(String[] args) {
		int sno = 3;
		new CaseDemo1().show(sno);
	}

}
