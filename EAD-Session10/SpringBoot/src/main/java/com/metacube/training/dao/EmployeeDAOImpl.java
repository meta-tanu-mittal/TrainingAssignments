package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private JdbcTemplate jdbcTemplate;
	
    @Autowired
	public EmployeeDAOImpl(DataSource dataSource)
	{
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
    
    private final String SQL_INSERT_EMPLOYEE="INSERT INTO employee(first_name,last_name,dob,gender,primary_contact_no,"
    		+ "secondary_contact_no,email_id,skype_id) "
			+ "VALUES(?,?,?,?,?,?,?,?)";
    
    private final String SQL_GET_ALL_EMPLOYEE = "SELECT * FROM employee";
    
    private final String SQL_FIND_EMPLOYEE="SELECT * FROM employee WHERE emp_code=?";
    
    private final String SQL_UPDATE_EMPLOYEE="UPDATE employee SET first_name=?,last_name=?,dob=?,gender=?,primary_contact_no=?,"
    		+ "seconday_contact_no=?,skype_id=? "
    		+ "WHERE emp_code=?";
    
    private final String SQL_FIND_BY_EMAIL="SELECT * from employee WHERE email_id=?";
    
	

	@Override
	public boolean updateEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE,employee.getFirstName(),employee.getLastName(),
				employee.getDob(),employee.getGender(),employee.getPrimaryContactNo(),
				employee.getSecondaryContactNo(),employee.getSkypeId(),employee.getEmpCode())>0;
	}

	@Override
	public Employee getEmployeeById(int empCode) {
		return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE, new Object[]{empCode},new EmployeeMapper());
	}

	@Override
	public List<Employee> getAllEmployee() {
		return jdbcTemplate.query(SQL_GET_ALL_EMPLOYEE, new EmployeeMapper());
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_INSERT_EMPLOYEE,employee.getFirstName(),employee.getLastName()
				,employee.getDob(),
				employee.getGender(),employee.getPrimaryContactNo(),
				employee.getSecondaryContactNo(),employee.getEmailId(),employee.getSkypeId())>0;
	}

	@Override
	public Employee getEmployeeByEmailId(String emailId) {
		return jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, new Object[]{emailId},new EmployeeMapper());
	}
	
	
	
	
}
