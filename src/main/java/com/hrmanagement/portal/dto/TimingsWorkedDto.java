package com.hrmanagement.portal.dto;

import java.sql.Time;
import java.util.Date;

public class TimingsWorkedDto {

    private Integer attendanceId;
    private Integer employeeId;
    private Date date;
    private Time timeIn;
    private Time timeOut;

    // Constructors, getters, and setters

    public TimingsWorkedDto() {
    }

    public TimingsWorkedDto(Integer attendanceId, Integer employeeId, Date date, Time timeIn, Time timeOut) {
        this.attendanceId = attendanceId;
        this.employeeId = employeeId;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
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
