package com.metacube.training.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.JobDetails;

@Repository
@Transactional
public class JobDetailsDAOImpl implements JobDetailsDAO{
    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean insertJobDetails(JobDetails jobDetails) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(jobDetails);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			return false;
		} finally {
			session.close();
		}

	}

	@Override
	public boolean updateJobDetails(JobDetails jobDetails) {
		return false;
	}

	@Override
	public JobDetails getJobDetailsById(int jobDetailId) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(JobDetails.class);
		criteria.add(Restrictions.eq("jobDetailId",jobDetailId));
		return (JobDetails) criteria.uniqueResult();
	}

	@Override
	public List<JobDetails> getAllJobDetails() {
		return null;
	}

}
