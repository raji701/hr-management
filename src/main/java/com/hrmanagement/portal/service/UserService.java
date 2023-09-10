package com.hrmanagement.portal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.customexception.InvalidPasswordException;
import com.hrmanagement.portal.customexception.ResourceNotFoundException;
import com.hrmanagement.portal.dto.EmployeeDto;
import com.hrmanagement.portal.dto.UserDto;
import com.hrmanagement.portal.model.Employee;
import com.hrmanagement.portal.model.User;
import com.hrmanagement.portal.repository.EmployeeRepo;
import com.hrmanagement.portal.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper mapper;

	// 1. List Of All Active Users
	public List<UserDto> getAllUsers() {
		List<User> users = userRepo.findAllByStatus(User.Status.activate);
		List<UserDto> userDto = users.stream().map(user -> mapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		return userDto;
	}

	
	//2. Login Api
	public EmployeeDto login(UserDto userDto) {
		String id = userDto.getUserId();
		String password = userDto.getPassWord();
		User user = userRepo.findByUserId(id);
		if (user != null) {
			if (password.equals(user.getPassWord())) {
				Employee employee = employeeRepo.findByUserId(id);
				EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
				return employeeDto;
			} else {
				throw new InvalidPasswordException("Invalid password :" + password + " authentication failed");
			}
		} else {
			throw new ResourceNotFoundException("User with userId: " + id + " not found");
		}
	}


	// 3. Deactivate User
	public UserDto DeleteUser(String id) {
		User user = userRepo.findByUserId(id);
		user.setStatus(User.Status.de_activated);
		userRepo.save(user);
		UserDto userDto = mapper.map(user, UserDto.class);
		return userDto;
	}
}
