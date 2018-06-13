package DBInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.DBconnection;
import data.DBSchema;

public class AddPublisher {

	public static String publisher(String name, String address, String phone) {
		// String sql = "SELECT * FROM Publisher WHERE " + DBSchema.PUB_NAME + " = '" +
		// name + "'";
		//
		// System.out.println("query is : " + sql);
		//

		String query = "INSERT INTO " + DBSchema.PUBLISHER + " (pub_name , address, phone)  VALUES ( '" + name + "', '" + address + "', '" + phone
				+ "')";

		System.out.println("query is: " + query);
		try {
			DBconnection.getConnection().setAutoCommit(true);

			Statement stmt = DBconnection.getConnection().createStatement();
			stmt.executeUpdate(query);

		} catch (Exception ex) {
			return "Publisher already found";
		}
		return null;
	}

}
