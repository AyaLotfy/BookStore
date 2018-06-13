package DBInterface;

import java.io.FileOutputStream;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.DBconnection;
import data.DBSchema;
import data.ITable;
import data.Table;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.exception.DRException;

public class DBAccess {
	private Connection myConnection;
	private Statement myStatement;

	public String updateBook(String ISBN, String[] bookAttributes, String[] authors) {
		// Constructing query
		String query = "SELECT " + DBSchema.CATEGORY_ID + " FROM " + DBSchema.CATEGORY + " WHERE "
				+ DBSchema.CATEGORY_NAME + " = '" + bookAttributes[5] + "'";
		try {
			myConnection.setAutoCommit(true);
			ResultSet set = myStatement.executeQuery(query);

			if (set.next()) {
				String categoryId = set.getString(DBSchema.CATEGORY_ID);

				query = "UPDATE " + DBSchema.BOOK + " SET " + DBSchema.ISBN + " = '" + bookAttributes[0] + "', "
						+ DBSchema.TITLE + " = '" + bookAttributes[1] + "', " + DBSchema.PUB_NAME + " = '"
						+ bookAttributes[2] + "', " + DBSchema.YEAR + " = '" + bookAttributes[3] + "', "
						+ DBSchema.PRICE + " = " + bookAttributes[4] + ", " + DBSchema.CATEGORY_ID + " = " + categoryId
						+ ", " + DBSchema.COPIES + " = " + bookAttributes[6] + ", " + DBSchema.THRESHOLD + " = "
						+ bookAttributes[7] + " WHERE " + DBSchema.ISBN + " = '" + ISBN + "'";

				int affectedRows = myStatement.executeUpdate(query);
				if (affectedRows != 1) {

				}
				query = "DELETE FROM " + DBSchema.BOOK_AUTHORS + " WHERE " + DBSchema.ISBN + " = '" + ISBN + "'";
				myStatement.execute(query);
				for (int i = 0; i < authors.length; i++) {
					query = "INSERT INTO " + DBSchema.BOOK_AUTHORS + " VALUES ( '" + bookAttributes[0] + "', '"
							+ authors[i] + "' )";
					myStatement.execute(query);
				}

			} else {
			}
		} catch (Exception ex) {

		}

		return null;
	}

	public ITable getTotalSales() {

		// String query = "select User_Id, ISBN ,Copies, Sell_Date,Price from Sales";

		String query = "SELECT S." + DBSchema.ISBN + "," + DBSchema.TITLE + "," + DBSchema.PUB_NAME + ", year("
				+ DBSchema.YEAR + "),B." + DBSchema.PRICE + "," + DBSchema.CATEGORY_NAME + ",B." + DBSchema.COPIES + ","
				+ DBSchema.THRESHOLD + ", SUM(S." + DBSchema.PRICE + ")" + " FROM " + DBSchema.BOOK + " AS B,"
				+ DBSchema.CATEGORY + " AS C," + DBSchema.SALES + " AS S " +

				"WHERE B." + DBSchema.ISBN + " = S." + DBSchema.ISBN + " AND B." + DBSchema.CATEGORY_ID + " = C."
				+ DBSchema.CATEGORY_ID + " AND S." + DBSchema.SELL_DATE + " <= CURDATE() " + " GROUP BY S."
				+ DBSchema.ISBN + " ORDER BY SUM(S." + DBSchema.PRICE + ") DESC";
		// Executing query
		ITable table = new Table();

		try {

			myConnection =  DBconnection.getConnection();
			JasperReportBuilder report = DynamicReports.report();
			report.columns(
					Columns.column("book Id", DBSchema.ISBN,
							DataTypes.stringType()),
					Columns.column("Title", DBSchema.TITLE,
							DataTypes.stringType()),
					Columns.column("Publisher", DBSchema.PUB_NAME,
							DataTypes.stringType()),
					Columns.column("year", "year(Pub_Year)",
							DataTypes.stringType()),
					Columns.column("Price", DBSchema.PRICE,
							DataTypes.doubleType()).setHorizontalTextAlignment(
							HorizontalTextAlignment.LEFT),
					Columns.column("Category", "Cat_Name",
							DataTypes.stringType()),
					Columns.column("Copies", DBSchema.COPIES,
							DataTypes.integerType())
							.setHorizontalTextAlignment(
									HorizontalTextAlignment.LEFT))
			// missing the total
					.title(// title of the report
					Components.text("\t\t\t\t\t\t total sales\n"))
					// .setHorizontalAlignment(HorizontalAlignment.CENTER))
					.setDataSource(query, myConnection);

			FileOutputStream file = new FileOutputStream("total sales.pdf");
			try {
				// show the report
				// report.show();

				// export the report to a pdf file
				report.toPdf(file);
				file.close();
			} catch (DRException e) {
				e.printStackTrace();
			}
			
			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet set = stmt.executeQuery(query);

			
			String[] attrs = { DBSchema.USER_ID, DBSchema.ISBN, DBSchema.COPIES, DBSchema.SELL_DATE, DBSchema.PRICE };

			List<String[]> data = new ArrayList<String[]>();

			while (set.next()) {
				List<String> tuple = new ArrayList<String>();
				for (int i = 0; i < attrs.length; i++) {
					tuple.add(set.getString(i + 1));
					// System.out.println(set.getString(i + 1) + "totSales");
				}
				String[] tempTuple = new String[tuple.size()];
				tempTuple = tuple.toArray(tempTuple);
				data.add(tempTuple);
			}

			String[][] tableData = new String[data.size()][];
			tableData = data.toArray(tableData);

			table.setAttributes(attrs);
			table.setData(tableData);
			System.out.println("user added");
		} catch (Exception ex) {
			return null;
		}

		return table;
	}

