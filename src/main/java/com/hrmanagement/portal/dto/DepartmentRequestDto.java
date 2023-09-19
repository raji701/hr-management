package com.hrmanagement.portal.dto;



public class DepartmentRequestDto {

	private int id;
	
	private String name;
	
	public DepartmentRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public DepartmentRequestDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	
	
	
}
