package com.hrmanagement.portal.dto;

import java.time.LocalDateTime;

public class ProjectDetailsDto {

    private Integer projectId;
    private String projectName;
    private LocalDateTime projectCreatedAt;
    private LocalDateTime projectCompletedAt;

    // Constructors, getters, and setters

    public ProjectDetailsDto() {
    }

    public ProjectDetailsDto(Integer projectId, String projectName, LocalDateTime projectCreatedAt, LocalDateTime projectCompletedAt) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectCreatedAt = projectCreatedAt;
        this.projectCompletedAt = projectCompletedAt;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDateTime getProjectCreatedAt() {
        return projectCreatedAt;
    }

    public void setProjectCreatedAt(LocalDateTime projectCreatedAt) {
        this.projectCreatedAt = projectCreatedAt;
    }

    public LocalDateTime getProjectCompletedAt() {
        return projectCompletedAt;
    }

    public void setProjectCompletedAt(LocalDateTime projectCompletedAt) {
        this.projectCompletedAt = projectCompletedAt;
    }
}
