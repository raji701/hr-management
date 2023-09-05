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
import com.hrmanagement.portal.dto.BankDetailsDto;
import com.hrmanagement.portal.service.BankDetailsService;

@RestController
@RequestMapping("/bankdetails")
public class BankDetailsContoller {
	
	@Autowired
	private BankDetailsService bankDetailsService;

	/**
	 * 1. getting bank details of all employees
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<ApiResponse<List<BankDetailsDto>>> Get() {
		
				List<BankDetailsDto> bankDetailsDto = bankDetailsService.getAllBankDetails();
				return ResponseEntity.ok(new ApiResponse<>(bankDetailsDto, null));
			}


	/**
	 * 2.Get Bank Details by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<BankDetailsDto>> getDepartmentById(@PathVariable Integer id) {
		BankDetailsDto departmentDto = bankDetailsService.getBankDetailsById(id);
		return ResponseEntity.ok(new ApiResponse<>(departmentDto, null));
	}

	/**
	 * 3.Creating new BankDetails Record
	 * 
	 * @param postRequest
	 * @return
	 */
	@PostMapping("/new")
	public ResponseEntity<ApiResponse<BankDetailsDto>> newDepartment(
			@RequestBody BankDetailsDto postRequest) {
		BankDetailsDto bankDetailsDto = bankDetailsService.createBankDetails(postRequest);
		return ResponseEntity.ok(new ApiResponse<>(bankDetailsDto, null));
	}

	/**
	 * 4.Updating existed BankDetails
	 * 
	 * @param id
	 * @param updateRequest
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<BankDetailsDto>> updateDepartment(@PathVariable Integer id,
			@RequestBody BankDetailsDto updatedDepartment) {
		BankDetailsDto bankDetailsDto = bankDetailsService.updateDepartment(id, updatedDepartment);
		return ResponseEntity.ok(new ApiResponse<>(bankDetailsDto, null));
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
			bankDetailsService.deleteBankDetails(id);
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
	@GetMapping("/{feild}")
	public ResponseEntity<ApiResponse<List<BankDetailsDto>>> getDepartmentsWithSort(@PathVariable String feild) {
		List<BankDetailsDto> bankDetailsDto = bankDetailsService.findBankDetailsWithSorting(feild);
		return ResponseEntity.ok(new ApiResponse<>(bankDetailsDto, null));

	}

	/**
	 * 7. Department Pages
	 * 
	 * @param offset
	 * @param pagesize
	 * @return
	 */
	@GetMapping("/pagination/{offset}/{pagesize}")
	public ResponseEntity<ApiResponse<Page<BankDetailsDto>>> getProductWithPagination(@PathVariable int offset,
			@PathVariable int pagesize) {
		Page<BankDetailsDto> departmentPages = bankDetailsService.findDepartmentwithPagination(offset, pagesize);
		return ResponseEntity.ok(new ApiResponse<>(departmentPages, null));
	}

}
