package com.hrmanagement.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrmanagement.portal.model.Role;

public interface RoleRepo extends JpaRepository<Role,Integer> {

}
