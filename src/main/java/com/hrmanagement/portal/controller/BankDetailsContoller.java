package com.hrmanagement.portal.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.model.BankDetails;
import com.hrmanagement.portal.service.BankDetailsService;

@RestController
public class BankDetailsContoller {
	
	@Autowired
	private BankDetailsService bankDetailsService;

	//1. list of departments
		@GetMapping("/bankdetails")
		public List<BankDetails> allEmployeeBankDetailsList()
		{
			return bankDetailsService.allEmployeeBankDetails();
		}

}
