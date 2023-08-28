package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.model.Employee;
import com.hrmanagement.portal.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// 1.List of Users
			@GetMapping("/employees")
			public List<Employee> listOfEmployees() {
				return employeeService.getAllEmployees();
			}


}
