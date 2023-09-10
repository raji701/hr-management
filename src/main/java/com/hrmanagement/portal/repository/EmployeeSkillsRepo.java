package com.hrmanagement.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hrmanagement.portal.model.EmploySkills;
import com.hrmanagement.portal.model.Employee;
import com.hrmanagement.portal.model.EmployeeSkillId;

public interface EmployeeSkillsRepo extends JpaRepository<EmploySkills,EmployeeSkillId>{

	
}
