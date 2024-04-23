package com.microservice.userservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.microservice.userservice.UserCustomExceptions.MyEditUserDBNotPossibleException;
import com.microservice.userservice.UserCustomExceptions.MyUserByIdNotFoundException;
import com.microservice.userservice.dao.UserDao;
import com.microservice.userservice.entity.User;
import com.microservice.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	public ResponseEntity<String> Create(User newUser) throws MyEditUserDBNotPossibleException {
		try {
			userdao.save(newUser);
			return new ResponseEntity<>("User Created SuccessFully", HttpStatus.CREATED);
		} catch (Exception e) {
			throw new MyEditUserDBNotPossibleException("Invalid User Creation Request");
		}
	}

	public ResponseEntity<User> GetUserById(Integer userid) throws MyUserByIdNotFoundException {
		try {
			User u = userdao.findById(userid).get();
			return new ResponseEntity<>(u, HttpStatus.OK);
		} catch (Exception e) {
			throw new MyUserByIdNotFoundException("No Such User present with id " + userid);
		}
	}

	public ResponseEntity<User> UpdateUserById(User user, Integer userid)
			throws MyUserByIdNotFoundException, MyEditUserDBNotPossibleException {
		String username = user.getUsername();
		String email = user.getEmail();
		String password = user.getPassword();
		User existingUser = new User();
		try {
			existingUser = userdao.findById(userid).get();
		} catch (Exception e) {
			throw new MyUserByIdNotFoundException("No Such User present with id " + userid);
		}
		existingUser.setUsername(username);
		existingUser.setEmail(email);
		existingUser.setPassword(password);
		try {
			userdao.save(existingUser);
			return new ResponseEntity<>(existingUser, HttpStatus.OK);
		} catch (Exception e) {
			throw new MyEditUserDBNotPossibleException("Invalid User Updation Request");
		}
	}

	public ResponseEntity<String> DeleteUser(Integer userid) throws MyEditUserDBNotPossibleException {
		try {
			userdao.deleteById(userid);
			return new ResponseEntity<String>("User Deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			throw new MyEditUserDBNotPossibleException("Invalid User Deletion Request");
		}
	}
}
