package com.java.multiThreading;

public class PavanSync implements Runnable{
	
	DataSync data;
	public PavanSync(DataSync data) {
		this.data = data;
	}
	@Override
	public void run() {
			data.dispMsg("pavan");
	}
	
	

}
