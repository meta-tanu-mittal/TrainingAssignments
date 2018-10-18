package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{


@Query("from employee where emailId=? and password=?")
public Employee getEmployeeByEmailId(String emailId,String password);
}
