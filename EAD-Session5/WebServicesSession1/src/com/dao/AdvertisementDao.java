package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Advertisement;
import com.model.Category;
import com.util.DBConnection;

public class AdvertisementDao {
	public boolean addAdvertisement(Advertisement adv) {
		Connection con = DBConnection.getConnection();
		String query = AdvertisementQueries.ADD_ADVERTISEMENT;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, adv.getTitle());
			ps.setString(2, adv.getDescription());
			ps.setInt(3, adv.getCategoryId());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;

	}

	public List<Advertisement> getAllAdvertisement() {
		List<Advertisement> listOfAdvertisement = new ArrayList<Advertisement>();
		Connection con = DBConnection.getConnection();
		String query = AdvertisementQueries.ALL_ADVERTISEMENT;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				int id = res.getInt("id");
				String title = res.getString("title");
				String desc = res.getString("description");
				int categoryId = res.getInt("category_id");
				Advertisement adv = new Advertisement(title, desc, categoryId);
				adv.setId(id);
				listOfAdvertisement.add(adv);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listOfAdvertisement;

	}

	public boolean updateAdvertisement(String title, int id) {
		Connection con = DBConnection.getConnection();
		String query = AdvertisementQueries.UPDATE_ADVERTISEMENT;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, title);
			ps.setInt(2, id);
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteAdvertisement(int id) {
		Connection con = DBConnection.getConnection();
		String query = AdvertisementQueries.DELETE_ADVERTISEMENT;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public List<Advertisement> getAllAdvertisementByCategoryId(int category_id) {
		List<Advertisement> listOfAdvertisement = new ArrayList<Advertisement>();
		Connection con = DBConnection.getConnection();
		String query = AdvertisementQueries.ADVERTISEMENT_BY_CATEGORY;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, category_id);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				int id = res.getInt("id");
				String title = res.getString("title");
				String desc = res.getString("description");
				int categoryId = res.getInt("category_id");
				Advertisement adv = new Advertisement(title, desc, categoryId);
				adv.setId(id);
				listOfAdvertisement.add(adv);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listOfAdvertisement;

	}

}
