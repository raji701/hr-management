package com.hrmanagement.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.model.Department;
import com.hrmanagement.portal.repository.DepartmentRepo;



@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo deptRepo;

	// 1.All Departments
	public List<Department> getAllDepartments() {
		return deptRepo.findAll();
	}

	
}
