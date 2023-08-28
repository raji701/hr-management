package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.model.User;
import com.hrmanagement.portal.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	// 1.List of Users
	@GetMapping("/users")
	public List<User> listUsers() {
		return userService.getAllUsers();
	}
}
