package com.hrmanagement.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.model.EducationDetails;
import com.hrmanagement.portal.repository.EducationDetailsRepo;



@Service
public class EducationDetailsService {
	
	@Autowired
	private EducationDetailsRepo eduRepo;
	
	public List<EducationDetails> AllEmployeeEducationDetails(){
		
		return eduRepo.findAll();
	}
}
