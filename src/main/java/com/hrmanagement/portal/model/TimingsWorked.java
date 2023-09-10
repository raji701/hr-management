package com.hrmanagement.portal.model;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_daily_attendance")
public class TimingsWorked {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendance_id")
	private Integer attendanceId;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "employee_id", insertable = false, updatable = false)
	private Employee employee;

	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "date")
	private Date date;

	@Column(name = "time_in")
	private Time timeIn;

	@Column(name = "time_out")
	private Time timeOut;

	public Integer getAttendanceId() {
		return attendanceId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(Time timeIn) {
		this.timeIn = timeIn;
	}

	public Time getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Time timeOut) {
		this.timeOut = timeOut;
	}

}
