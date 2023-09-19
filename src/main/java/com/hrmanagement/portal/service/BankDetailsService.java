package com.hrmanagement.portal.service;

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

import com.hrmanagement.portal.customexception.InvalidInputException;
import com.hrmanagement.portal.customexception.ResourceNotFoundException;
import com.hrmanagement.portal.dto.BankDetailsDto;
import com.hrmanagement.portal.model.BankDetails;
import com.hrmanagement.portal.model.Employee;
import com.hrmanagement.portal.repository.BankDetailsRepo;
import com.hrmanagement.portal.repository.EmployeeRepo;

@Service
public class BankDetailsService {

	private final BankDetailsRepo bankDetailsRepo;

	private final EmployeeRepo employeeRepo;

	private final ModelMapper mapper;

	@Autowired
	public BankDetailsService(BankDetailsRepo bankDetailsRepo, EmployeeRepo employeeRepo, ModelMapper mapper) {
		this.bankDetailsRepo = bankDetailsRepo;
		this.employeeRepo = employeeRepo;
		this.mapper = mapper;
	}

	public BankDetailsDto entityToDtoConverter(BankDetails bankDetails) {
		return mapper.map(bankDetails, BankDetailsDto.class);
	}

	public BankDetails dtoToEntityConverter(BankDetailsDto bankDetailsDto) {
		return mapper.map(bankDetailsDto, BankDetails.class);
	}

	// 1. all employee bank details list
	public List<BankDetailsDto> getAllBankDetails() {
		List<BankDetails> bankDetailsEntities = bankDetailsRepo.findAll();
		return bankDetailsEntities.stream().map(this::entityToDtoConverter).collect(Collectors.toList());
	}

	// 2.Get BankDetails by id
	public BankDetailsDto getBankDetailsById(Integer employeeId) {
		Optional<Employee> optionalEmployee = employeeRepo.findById(employeeId);
		if (optionalEmployee.isPresent()) {
			Optional<BankDetails> optionalBankDetails = bankDetailsRepo.findById(employeeId);
			if (optionalBankDetails.isPresent()) {
				BankDetails bankDetails = optionalBankDetails.get();
				BankDetailsDto dto = entityToDtoConverter(bankDetails);
				return dto;
			} else {
				throw new ResourceNotFoundException(
						"BankDetails not found for employee with employeeId: " + employeeId);
			}
		} else {
			throw new ResourceNotFoundException("Employee not found with employeeId: " + employeeId);

		}
	}

	// 3.Creating new BankDetails record
	public BankDetailsDto createBankDetails(BankDetailsDto createRequest) {
		Integer employeeId = createRequest.getEmployeeId();
		if (employeeId == null || employeeId <= 0) {
            throw new InvalidInputException("Invalid employeeId: " + employeeId);
        }
		Employee employee = employeeRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with employeeId: " + employeeId));

		if (bankDetailsRepo.existsById(employeeId)) {
			throw new DataIntegrityViolationException("The record already exists with id : " + employeeId);
		} else {
			BankDetails bankDetails = dtoToEntityConverter(createRequest);
			BankDetails savedBankDetails = bankDetailsRepo.save(bankDetails);
			BankDetailsDto savedDto = entityToDtoConverter(savedBankDetails);
			return savedDto;
		}
	}
	
	

	// 4.Updating existed BankDetails By id
	public BankDetailsDto updateDepartment(Integer employeeId, BankDetailsDto updatedBankDetails) {
		Optional<Employee> optionalEmployee = employeeRepo.findById(employeeId);
		if (optionalEmployee.isPresent()) {
			Optional<BankDetails> optionalBankDetails = bankDetailsRepo.findById(employeeId);
			if (optionalBankDetails.isPresent()) {
				BankDetails bankDetails = dtoToEntityConverter(updatedBankDetails);
				BankDetails savedBankDetails = bankDetailsRepo.save(bankDetails);
				return entityToDtoConverter(savedBankDetails);
			} else {
				throw new ResourceNotFoundException("BankDetails not found with ID: " + employeeId);
			}
		} else {
			throw new ResourceNotFoundException("employee not found with ID: " + employeeId);
		}
	}

	// 5. sorting by field
	public List<BankDetailsDto> findBankDetailsWithSorting(String feild) {
		List<BankDetails> sortedBankDetails = bankDetailsRepo.findAll(Sort.by(Sort.Direction.DESC, feild));
		return sortedBankDetails.stream().map(this::entityToDtoConverter).collect(Collectors.toList());
	}

	// 6. Pagination
	public List<BankDetailsDto> findBankDetailsWithPagination(int offset, int pageSize) {
		Page<BankDetails> pageOfBankDetails = bankDetailsRepo.findAll(PageRequest.of(offset, pageSize));
		List<BankDetailsDto> dtoList = pageOfBankDetails.getContent().stream().map(this::entityToDtoConverter)
				.collect(Collectors.toList());
		return dtoList;
	}

	// 7. Pagination and sorting
	public List<BankDetailsDto> findBankDetailsWithPaginationAndSorting(int offset, int pageSize, String field) {
		Page<BankDetails> pageOfBankDetails = bankDetailsRepo
				.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
		List<BankDetailsDto> dtoList = pageOfBankDetails.getContent().stream().map(this::entityToDtoConverter)
				.collect(Collectors.toList());
		return dtoList;
	}
	

}
