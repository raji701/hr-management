package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.model.ProjectDetails;
import com.hrmanagement.portal.service.ProjectDetailsService;

@RestController
public class ProjectDetailsController {

	@Autowired 
	private ProjectDetailsService projectDetailsService;
	
	@GetMapping("/projectdetails")
	public List<ProjectDetails> listOfProjectDetails()
	{
		return projectDetailsService.allProjectDetails();
	}
}
