package com.java.multiThreading;


public class Even extends Thread{
	
	@Override
	public void run() {
		for(int i =0; i<= 20; i+=2)
		{
			System.out.println("EVen "+i);
		}
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e)
		{
			e.getMessage();
		}
	}
	
	

}
