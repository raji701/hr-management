package com.hrmanagement.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrmanagement.portal.model.Skills;

public interface SkillsRepo extends JpaRepository<Skills,Integer> {

	public Skills findBySkillName(String name);
}
