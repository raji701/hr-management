package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.ResponseDto.ApiResponse;
import com.hrmanagement.portal.dto.EmployeeDto;
import com.hrmanagement.portal.dto.UserDto;
import com.hrmanagement.portal.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	// 1.List of Users
	@GetMapping
	public ResponseEntity<ApiResponse<List<UserDto>>> Get()
	{
		List<UserDto> userDto = userService.getAllUsers();
		return ResponseEntity.ok(new ApiResponse<>(userDto, null));
	}
	
	@GetMapping("/login")
	public ResponseEntity<ApiResponse<EmployeeDto>> userLogin(@RequestBody UserDto userDto) {
		EmployeeDto userEmployeeDetails = userService.login(userDto);
		return ResponseEntity.ok(new ApiResponse<>(userEmployeeDetails, null));
	}
 
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<UserDto>> deleteUser(@PathVariable String id) {
		UserDto deActivedUser = userService.DeleteUser(id);
		return ResponseEntity.ok(new ApiResponse<>(deActivedUser, null));
	}
	
}
