package com.hrmanagement.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.model.EmploySkills;
import com.hrmanagement.portal.repository.EmployeeSkillsRepo;

@Service
public class EmployeeSkillService {

	@Autowired
	private EmployeeSkillsRepo empSkillsRepo;
	
	public List<EmploySkills> listOfEmployeeSkills()
	{
		return empSkillsRepo.findAll();
	}
}
