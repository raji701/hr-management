package com.hrmanagement.portal.dto;

import com.hrmanagement.portal.model.Employee;
import com.hrmanagement.portal.model.ProjectDetails;
import com.hrmanagement.portal.model.ProjectHistory;
import java.time.LocalDateTime;

public class ProjectHistoryDto {

    public ProjectHistoryDto(EmployeeDto employee, ProjectDetailsDto projectDetails) {
		super();
		this.employee = employee;
		this.projectDetails = projectDetails;
	}
    
    public ProjectHistoryDto() {
    }
    
	private EmployeeDto employee;
	
    private ProjectDetailsDto projectDetails;
    
	public EmployeeDto getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}
	public ProjectDetailsDto getProjectDetails() {
		return projectDetails;
	}
	public void setProjectDetails(ProjectDetailsDto projectDetails) {
		this.projectDetails = projectDetails;
	}

 
//
//    public ProjectHistoryDto(ProjectHistory projectHistory) {
//        this.employee = new EmployeeDTO(projectHistory.getEmployee());
//        this.projectDetails = new ProjectDetailsDTO(projectHistory.getProjectDetails());
//    }
//
//    public EmployeeDTO getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(EmployeeDTO employee) {
//        this.employee = employee;
//    }
//
//    public ProjectDetailsDTO getProjectDetails() {
//        return projectDetails;
//    }
//
//    public void setProjectDetails(ProjectDetailsDTO projectDetails) {
//        this.projectDetails = projectDetails;
//    }
}
