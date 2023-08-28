package com.hrmanagement.portal.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="timings_worked")
public class TimingsWorked {
	
	@Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @ManyToOne
    @JsonIgnore
    @MapsId
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "time_in")
    private LocalDateTime timeIn;

    @Column(name = "time_out")
    private LocalDateTime timeOut;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "day_of_the_week")
    private DayOfWeekEnum dayOfTheWeek;

    @Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "modified_at")
	private LocalDateTime modifiedAt;
	
	@Column(name="modified_by")
	private int modifiedBy;


    public enum DayOfWeekEnum {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }


	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public LocalDateTime getTimeIn() {
		return timeIn;
	}


	public void setTimeIn(LocalDateTime timeIn) {
		this.timeIn = timeIn;
	}


	public LocalDateTime getTimeOut() {
		return timeOut;
	}


	public void setTimeOut(LocalDateTime timeOut) {
		this.timeOut = timeOut;
	}


	public DayOfWeekEnum getDayOfTheWeek() {
		return dayOfTheWeek;
	}


	public void setDayOfTheWeek(DayOfWeekEnum dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public int getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}


	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}


	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}


	public int getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	
	
	
    
}
