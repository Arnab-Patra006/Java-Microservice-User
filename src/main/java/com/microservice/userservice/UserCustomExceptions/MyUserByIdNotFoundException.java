package com.microservice.userservice.UserCustomExceptions;

public class MyUserByIdNotFoundException extends Exception {
	public MyUserByIdNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
