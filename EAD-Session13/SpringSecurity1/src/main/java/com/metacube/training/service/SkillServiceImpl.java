package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Skill;
import com.metacube.training.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
   private  SkillRepository skillRepository;
	
	@Override
	public Skill getSkillById(int id) {
		return skillRepository.findOne(id);
		
	}

	@Override
	public List<Skill> getAllSkills() {
		return skillRepository.findAll();

	}

	@Override
	public boolean updateSkill(Skill skill) {
		try
		{
			skillRepository.save(skill);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	
	}

	@Override
	public boolean createSkill(Skill skill) {
		try
		{
			skillRepository.save(skill);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	
	}

	@Override
	public Skill getSkillByName(String skillName) {
		return skillRepository.findBySkillName(skillName);

	}

}
