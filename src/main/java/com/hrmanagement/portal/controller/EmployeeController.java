package com.hrmanagement.portal.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hrmanagement.portal.ResponseDto.ApiResponse;
import com.hrmanagement.portal.customexception.InvalidInputException;
import com.hrmanagement.portal.dto.BankDetailsDto;
import com.hrmanagement.portal.dto.EmployeeDto;
import com.hrmanagement.portal.model.PersonalDetails.Gender;
import com.hrmanagement.portal.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * 1.Getting All Employee Details In The Organization
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<ApiResponse<List<EmployeeDto>>> allEmployees() {

		List<EmployeeDto> employeeDtoList = employeeService.getAllEmployees();
		return ResponseEntity.ok(new ApiResponse<>(employeeDtoList, null));
	}

	@GetMapping("/emp/{id}")
	public ResponseEntity<ApiResponse<EmployeeDto>> getByEmployeeId(@PathVariable("id") Integer employeeId){
		if(employeeId == null || employeeId < 0)
		{
			throw new InvalidInputException("the provided id is invalid");
		}
		EmployeeDto employeeDto = employeeService.getEmployeeByEmployeeId(employeeId);
		return ResponseEntity.ok(new ApiResponse<>(employeeDto, null));
		}
	
	
	/**
	 * 2.Creating New Employee Details
	 * 
	 * @param postRequest
	 * @return
	 */
	@PostMapping("/new")
	public ResponseEntity<ApiResponse<List<EmployeeDto>>> newEmployee(@RequestBody EmployeeDto postRequest) {
		List<EmployeeDto> employeeDtolist = employeeService.postEmployeeDetails(postRequest);
		Map<String, Object> meta = new LinkedHashMap<>();
		meta.put("employeeCount", employeeDtolist.size());
		return ResponseEntity.ok(new ApiResponse<>(employeeDtolist, meta));

		
	}
// 
//	
////	  @PostMapping("/upload-employee-data")
////	    public ResponseEntity<?> uploadCustomersData(@RequestParam("file")MultipartFile file){
////	        employeeService.saveEmployeeToDataBase(file);
////	        return ResponseEntity
////	                .ok(Map.of("Message" , "Employyee data uploaded and saved to database successfully"));
////	    }
////	
	
	
	 @PostMapping("/upload-employee-data")
	    public ResponseEntity<?> uploadEmployeeData(@RequestParam("file") MultipartFile file) {
	        try {
	        	employeeService.processCSVFile(file);
	            return ResponseEntity.ok("Employee data uploaded and saved to the database successfully");
	        } catch (IOException e) {
	            return ResponseEntity.badRequest().body("Failed to process the CSV file: " + e.getMessage());
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 3.Getting All Employee Details In A Specific Department
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/department/{id}")
	public ResponseEntity<ApiResponse<List<EmployeeDto>>> employeesInADepartment(@PathVariable int id) {
		List<EmployeeDto> employeeDtolist = employeeService.employeesUnderTheDepartment(id);
		Map<String, Object> meta = new LinkedHashMap<>();
		meta.put("employeeCount", employeeDtolist.size());
		return ResponseEntity.ok(new ApiResponse<>(employeeDtolist, meta));
	}

	/**
	 * 4.Getting All Employees Who Knows A Particular Skill
	 * 
	 * @param skillName
	 * @return
	 */
	@GetMapping("/skill/{skillName}")
	public ResponseEntity<ApiResponse<List<EmployeeDto>>> employeesHavingSkill(@PathVariable String skillName) {
		List<EmployeeDto> employeeDtolist = employeeService.employeesKnowing(skillName);
		Map<String, Object> meta = new LinkedHashMap<>();
		meta.put("employeeCount", employeeDtolist.size());
		return ResponseEntity.ok(new ApiResponse<>(employeeDtolist, meta));
	}

	/**
	 * 5.Getting All Employees By Gender
	 * 
	 * @param gender
	 * @return
	 */
	@GetMapping("/bygender/{gender}")
	public ResponseEntity<ApiResponse<List<EmployeeDto>>> employeesOfGender(@PathVariable String gender) {
		Gender genderEnum = Gender.valueOf(gender.toUpperCase());
		List<EmployeeDto> employeeDtolist = employeeService.employeesWithGender(genderEnum);
		Map<String, Object> meta = new LinkedHashMap<>();
		meta.put("employeeCount", employeeDtolist.size());
		return ResponseEntity.ok(new ApiResponse<>(employeeDtolist, meta));
	}

	@GetMapping("/pagination/{offset}/{pageSize}")
	public ResponseEntity<ApiResponse<List<EmployeeDto>>> getProductWithPagination(@PathVariable int offset,
			@PathVariable int pageSize) {
		List<EmployeeDto> employeePageList = employeeService.findEmployeeWithPagination(offset, pageSize);
		int pageCount = (int) Math.ceil((double) employeePageList.size() / pageSize);
		Map<String,Object> meta = new LinkedHashMap<>();
		meta.put("PageNo",offset);
		meta.put("PageSize", pageSize);
		meta.put("pageCount", pageCount);
		meta.put("recordCount", employeePageList.size());
		return ResponseEntity.ok(new ApiResponse<>(employeePageList, meta));
	}
}
