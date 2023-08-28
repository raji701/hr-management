package com.hrmanagement.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.model.Skills;
import com.hrmanagement.portal.repository.SkillsRepo;

@Service
public class SkillsService {
	
	@Autowired
	private SkillsRepo skillsRepo;
	
	public List<Skills> skills()
	{
		return skillsRepo.findAll();
		}
	

}
