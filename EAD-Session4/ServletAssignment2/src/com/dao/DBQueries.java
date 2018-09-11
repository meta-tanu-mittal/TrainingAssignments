package com.dao;

public interface DBQueries {
	
	public static final String insertUser="INSERT INTO user_detail(first_name,last_name,dob,contact,email,password,organization) "
			+ "VALUES(?,?,?,?,?,?,?)";
	
	public static final  String loginQuery="SELECT id,first_name,last_name,dob,contact,organization "
			+ "FROM user_detail "
			+ "WHERE email=? AND password=?";
	
	public static final String friendListQuery="SELECT id,first_name,last_name,dob,contact,email,password "
			+ "FROM user_detail "
			+ "WHERE organization=?";

}
