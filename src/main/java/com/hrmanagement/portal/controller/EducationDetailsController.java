package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.model.EducationDetails;
import com.hrmanagement.portal.service.EducationDetailsService;

@RestController
public class EducationDetailsController {
	
	@Autowired
	private EducationDetailsService eduService ;
	
	@GetMapping("/educationdetails")
	public List<EducationDetails> listOfEmployeeEducationDetails()
	{
		return eduService.AllEmployeeEducationDetails();
	}

}
