package com.java.multiThreading;

import java.util.LinkedList;

public class C2 implements Runnable{

	@Override
	public void run() {
		
		LinkedList<String> names = new LinkedList<String>();
		
		names.add("Chandu");
		names.add("mahesh");
		names.add("Srikanth");
		names.add("Srinivas");
		names.add("pavan");
		
		for (String string : names) {
			System.out.println("Linked List is :" +string);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	

}
