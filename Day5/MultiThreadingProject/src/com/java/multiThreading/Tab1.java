package com.java.multiThreading;

public class Tab1 implements Runnable {
	
	TrdSaftTable mtab;
	
	public Tab1(TrdSaftTable mtab) {
		this.mtab = mtab;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		mtab.dispTable(12);
	}

}
