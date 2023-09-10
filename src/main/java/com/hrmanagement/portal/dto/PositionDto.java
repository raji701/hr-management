package com.hrmanagement.portal.dto;

public class PositionDto {

	private Integer employeeId;

	private Integer positionName;

	public PositionDto(Integer employeeId, Integer positionName) {
		super();
		this.employeeId = employeeId;
		this.positionName = positionName;
	}

	public PositionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getPositionName() {
		return positionName;
	}

	public void setPositionName(Integer positionName) {
		this.positionName = positionName;
	}

}
