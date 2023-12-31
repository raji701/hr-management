package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.ResponseDto.ApiResponse;
import com.hrmanagement.portal.dto.EmployeeDto;
import com.hrmanagement.portal.model.EmploySkills;
import com.hrmanagement.portal.service.EmployeeSkillService;

@RestController
@RequestMapping("/employeeskills")
public class EmployeeSkillsController {

	@Autowired
	private EmployeeSkillService employeeSkillsService;
	
	@GetMapping
	public List<EmploySkills> employeeSkillsList()
	{
		return employeeSkillsService.listOfEmployeeSkills();
	}
	
	
}
