package com.hrmanagement.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrmanagement.portal.model.EmploySkills;
import com.hrmanagement.portal.model.EmployeeSkillId;

public interface EmployeeSkillsRepo extends JpaRepository<EmploySkills,EmployeeSkillId>{

}
