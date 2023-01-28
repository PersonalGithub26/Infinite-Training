package com.java.multiThreading;

public class SyncMain {

public static void main(String[] args) {
	
	DataSync data = new DataSync();
	
	ChanduSync cs = new ChanduSync(data);
	CnuSync css = new CnuSync(data);
	PavanSync ps = new PavanSync(data);
	
	Thread t1 = new Thread(cs);
	Thread t2 = new Thread(css);
	Thread t3 = new Thread(ps);
	
	t1.start();
	t2.start();
	t3.start();
}}
