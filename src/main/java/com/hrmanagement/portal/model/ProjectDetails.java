package com.hrmanagement.portal.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_details")
public class ProjectDetails {

	public enum ProjectStatus {
		CANCELED,
	    COMPLETED,
	    INPROGRESS,
	    ONHOLD,
	    
	}
	
	@Id
	@Column(name = "project_id")
	private Integer projectId;

	@Column(name = "project_name", length = 30)
	private String projectName;

	@Column(name = "project_created_at")
	private LocalDateTime projectCreatedAt;

	@Column(name = "project_completed_at")
	private LocalDateTime projectCompletedAt;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "created_by")
	private int createdBy;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="status")
	private ProjectStatus status;
	
	@JsonIgnore
	@OneToMany(mappedBy= "projectDetails")
	private List<ProjectHistory> projectHistoryList;

	@Column(name = "modified_at")
	private LocalDateTime modifiedAt;
	
	@Column(name="modified_by")
	private int modifiedBy;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public LocalDateTime getProjectCreatedAt() {
		return projectCreatedAt;
	}

	public void setProjectCreatedAt(LocalDateTime projectCreatedAt) {
		this.projectCreatedAt = projectCreatedAt;
	}

	public LocalDateTime getProjectCompletedAt() {
		return projectCompletedAt;
	}

	public void setProjectCompletedAt(LocalDateTime projectCompletedAt) {
		this.projectCompletedAt = projectCompletedAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public List<ProjectHistory> getProjectHistoryList() {
		return projectHistoryList;
	}

	public void setProjectHistoryList(List<ProjectHistory> projectHistoryList) {
		this.projectHistoryList = projectHistoryList;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}
	
	
}
