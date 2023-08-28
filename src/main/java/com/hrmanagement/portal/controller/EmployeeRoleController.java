package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.model.EmployeeRole;
import com.hrmanagement.portal.service.EmployeeRoleService;

@RestController
public class EmployeeRoleController {

		@Autowired
		private EmployeeRoleService employeeRoleService;
		
		@GetMapping("/employeeroles")
		public List<EmployeeRole> listOfEmployeeRoles()
		{
			return employeeRoleService.allemployeeRoleList();
		}
}