	public ITable getTopCustomers() {

		String query = "SELECT " + DBSchema.FIRST_NAME + "," + DBSchema.LAST_NAME + ",U." + DBSchema.USER_NAME + ","
				+ DBSchema.EMAIL + "," + DBSchema.PHONE + "," + DBSchema.ADDRESS + ", SUM(S." + DBSchema.PRICE
				+ ") FROM " + DBSchema.SALES + " AS S, " + DBSchema.USER + " AS U WHERE S." + DBSchema.USER_ID + " = U."
				+ DBSchema.USER_ID + " AND S." + DBSchema.SELL_DATE + " <= CURDATE() " + " GROUP BY U."
				+ DBSchema.USER_ID + " ORDER BY SUM(S." + DBSchema.PRICE + ") DESC LIMIT 5";

		// insert into Sales values ('1','admin','1',5,'2018-09-09',20);
		// insert into Sales values ('2','admin2','1',5,'2018-5-12',20);
		// insert into Sales values ('3','admin3','1',5,'2018-5-12',20);
		// insert into Sales values ('1','admin','2',5,'2018-5-12',20);
		// insert into Sales values ('1','admin','3',5,'2018-5-12',20);
		// insert into Sales values ('2','admin2','2',5,'2018-5-12',20);
		// insert into Sales values ('2','admin2','3',5,'2018-5-12',20);
		// insert into Sales values ('3','admin3','2',5,'2018-5-12',20);
		// insert into Sales values ('3','admin3','3',5,'2018-5-12',20);

		// insert into Sales values ('1' ,'1',5,'2018-09-09',20);
		// insert into Sales values ('2' ,'1',5,'2018-5-12',20);
		// insert into Sales values ('3' ,'1',5,'2018-5-12',20);
		// insert into Sales values ('1' ,'2',5,'2018-5-12',20);
		// insert into Sales values ('1' ,'3',5,'2018-5-12',20);
		// insert into Sales values ('2' ,'2',5,'2018-5-12',20);
		// insert into Sales values ('2' ,'3',5,'2018-5-12',20);
		// insert into Sales values ('3' ,'2',5,'2018-5-12',20);
		// insert into Sales values ('3' ,'3',5,'2018-5-12',20);

		System.out.println(query);

		// Executing query
		ITable table = new Table();
		try {
			// myConnection.setAutoCommit(true);
			myConnection = DBconnection.getConnection();
			JasperReportBuilder report = DynamicReports.report();
			report.columns(Columns.column("First Name", DBSchema.FIRST_NAME, DataTypes.stringType())
			// );
					, Columns.column("Last Name", DBSchema.LAST_NAME, DataTypes.stringType()),
					Columns.column("User Name", DBSchema.USER_NAME, DataTypes.stringType()),
					Columns.column("E-mail", DBSchema.EMAIL, DataTypes.stringType()),
					Columns.column("Phone ", DBSchema.PHONE, DataTypes.stringType()),
					Columns.column("Address", DBSchema.ADDRESS, DataTypes.stringType()),
					Columns.column("Total prices", "SUM(S." + DBSchema.PRICE + ")", DataTypes.integerType())
							.setHorizontalTextAlignment(HorizontalTextAlignment.LEFT))
					// missing the total
					.title(// title of the report
							Components.text("\t\t\t\t\t Top Customers\n"))
					.setDataSource(query, myConnection);

			FileOutputStream file = new FileOutputStream("top five customers.pdf");
			try {
				// show the report
				// report.show();

				// export the report to a pdf file
				report.toPdf(file);
				file.close();
			} catch (DRException e) {
				e.printStackTrace();
			}
			Statement stmt = DBconnection.getConnection().createStatement();

			ResultSet set = stmt.executeQuery(query);

			String[] attrs = { DBSchema.FIRST_NAME, DBSchema.LAST_NAME, DBSchema.USER, DBSchema.EMAIL, DBSchema.PHONE,
					DBSchema.ADDRESS, " sales" };

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

	public ITable getTopBooks() {

		String query = "SELECT S." + DBSchema.ISBN + "," + DBSchema.TITLE + "," + DBSchema.PUB_NAME + ", year("
				+ DBSchema.YEAR + "),B." + DBSchema.PRICE + "," + DBSchema.CATEGORY_NAME + ",B." + DBSchema.COPIES
				+ " FROM " + DBSchema.SALES + " AS S, " + DBSchema.BOOK + " AS B, " + DBSchema.CATEGORY + " AS C, "
				+ DBSchema.PUBLISHER + " AS P " + "WHERE B." + DBSchema.ISBN + " = S." + DBSchema.ISBN + " AND B."
				+ DBSchema.CATEGORY_ID + " = C." + DBSchema.CATEGORY_ID

				+ " AND B." + DBSchema.PUB_ID + " = P." + DBSchema.PUB_ID

				+ " AND S." + DBSchema.SELL_DATE + " <= CURDATE() " + " GROUP BY S." + DBSchema.ISBN + " LIMIT 10";

		System.out.println(query);
		
		// Executing query
		ITable table = new Table();
		try {

			myConnection =  DBconnection.getConnection();
			JasperReportBuilder report = DynamicReports.report();
			report.columns(
					Columns.column("book Id", DBSchema.ISBN,
							DataTypes.stringType()),
					Columns.column("Title", DBSchema.TITLE,
							DataTypes.stringType()),
					Columns.column("Publisher", DBSchema.PUB_NAME,
							DataTypes.stringType()),
					Columns.column("year", "year(Pub_Year)",
							DataTypes.stringType()),
					Columns.column("Price", DBSchema.PRICE,
							DataTypes.doubleType()).setHorizontalTextAlignment(
							HorizontalTextAlignment.LEFT),
					Columns.column("Category", "Cat_Name",
							DataTypes.stringType()),
					Columns.column("Copies", DBSchema.COPIES,
							DataTypes.integerType())
							.setHorizontalTextAlignment(
									HorizontalTextAlignment.LEFT))
			// missing the total
					.title(// title of the report
					Components.text("\t\t\t\t\t\t Top Books\n"))
					// .setHorizontalAlignment(HorizontalAlignment.CENTER))
					.setDataSource(query, myConnection);

			FileOutputStream file = new FileOutputStream("top books.pdf");
			try {
				// show the report
				// report.show();

				// export the report to a pdf file
				report.toPdf(file);
				file.close();
			} catch (DRException e) {
				e.printStackTrace();
			}
			
			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet set = stmt.executeQuery(query);

			String[] attrs = { DBSchema.ISBN, DBSchema.TITLE, DBSchema.PUB_NAME, DBSchema.YEAR, DBSchema.PRICE,
					DBSchema.CATEGORY_NAME, DBSchema.COPIES };

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

	public static void promoteUser(String userName) {
		String query = "UPDATE " + DBSchema.USER + " SET " + DBSchema.IS_MANAGER + " = True WHERE " + DBSchema.USER_NAME
				+ " = '" + userName + "'";

		try {
			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet set = stmt.executeQuery(query);
		} catch (Exception ex) {

		}

	}

}
