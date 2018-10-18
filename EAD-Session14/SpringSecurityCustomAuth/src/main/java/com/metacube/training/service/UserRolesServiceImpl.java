package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.UserRoles;
import com.metacube.training.repository.UserRolesRepository;

@Service
public class UserRolesServiceImpl implements UserRolesService{
	
    @Autowired
	UserRolesRepository userRolesRepository;
	
	@Override
	public List<UserRoles> getUserRolesByEmailId(String emailId) {
		return userRolesRepository.findUserRolesByEmailId(emailId);
	}

}
