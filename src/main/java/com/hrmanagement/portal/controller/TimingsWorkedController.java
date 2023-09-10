package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.ResponseDto.ApiResponse;
import com.hrmanagement.portal.dto.TimingsWorkedDto;
import com.hrmanagement.portal.service.TimingsWorkedService;

@RestController
@RequestMapping("/timingsworked")
public class TimingsWorkedController {
	
	@Autowired
	private TimingsWorkedService timingsWorkedService;
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<TimingsWorkedDto>>> getAll()
	{
		List<TimingsWorkedDto> timingsWorkedDto = timingsWorkedService.timingsWorked();
		return  ResponseEntity.ok(new ApiResponse<>(timingsWorkedDto,null));
	}

}
