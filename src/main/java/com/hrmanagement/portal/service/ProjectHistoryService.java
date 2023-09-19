package com.hrmanagement.portal.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.dto.ProjectDetailsDto;
import com.hrmanagement.portal.dto.ProjectHistoryDto;
import com.hrmanagement.portal.model.ProjectDetails;
import com.hrmanagement.portal.model.ProjectHistory;
import com.hrmanagement.portal.repository.ProjectHistoryRepo;

@Service
public class ProjectHistoryService {
	
	@Autowired
	private ProjectHistoryRepo projectHistoryRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public ProjectHistoryDto entityToDtoConverter(ProjectHistory projectHistory)
	{
		return mapper.map(projectHistory, ProjectHistoryDto.class);
	}
	
	
	public ProjectHistory dtoToEntityConverter(ProjectHistoryDto projectHistoryDto )
	{
		return mapper.map(projectHistoryDto, ProjectHistory.class);
	}
	
	
	

	public List<ProjectDetailsDto> projectHistoryOfAnEmployee(Integer id)
	{
		List<ProjectDetails> projectHistory = projectHistoryRepo.ProjectHistoryByEmployeeId(id);
		List<ProjectDetailsDto> projectHistoryDto = projectHistory
				.stream()
				.map(project -> mapper.map(project ,ProjectDetailsDto.class))
				.collect(Collectors.toList());
		return projectHistoryDto;
	}
	


  

   
}
