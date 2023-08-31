package com.hrmanagement.portal.controller;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hrmanagement.portal.dto.DepartmentRequestDto;
import com.hrmanagement.portal.model.Department;
import com.hrmanagement.portal.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired 
	private DepartmentService departmentService;
	
	//1. list of departments
	@GetMapping("/all")
	public List<Department> allDepartments()
	{
		return departmentService.getAllDepartments();
	}
	
	//2.Get department by id
	/**
	 * 
	 * @param id
	 * @return 
	 */
    @GetMapping("/{id}")
    public  Department getUserById(@PathVariable Integer id) {
       
    	 	Department department = departmentService.departmentById(id);  
            return department;
    }
	
	//3.Creating new department
	@PostMapping("/new")
	public ResponseEntity<String>newDepartment(@RequestBody DepartmentRequestDto postRequest)
	{
		try {
            departmentService.createDepartment(postRequest);
            return ResponseEntity.ok("Department created successfully");
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }
	}
	
	//4.Updating existed Department
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateById(Integer id, @RequestBody DepartmentRequestDto updateRequest)
	{
		try {
            departmentService.updateDepartment(id, updateRequest);
            return ResponseEntity.ok("Department updated successfully");
        } catch (ResponseStatusException e) {
        	 return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());        }
	}
	
	/** 
	 * 5.Deleting existed department by id
	 * 
	 * @param id
	 * @return string if deleted
	 */
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteDepartmentById(@PathVariable Integer id) {
	        try {
	        	departmentService.deleteDepartment(id);
	        	return ResponseEntity.noContent().build();	
	        } 
	        catch (ResponseStatusException e) {
	            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	        }
	    }
	
	
}
