package com.java.jUnitDemos;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Data {
	
	public int max3(int a, int b, int c)
	{
		int m = a;
		
			if(m < b)
			{
				m = b;
			}
			if(m < c)
			{
				m = c;
			}
		return m;
	}
	
	public int Sum(int a, int b)
	{
		return a+b;
	}
	
	public String sayHello()
	{
		return "Welcome to Junit Testcase...";
	}
	@Test
	public boolean check(int a)
	{
		if(a%2==0)
		{
			return true;
		}
		return false;
	}
	public Object show(String key)
	{
		Map m = new HashMap();
		m.put("Chandu", "Patel");
		m.put("Srinivas", "Kurumalla");
		m.put("Pavan", "mood");
		return m.get(key);
	}

}
