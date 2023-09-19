package com.hrmanagement.portal.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrmanagement.portal.customexception.ForbiddenException;
import com.hrmanagement.portal.customexception.ResourceNotFoundException;
import com.hrmanagement.portal.dto.EmployeeDto;
import com.hrmanagement.portal.model.Department;
import com.hrmanagement.portal.model.Employee;
import com.hrmanagement.portal.model.PersonalDetails.Gender;
import com.hrmanagement.portal.model.Skills;
import com.hrmanagement.portal.repository.DepartmentRepo;
import com.hrmanagement.portal.repository.EmployeeRepo;
import com.hrmanagement.portal.repository.PositionRepo;
import com.hrmanagement.portal.repository.SkillsRepo;

@Service
public class EmployeeService {

	private final EmployeeRepo employeeRepo;

	private final ModelMapper mapper;

	private final DepartmentRepo departmentRepo;

	private final SkillsRepo skillsRepo;

	private final PositionRepo positionRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo, ModelMapper mapper, DepartmentRepo departmentRepo,
			SkillsRepo skillsRepo, PositionRepo positionRepo) {
		this.employeeRepo = employeeRepo;
		this.mapper = mapper;
		this.departmentRepo = departmentRepo;
		this.skillsRepo = skillsRepo;
		this.positionRepo = positionRepo;
	}

	public EmployeeDto entityToDtoConverter(Employee employee) {
		return mapper.map(employee, EmployeeDto.class);
	}

	public Employee dtoToEntityConverter(EmployeeDto employeeDto) {
		return mapper.map(employeeDto, Employee.class);
	}

	// 1. List Of Employees
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employeeList = employeeRepo.findAll();
		List<EmployeeDto> employeeDtoList = employeeList.stream().map(this::entityToDtoConverter)
				.collect(Collectors.toList());
		return employeeDtoList;
	}

	// 2. Employee By Id
	public EmployeeDto getEmployeeByEmployeeId(Integer employeeId) {
		Optional<Employee> optionalEmployee = employeeRepo.findById(employeeId);
		if (optionalEmployee.isPresent()) {
			Employee employee = optionalEmployee.get();
			EmployeeDto employeeDto = entityToDtoConverter(employee);
			return employeeDto;
		} else {
			throw new ResourceNotFoundException("employee with id : " + employeeId + " not found");
		}

	}

	// 3.Post employee details
	public List<EmployeeDto> postEmployeeDetails(EmployeeDto employeeDto) {
		Integer employeeId = employeeDto.getEmployeeId();
		if (employeeRepo.existsById(employeeId)) {
			throw new DataIntegrityViolationException("The record already exists with id : " + employeeId);
		}
		Employee employee = dtoToEntityConverter(employeeDto);
		employeeRepo.save(employee);
		return getAllEmployees();
	}

	public void processCSVFile(MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			List<Employee> employees = CSVFileReader.readCSVFile(file.getInputStream());
			employeeRepo.saveAll(employees);
		} else {
			throw new IllegalArgumentException("CSV file is empty.");
		}
	}

	public void saveEmployeeToDataBase(MultipartFile file) {
		if (ExcelUploadService.isValidExcelFile(file)) {
			try {
				List<Employee> employees = ExcelUploadService.getEmployeeDataFromExcel(file.getInputStream());
				employeeRepo.saveAll(employees);
			} catch (IOException e) {
				throw new IllegalArgumentException("The file is not a valid excel file");
			}
		}
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

	// 3.1 Managers In A Department
	public List<EmployeeDto> managersInTheDepartment(Integer departmentId) {
		final Integer positionId = 8;
		List<Employee> managerList = employeeRepo.employeesWithPosition(positionId, departmentId);
		List<EmployeeDto> managerListDto = managerList.stream().map(manager -> mapper.map(manager, EmployeeDto.class))
				.toList();
		return managerListDto;
	}

	// 3.2 Employees Under manager
	public List<EmployeeDto> EmployeesUnderManager(Integer employeeId) {
		final int managerPositionId = 8;
		employeeRepo.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException(" the employee with this id : " + employeeId + " isn't present"));
		Integer positionId = employeeRepo.positionOfTheEmployee(employeeId);

		if (positionId == managerPositionId) {

			List<Employee> employeeList = employeeRepo.employeesUnder(employeeId);
			List<EmployeeDto> employeeDtoList = employeeList.stream()
					.map(employeeDto -> mapper.map(employeeDto, EmployeeDto.class)).toList();
			return employeeDtoList;
		} else {
			throw new ForbiddenException(
					"You do not have permission to access this resource or perform this operation.");
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

	// 7. Pagination
	public List<EmployeeDto> findEmployeeWithPagination(int offset, int pageSize) {
		Page<Employee> pageOfEmployees = employeeRepo.findAll(PageRequest.of(offset, pageSize));
		List<EmployeeDto> dtoList = pageOfEmployees.getContent().stream()
				.map(employee -> mapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
		return dtoList;
	}

	// 8. Pagination and sorting
	public List<EmployeeDto> findEmployeeDetailsWithPaginationAndSorting(int offset, int pageSize, String field) {
		Page<Employee> pageOfEmployeeDetails = employeeRepo
				.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
		List<EmployeeDto> dtoList = pageOfEmployeeDetails.getContent().stream().map(this::entityToDtoConverter)
				.collect(Collectors.toList());
		return dtoList;
	}

}
