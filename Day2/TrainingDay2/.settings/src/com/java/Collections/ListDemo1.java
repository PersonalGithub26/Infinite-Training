package com.java.Collections;

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
	public static void main(String[] args) {
		List names = new ArrayList();
		names.add("Chandu");
		names.add("Srinivas");
		names.add("Akhila");
		System.out.println("Names are   ");
		for (Object object : names) {
			System.out.println(object);
			
		}
		names.add(2, "Chetan");
		System.out.println("Added names are  ");
		for (Object object : names) {
			System.out.println(object);
			
		}
		names.set(2, "Ahila pentam");
		System.out.println("Setted name   ");
		for (Object object : names) {
			System.out.println(object);
		}
			
			
		
	}

}
