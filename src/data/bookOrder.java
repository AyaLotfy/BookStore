package data;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.DBconnection;

public class bookOrder {

	public String ISBN, title, pub_name, category;

	public Book book;

	public int copies;

	public boolean isAccepted;

	public Double price;

	public void placeOrder(String ISBN, String copies) {
		String query = "INSERT INTO " + DBSchema.ORDER + " VALUES ( '" + ISBN + "', " + copies + ", False)";

		try {
			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet set = stmt.executeQuery(query);
		} catch (Exception ex) {

		}

	}

	public void updateOrder(String ISBN, String copies) {
		String query = "UPDATE " + DBSchema.ORDER + " SET " + DBSchema.COPIES + " = " + copies + " WHERE "
				+ DBSchema.ISBN + " = '" + ISBN + "'";

		try {
			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet set = stmt.executeQuery(query);
		} catch (Exception ex) {

		}

	}
	//
	// @Override
	// public ITable getConfimedOrders() {
	// // Constructing query
	// String query = "SELECT B." + DBSchema.ISBN + "," + DBSchema.TITLE
	// + "," + DBSchema.PUB_NAME + ", year(" + DBSchema.YEAR
	// + ")," + DBSchema.PRICE + "," + DBSchema.CATEGORY_NAME
	// + "," + "O." + DBSchema.COPIES + "," + DBSchema.THRESHOLD
	// + " FROM " + DBSchema.BOOK + " AS B, " + DBSchema.ORDER
	// + " AS O, " + DBSchema.CATEGORY + " AS C WHERE B."
	// + DBSchema.ISBN + " = O." + DBSchema.ISBN + " AND B."
	// + DBSchema.CATEGORY_ID + " = C." + DBSchema.CATEGORY_ID
	// + " AND " + DBSchema.ACCEPTED + " = True";
	//
	// // Executing query
	// ITable table = new Table();
	// try {
	//
	// myConnection.setAutoCommit(true);
	// ResultSet set = myStatement.executeQuery(query);
	//
	// String[] attrs = { DBSchema.ISBN, DBSchema.TITLE,
	// DBSchema.PUB_NAME, DBSchema.YEAR, DBSchema.PRICE,
	// DBSchema.CATEGORY_NAME, DBSchema.COPIES,
	// DBSchema.THRESHOLD };
	//
	// List<String[]> data = new ArrayList<String[]>();
	//
	// while (set.next()) {
	// List<String> tuple = new ArrayList<String>();
	// for (int i = 0; i < attrs.length; i++) {
	// tuple.add(set.getString(i + 1));
	// }
	// String[] tempTuple = new String[tuple.size()];
	// tempTuple = tuple.toArray(tempTuple);
	// data.add(tempTuple);
	// }
	//
	// String[][] tableData = new String[data.size()][];
	// tableData = data.toArray(tableData);
	//
	// table.setAttributes(attrs);
	// table.setData(tableData);
	//
	// } catch (Exception ex) {
	//
	// }
	//
	// return table;
	// }

	public ITable getUnConfirmedOrders() {
		String query = "SELECT B." + DBSchema.ISBN + "," + DBSchema.TITLE + "," + DBSchema.PUB_NAME + ", year("
				+ DBSchema.YEAR + ")," + DBSchema.PRICE + "," + DBSchema.CATEGORY_NAME + "," + "O." + DBSchema.COPIES
				+ "," + DBSchema.THRESHOLD

				+ " FROM " + DBSchema.BOOK + " AS B, " + DBSchema.ORDER + " AS O, " + DBSchema.CATEGORY + " AS C,"
				+ DBSchema.PUBLISHER + " AS P "

				+ " WHERE B." + DBSchema.ISBN + " = O." + DBSchema.ISBN + " AND B." + DBSchema.CATEGORY_ID + " = C."
				+ DBSchema.CATEGORY_ID + " AND " + DBSchema.ACCEPTED + " = FALSE" + " AND P." + DBSchema.PUB_ID + "= B."
				+ DBSchema.PUB_ID;
		System.out.println(query);
		// Executing query
		ITable table = new Table();
		try {
			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet set = stmt.executeQuery(query);

			String[] attrs = { DBSchema.ISBN, DBSchema.TITLE, DBSchema.PUB_NAME, DBSchema.YEAR, DBSchema.PRICE,
					DBSchema.CATEGORY_NAME, DBSchema.COPIES, DBSchema.THRESHOLD };

			List<String[]> data = new ArrayList<String[]>();

			while (set.next()) {
				List<String> tuple = new ArrayList<String>();
				for (int i = 0; i < attrs.length; i++) {
					tuple.add(set.getString(i + 1));
				}
				String[] tempTuple = new String[tuple.size()];
				tempTuple = tuple.toArray(tempTuple);
				data.add(tempTuple);
			}

			String[][] tableData = new String[data.size()][];
			tableData = data.toArray(tableData);

			table.setAttributes(attrs);
			table.setData(tableData);

		} catch (Exception ex) {

		}

		return table;
	}

	public void deleteOrder(String ISBN) {

		String query = "DELETE FROM " + DBSchema.ORDER + " WHERE " + DBSchema.ISBN + " = '" + ISBN + "'";

		try {
			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet set = stmt.executeQuery(query);
		} catch (Exception ex) {

		}

	}

	public void confirmOrder(String ISBN) {
		// Constructing query
		String query = "UPDATE " + DBSchema.ORDER + " SET " + DBSchema.ACCEPTED + " = True WHERE " + DBSchema.ISBN
				+ " = '" + ISBN + "'";

		try {
			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet set = stmt.executeQuery(query);
		} catch (Exception ex) {
		}

	}

}
