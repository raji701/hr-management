package com.hrmanagement.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrmanagement.portal.model.User;
import com.hrmanagement.portal.model.User.Status;



public interface UserRepo extends JpaRepository<User,Integer> {

	User findByUserId(String id);
	
	List<User> findAllByStatus(Status status);
	
	
}
