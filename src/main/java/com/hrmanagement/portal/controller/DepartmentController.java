package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

import com.hrmanagement.portal.ResponseDto.ResponseHandler;
import com.hrmanagement.portal.dto.DepartmentRequestDto;
import com.hrmanagement.portal.model.Department;
import com.hrmanagement.portal.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	/**
	 * 1. getting all department details
	 * 
	 * @return
	 */
	@GetMapping(value = "/all")
	public ResponseEntity<Object> Get() {
		try {
			List<DepartmentRequestDto> result = departmentService.getAllDepartments();
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	/**
	 * 2.Get department by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable Integer id) {

		Department department = departmentService.departmentById(id);
		return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, department);
	}

	/**
	 * 3.Creating new department
	 * 
	 * @param postRequest
	 * @return
	 */
	@PostMapping("/new")
	public ResponseEntity<Object> newDepartment(@RequestBody DepartmentRequestDto postRequest) {
		try {
			Department department = departmentService.createDepartment(postRequest);
			return ResponseHandler.generateResponse("Successfully posted data!", HttpStatus.CREATED, department);
		} catch (ResponseStatusException e) {
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
	}

	/**
	 * 4.Updating existed Department
	 * 
	 * @param id
	 * @param updateRequest
	 * @return
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateById(Integer id, @RequestBody DepartmentRequestDto updateRequest) {
		try {
			Department department = departmentService.updateDepartment(id, updateRequest);
			return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.CREATED, department);
		} catch (ResponseStatusException e) {
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
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
		} catch (ResponseStatusException e) {
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
	}

	/**
	 * 6. sorting feilds
	 * 
	 * @param feild
	 * @return
	 */
	@GetMapping("/sort/{feild}")
	public ResponseEntity<Object> getDepartmentsWithSort(@PathVariable String feild) {
		 List<Department> department = departmentService.findDepartmentWithSorting(feild);
		 
	return ResponseHandler.generateResponse("Successfully retreived data!", HttpStatus.OK, department);

	}

	@GetMapping("/pagination/{offset}/{pagesize}")
	public ResponseEntity<Object> getProductWithPagination(@PathVariable int offset, @PathVariable int pagesize) {
		Page<Department> department = departmentService.findDepartmentwithPagination(offset, pagesize);
		return ResponseHandler.generateResponse("Successfully retreived data!", HttpStatus.OK, department);
	}
}
