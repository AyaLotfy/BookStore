//package DBInterface;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.LinkedList;
//
//import application.DBconnection;
//import data.Book;
//import data.DBSchema;
//import data.customer;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//
//public class databaseReq {
//
//	Book SearchByISBN(String ISBN) {
//		return null;
//	}
//	private static String lastQuery;
//
//	private static int low, high;
//	
//	private static final int block = 10;
//
//	public static void SearchByISBNORTitle(String ISBN) {
//		lastQuery = "SELECT * FROM BOOK NATURAL JOIN PUBLISHER NATURAL JOIN CATEGORY NATURAL JOIN BOOK_AUTHORS WHERE (TITLE = '" + ISBN + "' OR ISBN = '" + ISBN + "')";
//		low = 0;
//		System.out.println("search query: "+ lastQuery);
//	}
//
//	public static void SearchByCategory(String category) {
//		low = 0;
//		lastQuery = "SELECT * FROM BOOK NATURAL JOIN PUBLISHER NATURAL JOIN CATEGORY NATURAL JOIN BOOK_AUTHORS WHERE CAT_NAME = '" + category + "'";
//	}
//
//	public static void SearchByAuthor(String author) {
//		low = 0;
//		lastQuery += "SELECT * FROM BOOK NATURAL JOIN PUBLISHER NATURAL JOIN CATEGORY NATURAL JOIN BOOK_AUTHORS WHERE AUTHOR_NAME = '" + author + "'";
//	}
//
//	public static void SearchByPublisher(String publisher) {
//		low = 0;
//		lastQuery += "SELECT * FROM BOOK NATURAL JOIN PUBLISHER NATURAL JOIN CATEGORY NATURAL JOIN BOOK_AUTHORS WHERE PUB_NAME = '" + publisher + "'";
//	}
//
//	public static ObservableList<String> getCategories() {
//
//		ObservableList<String> collec = FXCollections.observableArrayList();
//
//		String sql = "SELECT Cat_name from Category";
//
//		try {
//
//			Statement stmt = DBconnection.getConnection().createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//
//			// Extract data from result set
//			while (rs.next()) {
//				String cat = rs.getString("Cat_name");
//				collec.add(cat);
//			}
//
//			// Clean-up environment
//			rs.close();
//			stmt.close();
//			return collec;
//
//		} catch (SQLException se) {
//			// Handle errors for JDBC
//			se.printStackTrace();
//		}
//		return null;
//
//	}
//
//	public static ObservableList<String> getPublishers() {
//		ObservableList<String> collec = FXCollections.observableArrayList();
//
//		String sql = "SELECT Pub_name from Publisher";
//
//		try {
//
//			Statement stmt = DBconnection.getConnection().createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//
//			// Extract data from result set
//			while (rs.next()) {
//				String cat = rs.getString("Pub_name");
//				collec.add(cat);
//			}
//
//			// Clean-up environment
//			rs.close();
//			stmt.close();
//			return collec;
//
//		} catch (SQLException se) {
//			// Handle errors for JDBC
//			se.printStackTrace();
//		}
//		return null;
//
//	}
//	public static ObservableList<Book> getResult() {
//		ObservableList<Book> collec = FXCollections.observableArrayList();
//
//		String query = lastQuery + "ORDER BY BOOK_ID LIMIT " + block;
//		
//		System.out.println("get result query: "+ query);
//
//		try {
//
//			Statement stmt = DBconnection.getConnection().createStatement();
//			ResultSet rs = stmt.executeQuery(query);
//
//			Book book = null;
//			// Extract data from result set
//			while (rs.next()) {
//				book = new Book();
//				book.setID(rs.getInt("BOOK_ID"));
//				book.setISBN(rs.getString(DBSchema.ISBN));
//				book.setTitle(rs.getString(DBSchema.TITLE));
//				book.setPubName(rs.getString(DBSchema.PUB_NAME));
//				book.setPub_year(rs.getString(DBSchema.YEAR));
//				book.setPrice(rs.getDouble(DBSchema.PRICE));
//				book.setCategory(rs.getString(DBSchema.CATEGORY_NAME));
//				book.setCopies(rs.getInt(DBSchema.COPIES));
//				book.setThreshold(rs.getInt(DBSchema.THRESHOLD));
//				book.setAuthor(rs.getString(DBSchema.AUTHOR_NAME));
//				collec.add(book);
//			}
//
//			//high = book.getID();
//			// Clean-up environment
//			rs.close();
//			stmt.close();
//			return collec;
//
//		} catch (SQLException se) {
//			// Handle errors for JDBC
//			se.printStackTrace();
//		}
//		return null;
//
//	}
//
//	public static ObservableList<String> getNext() {
//		return null;
//
//	}
//
//	public static ObservableList<String> getPrev() {
//		return null;
//
//	}
//
//
//}
package DBInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import application.DBconnection;
import data.Book;
import data.DBSchema;
import data.customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class databaseReq {

	Book SearchByISBN(String ISBN) {
		return null;
	}

	private static String lastQuery = "";

	private static int low, high;

	private static final int block = 10;

	public static void SearchByISBNORTitle(String ISBN) {
		lastQuery = "SELECT * FROM BOOK NATURAL JOIN PUBLISHER NATURAL JOIN CATEGORY NATURAL JOIN BOOK_AUTHORS WHERE (TITLE = '"
				+ ISBN + "' OR ISBN = '" + ISBN + "')";
		low = 0;
		System.out.println("search query: " + lastQuery);
	}

	public static void SearchByCategory(String category) {
		low = 0;
		lastQuery = "SELECT * FROM BOOK NATURAL JOIN PUBLISHER NATURAL JOIN CATEGORY NATURAL JOIN BOOK_AUTHORS WHERE CAT_NAME = '"
				+ category + "'";
	}

	public static void SearchByAuthor(String author) {
		low = 0;
		lastQuery = "SELECT * FROM BOOK NATURAL JOIN PUBLISHER NATURAL JOIN CATEGORY NATURAL JOIN BOOK_AUTHORS WHERE AUTHOR_NAME = '"
				+ author + "'";
	}

	public static void SearchByPublisher(String publisher) {
		low = 0;
		lastQuery = "SELECT * FROM BOOK NATURAL JOIN PUBLISHER NATURAL JOIN CATEGORY NATURAL JOIN BOOK_AUTHORS WHERE PUB_NAME = '"
				+ publisher + "'";
	}

	public static ObservableList<String> getCategories() {

		ObservableList<String> collec = FXCollections.observableArrayList();

		String sql = "SELECT Cat_name from Category";

		try {

			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
			while (rs.next()) {
				String cat = rs.getString("Cat_name");
				collec.add(cat);
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

	public static ObservableList<String> getPublishers() {
		ObservableList<String> collec = FXCollections.observableArrayList();

		String sql = "SELECT Pub_name from Publisher";

		try {

			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
			while (rs.next()) {
				String cat = rs.getString("Pub_name");
				collec.add(cat);
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

	public static ObservableList<Book> getResult() {
		ObservableList<Book> collec = FXCollections.observableArrayList();

		String query = lastQuery + "ORDER BY BOOK_ID LIMIT " + block;

		System.out.println("get result query: " + query);

		try {

			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);

			Book book = new Book();
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
				book.setAuthor(rs.getString(DBSchema.AUTHOR_NAME));
				collec.add(book);
			}

			high = book.getID();
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

	public static ObservableList<Book> getNext() {
		String query = lastQuery + " AND BOOK_ID > " + high + "ORDER BY BOOK_ID ASC LIMIT " + block;
		ObservableList<Book> collec = execute(query);
		low = high;
		high = collec.get(collec.size() - 1).getID();
		return collec;
	}

	public static ObservableList<Book> getPrev() {
		String query = lastQuery + " AND BOOK_ID < " + low + "ORDER BY BOOK_ID DESC LIMIT " + block;
		ObservableList<Book> collec = execute(query);
		high = low;
		low  = collec.get(collec.size() - 1).getID();
		return collec;
	}

	public static ObservableList<Book> execute(String query) {

		ObservableList<Book> collec = FXCollections.observableArrayList();

		System.out.println("get result query: " + query);

		try {

			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);

			Book book = new Book();
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
				book.setAuthor(rs.getString(DBSchema.AUTHOR_NAME));
				collec.add(book);
			}

			high = book.getID();
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
