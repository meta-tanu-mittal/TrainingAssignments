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

		String query = "SELECT  order_placed.id,order_placed.order_date,SUM(order_details.price*order_details.product_quantity)  AS price "
				+ "FROM user " + "INNER JOIN order_placed ON user.id=order_placed.user_id "
				+ "INNER JOIN order_details ON order_placed.id=order_details.order_id " + "WHERE user.id=?"
				+ " AND order_details.status='shipped'" + "GROUP BY order_details.order_id";

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(query);
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
		String strInsert = "insert into product_image(name,image_url,product_id) values(?,?,?)";
		try (Connection con = DBConnection.getConnection();

				PreparedStatement ps = con.prepareStatement(strInsert);) {
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
		String query = "UPDATE product " + "SET product.product_state='inactive' " + "WHERE product.id NOT IN "
				+ "(SELECT order_details.product_id " + "FROM order_placed "
				+ "INNER JOIN order_details ON order_placed.id=order_details.order_id "
				+ "WHERE DATEDIFF(CURDATE(),order_placed.order_date)<365)";
		
		int res = 0;
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(query);
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
		String query = "SELECT parent.name, COUNT(*)  AS noOfChild " + "FROM category AS parent "
				+ "INNER JOIN category AS child ON child.parent_id=parent.id " + "GROUP BY child.parent_id "
				+ "ORDER BY parent.name";

		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(query);
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
