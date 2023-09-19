package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.hrmanagement.portal.ResponseDto.ApiResponse;
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
	@GetMapping
	public ResponseEntity<ApiResponse<List<Department>>> Get() {

		List<Department> departmentDto = departmentService.getAllDepartments();
		return ResponseEntity.ok(new ApiResponse<>(departmentDto, null));
	}

	/**
	 * 2.Get department by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<DepartmentRequestDto>> getDepartmentById(@PathVariable Integer id) {
		DepartmentRequestDto departmentDto = departmentService.getDepartmentById(id);
		return ResponseEntity.ok(new ApiResponse<>(departmentDto, null));
	}

	/**
	 * 3.Creating new department
	 * 
	 * @param postRequest
	 * @return
	 */
	@PostMapping("/new")
	public ResponseEntity<ApiResponse<DepartmentRequestDto>> newDepartment(
			@RequestBody DepartmentRequestDto postRequest) {
		DepartmentRequestDto departmentDto = departmentService.createDepartment(postRequest);
		return ResponseEntity.ok(new ApiResponse<>(departmentDto, null));
	}

	/**
	 * 4.Updating existed Department
	 * 
	 * @param id
	 * @param updateRequest
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<DepartmentRequestDto>> updateDepartment(@PathVariable Integer id,
			@RequestBody DepartmentRequestDto updatedDepartment) {
		DepartmentRequestDto departmentDto = departmentService.updateDepartment(id, updatedDepartment);
		return ResponseEntity.ok(new ApiResponse<>(departmentDto, null));
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
	 * 6. sorting fields
	 * 
	 * @param feild
	 * @return
	 */
	@GetMapping("/sort/{feild}")
	public ResponseEntity<ApiResponse<List<DepartmentRequestDto>>> getDepartmentsWithSort(@PathVariable String feild) {
		List<DepartmentRequestDto> departmentDto = departmentService.findDepartmentWithSorting(feild);
		return ResponseEntity.ok(new ApiResponse<>(departmentDto, null));

	}

	/**
	 * 7. Department Pages
	 * 
	 * @param offset
	 * @param pagesize
	 * @return
	 */
	@GetMapping("/{offset}/{pagesize}")
	public ResponseEntity<ApiResponse<Page<DepartmentRequestDto>>> getProductWithPagination(@PathVariable int offset,
			@PathVariable int pagesize) {
		Page<DepartmentRequestDto> departmentPages = departmentService.findDepartmentwithPagination(offset, pagesize);
		return ResponseEntity.ok(new ApiResponse<>(departmentPages, null));
	}
}
