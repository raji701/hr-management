package com.hrmanagement.portal.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.customexception.ResourceNotFoundException;
import com.hrmanagement.portal.dto.PersonalDetailsDto;
import com.hrmanagement.portal.dto.PositionDto;
import com.hrmanagement.portal.model.Employee;
import com.hrmanagement.portal.model.PersonalDetails;
import com.hrmanagement.portal.model.Position;
import com.hrmanagement.portal.repository.EmployeeRepo;
import com.hrmanagement.portal.repository.PositionRepo;

@Service
public class PositionService {

	@Autowired
	private PositionRepo positionRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public PositionDto entityToDtoConverter(Position position)
	{
		return mapper.map(position, PositionDto.class);
	}
	
	
	public Position dtoToEntityConverter(PositionDto positionDto)
	{
		return mapper.map(positionDto, Position.class);
	}
	
	public List<PositionDto> getPositionsOfAllEmployees() {
		List<Position> personalDetails = positionRepo.findAll();
		return personalDetails.stream().map(this::entityToDtoConverter).toList();
	}
	
	public PositionDto getPositionByEmployeeId(Integer employeeId) {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if (employeeOptional.isPresent()) {
        	  Optional<Position> positionOptional = positionRepo.findById(employeeId);
              if (positionOptional.isPresent()) {
            	  Position position = positionOptional.get();
            	  PositionDto positionDto = entityToDtoConverter(position);
            	  return positionDto;
              }
              else {
                 throw new ResourceNotFoundException("Positional details not found for employee with ID " + employeeId);
              }          
        }
        else {
            throw new ResourceNotFoundException("Employee with ID " + employeeId + " not found");
        }
    }
        
       
    public PositionDto createOrUpdatePosition(Integer employeeId, PositionDto positionDto) {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if (employeeOptional.isPresent()) {
        	 
        	 Position position = dtoToEntityConverter(positionDto);
        	 positionRepo.save(position);

             return entityToDtoConverter(position);
        }
        else {
        	throw new ResourceNotFoundException("Employee with ID " + employeeId + " not found");
        }
    }
}
