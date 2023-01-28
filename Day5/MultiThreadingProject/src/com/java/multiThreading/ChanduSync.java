package com.java.multiThreading;

public class ChanduSync implements Runnable{
	
	DataSync data;
	
	public ChanduSync(DataSync data) {
		this.data = data;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
			data.dispMsg("Chandu");
	}

}
