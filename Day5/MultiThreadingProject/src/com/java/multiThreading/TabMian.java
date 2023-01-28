package com.java.multiThreading;

public class TabMian {
	
	public static void main(String[] args) {
		
		TrdSaftTable trd = new TrdSaftTable();
		
		Tab1 t1 = new Tab1(trd);
		Tab2 t2 = new Tab2(trd);
		
		Thread tt = new Thread(t1);
		Thread tt1 = new Thread(t2);
		
		tt.start();
		tt1.start();
	}

}
