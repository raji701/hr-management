package com.hrmanagement.portal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.dto.EmployeeDto;
import com.hrmanagement.portal.model.EmploySkills;
import com.hrmanagement.portal.model.Employee;
import com.hrmanagement.portal.repository.EmployeeSkillsRepo;

@Service
public class EmployeeSkillService {

	@Autowired
	private EmployeeSkillsRepo employeeSkillsRepo;
	
	@Autowired
	private ModelMapper mapper ;
	
	public List<EmploySkills> listOfEmployeeSkills()
	{
		return employeeSkillsRepo.findAll();
	}
	
	
}
