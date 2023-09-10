package com.hrmanagement.portal.customexception;

public class InvalidPasswordException extends RuntimeException{

	public InvalidPasswordException(String message)
	{
		super(message);
	}
}
