package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.model.Department;
import com.hrmanagement.portal.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired 
	private DepartmentService deptService;
	
	//1. list of departments
	@GetMapping("/departments")
	public List<Department> allDepartments()
	{
		return deptService.getAllDepartments();
	}
	
	
}
