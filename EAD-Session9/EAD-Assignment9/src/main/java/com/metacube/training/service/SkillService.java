package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillService {

	Skill getSkillById(int id);

	List<Skill> getAllSkills();

	boolean updateSkill(Skill skill);

	boolean createSkill(Skill skill);

}
