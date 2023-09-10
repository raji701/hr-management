package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.ResponseDto.ApiResponse;
import com.hrmanagement.portal.dto.ProjectDetailsDto;
import com.hrmanagement.portal.model.ProjectHistory;
import com.hrmanagement.portal.service.ProjectHistoryService;

@RestController
@RequestMapping("/projectshistory")
public class ProjectHistoryController {
	
	@Autowired
	private ProjectHistoryService projectHistoryService;
	
	@GetMapping
	public List<ProjectHistory> listOfProjectsDone()
	{
		return projectHistoryService.allProjectsHistory();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<List<ProjectDetailsDto>>> getProjectHistoryByEmployeeId(@PathVariable Integer id)
	{
		List<ProjectDetailsDto> projectHistory = projectHistoryService.projectHistoryOfAnEmployee(id);
		return ResponseEntity.ok(new ApiResponse<>(projectHistory,null));
	}
}
