package com.metacube.training.jdbc;

public class DBQueries {
	public static final String userOrder = "SELECT  order_placed.id,order_placed.order_date,SUM(order_details.price*order_details.product_quantity)  AS price "
			+ "FROM user "
			+ "INNER JOIN order_placed ON user.id=order_placed.user_id "
			+ "INNER JOIN order_details ON order_placed.id=order_details.order_id "
			+ "WHERE user.id=? "
			+ " AND order_details.status='shipped'"
			+ "GROUP BY order_details.order_id";

	public static final String insertImage = "insert into product_image(name,image_url,product_id) values(?,?,?)";

	public static final String updateProductStatus = "UPDATE product "
			+ "SET product.product_state='inactive' "
			+ "WHERE product.id NOT IN "
			+ "(SELECT order_details.product_id "
			+ "FROM order_placed "
			+ "INNER JOIN order_details ON order_placed.id=order_details.order_id "
			+ "WHERE DATEDIFF(CURDATE(),order_placed.order_date)<365)";

	public static final String countChild = "SELECT parent.name, COUNT(*)  AS noOfChild "
			+ "FROM category AS parent "
			+ "INNER JOIN category AS child ON child.parent_id=parent.id "
			+ "GROUP BY child.parent_id " + "ORDER BY parent.name";

}
