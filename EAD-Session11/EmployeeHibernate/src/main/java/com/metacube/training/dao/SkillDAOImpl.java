package com.metacube.training.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Job;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;

@Repository
@Transactional
public class SkillDAOImpl implements SkillDAO {

	@Autowired
	private SessionFactory sessionFactory;

//	private final String SQL_FIND_SKILL = "select * from skills_master where skill_id = ?";
//	// private final String SQL_DELETE_SKILL = "delete from skills_master where
//	// skill_id = ?";
//	private final String SQL_UPDATE_SKILL = "update skills_master set skill_name=? WHERE skill_id=?";
//	private final String SQL_GET_ALL = "select * from skills_master";
//	private final String SQL_INSERT_SKILL = "insert into skills_master(skill_name) values(?)";

	public Skill getSkillById(int skillId) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Skill.class);
		criteria.add(Restrictions.eq("skillId",skillId));
		return (Skill) criteria.uniqueResult();
	}

	public List<Skill> getAllSkills() {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Skill.class);
		return (List<Skill>) criteria.list();
	}

	public boolean createSkill(Skill skill) {
		Session session=null;
		try
		{
			session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(skill);
			transaction.commit();
			return true;
		}
		catch(HibernateException e)
		{
			return false;
		}
		finally
		{
			session.close();
		}
	}

	public boolean updateSkill(Skill skill) {
		CriteriaBuilder cb=sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaUpdate<Skill> update=cb.createCriteriaUpdate(Skill.class);
		Root root=update.from(Skill.class);
		update.set("skillName",skill.getSkillName());
		update.where(cb.equal(root.get("skillId"),skill.getSkillId()));

		return sessionFactory.getCurrentSession().createQuery(update)
				.executeUpdate() > 0;
	}

	@Override
	public Skill getSkillByName(String skillName) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Skill.class);
		criteria.add(Restrictions.eq("skillName",skillName));
		return (Skill) criteria.uniqueResult();
	}

}
