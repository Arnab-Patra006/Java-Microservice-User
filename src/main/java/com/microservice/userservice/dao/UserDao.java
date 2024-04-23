package com.microservice.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.userservice.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
