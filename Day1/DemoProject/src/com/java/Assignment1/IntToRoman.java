package com.java.Assignment1;

public class IntToRoman {
	public void intToRoman(int n)
	{
		int[] nums = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
		String[] roman = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD",
										"D", "CM", "M"};
				
									
		StringBuilder sRoman = new StringBuilder();
		for (int i = nums.length - 1; i >= 0; i--) 
		{
			while(n >= nums[i])
			{
				sRoman.append(roman[i]);
				n = n - nums[i];
			}
			
		}
		System.out.println(sRoman.toString());
		
		
		}
	public static void main(String[] args) {
		IntToRoman ir = new IntToRoman();
		int n = 8;
		ir.intToRoman(n);
	}
	}


