package com.java.EmailValidatation;

public class InvalidEmailException extends Exception{
	
	public InvalidEmailException(){}
	
	public InvalidEmailException(String error)
	{
		super(error);
	}

}
