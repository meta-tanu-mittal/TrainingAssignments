package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.UserRoles;

public interface UserRolesService {
	
	public List<UserRoles> getUserRolesByEmailId(String emailId);
}
