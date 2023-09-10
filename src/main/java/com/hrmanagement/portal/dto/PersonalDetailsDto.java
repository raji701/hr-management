package com.hrmanagement.portal.dto;

import java.time.LocalDate;

public class PersonalDetailsDto {

    private Integer employeeId;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private Integer gender;
    private Integer bloodGroup;
    private String citizenship;
    private String religion;
    private Integer maritalStatus;
    private LocalDate marriageDate;
    private String passportNumber;
    private Long aadharNumber;
    private String panCardNumber;
    
    
	public PersonalDetailsDto() {
		super();
		
	}
	
	public PersonalDetailsDto(Integer employeeId, LocalDate dateOfBirth, String placeOfBirth, Integer gender,
			Integer bloodGroup, String citizenship, String religion, Integer maritalStatus, LocalDate marriageDate,
			String passportNumber, Long aadharNumber, String panCardNumber) {
		super();
		this.employeeId = employeeId;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.citizenship = citizenship;
		this.religion = religion;
		this.maritalStatus = maritalStatus;
		this.marriageDate = marriageDate;
		this.passportNumber = passportNumber;
		this.aadharNumber = aadharNumber;
		this.panCardNumber = panCardNumber;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(Integer bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public Integer getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public LocalDate getMarriageDate() {
		return marriageDate;
	}
	public void setMarriageDate(LocalDate marriageDate) {
		this.marriageDate = marriageDate;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public Long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPanCardNumber() {
		return panCardNumber;
	}
	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}
   

    
}
