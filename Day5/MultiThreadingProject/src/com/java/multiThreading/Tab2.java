package com.java.multiThreading;

public class Tab2 implements Runnable {
	
	TrdSaftTable tf;
	
	public Tab2(TrdSaftTable tf) {
		this.tf=tf;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		tf.dispTable(15);
	}

}
