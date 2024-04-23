package com.microservice.userservice.UserCustomExceptions;

public class MyEditUserDBNotPossibleException extends Exception {
	public MyEditUserDBNotPossibleException(String errorMessage) {
		super(errorMessage);
	}
}
