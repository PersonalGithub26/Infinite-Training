package com.java.jUnitDemos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataTest {

	static Data obj;
	
	@Before
	public void show()
	{
		System.out.println("Test cases Execution started...");
	}
	
	@After
	public void clear()
	{
		System.out.println("Test cases Execution completed..");
	}
	
	@BeforeClass
	public static void setUo()
	{
		obj = new Data();
		System.out.println("Test casses are geting executed...");
	}
	
	@AfterClass
	
		public static void cleanUp()
		{
			obj = null;
			System.out.println("Test cases completed");
		}
	
	@Test
	public void testsayHello() {

		assertEquals("Welcome to Junit Testcase...", obj.sayHello());
	}

	@Test
	public void testSum()
	{
		assertEquals(5, obj.Sum(2, 3));
	}

	@Test
	public void textMax3()
	{
		
		assertEquals(5, obj.max3(5, 2, 3));
		assertEquals(5, obj.max3(2, 5, 3));
		assertEquals(5, obj.max3(2, 3, 5));
	}
	
	@Test
	public void testCheck()
	{
		Data obj = new Data();
		assertTrue(obj.check(2));
		assertFalse(obj.check(1));
	}
	
	@Test
	public void testArray()
	{
		int[] a = {1,2,3,4};
		int[] b = {1,2,3,4};
		assertArrayEquals(a, b);
	}
	
	@Test
	public void testShow()
	{
		assertNull(obj.show("patel"));
		assertNotNull(obj.show("Chandu"));
	}
}

// sprint zeera ejill