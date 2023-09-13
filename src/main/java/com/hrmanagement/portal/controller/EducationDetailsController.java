package com.hrmanagement.portal.controller;

import java.util.List;

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
import com.hrmanagement.portal.dto.EducationDetailsDto;
import com.hrmanagement.portal.service.EducationDetailsService;

@RestController
@RequestMapping("/educationDetails")
public class EducationDetailsController {
	
	@Autowired
	private EducationDetailsService educationDetailsService ;
	
    @GetMapping("/{employeeId}")
    public ResponseEntity<ApiResponse<EducationDetailsDto>> getEducationDetails(@PathVariable Integer employeeId) {
        EducationDetailsDto educationDetails = educationDetailsService.getEducationDetails(employeeId);
        return ResponseEntity.ok(new ApiResponse<>(educationDetails,null));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EducationDetailsDto>> createEducationDetails(@RequestBody EducationDetailsDto educationDetailsDo) {
     EducationDetailsDto createdEducationDetails = educationDetailsService.createEducationDetails(educationDetailsDo);
     return ResponseEntity.ok(new ApiResponse<>(createdEducationDetails,null));
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<ApiResponse<EducationDetailsDto>> updateEducationDetails(
            @PathVariable Integer employeeId, @RequestBody EducationDetailsDto updatedEducationDetailsDto) {
        
        EducationDetailsDto educationDetails = educationDetailsService.updateEducationDetails(employeeId,updatedEducationDetailsDto);
        return ResponseEntity.ok(new ApiResponse<>(educationDetails,null));
    }

	
	

}
