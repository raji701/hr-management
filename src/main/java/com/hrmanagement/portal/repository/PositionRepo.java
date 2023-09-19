package com.hrmanagement.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrmanagement.portal.model.Position;

public interface PositionRepo extends JpaRepository<Position,Integer>{
	
	

}
