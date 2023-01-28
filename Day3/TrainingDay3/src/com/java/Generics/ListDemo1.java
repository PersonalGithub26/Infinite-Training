package com.java.Generics;

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
	
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(new Integer(3));
		nums.add(new Integer(34));
		nums.add(new Integer(4));
		nums.add(new Integer(5));
		nums.add(new Integer(6));
		nums.add(new Integer(7));
		nums.add(new Integer(null));
		nums.add(null);
		int sum = 0;
		for (Integer integer : nums) {
			sum += integer;
		}
		System.out.println(sum);
		
	}

}
