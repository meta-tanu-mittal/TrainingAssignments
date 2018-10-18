package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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

import com.metacube.training.model.Project;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {

	
	@Autowired
	   private SessionFactory sessionFactory;

	

	public Project getProjectById(int projectId) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Project.class);
		criteria.add(Restrictions.eq("projectId", projectId));
		return (Project) criteria.uniqueResult();
   
	}

	public List<Project> getAllProjects() {
		TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery("from Project");
		return query.getResultList();
	}

	public boolean deleteProject(Project project) {
		return false;
		
	}

	public boolean updateProject(Project project) {
		CriteriaBuilder cb = sessionFactory.getCurrentSession()
				.getCriteriaBuilder();
		CriteriaUpdate<Project> update = cb.createCriteriaUpdate(Project.class);
		Root e = update.from(Project.class);
		update.set("projectId", project.getProjectId());
		update.set("name", project.getName());
		update.set("description", project.getDescription());
		update.set("logo", project.getLogo());
		update.set("startDate", project.getStartDate());
		update.set("endDate", project.getEndDate());
		update.where(cb.equal(e.get("projectId"), project.getProjectId()));

		return sessionFactory.getCurrentSession().createQuery(update)
				.executeUpdate() > 0;
	}

	public boolean createProject(Project project) {
		Session session=null;
		try
		{
			session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(project);
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

}