package com.hrmanagement.portal.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeeRoleId implements Serializable {

	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "role_id")
	private Integer roleId;

	public EmployeeRoleId() {
		super();

	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, roleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeRoleId other = (EmployeeRoleId) obj;
		return Objects.equals(employeeId, other.employeeId) && Objects.equals(roleId, other.roleId);
	}

	
}
