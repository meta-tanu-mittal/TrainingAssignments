package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Skill;
import com.metacube.training.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
   private  SkillRepository SkillRepository;
	
	@Override
	public Skill getSkillById(int id) {
		return SkillRepository.findOne(id);
		
	}

	@Override
	public List<Skill> getAllSkills() {
		return SkillRepository.findAll();

	}

	@Override
	public boolean updateSkill(Skill skill) {
		try
		{
			SkillRepository.save(skill);
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
			SkillRepository.save(skill);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	
	}

	@Override
	public Skill getSkillByName(String skillName) {
		return null;

	}

}
