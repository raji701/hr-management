package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.ResponseDto.ApiResponse;
import com.hrmanagement.portal.dto.PersonalDetailsDto;
import com.hrmanagement.portal.service.PersonalDetailsService;

@RestController
public class PersonalDetailsController {

	@Autowired
	private PersonalDetailsService personalDetailsService;

	// 1. employees personal details list

	@GetMapping("/personaldetails")
	public ResponseEntity<ApiResponse<List<PersonalDetailsDto>>> personalDetails() {
		List<PersonalDetailsDto> personalDetailsDto = personalDetailsService.getPersonalDetailsOfAllEmployees();
		return ResponseEntity.ok(new ApiResponse<>(personalDetailsDto, null));
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<ApiResponse<PersonalDetailsDto>> getPersonalDetailsByEmployeeId(
			@PathVariable Integer employeeId) {
		PersonalDetailsDto personalDetailsDto = personalDetailsService.getPersonalDetailsByEmployeeId(employeeId);
		return ResponseEntity.ok(new ApiResponse<>(personalDetailsDto, null));

	}

	@PostMapping("/{employeeId}")
	public ResponseEntity<ApiResponse<PersonalDetailsDto>> createOrUpdatePersonalDetails(@PathVariable Integer employeeId,
			@RequestBody PersonalDetailsDto personalDetailsDto) {
		PersonalDetailsDto createdPersonalDetailsDto = personalDetailsService.createOrUpdatePersonalDetails(employeeId, personalDetailsDto);
		return ResponseEntity.ok(new ApiResponse<>(createdPersonalDetailsDto,null));

	}
}
