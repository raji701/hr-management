package com.hrmanagement.portal.service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.hrmanagement.portal.dto.DepartmentRequestDto;
import com.hrmanagement.portal.model.Department;
import com.hrmanagement.portal.repository.DepartmentRepo;



@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo deptRepo;

	// 1.All Departments
	public List<Department> getAllDepartments() {
		return deptRepo.findAll();
	}
	
	//2.Get Department by id
	public Department departmentById(Integer id)
	{
		Department department = deptRepo.findById(id).get();

		        if (department == null) {
		            throw new NoSuchElementException();
		        }

		        return department;
	}
	
	//3.Creating new department record
	public Department createDepartment(DepartmentRequestDto createRequest) {
		
		if (deptRepo.existsById(createRequest.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "DepartmentId already exists");
        }
		
		Department newDepartment = new Department();
		newDepartment.setDepartmentId(createRequest.getId());
		newDepartment.setDepartmentName(createRequest.getName());
		
		
		Department savedDepartment = deptRepo.save(newDepartment);
		return savedDepartment;
	}
	
	//4.Updating existed Department By id
	public void updateDepartment(Integer id , DepartmentRequestDto updateRequest)
	{
		Department updatedDepartment = deptRepo.findById(id).orElseThrow(()->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found with ID: " + id));
		
		updatedDepartment.setDepartmentId(updateRequest.getId());
		updatedDepartment.setDepartmentName(updateRequest.getName());
		
		deptRepo.save(updatedDepartment);
	}
	
	
	//5. deleting a record by id
	 public void deleteDepartment(Integer id) {
		 
	        if (!deptRepo.existsById(id))
	        {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found with ID: " + id);
	        }
	        deptRepo.deleteById(id);
	    }
}
