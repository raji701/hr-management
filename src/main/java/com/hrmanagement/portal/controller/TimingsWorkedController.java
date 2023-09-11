package com.hrmanagement.portal.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.ResponseDto.ApiResponse;
import com.hrmanagement.portal.dto.TimingsWorkedDto;
import com.hrmanagement.portal.service.TimingsWorkedService;

@RestController
@RequestMapping("/timingsworked")
public class TimingsWorkedController {
	
	@Autowired
	private TimingsWorkedService timingsWorkedService;
	
	/**
	 * 1.Getting All Records
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<ApiResponse<List<TimingsWorkedDto>>> getAll()
	{
		List<TimingsWorkedDto> timingsWorkedDto = timingsWorkedService.timingsWorked();
		return  ResponseEntity.ok(new ApiResponse<>(timingsWorkedDto,null));
	}

	/**
	 * 2.Creating Timings Worked Record
	 * 
	 * @param timingsWorkedDto
	 * @return
	 */
    @PostMapping("/new")
    public ResponseEntity<ApiResponse<TimingsWorkedDto>> createTimingsWorkedRecord(@RequestBody TimingsWorkedDto timingsWorkedDto) {
        TimingsWorkedDto createdRecord = timingsWorkedService.createTimingsWorkedRecord(timingsWorkedDto);
        return  ResponseEntity.ok( new ApiResponse<>(createdRecord,null));
    }

    /**
     * 3.Getting Timings Worked Records By Employee Id
     * 
     * @param employeeId
     * @return
     */
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<ApiResponse<List<TimingsWorkedDto>>> getTimingsWorkedRecordsByEmployeeId(@PathVariable Integer employeeId) {
        List<TimingsWorkedDto> records = timingsWorkedService.getTimingsWorkedRecordsByEmployeeId(employeeId);
        return  ResponseEntity.ok( new ApiResponse<>(records,null));
    }

    /**
     * 4.Updating Timings Worked Record
     * 
     * @param attendanceId
     * @param timingsWorkedDto
     * @return
     */
    @PutMapping("/{attendanceId}")
    public ResponseEntity<ApiResponse<TimingsWorkedDto>> updateTimingsWorkedRecord(
            @PathVariable Integer attendanceId,
            @RequestBody TimingsWorkedDto timingsWorkedDto) {
        TimingsWorkedDto updatedRecord = timingsWorkedService.updateTimingsWorkedRecord(attendanceId, timingsWorkedDto);
        return  ResponseEntity.ok( new ApiResponse<>(updatedRecord,null));
    }

    /**
     * 5.Calculating Total Hours Worked By An Employee
     * 
     * @param employeeId
     * @return
     */
    @GetMapping("/employee/{employeeId}/total-hours")
    public ResponseEntity<ApiResponse<Double>> calculateTotalWorkedHours(@PathVariable Integer employeeId) {
        Double totalHours = timingsWorkedService.calculateTotalWorkedHours(employeeId);
        return  ResponseEntity.ok( new ApiResponse<>(totalHours,null));
    }

    /**
     * 6.Getting Timings Worked Records With in a Date Range
     * 
     * @param employeeId
     * @param startDate
     * @param endDate
     * @return
     */
    @GetMapping("/employee/{employeeId}/date-range")
    public ResponseEntity<ApiResponse<List<TimingsWorkedDto>>> getTimingsWorkedRecordsByDateRange(
            @PathVariable Integer employeeId,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {

        List<TimingsWorkedDto> timingsWorkedDtos = timingsWorkedService.getTimingsWorkedRecordsByDateRange(employeeId, startDate, endDate);
        if (timingsWorkedDtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return  ResponseEntity.ok( new ApiResponse<>(timingsWorkedDtos,null));
    }

}
