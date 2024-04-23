package com.microservice.userservice.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservice.userservice.UserCustomExceptions.MyEditUserDBNotPossibleException;
import com.microservice.userservice.UserCustomExceptions.MyUserByIdNotFoundException;

@ControllerAdvice
public class GlobalUserExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = MyUserByIdNotFoundException.class)
	public ResponseEntity<String> MyUserByIdNotFoundExceptionF(MyUserByIdNotFoundException message) {
		return new ResponseEntity<String>(message.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = MyEditUserDBNotPossibleException.class)
	public ResponseEntity<String> MyEditUserDBNotPossibleExceptionF(MyEditUserDBNotPossibleException message) {
		return new ResponseEntity<>(message.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
