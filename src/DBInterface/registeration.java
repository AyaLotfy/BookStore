package DBInterface;

import java.sql.ResultSet;

import java.sql.Statement;

import application.DBconnection;
import data.DBSchema;
import data.customer;

public class registeration {
	
	
	public registeration() {
		
	}
	
	public static String addNewCustomer(customer customer) {
		
		System.out.println("add new customer");
		
		String query = "INSERT INTO " + DBSchema.USER + " (Username, F_Name, L_Name, Email, User_Password, Phone, Address) VALUES (";
		query += ("'" + customer.userName + "'" + ",");
		query += ("'" +customer.fName+ "'" + ",");
		query += ("'" + customer.lName + "'" + ",");
		query += ("'" + customer.email + "'" + ",");
		query += ("'" +customer.password+ "'" + ",");
		query += ("'" + customer.phone + "'" + ",");
		query += ("'" + customer.address+ "'" );
		query += ")";
		System.out.println("query is: " + query); 
		try {
			DBconnection.getConnection().setAutoCommit(true);
			
			Statement  stmt =  DBconnection.getConnection().createStatement();
			stmt.executeUpdate(query);
			
			System.out.println("user added");
		} catch (Exception ex) {
			return "User already found";
		}
		return null;		
	}
	public static String updateCustomer(String userName, String[] userAttributes) {
		
		System.out.println("update customer");
		
		String query = "UPDATE " + DBSchema.USER + " SET "
				+ DBSchema.FIRST_NAME + "='" + userAttributes[0] + "',"
				+ DBSchema.LAST_NAME + "='" + userAttributes[1] + "',"
				+ DBSchema.USER + "='" + userAttributes[2] + "',"
				+ DBSchema.PASSWORD + "='" + userAttributes[3] + "',"
				+ DBSchema.EMAIL + "='" + userAttributes[4] + "',"
				+ DBSchema.PHONE + "='" + userAttributes[5] + "',"
				+ DBSchema.ADDRESS + "='" + userAttributes[6] + "',"
				+ DBSchema.IS_MANAGER + "=" + "true" + " WHERE "
				+ DBSchema.USER + "='" + userName + "'";
		
		System.out.println("query is: " + query); 
		try {
			DBconnection.getConnection().setAutoCommit(true);
			
			Statement  stmt =  DBconnection.getConnection().createStatement();
			stmt.executeUpdate(query);
			
			System.out.println("user added");
		} catch (Exception ex) {
			return "User already found";
		}
		return null;		
	}	

}
