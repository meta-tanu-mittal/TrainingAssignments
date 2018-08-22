package com.metacube.training.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Methods in class
 * 1 find order details for particular order
 * 2 insert image in batch
 * 3 change product state if not ordered for particular time
 * 4 find top category with number of child
 * @author Tanu Mittal
 *
 */
public class FetchData {

	/**
	 * find list of order for particular user
	 * 
	 * @param user_id
	 *            is id of user
	 * @return list of order details for user
	 */
	public List getAllOrders(int user_id) {
		List<OrderDetail> listOfOrders = new ArrayList<OrderDetail>();

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(DBQueries.userOrder);
			ps.setInt(1, user_id);

			ResultSet res = ps.executeQuery();
			while (res.next()) {
				int id = res.getInt("id");
				Date date = res.getDate("order_date");
				float price = res.getFloat("price");
				listOfOrders.add(new OrderDetail(id, date, price));
     
				System.out.println(id + " " + date + " " + price);
			}
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listOfOrders;

	}

	/**
	 * insert image in database in batch
	 * 
	 * @param img
	 *            is list of image to be inserted in database
	 * @return no of images that are inserted in database
	 */
	public int insertImageInBatch(List<Image> img) {
		int[] result = null;
		try (Connection con = DBConnection.getConnection();

				PreparedStatement ps = con.prepareStatement(DBQueries.insertImage);) {
			try {
				con.setAutoCommit(false);

				for (int i = 0; i < img.size(); i++) {
					ps.setString(1, img.get(i).getName());
					ps.setString(2, img.get(i).getUrl());
					ps.setInt(3, img.get(i).getProductId());
					ps.addBatch();
				}

				result = ps.executeBatch();
				System.out.println("The number of rows inserted: " + result.length);
				con.commit();

			} catch (SQLException ex) {
				ex.printStackTrace();
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result.length;

	}

	/**
	 * change product status if not ordered for given period of time
	 * 
	 * @return count of inactive products
	 */
	public int changeProductStatus() {
		
		int res = 0;
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(DBQueries.updateProductStatus);
			res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;

	}

	/**
	 * find top category and no of child
	 * 
	 * @return list of parent and count of child
	 */
	public List findTopCategoryAndChild() {
		List<ParentAndChild> listOfCategory = new ArrayList<ParentAndChild>();

		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(DBQueries.countChild);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				String name = res.getString("name");
				int noOfChild = res.getInt("noOfChild");
				System.out.println(name + " " + noOfChild);
				listOfCategory.add(new ParentAndChild(name, noOfChild));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfCategory;
	}

}
