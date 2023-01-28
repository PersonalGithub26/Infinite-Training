package com.java.Practice;

public class MulThreadTest {
	
	public static void main(String[] args) {
		
		java.lang.Thread t1 = new java.lang.Thread(new MulThread());
		t1.start();
	}

}