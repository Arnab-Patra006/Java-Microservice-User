package com.microservice.userservice.service;

import org.springframework.http.ResponseEntity;
import com.microservice.userservice.UserCustomExceptions.MyEditUserDBNotPossibleException;
import com.microservice.userservice.UserCustomExceptions.MyUserByIdNotFoundException;
import com.microservice.userservice.entity.User;

public interface UserService {
	public ResponseEntity<String> Create(User newUser) throws MyEditUserDBNotPossibleException;

	public ResponseEntity<User> GetUserById(Integer userid) throws MyUserByIdNotFoundException;

	public ResponseEntity<User> UpdateUserById(User user, Integer userid)
			throws MyUserByIdNotFoundException, MyEditUserDBNotPossibleException;

	public ResponseEntity<String> DeleteUser(Integer userid) throws MyEditUserDBNotPossibleException;
}
