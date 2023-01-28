package com.infinite.day1;

public class CaseDemo2 {
	public void show(String dayName)
	{
		switch (dayName) {
		case "MONDAY":
			System.out.println("IT IS MONDAY");
			
			break;
		case "TUESDAY":
			System.out.println("IT IS TUESDAY");
			break;
		case "WEDNERSDAY":
			System.out.println("IT ISWEDNERSDY");
			break;
		case "THURSAY":
			System.out.println("IT IS THURSDAY");
			break;
		case "FRIDAY":
			System.out.println("IT IS FRIDAY");
			break;
		case "SATURAY":
			System.out.println("IT IS SAURDAY");
			break;
		case "SUNDAY":
			System.out.println("IT IS SUNDAY");
			
			

		default:
			break;
		}
	}
	public static void main(String[] args) {
		String dayName = "MONDAY";
		new CaseDemo2().show(dayName);
	}

}
