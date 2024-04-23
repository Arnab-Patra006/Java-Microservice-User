package com.microservice.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.userservice.entity.User;
import com.microservice.userservice.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserServiceImpl userservice;

	@PostMapping("create")
	public ResponseEntity<String> CreateNewUser(@RequestBody User user) throws Exception {
		return userservice.Create(user);
	}

	@GetMapping("/{userid}")
	public ResponseEntity<User> UserById(@PathVariable Integer userid) throws Exception {
		return userservice.GetUserById(userid);
	}

	@PutMapping("/update/{userid}")
	public ResponseEntity<User> UpdateUser(@RequestBody User user, @PathVariable Integer userid) throws Exception {
		return userservice.UpdateUserById(user, userid);
	}

	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<String> DeleteUser(@PathVariable Integer userid) throws Exception {
		return userservice.DeleteUser(userid);
	}
}
