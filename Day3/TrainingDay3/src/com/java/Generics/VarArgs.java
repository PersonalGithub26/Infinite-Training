package com.java.Generics;    

public class VarArgs {
	
	public void show(int day, String... Attendance )
	{
		System.out.print("Day : "+day);
		
		for (String s : Attendance) {
			System.out.print(s + " ");
			
		}
		System.out.print("\n");
	}
	public static void main(String[] args) {
		VarArgs v = new VarArgs();
		v.show(1, "Chandu");
		v.show(2, "Srinivas","Chandu");
		v.show(3, "Srinivas","Chandu","Akhila");
		v.show(4, "Chandu","Srinivas", "Akhila", "Prasanna");
		
				
	}
	

}
