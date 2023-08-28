package com.hrmanagement.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.model.Position;
import com.hrmanagement.portal.repository.PositionRepo;

@Service
public class PositionService {

	@Autowired
	private PositionRepo posRepo;
	
	public List<Position> positionList()
	{
		return posRepo.findAll();
	}
}
