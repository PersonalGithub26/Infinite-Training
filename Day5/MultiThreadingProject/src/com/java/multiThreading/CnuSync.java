package com.java.multiThreading;

public class CnuSync implements Runnable
{
	DataSync data;
	public CnuSync(DataSync data) {
		this.data = data;
	}
	@Override
	public void run() {
		data.dispMsg("Cnu");
		
	}

}
