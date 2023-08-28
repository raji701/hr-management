package com.hrmanagement.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.model.ProjectDetails;
import com.hrmanagement.portal.repository.ProjectDetailsRepo;

@Service
public class ProjectDetailsService {

	@Autowired
	private ProjectDetailsRepo projDetailsRepo;
	
	public List<ProjectDetails> allProjectDetails()
	{
		return projDetailsRepo.findAll();
	}
}
