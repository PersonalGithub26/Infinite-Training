package com.java.EmailValidatation;

public class InvalidUserException extends Exception{
	
	public InvalidUserException(){}
	
	public InvalidUserException(String error)
	{
		super(error);
	}
	

}
