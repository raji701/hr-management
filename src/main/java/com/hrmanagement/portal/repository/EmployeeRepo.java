package com.hrmanagement.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrmanagement.portal.model.Employee;



public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	
	

}
