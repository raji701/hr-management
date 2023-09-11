package com.hrmanagement.portal.service;

import java.sql.Time;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.customexception.ResourceNotFoundException;
import com.hrmanagement.portal.dto.TimingsWorkedDto;
import com.hrmanagement.portal.model.TimingsWorked;
import com.hrmanagement.portal.repository.TimingsWorkedRepo;

@Service
public class TimingsWorkedService {
	
	@Autowired
	private TimingsWorkedRepo timingsWorkedRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public TimingsWorkedDto entityToDtoConverter(TimingsWorked timingsWorked)
	{
		return mapper.map(timingsWorked, TimingsWorkedDto.class);
	}
	
	
	public TimingsWorked dtoToEntityConverter(TimingsWorkedDto timingsWorkedDto)
	{
		return mapper.map(timingsWorkedDto, TimingsWorked.class);
	}
	
	//1. Getting All Records
	public List<TimingsWorkedDto> timingsWorked()
	{
		List<TimingsWorked> timingsWorked = timingsWorkedRepo.findAll();
		List<TimingsWorkedDto> timingsWorkedDto = timingsWorked
				.stream()
				.map(this:: entityToDtoConverter )
				.collect(Collectors.toList());
		return timingsWorkedDto;
	}

	//2. Creating Timings Worked Record 
    public TimingsWorkedDto createTimingsWorkedRecord(TimingsWorkedDto timingsWorkedDto) {
      
    	TimingsWorked timingsWorked = mapper.map(timingsWorkedDto, TimingsWorked.class);
    	TimingsWorked savedRecord = timingsWorkedRepo.save(timingsWorked);
    	TimingsWorkedDto savedTimingsWorkedDto = entityToDtoConverter(savedRecord);
        return savedTimingsWorkedDto;
    }
    
    //3. Getting Timings Worked Records By Employee Id
    public List<TimingsWorkedDto> getTimingsWorkedRecordsByEmployeeId(Integer employeeId) {
        List<TimingsWorked> timingsWorkedList  = timingsWorkedRepo.findAllByEmployeeId(employeeId);
        List<TimingsWorkedDto> timingsWorkedDtoList = timingsWorkedList.stream().map(this::entityToDtoConverter).collect(Collectors.toList());
        return timingsWorkedDtoList;
    }
    
    //4. Updating Timings Worked Record
    public TimingsWorkedDto updateTimingsWorkedRecord(Integer attendanceId, TimingsWorkedDto timingsWorkedDto) {
        Optional<TimingsWorked> optionalRecord = timingsWorkedRepo.findById(attendanceId);
        if (optionalRecord.isPresent()) {
            TimingsWorked existingRecord = optionalRecord.get();
            dtoToEntityConverter(timingsWorkedDto);
            TimingsWorked updatedRecord = timingsWorkedRepo.save(existingRecord);
            TimingsWorkedDto UpdatedDtoRecord = entityToDtoConverter(updatedRecord);
            return UpdatedDtoRecord;
        }
        throw new ResourceNotFoundException("Record not found with attendanceId: " + attendanceId);
    }
    
    //5. Calculating Total Hours Worked By An Employee
    public Double calculateTotalWorkedHours(Integer employeeId) {
    	Optional<TimingsWorked> optionalRecord = timingsWorkedRepo.findById(employeeId);
        if (optionalRecord.isPresent()) {
    	List<TimingsWorked> timingsWorkedList = timingsWorkedRepo.findAllByEmployeeId(employeeId);

    	double totalWorkedHours = 0.0;

    	for (TimingsWorked timingsWorked : timingsWorkedList) {
    	    Time timeIn = timingsWorked.getTimeIn();
    	    Time timeOut = timingsWorked.getTimeOut();

    	    if (timeIn != null && timeOut != null) {
    	        long millisecondsWorked = timeOut.getTime() - timeIn.getTime();
    	        double hoursWorked = (double) millisecondsWorked / (1000 * 60 * 60); // Converting to hours
    	        totalWorkedHours += hoursWorked;
    	    }
    	}

    	return totalWorkedHours;
        }
        throw new ResourceNotFoundException("Record not found with EmployeeId: " + employeeId);
    }
    
    //6.Getting Timings Worked Records With in a Date Range
    public List<TimingsWorkedDto> getTimingsWorkedRecordsByDateRange(Integer employeeId, Date startDate, Date endDate) {
     
        List<TimingsWorked> timingsWorkedList = timingsWorkedRepo.findByEmployeeIdAndDateRange(employeeId, startDate, endDate);
        List<TimingsWorkedDto> timingsWorkedDtos = timingsWorkedList.stream().map(this::entityToDtoConverter).toList();
        return timingsWorkedDtos;
    }
}
