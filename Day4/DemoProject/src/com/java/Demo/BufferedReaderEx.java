package com.java.Demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderEx {
	public static void main(String[] args) {
		
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your name");
		
		String name;
		try {
			name = br.readLine();
		 	System.out.println("Name is "+name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}
}
