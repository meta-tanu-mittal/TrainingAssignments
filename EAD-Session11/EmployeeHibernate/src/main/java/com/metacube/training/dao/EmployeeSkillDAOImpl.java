package com.metacube.training.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.EmployeeSkill;
import com.metacube.training.model.Job;

@Repository
@Transactional
public class EmployeeSkillDAOImpl implements EmployeeSkillDAO{
    @Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean insertEmployeeSkill(EmployeeSkill employeeSkill) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(employeeSkill);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			return false;
		} finally {
			session.close();
		}

	}

	@Override
	public List<Integer> getAllEmployeeCode(int skillCode) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(EmployeeSkill.class);
		criteria.add(Restrictions.eq("skillCode",skillCode));
		PropertyProjection p=Projections.property("empCode");
		List<Integer> codeList=criteria.setProjection(p).list();
		return codeList;
	}

}
