package com.hrmanagement.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.model.ProjectHistory;
import com.hrmanagement.portal.repository.ProjectHistoryRepo;

@Service
public class ProjectHistoryService {
	@Autowired
	private ProjectHistoryRepo projHistoryRepo;
	
	public List<ProjectHistory> allProjectsHistory()
	{
		return projHistoryRepo.findAll();
	}

}
