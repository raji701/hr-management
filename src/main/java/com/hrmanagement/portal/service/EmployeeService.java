package com.hrmanagement.portal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.customexception.ResourceNotFoundException;
import com.hrmanagement.portal.dto.EmployeeDto;
import com.hrmanagement.portal.model.Department;
import com.hrmanagement.portal.model.Employee;
import com.hrmanagement.portal.model.PersonalDetails.Gender;
import com.hrmanagement.portal.model.Skills;
import com.hrmanagement.portal.repository.DepartmentRepo;
import com.hrmanagement.portal.repository.EmployeeRepo;
import com.hrmanagement.portal.repository.SkillsRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private DepartmentRepo departmentRepo;

	@Autowired
	private SkillsRepo skillsRepo;

	// 1. List Of Employees
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employeeList = employeeRepo.findAll();
		List<EmployeeDto> employeeDtoList = employeeList.stream().map(employee -> mapper.map(employee, EmployeeDto.class))
				.collect(Collectors.toList());
		return employeeDtoList;
	}

	// 2.Post employee details 
	public List<EmployeeDto> postEmployeeDetails(EmployeeDto employeeDto) {

		Employee employee = mapper.map(employeeDto, Employee.class);
		Employee savedEmployee = employeeRepo.save(employee);
		mapper.map(savedEmployee, EmployeeDto.class);

		return getAllEmployees();
	}

	// 3. Employees in a department
	public List<EmployeeDto> employeesUnderTheDepartment(Integer id) {
		Optional<Department> department = departmentRepo.findById(id);
		if (department.isPresent()) {
			List<Employee> employeeList = employeeRepo.findAllByDepartmentId(id);
			List<EmployeeDto> employeeDtoList = employeeList.stream()
					.map(employee -> mapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
			return employeeDtoList;
		} else {
			throw new ResourceNotFoundException("Department with id : " + id + " not found");
		}
	}

	// 4. Employees knowing particular skill
	public List<EmployeeDto> employeesKnowing(String skillName) {
		Skills skill = skillsRepo.findBySkillName(skillName);
		if (skill != null) {
			List<Employee> employeeList = employeeRepo.findAllBySkillName(skillName);
			List<EmployeeDto> employeeDtoList = employeeList.stream()
					.map(employee -> mapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
			return employeeDtoList;

		} else {
			throw new ResourceNotFoundException("Organisation is not using " + skillName + " technology");
		}

	}

	// 5.Employee gender
	public List<EmployeeDto> employeesWithGender(Gender gender) {
		List<Employee> employeeList = employeeRepo.findAllByGender(gender);
		List<EmployeeDto> employeeDtoList = employeeList.stream()
				.map(employee -> mapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());

		return employeeDtoList;
	}

}
