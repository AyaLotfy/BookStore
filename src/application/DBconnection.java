package application;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import data.DBSchema;

public class DBconnection {

	private static Connection connection;

	private DBconnection() {

		try {
/*salma*/
//			// STEP 2: Register JDBC driver
//			Class.forName("com.mysql.jdbc.Driver");
//
//			// STEP 3: Open a connection
//			System.out.println("Connecting to database...");
//			connection = DriverManager.getConnection(DBSchema.DB_URL, DBSchema.DB_USERNAME, DBSchema.DB_PASSWORD);
			/*aya*/
			

			 Class.forName("com.mysql.jdbc.Driver");
			
			 // connection to database
			 connection = DriverManager.getConnection(DBSchema.DB_URL + DBSchema.DB_NAME,
			 DBSchema.DB_USERNAME,
			 DBSchema.DB_PASSWORD);
			
			 // create statement
			 Statement statement = connection.createStatement();
			 connection.setAutoCommit(true);
			 /*aya*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createConnection() {
		if (connection == null) {
			new DBconnection();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
