package com.hrmanagement.portal.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.customexception.ResourceNotFoundException;
import com.hrmanagement.portal.dto.EmployeeDto;
import com.hrmanagement.portal.dto.ProjectDetailsDto;
import com.hrmanagement.portal.model.Employee;
import com.hrmanagement.portal.model.ProjectDetails;
import com.hrmanagement.portal.model.ProjectDetails.ProjectStatus;
import com.hrmanagement.portal.repository.ProjectDetailsRepo;

@Service
public class ProjectDetailsService {

  private final ProjectDetailsRepo projectDetailsRepo;
  private final ModelMapper mapper;
  
	@Autowired
	public ProjectDetailsService(ProjectDetailsRepo projectDetailsRepo ,ModelMapper mapper) {		
		this.projectDetailsRepo = projectDetailsRepo;
		this.mapper = mapper;
	}
		
	
    public List<ProjectDetailsDto> getAllProjectDetails(){
    	List<ProjectDetails> projectDetailsList= projectDetailsRepo.findAll();
    	List<ProjectDetailsDto> projectDetailsDtoList =projectDetailsList.stream().map(project -> mapper.map(project, ProjectDetailsDto.class)).toList();
    	return projectDetailsDtoList;
    }

    public ProjectDetailsDto getProjectDetailsByProjectId(Integer projectId) {
    	Optional<ProjectDetails> projectDetails  = projectDetailsRepo.findById(projectId);
    	if(projectDetails.isPresent())
    	{	
    		ProjectDetails optionalProjectDetails = projectDetails.get();
    		ProjectDetailsDto projectDetailsDto = mapper.map(optionalProjectDetails , ProjectDetailsDto.class);
    		return projectDetailsDto;
    	}
    	else
    	{
    		throw new ResourceNotFoundException("Project Id :"+ projectId + "Not Found");
    	}
    }

    public List<ProjectDetailsDto> createProjectDetails(ProjectDetailsDto projectDetailsDto) {
        
    	ProjectDetails projectDetails = mapper.map(projectDetailsDto,ProjectDetails.class);
        projectDetailsRepo.save(projectDetails);
        return getAllProjectDetails();
    }

    public ProjectDetailsDto updateProjectDetails(Integer projectId, ProjectDetailsDto updatedProjectDetailsDto) {
    
    	Optional<ProjectDetails> OptionalProjectDetails = projectDetailsRepo.findById(projectId);
    	if(OptionalProjectDetails.isPresent())
    	{
    		ProjectDetails projectDetails = mapper.map(updatedProjectDetailsDto,ProjectDetails.class);
    		ProjectDetails savedProjectDetails = projectDetailsRepo.save(projectDetails);
    		ProjectDetailsDto projectDetailsDto = mapper.map(savedProjectDetails,ProjectDetailsDto.class);
    		return projectDetailsDto;
    	}
    	else
    	{
    		throw new ResourceNotFoundException("Project Id :"+ projectId + "Not Found");
    	}
    	
    }
    
    public List<ProjectDetailsDto> projectsByStatus(ProjectStatus status)
    {
    	List<ProjectDetails> projectDetailsList = projectDetailsRepo.findAllByStatus(status);
		List<ProjectDetailsDto> projectDetailsDtoList = projectDetailsList.stream()
				.map(project -> mapper.map(project, ProjectDetailsDto.class)).collect(Collectors.toList());

		return projectDetailsDtoList;
    }

}
