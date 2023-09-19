package com.hrmanagement.portal.service;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.hrmanagement.portal.customexception.ResourceNotFoundException;
import com.hrmanagement.portal.dto.EducationDetailsDto;
import com.hrmanagement.portal.model.EducationDetails;
import com.hrmanagement.portal.repository.EducationDetailsRepo;
import com.hrmanagement.portal.repository.EmployeeRepo;



@Service
public class EducationDetailsService {
	
	 private final EducationDetailsRepo educationDetailsRepo;
	 private final ModelMapper mapper;
	 private final EmployeeRepo employeeRepo;
	 
	@Autowired
	public EducationDetailsService(EducationDetailsRepo educationDetailsRepo ,ModelMapper mapper,EmployeeRepo employeeRepo)
	{
		this.educationDetailsRepo = educationDetailsRepo ;
		this.mapper = mapper;
		this.employeeRepo = employeeRepo;
	}
	
	
	// education details of an employee
	   public EducationDetailsDto getEducationDetailsOfEmployee(Integer employeeId) {
	     employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee Id :"+ employeeId +" not found"));
	     EducationDetails educationDetails =  educationDetailsRepo.findAllByEmployeeId(employeeId);
	     if(educationDetails != null)
	      {
	    	  EducationDetailsDto educationDetailsDto = mapper.map(educationDetails, EducationDetailsDto.class);
	    	  return educationDetailsDto;
	      }
	      else
	      {
	    	  throw new ResourceNotFoundException("Education details are not found for employee with employeeId: "+ employeeId );
	      }
	    }

	 // posting educational details of an employee 
	    public EducationDetailsDto createEducationDetails(EducationDetailsDto educationDetailsDto) {
	    	Integer employeeId = educationDetailsDto.getEmployeeId();
	    	employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("you can't post details because the employee with this id : "+ employeeId +" isn't present"));
			if (educationDetailsRepo.existsById(employeeId)) {
				throw new DataIntegrityViolationException("The record already exists with id : " + employeeId);
			}
	    	EducationDetails educationDetails = mapper.map(educationDetailsDto, EducationDetails.class);
	    	EducationDetails savedEducationDetails =educationDetailsRepo.save(educationDetails);
	    	EducationDetailsDto savedEducationDetailsDto = mapper.map(savedEducationDetails, EducationDetailsDto.class);
	    	return savedEducationDetailsDto;
	    	
	    }

	    // updating education details of an employee
	    public EducationDetailsDto updateEducationDetails(Integer employeeId ,EducationDetailsDto educationDetailsDto) {
	    	employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("you can't update education details because the employee with this id : "+ employeeId +" isn't present"));
	    	EducationDetails existingEducationalDetails = educationDetailsRepo.findAllByEmployeeId(employeeId);
	    	if(existingEducationalDetails != null) {
	    		
	    		mapper.map(educationDetailsDto ,existingEducationalDetails);
		    	EducationDetails updatedEducationDetails =educationDetailsRepo.save(existingEducationalDetails);
		    	EducationDetailsDto updatedEducationDetailsDto = mapper.map(updatedEducationDetails, EducationDetailsDto.class);
		    	return updatedEducationDetailsDto;
	    	}
	    	else
	    	{
	    		throw new ResourceNotFoundException("Employee Id :"+ employeeId +" not found");
	    	}
	    }
	    
	    // partial updation of employee education details 
	   public EducationDetailsDto partiallyUpdatedEducationalDetails(Integer employeeId ,EducationDetailsDto educationDetailsDto)
	   {
		   employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("you can't update education details because the employee with this id : "+ employeeId +" isn't present"));
		   EducationDetails existingEducationalDetails = educationDetailsRepo.findAllByEmployeeId(employeeId);
	    	if(existingEducationalDetails != null) {
	    		
	    		if (educationDetailsDto.getDegree() != null) {
	    			existingEducationalDetails.setDegree(educationDetailsDto.getDegree());
	            }

	            if (educationDetailsDto.getInstitute() != null) {
	            	existingEducationalDetails.setInstitute(educationDetailsDto.getInstitute());
	            }
	            
	            if(educationDetailsDto.getCgpa()!= null) {
	            	existingEducationalDetails.setCgpa(educationDetailsDto.getCgpa());	            		 
	            }
	            
	            if(educationDetailsDto.getUniversity()!= null) {
	            	existingEducationalDetails.setUniversity(educationDetailsDto.getUniversity());		
	            }
	            
	            if(educationDetailsDto.getSpecialization()!= null) {
	            	existingEducationalDetails.setSpecialization(educationDetailsDto.getSpecialization());		
	            }
	            	
	            if(educationDetailsDto.getSpecialization()!= null) {
	            	existingEducationalDetails.setSpecialization(educationDetailsDto.getSpecialization());		
	            }
	            
	            if(educationDetailsDto.getYearOfPassing()!= null) {
	            	existingEducationalDetails.setYearOfPassing(educationDetailsDto.getYearOfPassing());		
	            }
	            
	            EducationDetails updatedColumnValues = educationDetailsRepo.save(existingEducationalDetails);
	            EducationDetailsDto updatededucationDetailsDto = mapper.map(updatedColumnValues, EducationDetailsDto.class);
	            return updatededucationDetailsDto;
	    	}
	    	else
	    	{
	    		throw new ResourceNotFoundException("Employee Id :"+ employeeId +" not found");
	    	}
	   }
}
