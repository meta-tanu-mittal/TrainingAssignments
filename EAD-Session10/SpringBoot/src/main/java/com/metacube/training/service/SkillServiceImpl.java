package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.SkillDAO;
import com.metacube.training.model.Skill;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	SkillDAO skillDAO;

	@Override
	public Skill getSkillById(int id) {
		return skillDAO.getSkillById(id);
	}

	@Override
	public List<Skill> getAllSkills() {
		return skillDAO.getAllSkills();
	}

	@Override
	public boolean updateSkill(Skill skill) {
		return skillDAO.updateSkill(skill);
	}

	@Override
	public boolean createSkill(Skill skill) {
		return skillDAO.createSkill(skill);
	}

}
