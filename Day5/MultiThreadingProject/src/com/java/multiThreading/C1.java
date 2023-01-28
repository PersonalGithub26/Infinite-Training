package com.java.multiThreading;

import java.util.ArrayList;
import java.util.List;

public class C1 implements Runnable{

	@Override
	public void run() {
		List<String> names = new ArrayList<String>();
		names.add("Chandu");
		names.add("Chandu");
		names.add("Srikanth");
		names.add("Srinivas");
		names.add("pavan");
		for (String string : names) {
			System.out.println("names is :" +string);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
}
	
		
