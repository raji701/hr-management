package com.hrmanagement.portal.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProjectHistoryId implements Serializable {

	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "project_id")
	private Integer projectId;

	public ProjectHistoryId() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, projectId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectHistoryId other = (ProjectHistoryId) obj;
		return Objects.equals(employeeId, other.employeeId) && Objects.equals(projectId, other.projectId);
	}

}