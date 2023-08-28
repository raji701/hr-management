package com.hrmanagement.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrmanagement.portal.model.Department;

public interface DepartmentRepo extends JpaRepository<Department,Integer>{

}
