package com.dao;

public interface CategoryQueries {
	String ADD_CATEGORY="INSERT INTO category(name) VALUES(?)";
	
    String ALL_CATEGORY="SELECT id,name FROM category";
    
    String UPDATE_CATEGORY="UPDATE category SET name=? WHERE id=?";
    
    
}
