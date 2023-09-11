package com.hrmanagement.portal.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrmanagement.portal.model.TimingsWorked;

public interface TimingsWorkedRepo extends JpaRepository<TimingsWorked , Integer>{
	
     public List<TimingsWorked>	findAllByEmployeeId(Integer id);
     
     @Query("SELECT tw FROM TimingsWorked tw WHERE tw.employeeId = :employeeId AND tw.date BETWEEN :startDate AND :endDate")
     List<TimingsWorked> findByEmployeeIdAndDateRange(
             Integer employeeId,
             Date startDate,
             Date endDate
     );

}
