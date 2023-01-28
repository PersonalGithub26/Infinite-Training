package com.java.multiThreading;

public class DataSync {
	
	synchronized void dispMsg(String name)
	{
		System.out.println("Hii." +name);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("how are youu...");
	}

}
