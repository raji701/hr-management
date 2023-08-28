package com.hrmanagement.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.model.Employee;
import com.hrmanagement.portal.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	// 1. List Of Employees
		public List<Employee> getAllEmployees() {
			return employeeRepo.findAll();
		}

}
