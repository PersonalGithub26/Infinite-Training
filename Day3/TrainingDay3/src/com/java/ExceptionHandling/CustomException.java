package com.java.ExceptionHandling;

public class CustomException extends Exception{
	
	public CustomException(){};
	
	public CustomException(String error)
	{
		super(error);
	}

}
