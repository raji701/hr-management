package com.hrmanagement.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hrmanagement.portal.model.ProjectDetails;
import com.hrmanagement.portal.model.ProjectHistory;
import com.hrmanagement.portal.model.ProjectHistoryId;

public interface ProjectHistoryRepo extends JpaRepository<ProjectHistory,ProjectHistoryId>{

	@Query("SELECT p.projectDetails FROM ProjectHistory p JOIN p.employee e WHERE e.employeeId = :id ")
	public List<ProjectDetails> ProjectHistoryByEmployeeId(@Param("id") int id);
	}
