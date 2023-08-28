package com.hrmanagement.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrmanagement.portal.model.EmployeeRole;
import com.hrmanagement.portal.model.EmployeeRoleId;

public interface EmployeeRoleRepo extends JpaRepository<EmployeeRole,EmployeeRoleId> {

}
