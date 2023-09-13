package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.model.Skills;
import com.hrmanagement.portal.service.SkillsService;

@RestController
public class SkillsController {
	
	@Autowired
	private SkillsService skillsService;
	
	
}
