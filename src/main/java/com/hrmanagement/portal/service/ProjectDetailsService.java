package com.hrmanagement.portal.service;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.customexception.ResourceNotFoundException;
import com.hrmanagement.portal.dto.ProjectDetailsDto;
import com.hrmanagement.portal.model.ProjectDetails;
import com.hrmanagement.portal.repository.ProjectDetailsRepo;

@Service
public class ProjectDetailsService {

	@Autowired
	private ProjectDetailsRepo projectDetailsRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public ProjectDetailsDto entityToDtoConverter(ProjectDetails projectDetails)
	{
		return mapper.map(projectDetails, ProjectDetailsDto.class);
	}
	
	
	public ProjectDetails dtoToEntityConverter(ProjectDetailsDto projectDetailsDto)
	{
		return mapper.map(projectDetailsDto, ProjectDetails.class);
	}
	
    public List<ProjectDetailsDto> getAllProjectDetails(){
    	List<ProjectDetails> projectDetailsList= projectDetailsRepo.findAll();
    	List<ProjectDetailsDto> projectDetailsDtoList =projectDetailsList.stream().map(this::entityToDtoConverter).toList();
    	return projectDetailsDtoList;
    }

    public ProjectDetailsDto getProjectDetailsById(Integer projectId) {
    	Optional<ProjectDetails> projectDetails  = projectDetailsRepo.findById(projectId);
    	if(projectDetails.isPresent())
    	{	
    		ProjectDetails optionalProjectDetails = projectDetails.get();
    		ProjectDetailsDto projectDetailsDto = entityToDtoConverter(optionalProjectDetails);
    		return projectDetailsDto;
    	}
    	else
    	{
    		throw new ResourceNotFoundException("Project Id :"+ projectId + "Not Found");
    	}
    }

    public List<ProjectDetailsDto> createProjectDetails(ProjectDetailsDto projectDetailsDto) {
        
    	ProjectDetails projectDetails = dtoToEntityConverter(projectDetailsDto);
        projectDetailsRepo.save(projectDetails);
        return getAllProjectDetails();
    }

    public ProjectDetailsDto updateProjectDetails(Integer projectId, ProjectDetailsDto updatedProjectDetailsDto) {
    
    	Optional<ProjectDetails> OptionalProjectDetails = projectDetailsRepo.findById(projectId);
    	if(OptionalProjectDetails.isPresent())
    	{
    		ProjectDetails projectDetails = dtoToEntityConverter(updatedProjectDetailsDto);
    		ProjectDetails savedProjectDetails = projectDetailsRepo.save(projectDetails);
    		ProjectDetailsDto projectDetailsDto = entityToDtoConverter(savedProjectDetails);
    		return projectDetailsDto;
    	}
    	else
    	{
    		throw new ResourceNotFoundException("Project Id :"+ projectId + "Not Found");
    	}
    	
    }

}
