package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.UserRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Integer>{
	
	public List<UserRoles> findUserRolesByEmailId(String emailId);
	

}
