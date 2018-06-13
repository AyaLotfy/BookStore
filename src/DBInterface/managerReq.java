package DBInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import application.DBconnection;
import data.Book;
import data.DBSchema;
import data.bookOrder;
import data.customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class managerReq extends databaseReq {

	public static String addNewBook(Book book) {
		System.out.println("add new book");

		String query = "INSERT INTO " + DBSchema.BOOK
				+ " (ISBN, TITLE, PUB_ID, PUB_YEAR, PRICE, CAT_ID, COPIES, THRESHOLD) VALUES (";
		query += ("'" + book.getISBN() + "'" + ",");
		query += ("'" + book.getTitle() + "'" + ",");
		query += ("(SELECT PUB_ID FROM PUBLISHER WHERE PUB_NAME = '" + book.getPubName() + "'),");
		query += ("'" + book.getPubYear() + "'" + ",");
		query += ("'" + book.getPrice() + "'" + ",");
		query += ("(SELECT Cat_Id FROM CATEGORY WHERE CAT_NAME = '" + book.getCategory() + "'),");
		query += ("'" + book.getCopies() + "'" + ",");
		query += ("'" + book.getThreshold() + "'");
		query += ")";

		System.out.println("query is: " + query);

		String query2 = "INSERT INTO " + DBSchema.BOOK_AUTHORS + " VALUES ( '" + book.getISBN() + "', '"
				+ book.getAuthor() + "')";
		try {
			DBconnection.getConnection().setAutoCommit(true);

			Statement stmt = DBconnection.getConnection().createStatement();
			stmt.executeUpdate(query);
			stmt.executeUpdate(query2);

			System.out.println("book added");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error in adding book" + ex.getMessage();
		}
		return null;
	}

	public static String editQuantity(Book book, String newQuantity) {
		try {
			int quant = Integer.valueOf(newQuantity);
			String query = "UPDATE BOOK SET COPIES = " + newQuantity + " WHERE ISBN = '" + book.getISBN() + "'";

			System.out.println("query is: " + query);

			DBconnection.getConnection().setAutoCommit(true);
			Statement stmt = DBconnection.getConnection().createStatement();
			stmt.executeUpdate(query);

			System.out.println("book edited");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error in editing book";
		}
		return null;

	}

	public static String addOrder(bookOrder order) {
		String query = "INSERT INTO " + DBSchema.ORDER + " VALUES ( '" + order.ISBN + "', " + order.copies + ", False)";

		try {
			System.out.println("query is: " + query);
			DBconnection.getConnection().setAutoCommit(true);
			Statement stmt = DBconnection.getConnection().createStatement();
			stmt.executeUpdate(query);
			System.out.println("order added");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error in adding order";
		}
		return null;
	}

	public static String confirmOrder(bookOrder order) {
		// Constructing query
		String query = "UPDATE " + DBSchema.ORDER + " SET " + DBSchema.ACCEPTED + " = True WHERE " + DBSchema.ISBN
				+ " = '" + order.ISBN + "'";
		try {
			System.out.println("query is: " + query);

			DBconnection.getConnection().setAutoCommit(true);
			Statement stmt = DBconnection.getConnection().createStatement();
			stmt.executeUpdate(query);
			order.isAccepted = true;
			System.out.println("order confirmed");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error in confirming user";
		}
		return null;
	}

	public static LinkedList<customer> getCustomers() {
		return null;
	}

	public static String promote(String userName) {

		String query = "UPDATE Library_User SET IS_MANAGER = 1 WHERE username = '" + userName + "'";

		try {
			System.out.println("query is: " + query);

			DBconnection.getConnection().setAutoCommit(true);
			Statement stmt = DBconnection.getConnection().createStatement();
			stmt.executeUpdate(query);

			System.out.println("user promoted");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error in promoting user";
		}
		return null;
	}

	public static ObservableList<bookOrder> getOrders() {

		ObservableList<bookOrder> collec = FXCollections.observableArrayList();

		String query = "SELECT * from BOOK NATURAL JOIN BOOK_ORDER NATURAL JOIN CATEGORY NATURAL JOIN PUBLISHER";

		System.out.println("get result query: " + query);

		try {

			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);

			Book book = new Book();
			bookOrder order = new bookOrder();
			// Extract data from result set
			while (rs.next()) {
				book = new Book();
				book.setID(rs.getInt("BOOK_ID"));
				book.setISBN(rs.getString(DBSchema.ISBN));
				book.setTitle(rs.getString(DBSchema.TITLE));
				book.setPubName(rs.getString(DBSchema.PUB_NAME));
				book.setPub_year(rs.getString(DBSchema.YEAR));
				book.setPrice(rs.getDouble(DBSchema.PRICE));
				book.setCategory(rs.getString(DBSchema.CATEGORY_NAME));
				book.setCopies(rs.getInt(DBSchema.COPIES));
				book.setThreshold(rs.getInt(DBSchema.THRESHOLD));

				order.book = book;
				order.copies = rs.getInt("order_copies");
				order.isAccepted = rs.getBoolean("Accepted");
				order.ISBN = book.getISBN();
				order.title = book.getTitle();
				order.pub_name = book.getPubName();
				order.price = book.getPrice();
				order.category = book.getCategory();

				collec.add(order);
			}

			// Clean-up environment
			rs.close();
			stmt.close();
			return collec;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		}
		return null;

	}

}
