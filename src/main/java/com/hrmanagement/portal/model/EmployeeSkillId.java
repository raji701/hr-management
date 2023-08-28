package com.hrmanagement.portal.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeeSkillId implements Serializable {

	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "skill_id")
	private Integer skillId;

	public EmployeeSkillId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, skillId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeSkillId other = (EmployeeSkillId) obj;
		return Objects.equals(employeeId, other.employeeId) && Objects.equals(skillId, other.skillId);
	}

}
