package com.hrmanagement.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.model.PersonalDetails;
import com.hrmanagement.portal.repository.PersonalDetailsRepo;

@Service
public class PersonalDetailsService {

	@Autowired
	private PersonalDetailsRepo personalDetailsRepo;
	
	

	// 1.All employee personal Details
	public List<PersonalDetails> getPersonalDetailsOfAllEmployees() {
		return personalDetailsRepo.findAll();
	}
}
