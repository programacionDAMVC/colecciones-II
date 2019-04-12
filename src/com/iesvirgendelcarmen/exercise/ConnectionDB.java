package com.iesvirgendelcarmen.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	private static Connection connection = null;
	private ConnectionDB() {}

	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection =  DriverManager.getConnection("jdbc:sqlite:database/cars.sql");
		}
		return connection;
	}

	public static void closeConnection() throws SQLException {
		if (connection != null)
			connection.close();
	}
	public static void main(String[] args) throws SQLException {
		Connection conecction1 = ConnectionDB.getConnection();
		Connection conecction2 = ConnectionDB.getConnection();
		System.out.println(conecction1);
		System.out.println(conecction2);
		ConnectionDB.closeConnection();
	//	System.out.println(conecction2);

	}
}
