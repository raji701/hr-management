package com.hrmanagement.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrmanagement.portal.model.ProjectDetails;
import com.hrmanagement.portal.model.ProjectDetails.ProjectStatus;

public interface ProjectDetailsRepo extends JpaRepository<ProjectDetails,Integer>{

	List<ProjectDetails> findAllByStatus(ProjectStatus status);
}
