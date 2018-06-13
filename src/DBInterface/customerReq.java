package DBInterface;

import java.sql.Connection;
import java.sql.SQLException;

import application.CurrentState;
import application.DBconnection;
import data.Book;

public class customerReq extends databaseReq {

	public static String changeUsername(String newName) {
		return null;
	}

	public static String changefName(String newName) {
		return null;
	}

	public static String changelName(String newName) {
		return null;
	}

	public static String changeEmail(String email) {
		return null;
	}

	public static String changePhone(String phone) {
		return null;
	}

	public static String changeAddress(String address) {
		return null;
	}

	public static String checkOut() {

		Connection conn = DBconnection.getConnection();
		try {
			conn.setAutoCommit(false); // start transaction
			String query = "";
			for (Book b : CurrentState.ShoppingCart) {
				query = "UPDATE BOOK SET Copies  = Copies - 1 where ISBN = '" + b.getISBN() + "'";
			}
			conn.commit(); // end transaction
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				conn.rollback(); // roll back
				return e.getMessage();
			} catch (SQLException e1) {
				e.printStackTrace();
				e1.printStackTrace();
				return e1.getMessage();
			}
		}

		return null;
	}

}
