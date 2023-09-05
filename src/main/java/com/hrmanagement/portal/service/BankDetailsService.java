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
import com.hrmanagement.portal.dto.BankDetailsDto;
import com.hrmanagement.portal.dto.DepartmentRequestDto;
import com.hrmanagement.portal.model.BankDetails;
import com.hrmanagement.portal.repository.BankDetailsRepo;

@Service
public class BankDetailsService {

	@Autowired
	private BankDetailsRepo bankDetailsRepo;

	@Autowired
	private ModelMapper mapper;

	// 1. all employee bank details list
	public List<BankDetailsDto> getAllBankDetails() {
		List<BankDetails> bankDetailsEntities = bankDetailsRepo.findAll();
		return bankDetailsEntities.stream().map(bankDetails -> mapper.map(bankDetails, BankDetailsDto.class))
				.collect(Collectors.toList());
	}

	// 2.Get BankDetails by id
	public BankDetailsDto getBankDetailsById(Integer id) {
		Optional<BankDetails> optionalBankDetails = bankDetailsRepo.findById(id);
		if (optionalBankDetails.isPresent()) {
			BankDetails bankDetails = optionalBankDetails.get();
			BankDetailsDto dto = mapper.map(bankDetails, BankDetailsDto.class);
			return dto;
		} else {
			throw new ResourceNotFoundException("Department not found with ID: " + id);
		}
	}

	// 3.Creating new BankDetails record
	public BankDetailsDto createBankDetails(BankDetailsDto createRequest) {
		BankDetails bankDetails = mapper.map(createRequest, BankDetails.class);
		BankDetails savedBankDetails = bankDetailsRepo.save(bankDetails);
		BankDetailsDto savedDto = mapper.map(savedBankDetails, BankDetailsDto.class);
		return savedDto;
	}

	// 4.Updating existed BankDetails By id
	public BankDetailsDto updateDepartment(Integer id, BankDetailsDto updatedBankDetails) {
		Optional<BankDetails> optionalBankDetails = bankDetailsRepo.findById(id);
		if (optionalBankDetails.isPresent()) {
			BankDetails existingBankDetails = optionalBankDetails.get();
			mapper.map(updatedBankDetails, existingBankDetails);
			BankDetails updatedEntity = bankDetailsRepo.save(existingBankDetails);
			BankDetailsDto updatedDto = mapper.map(updatedEntity, BankDetailsDto.class);
			return updatedDto;
		} else {
			throw new ResourceNotFoundException("BankDetails not found with ID: " + id);
		}
	}

	// 5. deleting a record by id
	public void deleteBankDetails(Integer id) {

		if (!bankDetailsRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "BankDetails not found with ID: " + id);
		}
		bankDetailsRepo.deleteById(id);
	}

	// 6. sorting fields
	public List<BankDetailsDto> findBankDetailsWithSorting(String feild) {
		List<BankDetails> sortedBankDetails = bankDetailsRepo.findAll(Sort.by(Sort.Direction.DESC, feild));
		return sortedBankDetails.stream().map(bankDetails -> mapper.map(bankDetails, BankDetailsDto.class))
				.collect(Collectors.toList());
	}

	// 7. Pagination
	public Page<BankDetailsDto> findDepartmentwithPagination(int offset, int pageSize) {
		Page<BankDetails> pageOfBankDetails = bankDetailsRepo.findAll(PageRequest.of(offset, pageSize));
		List<BankDetailsDto> dtoList = pageOfBankDetails.getContent().stream()
				.map(bankDetails -> mapper.map(bankDetails, BankDetailsDto.class)).collect(Collectors.toList());
		return pageOfBankDetails.map(bankDetails -> mapper.map(bankDetails, BankDetailsDto.class));

	}

}
