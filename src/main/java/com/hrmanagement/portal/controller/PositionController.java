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
import com.hrmanagement.portal.dto.PositionDto;
import com.hrmanagement.portal.service.PositionService;

@RestController
@RequestMapping("/positions")
public class PositionController {
	
	@Autowired
	private PositionService positionService;
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<PositionDto>>> positions() {
		List<PositionDto> positionDto = positionService.getPositionsOfAllEmployees();
		return ResponseEntity.ok(new ApiResponse<>(positionDto, null));
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<ApiResponse<PositionDto>> getPositionByEmployeeId(
			@PathVariable Integer employeeId) {
		PositionDto positionDto = positionService.getPositionByEmployeeId(employeeId);
		return ResponseEntity.ok(new ApiResponse<>(positionDto, null));

	}

	@PostMapping("/{employeeId}")
	public ResponseEntity<ApiResponse<PositionDto>> createOrUpdatePosition(@PathVariable Integer employeeId,
			@RequestBody PositionDto positionDto) {
		PositionDto createdPositionDto = positionService.createOrUpdatePosition(employeeId, positionDto);
		return ResponseEntity.ok(new ApiResponse<>(createdPositionDto,null));

	}

}
