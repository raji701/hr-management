package com.hrmanagement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrmanagement.portal.model.Position;
import com.hrmanagement.portal.service.PositionService;

@RestController
public class PositionController {
	
	@Autowired
	private PositionService positionService;
	
	@GetMapping("/positions")
	public List<Position> positionList()
	{
		return positionService.positionList();
	}

}
