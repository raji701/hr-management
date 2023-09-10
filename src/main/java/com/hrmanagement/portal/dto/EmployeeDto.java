package com.hrmanagement.portal.dto;

import java.time.LocalDate;

public class EmployeeDto {

    private Integer employeeId;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String employeeAddress;
    private Double salary;
    private int departmentId;
    private String employmentType;
    private LocalDate dateOfJoining;
    
    
	public EmployeeDto(Integer employeeId, String userId, String firstName, String lastName, String email, String phone,
			String employeeAddress, Double salary, int departmentId, String employmentType, LocalDate dateOfJoining) {
		super();
		this.employeeId = employeeId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.employeeAddress = employeeAddress;
		this.salary = salary;
		this.departmentId = departmentId;
		this.employmentType = employmentType;
		this.dateOfJoining = dateOfJoining;
	}


	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmployeeAddress() {
		return employeeAddress;
	}


	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public String getEmploymentType() {
		return employmentType;
	}


	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}


	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}


	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
    
	
    
	
    
}
