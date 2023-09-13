package com.hrmanagement.portal.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.customexception.ResourceNotFoundException;
import com.hrmanagement.portal.dto.EducationDetailsDto;
import com.hrmanagement.portal.model.EducationDetails;
import com.hrmanagement.portal.repository.EducationDetailsRepo;



@Service
public class EducationDetailsService {
	
	@Autowired
	private EducationDetailsRepo educationDetailsRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public EducationDetailsDto entityToDtoConverter(EducationDetails educationDetails)
	{
		return mapper.map(educationDetails, EducationDetailsDto.class);
	}
	
	
	public EducationDetails dtoToEntityConverter(EducationDetailsDto educationDetailsDto)
	{
		return mapper.map(educationDetailsDto, EducationDetails.class);
	}
	
	   public EducationDetailsDto getEducationDetails(Integer employeeId) {
	      Optional<EducationDetails> educationDetails = educationDetailsRepo.findById(employeeId);
	      if(educationDetails.isPresent())
	      {
	    	  EducationDetails educationDetailsRecord = educationDetails.get();
	    	  EducationDetailsDto educationDetailsDto = entityToDtoConverter(educationDetailsRecord);
	    	  return educationDetailsDto;
	      }
	      else
	      {
	    	  throw new ResourceNotFoundException("Employee Id :"+ employeeId +" not found");
	      }
	    }

	    public EducationDetailsDto createEducationDetails(EducationDetailsDto educationDetailsDto) {
	        
	    	EducationDetails educationDetails = dtoToEntityConverter(educationDetailsDto);
	    	EducationDetails savedEducationDetails =educationDetailsRepo.save(educationDetails);
	    	EducationDetailsDto savedEducationDetailsDto = entityToDtoConverter(savedEducationDetails);
	    	return savedEducationDetailsDto;
	    	
	    }

	    public EducationDetailsDto updateEducationDetails(Integer employeeId ,EducationDetailsDto educationDetailsDto) {
	        
	    	Optional<EducationDetails> optionalEducationaDetails = educationDetailsRepo.findById(employeeId);
	    	if(optionalEducationaDetails.isPresent()) {
	    		
	    	EducationDetails getOptionalEducationaDetails =	optionalEducationaDetails.get();
	    	dtoToEntityConverter(educationDetailsDto);
	    	EducationDetails updateEducationDetails =educationDetailsRepo.save(getOptionalEducationaDetails);
	    	EducationDetailsDto updateEducationDetailsDto = entityToDtoConverter(updateEducationDetails);
	    	return updateEducationDetailsDto;
	    	}
	    	else
	    	{
	    		throw new ResourceNotFoundException("Employee Id :"+ employeeId +" not found");
	    	}
	    }
}
