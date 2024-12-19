package com.ems.Exception;

public class EmployeeAlreadyExistException extends RuntimeException{
	public EmployeeAlreadyExistException(String message) {
		
		super(message);
	}

}
