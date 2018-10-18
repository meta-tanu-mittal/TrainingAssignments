package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metacube.training.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e where e.emailId=:emailId and e.password=:password")
	public Employee getEmployeeByEmailIdAndPassword(
			@Param("emailId") String emailId, @Param("password") String password);

	@Query("select e from Employee e where e.emailId=:emailId")
	public Employee getEmployeeByEmailId(@Param("emailId") String emailId);
	
	@Query("select e from Employee e where CONCAT(e.firstName,' ',e.lastName) LIKE CONCAT('%',:name,'%')")
	public List<Employee> getEmployeeByName(@Param("name") String name);

}
