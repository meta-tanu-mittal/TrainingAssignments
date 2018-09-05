package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * class for database connection
 * 
 * @author Tanu Mittal
 *
 */
public class DBConnection {

	public static Connection getConnection() {
		String host = "jdbc:mysql://localhost:3306/";
		String dbName = "web_service";
		String mysqlURL = host + dbName;
		String userId = "root";
		String password = "12345";
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(mysqlURL, userId, password);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error loading driver: " + cnfe);
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

}
