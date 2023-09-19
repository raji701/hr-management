package com.hrmanagement.portal.dto;

public class EducationDetailsDto {

    private Integer employeeId;
    private String institute;
    private String university;
    private String degree;
    private String specialization;
    private Integer yearOfPassing;
    private Float cgpa;
    
    

    public EducationDetailsDto(Integer employeeId, String institute, String university, String degree,
			String specialization, Integer yearOfPassing, Float cgpa) {
		super();
		this.employeeId = employeeId;
		this.institute = institute;
		this.university = university;
		this.degree = degree;
		this.specialization = specialization;
		this.yearOfPassing = yearOfPassing;
		this.cgpa = cgpa;
	}

	public EducationDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Integer getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(Integer yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }
}
