package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.model.EmploySkills;
import com.hrmanagement.portal.service.EmployeeSkillService;

@RestController
public class EmployeeSkillsController {

	@Autowired
	private EmployeeSkillService employeeSkillsService;
	
	@GetMapping("/employeeskills")
	public List<EmploySkills> employeeSkillsList()
	{
		return employeeSkillsService.listOfEmployeeSkills();
	}
}
