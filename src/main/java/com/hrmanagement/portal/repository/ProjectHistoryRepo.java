package com.hrmanagement.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrmanagement.portal.model.ProjectHistory;
import com.hrmanagement.portal.model.ProjectHistoryId;

public interface ProjectHistoryRepo extends JpaRepository<ProjectHistory,ProjectHistoryId>{

}
