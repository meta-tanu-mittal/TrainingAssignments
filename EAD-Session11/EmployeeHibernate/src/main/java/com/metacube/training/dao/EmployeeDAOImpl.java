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
import com.metacube.training.model.Employee;
import com.metacube.training.model.Project;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	   private SessionFactory sessionFactory;

	@Override
	public boolean updateEmployee(Employee employee) {
		CriteriaBuilder cb = sessionFactory.getCurrentSession()
				.getCriteriaBuilder();
		CriteriaUpdate<Employee> update = cb.createCriteriaUpdate(Employee.class);
		Root e = update.from(Employee.class);
		update.set("firstName",employee.getFirstName());
		update.set("lastName",employee.getLastName());
		update.set("dob",employee.getDob());
		update.set("gender",employee.getGender());
		update.set("primaryContactNo",employee.getPrimaryContactNo());
		update.set("secondaryContactNo",employee.getSecondaryContactNo());
		update.set("skypeId",employee.getSkypeId());
		update.set("password",employee.getPassword());
		update.where(cb.equal(e.get("empCode"), employee.getEmpCode()));

		return sessionFactory.getCurrentSession().createQuery(update)
				.executeUpdate() > 0;
	}

	@Override
	public Employee getEmployeeById(int empCode) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("empCode", empCode));
		return (Employee) criteria.uniqueResult();
	}

	@Override
	public List<Employee> getAllEmployee() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		return (List<Employee>) criteria.list();
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			return false;
		} finally {
			session.close();
		}

		
	}

	@Override
	public Employee checkValidLogin(String emailId, String password) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("emailId", emailId))
		         .add(Restrictions.eq("password",password));
		return (Employee) criteria.uniqueResult();
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.or(Restrictions.like("firstName","%"+name+"%"),Restrictions.like("lastName","%"+name+"%")));		
		return criteria.list();
	}

	@Override
	public Employee getEmployeeByEmailId(String emailId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("emailId", emailId));
		return (Employee) criteria.uniqueResult();
	}

}
