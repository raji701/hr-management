package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.ResponseDto.ApiResponse;
import com.hrmanagement.portal.dto.ProjectDetailsDto;
import com.hrmanagement.portal.dto.ProjectHistoryDto;
import com.hrmanagement.portal.model.ProjectHistory;
import com.hrmanagement.portal.service.ProjectHistoryService;

@RestController
@RequestMapping("/projectshistory")
public class ProjectHistoryController {

	@Autowired
	private ProjectHistoryService projectHistoryService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<ProjectHistoryDto>>> ProjectHistory() {
		List<ProjectHistoryDto> createdProjectHistoryDto = projectHistoryService.getAllProjectsHistory();
		return ResponseEntity.ok(new ApiResponse<>(createdProjectHistoryDto , null));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<List<ProjectDetailsDto>>> getProjectHistoryByEmployeeId(
			@PathVariable Integer id) {
		List<ProjectDetailsDto> projectHistory = projectHistoryService.projectHistoryOfAnEmployee(id);
		return ResponseEntity.ok(new ApiResponse<>(projectHistory, null));
	}

	@PostMapping
	public ResponseEntity<ApiResponse<List<ProjectHistoryDto>>> createProjectHistory(@RequestBody ProjectHistoryDto projectHistoryDto) {
		List<ProjectHistoryDto> createdProjectHistory = projectHistoryService.createProjectHistory(projectHistoryDto);
		return ResponseEntity.ok(new ApiResponse<>(createdProjectHistory , null));
	}
}
