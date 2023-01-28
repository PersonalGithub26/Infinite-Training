package com.java.Collections;

import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetDemo2 {
	public static void main(String[] args) {
		SortedSet names = new TreeSet();
		
		names.add("Chandu");
		names.add("Srinivas");
		names.add("Akhila");names.add("Chandu");
		System.out.println("nmaes in sorted lis  ");
		for (Object object : names) {
			System.out.println(object);
		}
		
		
	}

}
