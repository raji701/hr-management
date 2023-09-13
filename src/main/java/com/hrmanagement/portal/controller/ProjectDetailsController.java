package com.hrmanagement.portal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.ResponseDto.ApiResponse;
import com.hrmanagement.portal.dto.ProjectDetailsDto;
import com.hrmanagement.portal.model.ProjectDetails;
import com.hrmanagement.portal.service.ProjectDetailsService;

@RestController
@RequestMapping("/projectdetails")
public class ProjectDetailsController {

	@Autowired 
	private ProjectDetailsService projectDetailsService;
	
	  @GetMapping
	    public ResponseEntity<ApiResponse<List<ProjectDetailsDto>>> getAllProjectDetails() {
	        List<ProjectDetailsDto> projectDetailsDtoList = projectDetailsService.getAllProjectDetails();
	        return ResponseEntity.ok(new ApiResponse<>(projectDetailsDtoList,null));
	    }

	    @GetMapping("/{projectId}")
	    public ResponseEntity<ApiResponse<ProjectDetailsDto>> getProjectDetailsById(@PathVariable Integer projectId) {
	        ProjectDetailsDto projectDetailsDto = projectDetailsService.getProjectDetailsById(projectId);
	        return ResponseEntity.ok(new ApiResponse<>(projectDetailsDto,null));
	    }

	    @PostMapping("/new")
	    public ResponseEntity<ApiResponse<List<ProjectDetailsDto>>> createProjectDetails(@RequestBody ProjectDetailsDto projectDetailsDto) {
	       List<ProjectDetailsDto> createdProjectDetailsDto = projectDetailsService.createProjectDetails(projectDetailsDto);
	       return ResponseEntity.ok(new ApiResponse<>(createdProjectDetailsDto,null));
	    }

	    @PutMapping("/{projectId}")
	    public ResponseEntity<ApiResponse<ProjectDetailsDto>> updateProjectDetails(
	            @PathVariable Integer projectId, @RequestBody ProjectDetailsDto updatedProjectDetailsDto) {
	        ProjectDetailsDto projectDetailsDto = projectDetailsService.updateProjectDetails(projectId, updatedProjectDetailsDto);
	        return ResponseEntity.ok(new ApiResponse<>(projectDetailsDto,null));
	    }
}
