package com.java.multiThreading;

import java.util.Vector;

public class C3 implements Runnable {

	@Override
	public void run() {
		Vector<String> names = new Vector<String>();
		names.add("Chandu");
		names.add("Chandu");
		names.add("Srikanth");
		names.add("Srinivas");
		names.add("pavan");
		for (String string : names) {
			System.out.println("Vector list is :" + string);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	


}
