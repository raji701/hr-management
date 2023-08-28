package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.model.ProjectHistory;
import com.hrmanagement.portal.service.ProjectHistoryService;

@RestController
public class ProjectHistoryController {
	
	@Autowired
	private ProjectHistoryService projectHistoryService;
	
	@GetMapping("/projectshistory")
	public List<ProjectHistory> listOfProjectsDone()
	{
		return projectHistoryService.allProjectsHistory();
	}

}
