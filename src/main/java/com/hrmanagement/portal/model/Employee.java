package com.hrmanagement.portal.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@Column(name = "employee_id")
	private Integer employeeId;

	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "user_id", unique = true, nullable = false, insertable=false,updatable=false)
	private User refUserId;
	
	
	@Column(name="user_id",unique= true , nullable= false)
	private String userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "phone", unique = true, nullable = false)
	private String phone;

	@Column(name = "employee_address", length = 120)
	private String employeeAddress;

	@Column(name = "salary")
	private Double salary;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "department_id",insertable=false,updatable=false)
	private Department department;
	
	@Column(name = "department_id")
	private int departmentId;

	@Column(name = "employment_type", length = 20)
	private String employmentType;

	@Column(name = "date_of_joining")
	private LocalDate dateOfJoining;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "modified_at")
	private LocalDateTime modifiedAt;
	
	@Column(name="modified_by")
	private Integer modifiedBy;
	
	@Column(name="reporting_to")
	private Integer reportingTo;
	
	@Column(name="position_id")
	private Integer positionId;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name ="position_id",insertable=false,updatable=false)
	private Position position;

	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<EmploySkills> employeeSkillsList;

	@JsonIgnore
	@OneToOne(mappedBy = "employee")
	private BankDetails bankDetails;

	@JsonIgnore
	@OneToOne(mappedBy = "employee")
	private EducationDetails educationDetails;


	@JsonIgnore
	@OneToOne(mappedBy = "employee")
	private PersonalDetails personalDetails;


	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<ProjectHistory> projectHistoryList;

	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<TimingsWorked> timingsWorkedList;

	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<EmployeeRole> employeeRolesList;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public User getRefUserId() {
		return refUserId;
	}

	public void setRefUserId(User refUserId) {
		this.refUserId = refUserId;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Integer getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(Integer reportingTo) {
		this.reportingTo = reportingTo;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public List<EmploySkills> getEmployeeSkillsList() {
		return employeeSkillsList;
	}

	public void setEmployeeSkillsList(List<EmploySkills> employeeSkillsList) {
		this.employeeSkillsList = employeeSkillsList;
	}

	public BankDetails getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}

	public EducationDetails getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(EducationDetails educationDetails) {
		this.educationDetails = educationDetails;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public List<ProjectHistory> getProjectHistoryList() {
		return projectHistoryList;
	}

	public void setProjectHistoryList(List<ProjectHistory> projectHistoryList) {
		this.projectHistoryList = projectHistoryList;
	}

	public List<TimingsWorked> getTimingsWorkedList() {
		return timingsWorkedList;
	}

	public void setTimingsWorkedList(List<TimingsWorked> timingsWorkedList) {
		this.timingsWorkedList = timingsWorkedList;
	}

	public List<EmployeeRole> getEmployeeRolesList() {
		return employeeRolesList;
	}

	public void setEmployeeRolesList(List<EmployeeRole> employeeRolesList) {
		this.employeeRolesList = employeeRolesList;
	}

	

	

	

	

	

}
