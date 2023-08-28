package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.model.PersonalDetails;
import com.hrmanagement.portal.service.PersonalDetailsService;

@RestController
public class PersonalDetailsController {

	@Autowired
	private PersonalDetailsService personalDetailsService;
	
	//1. employees personal details list
	
		@GetMapping("/personaldetails")
		public List<PersonalDetails> personalDetails()
		{
			return personalDetailsService.getPersonalDetailsOfAllEmployees();
		}
}
