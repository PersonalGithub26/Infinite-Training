package com.java.abs1;

public class MobileFactory implements MobileDetails{

	@Override
	public Mobile getMobileDetails(String value) {
		if(value.equals("Iphone"))
		{
			return new IPhone();
		}
		if(value.equals("samsung"))
		{
			return new Samsung();
		}
		if(value.equals("OnePlus"))
		{
			return new OnePlus();
		}
		
		return null;
	}

}
