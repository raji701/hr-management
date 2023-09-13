package com.hrmanagement.portal.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.customexception.ResourceNotFoundException;
import com.hrmanagement.portal.dto.PersonalDetailsDto;
import com.hrmanagement.portal.model.Employee;
import com.hrmanagement.portal.model.PersonalDetails;
import com.hrmanagement.portal.model.TimingsWorked;
import com.hrmanagement.portal.repository.EmployeeRepo;
import com.hrmanagement.portal.repository.PersonalDetailsRepo;

@Service
public class PersonalDetailsService {

	@Autowired
	private PersonalDetailsRepo personalDetailsRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public PersonalDetailsDto entityToDtoConverter(PersonalDetails personalDetails)
	{
		return mapper.map(personalDetails, PersonalDetailsDto.class);
	}
	
	
	public PersonalDetails dtoToEntityConverter(PersonalDetailsDto personalDetailsDto)
	{
		return mapper.map(personalDetailsDto, PersonalDetails.class);
	}

	// 1.All employee personal Details
	public List<PersonalDetailsDto> getPersonalDetailsOfAllEmployees() {
		List<PersonalDetails> personalDetails = personalDetailsRepo.findAll();
		return personalDetails.stream().map(this::entityToDtoConverter).toList();
	}
	
    public PersonalDetailsDto getPersonalDetailsByEmployeeId(Integer employeeId) {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if (employeeOptional.isPresent()) {
        	  Optional<PersonalDetails> personalDetailsOptional = personalDetailsRepo.findById(employeeId);
              if (personalDetailsOptional.isPresent()) {
            	  PersonalDetails personalDetails = personalDetailsOptional.get();
            	  PersonalDetailsDto peronalDetailsDto = entityToDtoConverter(personalDetails);
            	  return peronalDetailsDto;
              }
              else {
                 throw new ResourceNotFoundException("Personal details not found for employee with ID " + employeeId);
              }          
        }
        else {
            throw new ResourceNotFoundException("Employee with ID " + employeeId + " not found");
        }
    }
        
       
    public PersonalDetailsDto createOrUpdatePersonalDetails(Integer employeeId, PersonalDetailsDto personalDetailsDto) {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if (employeeOptional.isPresent()) {
        	 
        	 PersonalDetails personalDetails = dtoToEntityConverter(personalDetailsDto);
             personalDetailsRepo.save(personalDetails);

             return entityToDtoConverter(personalDetails);
        }
        else {
        	throw new ResourceNotFoundException("Employee with ID " + employeeId + " not found");
        }
    }
}
