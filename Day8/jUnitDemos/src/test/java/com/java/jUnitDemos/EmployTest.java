package com.java.jUnitDemos;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployTest {
	
	@Test
	public void testConstructors()
	{
		Employ employ = new Employ();
		assertNotNull(employ);
		Employ employ2 = new Employ(1, "Chandu", Gender.MALE, "ece", "java", 25674.53);
		assertEquals(1, employ2.getEmpId());
		assertEquals("Chandu", employ2.getName());
		assertEquals(Gender.MALE, employ2.getGender());
		assertEquals("ece", employ2.getDept());
		assertEquals("java", employ2.getDesig());
		assertEquals(25674.53, employ2.getBasic(), 0);
				
	}
	@Test
	public void testGettersAndSetters()
	{
		Employ employ = new Employ();
		employ.setEmpId(1);
		employ.setName("chandu");
		employ.setGender(Gender.MALE);
		employ.setDept("ece");
		employ.setDesig("java");
		employ.setBasic(2345.82);
		
		assertEquals(1, employ.getEmpId());
		assertEquals("chandu", employ.getName());
		assertEquals(Gender.MALE, employ.getGender());
		assertEquals("ece", employ.getDept());
		assertEquals("java", employ.getDesig());
		assertEquals(2345.82, employ.getBasic(), 0);
		
	}
	@Test
	public void testToString()
	{
		Employ employ = new Employ(1, "chandu", Gender.MALE, "ece","java",2345.82);
		
		String result = "Employ [empId=" + employ.getEmpId() + ", name=" + employ.getName() 
		+", gender="+ employ.getGender() + ", dept=" +employ.getDept()+", desig="+employ.getDesig()
		+", basic="+employ.getBasic() + "]";
		
		assertEquals(result, employ.toString());
	} 
}
