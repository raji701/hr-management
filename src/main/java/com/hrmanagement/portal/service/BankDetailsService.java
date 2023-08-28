package com.hrmanagement.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.model.BankDetails;
import com.hrmanagement.portal.repository.BankDetailsRepo;

@Service
public class BankDetailsService {
	
	@Autowired
	private BankDetailsRepo bankDetailsRepo;
	
	//1. all employee bank details list
	public List<BankDetails> allEmployeeBankDetails(){
		
		return bankDetailsRepo.findAll();
	}
	
	

}
