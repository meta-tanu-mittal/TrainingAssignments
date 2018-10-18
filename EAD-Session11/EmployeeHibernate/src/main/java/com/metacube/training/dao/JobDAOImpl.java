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

@Repository
@Transactional
public class JobDAOImpl implements JobDAO {

	@Autowired
	private SessionFactory sessionFactory;

//	private final String SQL_FIND_JOB_BY_ID = "select * from job_title_master where job_code = ?";
//	private final String SQL_UPDATE_JOB = "update job_title_master set job_title=? WHERE job_code=?";
//	private final String SQL_GET_ALL_JOB = "select * from job_title_master";
//	private final String SQL_INSERT_JOB = "insert into job_title_master(job_title) values(?)";

	@Override
	public Job getJobTitleById(int id) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Job.class);
		criteria.add(Restrictions.eq("jobCode",id));
		return (Job) criteria.uniqueResult();
	}

	@Override
	public List<Job> getAllJobTitle() {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Job.class);
		return (List<Job>)criteria.list();
	}

	@Override
	public boolean updateJobTitle(Job jobTitle) {
		CriteriaBuilder cb=sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaUpdate<Job> update=cb.createCriteriaUpdate(Job.class);
		Root root=update.from(Job.class);
		update.set("jobTitle",jobTitle.getJobTitle());
		update.where(cb.equal(root.get("jobCode"), jobTitle.getJobCode()));

		return sessionFactory.getCurrentSession().createQuery(update)
				.executeUpdate() > 0;
	}

	@Override
	public boolean insertJobTitle(Job jobTitle) {
		Session session=null;
		try
		{
			session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(jobTitle);
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
