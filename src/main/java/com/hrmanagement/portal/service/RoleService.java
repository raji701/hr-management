package com.hrmanagement.portal.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.customexception.ResourceNotFoundException;
import com.hrmanagement.portal.dto.RoleDto;
import com.hrmanagement.portal.model.Role;
import com.hrmanagement.portal.repository.EmployeeRepo;
import com.hrmanagement.portal.repository.RoleRepo;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public RoleDto entityToDtoConverter(Role role)
	{
		return mapper.map(role, RoleDto.class);
	}
	
	
	public Role dtoToEntityConverter(RoleDto roleDto)
	{
		return mapper.map(roleDto, Role.class);
	}
	

	public List<RoleDto> getAllRoles() {
		List<Role> personalDetails = roleRepo.findAll();
		return personalDetails.stream().map(this::entityToDtoConverter).toList();
	}
	
	public RoleDto getRoleById(Integer roleId) {
		
		Optional<Role> roleOptional = roleRepo.findById(roleId);
              if (roleOptional.isPresent()) {
            	  Role role = roleOptional.get();
            	  RoleDto roleDto = entityToDtoConverter(role);
            	  return roleDto;
              }
              else {
                 throw new ResourceNotFoundException("Role with ID " + roleId + " not found");
              }          
        }
      
    public RoleDto createRole(RoleDto roleDto) {
        Role role = dtoToEntityConverter(roleDto);
        Role savedRole = roleRepo.save(role);

        return entityToDtoConverter(savedRole);
    }

    public RoleDto updateRole(Integer roleId, RoleDto roleDto) {
        Optional<Role> roleOptional = roleRepo.findById(roleId);
        if (roleOptional.isPresent()) {
             Role role = roleOptional.get();
             entityToDtoConverter(role);
        Role updatedRole = roleRepo.save(role);

        return entityToDtoConverter(updatedRole); 
        }
        else {
        throw new ResourceNotFoundException("Role with ID " + roleId + " not found");
        }
    }
}  
          
    
