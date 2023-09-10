package com.hrmanagement.portal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.dto.TimingsWorkedDto;
import com.hrmanagement.portal.model.TimingsWorked;
import com.hrmanagement.portal.repository.TimingsWorkedRepo;

@Service
public class TimingsWorkedService {
	
	@Autowired
	private TimingsWorkedRepo timingsWorkedRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<TimingsWorkedDto> timingsWorked()
	{
		List<TimingsWorked> timingsWorked = timingsWorkedRepo.findAll();
		List<TimingsWorkedDto> timingsWorkedDto = timingsWorked
				.stream()
				.map(timings-> mapper.map(timings,TimingsWorkedDto.class ))
				.collect(Collectors.toList());
		return timingsWorkedDto;
	}

}
