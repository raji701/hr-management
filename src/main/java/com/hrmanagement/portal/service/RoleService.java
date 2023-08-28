package com.hrmanagement.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.model.Role;
import com.hrmanagement.portal.repository.RoleRepo;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepo roleRepo;
	
	public List<Role> allRoles()
	{
		return roleRepo.findAll();
	}

}
