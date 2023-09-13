package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.ResponseDto.ApiResponse;
import com.hrmanagement.portal.dto.RoleDto;
import com.hrmanagement.portal.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<RoleDto>>> roles() {
		List<RoleDto> positionDtoList = roleService.getAllRoles();
		return ResponseEntity.ok(new ApiResponse<>(positionDtoList, null));
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<ApiResponse<RoleDto>> grtRoleById(@PathVariable Integer roleId) {
		RoleDto positionDto = roleService.getRoleById(roleId);
		return ResponseEntity.ok(new ApiResponse<>(positionDto, null));

	}

	@PostMapping
	public ResponseEntity<ApiResponse<RoleDto>> createRole(@RequestBody RoleDto roleDto) {
		RoleDto createdRoleDto = roleService.createRole(roleDto);
		return ResponseEntity.ok(new ApiResponse<>(createdRoleDto, null));

	}

	@PutMapping("/{roleId}")
	public ResponseEntity<ApiResponse<RoleDto>> updateRole(@PathVariable Integer roleId, @RequestBody RoleDto roleDto) {
		RoleDto updatedRoleDto = roleService.updateRole(roleId, roleDto);
		return ResponseEntity.ok(new ApiResponse<>(updatedRoleDto, null));

	}

}
