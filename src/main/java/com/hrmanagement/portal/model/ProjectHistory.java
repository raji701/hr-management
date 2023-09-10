package com.hrmanagement.portal.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_history")
public class ProjectHistory {

	@JsonIgnore
	@EmbeddedId
	private ProjectHistoryId id;

	@Column(name = "employee_id",insertable = false, updatable = false)
	private Integer employeeId;

	@Column(name = "project_id",insertable = false, updatable = false)
	private Integer projectId;

	@ManyToOne
	@JsonIgnore
	@MapsId("employee_id")
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@ManyToOne
	@JsonIgnore
	@MapsId("project_id")
	@JoinColumn(name = "project_id")
	private ProjectDetails projectDetails;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "modified_at")
	private LocalDateTime modifiedAt;

	@Column(name = "modified_by")
	private int modifiedBy;

	public ProjectHistoryId getId() {
		return id;
	}

	public void setId(ProjectHistoryId id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public ProjectDetails getProjectDetails() {
		return projectDetails;
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

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

}
