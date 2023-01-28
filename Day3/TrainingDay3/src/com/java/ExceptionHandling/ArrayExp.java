package com.java.ExceptionHandling;

public class ArrayExp {
	
	public static void main(String[] args) {
		int[] a = new int[] {12,13};
		try {
			a[10] = 12;
		}catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Array size is small");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("Array Exception over");
		}
		
	}

}
