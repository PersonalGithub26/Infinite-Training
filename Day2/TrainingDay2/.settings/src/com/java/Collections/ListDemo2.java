package com.java.Collections;

import java.util.List;
import java.util.ArrayList;

public class ListDemo2 {
	public static void main(String[] args) {
		List nums = new ArrayList();
		nums.add(new Integer(3));
		nums.add(new Integer(4));
		nums.add(new Integer(6));
		nums.add(new Integer(8));
		int sum = 0;
		for (Object object : nums) {
			sum += (Integer)object;
			
			
		}
		System.out.println(sum);

		
		
	}

}
