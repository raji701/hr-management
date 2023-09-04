package com.hrmanagement.portal.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

	
	@Autowired
	private ModelMapper mapper;

	/**
	 * 1.All Departments
	 * 
	 * @return
	 */
	public List<DepartmentRequestDto> getAllDepartments() {
		List<Department> departmentEntities = deptRepo.findAll();
		return departmentEntities.stream().map(department -> mapper.map(department, DepartmentRequestDto.class))
				.collect(Collectors.toList());
	}

	/**
	 * 2.Get Department by id
	 * 
	 * @param id
	 * @return
	 */
	public Department departmentById(Integer id) {
		Department department = deptRepo.findById(id).get();

		if (department == null) {
			throw new NoSuchElementException();
		}

		return department;
	}

	/**
	 * 3.Creating new department record
	 * 
	 * @param createRequest
	 * @return
	 */
	public Department createDepartment(DepartmentRequestDto createRequest) {

		if (deptRepo.existsById(createRequest.getId())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "DepartmentId already exists");
		}

		Department department = mapper.map(createRequest, Department.class);

		Department savedDepartment = deptRepo.save(department);
		return savedDepartment;
	}

	/**
	 * 4.Updating existed Department By id
	 * 
	 * @param id
	 * @param updateRequest
	 */
	public Department updateDepartment(Integer id, DepartmentRequestDto updateRequest) {
//		Department existingId = deptRepo.findById(id).orElseThrow(
//				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found with ID: " + id));

		Department department = mapper.map(updateRequest, Department.class);

		Department updatedDepartment = deptRepo.save(department);
		return updatedDepartment;
	}

	/**
	 * 5. deleting a record by id
	 * 
	 * @param id
	 */
	public void deleteDepartment(Integer id) {

		if (!deptRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found with ID: " + id);
		}
		deptRepo.deleteById(id);
	}

	/**
	 * 6. sorting feilds
	 * 
	 * @param feild
	 * @return
	 */
	public List<Department> findDepartmentWithSorting(String feild) {
		return deptRepo.findAll(Sort.by(Sort.Direction.DESC, feild));
	}

	/**
	 * 
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public Page<Department> findDepartmentwithPagination(int offset, int pageSize) {
		return deptRepo.findAll(PageRequest.of(offset, pageSize));
	}
}
