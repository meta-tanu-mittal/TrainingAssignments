package com.dao;

public interface AdvertisementQueries {
	
	String ADD_ADVERTISEMENT="INSERT INTO advertisement(title,description,category_id) VALUES(?,?,?)";
	 String ALL_ADVERTISEMENT="SELECT id,title,description,category_id FROM advertisement";

}
