package com.java.jdk8;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class MapTableEx {

	public static void main(String[] args) {

		Map<String, String> users = new Hashtable<String, String>();
		users.put("Chandu", "Chandu@123");
		users.put("Srinu", "Sriniu@123");
		users.put("Akhila", "Akhila@123");

		String user, password;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter userName");
		user = sc.next();
		System.out.println("Enter password");
		password = sc.next();
		
		String result = users.getOrDefault(user, "Not found");
		if(result.equals(password))
		{
			System.out.println("Correct..");
		}
		else
		{
			System.out.println("Incorrect...!");
		}

//		users.forEach((key, value) -> {
//			System.out.println("Key : " + key + " Value : " + value);
//		});
		
//		for(String key: users.keySet()){
//		    if(key.equals(user))
//		    {
//		    	System.out.println("Found");
//		    }
//		    for(String value: users.values())
//		    {
//		    	if(value.equals(password))
//		    	{
//		    		System.out.println();
//		    	}
//		    }
		

	}

}
