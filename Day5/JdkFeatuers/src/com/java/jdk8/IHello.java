package com.java.jdk8;

//Functional Interface will accept strictly only one abstract method will not allow another method and n number of
// default methods

@FunctionalInterface
public interface IHello {
	
	void dispMsg();
	default void disp()
	
	{
		System.out.println(" This is a default method...");
	}
}
