package com.hrmanagement.portal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanagement.portal.customexception.ResourceNotFoundException;
import com.hrmanagement.portal.dto.SkillsDto;
import com.hrmanagement.portal.model.Skills;
import com.hrmanagement.portal.repository.SkillsRepo;

@Service
public class SkillsService {

	@Autowired
	private SkillsRepo skillsRepo;

	@Autowired
	private ModelMapper mapper;

	public SkillsDto entityToDtoConverter(Skills skill) {
		return mapper.map(skill, SkillsDto.class);
	}

	public Skills dtoToEntityConverter(SkillsDto skillsDto) {
		return mapper.map(skillsDto, Skills.class);
	}

	public List<SkillsDto> getAllSkills() {
		List<Skills> skills = skillsRepo.findAll();
		return skills.stream().map(this::entityToDtoConverter).collect(Collectors.toList());
	}

	public SkillsDto getSkill(Integer skillId) {
		Optional<Skills> skillOptional = skillsRepo.findById(skillId);
		if (skillOptional.isEmpty()) {
			Skills skill = skillOptional.get();
			return entityToDtoConverter(skill);
		} else {

			throw new ResourceNotFoundException("Skill with ID " + skillId + " not found");

		}

	}

	public SkillsDto createSkill(SkillsDto skillsDto) {
		Skills skill = dtoToEntityConverter(skillsDto);

		Skills savedSkill = skillsRepo.save(skill);

		return entityToDtoConverter(savedSkill);
	}

	public SkillsDto updateSkill(Integer skillId, SkillsDto skillsDto) {
		Optional<Skills> skillOptional = skillsRepo.findById(skillId);
		if (skillOptional.isPresent()) {
			Skills skill = skillOptional.get();
			dtoToEntityConverter(skillsDto);

			Skills updatedSkill = skillsRepo.save(skill);

			return entityToDtoConverter(updatedSkill);
		}

		throw new ResourceNotFoundException("Skill with ID " + skillId + " not found");

	}

}
