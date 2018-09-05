package com.dao;

public interface AdvertisementQueries {

	String ADD_ADVERTISEMENT = "INSERT INTO advertisement(title,description,category_id) VALUES(?,?,?)";

	String ALL_ADVERTISEMENT = "SELECT id,title,description,category_id FROM advertisement";

	String UPDATE_ADVERTISEMENT = "UPDATE advertisement SET title=? WHERE id=?";

	String DELETE_ADVERTISEMENT = "DELETE FROM advertisement WHERE id=?";

	String ADVERTISEMENT_BY_CATEGORY = "SELECT id,title,description,category_id FROM advertisement WHERE category_id=? ";

}
