package com.hrmanagement.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrmanagement.portal.model.BankDetails;

public interface BankDetailsRepo extends JpaRepository<BankDetails,Integer>{

	  boolean existsByEmployeeId(Integer employeeId);
}
