package com.hrmanagement.portal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.hrmanagement.portal.customexception.ResourceNotFoundException;
import com.hrmanagement.portal.dto.DepartmentRequestDto;
import com.hrmanagement.portal.model.Department;
import com.hrmanagement.portal.repository.DepartmentRepo;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo deptRepo;

	@Autowired
	private ModelMapper mapper;

	// 1.All Departments
	public List<DepartmentRequestDto> getAllDepartments() {
		List<Department> departmentEntities = deptRepo.findAll();
		return departmentEntities.stream().map(department -> mapper.map(department, DepartmentRequestDto.class))
				.collect(Collectors.toList());
	}

	// 2.Get Department by id
	public DepartmentRequestDto getDepartmentById(Integer id) {
		Optional<Department> optionalDepartment = deptRepo.findById(id);
		if (optionalDepartment.isPresent()) {
			Department department = optionalDepartment.get();
			DepartmentRequestDto dto = mapper.map(department, DepartmentRequestDto.class);
			return dto;
		} else {
			throw new ResourceNotFoundException("Department not found with ID: " + id);
		}
	}

	// 3.Creating new department record
	public DepartmentRequestDto createDepartment(DepartmentRequestDto createRequest) {
		Department department = mapper.map(createRequest, Department.class);
		Department savedDepartment = deptRepo.save(department);
		DepartmentRequestDto savedDto = mapper.map(savedDepartment, DepartmentRequestDto.class);
		return savedDto;
	}

	// 4.Updating existed Department By id
	public DepartmentRequestDto updateDepartment(Integer id, DepartmentRequestDto updatedDepartment) {
		Optional<Department> optionalDepartment = deptRepo.findById(id);
		if (optionalDepartment.isPresent()) {
			Department existingDepartment = optionalDepartment.get();
			mapper.map(updatedDepartment, existingDepartment);
			Department updatedEntity = deptRepo.save(existingDepartment);
			DepartmentRequestDto updatedDto = mapper.map(updatedEntity, DepartmentRequestDto.class);
			return updatedDto;
		} else {
			throw new ResourceNotFoundException("Department not found with ID: " + id);
		}
	}

	// 5. deleting a record by id
	public void deleteDepartment(Integer id) {

		if (!deptRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found with ID: " + id);
		}
		deptRepo.deleteById(id);
	}

	// 6. sorting fields
	public List<DepartmentRequestDto> findDepartmentWithSorting(String feild) {
		List<Department> sortedDepartments = deptRepo.findAll(Sort.by(Sort.Direction.DESC, feild));
		return sortedDepartments.stream().map(department -> mapper.map(department, DepartmentRequestDto.class))
				.collect(Collectors.toList());
	}

	// 7. Pagination
	public Page<DepartmentRequestDto> findDepartmentwithPagination(int offset, int pageSize) {
		Page<Department> pageOfDepartments = deptRepo.findAll(PageRequest.of(offset, pageSize));
		List<DepartmentRequestDto> dtoList = pageOfDepartments.getContent().stream()
				.map(department -> mapper.map(department, DepartmentRequestDto.class)).collect(Collectors.toList());
		return pageOfDepartments.map(department -> mapper.map(department, DepartmentRequestDto.class));

	}
}
