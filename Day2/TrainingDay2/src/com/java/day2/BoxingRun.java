package com.java.day2;

public class BoxingRun {
	public void show(Object ob)
	{
		String type = ob.getClass().getSimpleName();
		if(type.equals("Integer"))
		{
			System.out.println("integer casting...");
			int x = (Integer) ob;
		}
		if(type.equals("String"))
		{
			System.out.println("String casting..");
			String s = (String) ob;
			
		}
		if(type.equals("Double"))
		{
			System.out.println("Double casting...");
			double d = (Double) ob;
		}
				
							
	}
	public static void main(String[] args) {
		int x = 12;
		String s1 =  "Chandu";
		double d = 12.4;
		BoxingRun bx = new BoxingRun();
		bx.show(x);
		bx.show(s1);
		bx.show(d);
	}
	

}
