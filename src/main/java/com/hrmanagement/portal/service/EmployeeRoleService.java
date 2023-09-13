package com.hrmanagement.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.model.EmployeeRole;
import com.hrmanagement.portal.repository.EmployeeRoleRepo;

@Service
public class EmployeeRoleService {

	@Autowired
	private EmployeeRoleRepo empRoleRepo;
	
	public List<EmployeeRole> allemployeeRoleList()
	{
		return empRoleRepo.findAll();
    }
	
	
}