package com.hrmanagement.portal.controller;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.ResponseDto.ApiResponse;
import com.hrmanagement.portal.customexception.InvalidInputException;
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
	public ResponseEntity<ApiResponse<List<BankDetailsDto>>> getBankDetailsOfAllEmployees(){
		
		List<BankDetailsDto> bankDetailsDto = bankDetailsService.getAllBankDetails();
		Map<String,Object> meta = new LinkedHashMap<>();
		meta.put("recordCount", bankDetailsDto.size());
		return ResponseEntity.ok(new ApiResponse<>(bankDetailsDto, null));
	}


	/**
	 * 2.Get Bank Details by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<BankDetailsDto>> getBankDetailsByEmployeeId(@PathVariable("id") Integer employeeId){
		
		BankDetailsDto departmentDto = bankDetailsService.getBankDetailsById(employeeId);
		return ResponseEntity.ok(new ApiResponse<>(departmentDto, null));
		
	}

	/**
	 * 3.Creating new BankDetails Record
	 * 
	 * @param postRequest
	 * @return
	 */
	@PostMapping
	public ResponseEntity<ApiResponse<BankDetailsDto>> postBankDetails(
			@RequestBody BankDetailsDto postRequest) {
		BankDetailsDto bankDetailsDto = bankDetailsService.createBankDetails(postRequest);
		return ResponseEntity.ok(new ApiResponse<>(bankDetailsDto, null));
	}

	/**
	 * 4. existing Bank Details Updation
	 * 
	 * @param id
	 * @param updateRequest
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<BankDetailsDto>> updateEmployeeBankDetails(@PathVariable("id") Integer employeeId,
			@RequestBody BankDetailsDto updatedBankDetails) {
		BankDetailsDto bankDetailsDto = bankDetailsService.updateDepartment(employeeId, updatedBankDetails);
		return ResponseEntity.ok(new ApiResponse<>(bankDetailsDto, null));
	}


	/**
	 * 5. sorting fields
	 * 
	 * @param feild
	 * @return
	 */
	@GetMapping("/{feild}")
	public ResponseEntity<ApiResponse<List<BankDetailsDto>>> getBankDetailsWithSort(@PathVariable String feild) {
		List<BankDetailsDto> bankDetailsDto = bankDetailsService.findBankDetailsWithSorting(feild);
		return ResponseEntity.ok(new ApiResponse<>(bankDetailsDto, null));

	}
	
	/**
	 * 6. Bank Details Pages
	 * 
	 * @param offset
	 * @param pagesize
	 * @return
	 */
	@GetMapping("/pagination/{offset}/{pagesize}")
	public ResponseEntity<ApiResponse<List<BankDetailsDto>>> getProductWithPagination(@PathVariable int offset,
			@PathVariable int pageSize) {
		List<BankDetailsDto> departmentPages = bankDetailsService.findBankDetailsWithPagination(offset, pageSize);
		int pageCount = (int) Math.ceil((double) departmentPages.size() / pageSize);
		Map<String,Object> meta = new LinkedHashMap<>();
		meta.put("PageNo",offset);
		meta.put("PageSize", pageSize);
		meta.put("pageCount", pageCount);
		meta.put("recordCount", departmentPages.size());
		return ResponseEntity.ok(new ApiResponse<>(departmentPages, null));
	}

	/**
	 * 7.Pagination with sorting
	 * 
	 * @param offset
	 * @param pageSize
	 * @param field
	 * @return
	 */
	@GetMapping("/pagination/{offset}/{pagesize}/{field}")
	public ResponseEntity<ApiResponse<List<BankDetailsDto>>> getProductWithPagination(@PathVariable int offset,
			@PathVariable int pageSize , @PathVariable String field) {
		List<BankDetailsDto> departmentPages = bankDetailsService.findBankDetailsWithPaginationAndSorting(offset, pageSize,field);
		int pageCount = (int) Math.ceil((double) departmentPages.size() / pageSize);
		Map<String,Object> meta = new LinkedHashMap<>();
		meta.put("PageNo",offset);
		meta.put("PageSize", pageSize);
		meta.put("pageCount", pageCount);
		meta.put("recordCount", departmentPages.size());
		return ResponseEntity.ok(new ApiResponse<>(departmentPages, null));
	}
}
