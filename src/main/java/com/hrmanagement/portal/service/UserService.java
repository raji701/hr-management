package com.hrmanagement.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.model.User;
import com.hrmanagement.portal.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	// 1. List Of Users
			public List<User> getAllUsers() {
				return userRepo.findAll();
			}

}
