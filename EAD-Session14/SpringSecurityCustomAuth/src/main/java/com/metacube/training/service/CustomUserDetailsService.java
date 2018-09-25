package com.metacube.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.UserRoles;

@Service
public class CustomUserDetailsService implements UserDetailsService{
 

@Autowired
EmployeeService employeeService;

@Autowired
UserRolesService userRolesService;

@Override
public UserDetails loadUserByUsername(String emailId)
throws UsernameNotFoundException {
Employee employee=employeeService.getEmployeeByEmailId(emailId);
if(employee==null){
           throw new UsernameNotFoundException("employee not found"); 
       }
           return new org.springframework.security.core.userdetails.User(employee.getEmailId(), employee.getPassword(), 
                employee.isEnabled(), true, true, true, getGrantedAuthorities(emailId));
}

private List<GrantedAuthority> getGrantedAuthorities(String emailId){
       List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
       List<UserRoles> listOfUserRoles=userRolesService.getUserRolesByEmailId(emailId);
       for(UserRoles userRoles : listOfUserRoles){
           authorities.add(new SimpleGrantedAuthority("ROLE_"+userRoles.getRole()));
       }
       return authorities;
   }
}
