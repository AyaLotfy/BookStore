package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.omg.CORBA.Current;

import data.DBSchema;
import data.User;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;

import DBInterface.*;
import UI.UIControl;

//import jdk.nashorn.internal.ir.Statement;
/*
 //package application;
//
//public class Main  {
//
//	public static void main(String[] args) {
//		Controller c = new Controller(args);
//		c.startApplication();
//	}
//}
package application;

import java.sql.*;

public class Main {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://localhost:8889/library?autoReconnect=true&useSSL=false";
	static final String DB_URL = "jdbc:mysql://localhost:3306/project2?autoReconnect=true&useSSL=false";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "tiger";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM Library_User";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("User_Id");
				String TITLE = rs.getString("Username");
			//	String PUBLISHER_NAME = rs.getString("PUBLISHER_NAME");

				// Display values
				System.out.print("ID: " + id);
				System.out.println(", username: " + TITLE);
			//	System.out.println(", PUBLISHER_NAME: " + PUBLISHER_NAME);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main

}
 */

/**
 *
 * @author Phil
 */
public class MainFrameController implements Initializable {

	@FXML
	private Label label;

	@FXML
	private Label invalid_label;

	@FXML
	private TextField username_box;

	@FXML
	private TextField password_box;

	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {

		System.out.println("Sign up");

		UIControl.changeLayout(event, getClass().getResource("SignUpFrame.fxml"));

	}

	@FXML
	private void handleButtonActionLogIn(ActionEvent event) throws IOException {

		System.out.println("Log in");

		String name = username_box.getText();
		String pass = password_box.getText();

		User res = logging.logUser(name, pass);

		if (res == null) {
			System.out.println("user " + name + " pass " + pass + " not found");
			userNotFoundAlert();
		} else {
			CurrentState.user_id = res.getId();
			CurrentState.user_name = res.getName();
			
			if (res.Is_manager() == 1) {
				CurrentState.is_manager = true;
				//UIControl.changeLayout(event, getClass().getResource("ManagerFrame.fxml"));	
					FXMLLoader Loader = new FXMLLoader();
					Loader.setLocation(getClass().getResource("ManagerFrame.fxml"));

					try {
						Loader.load();
					} catch (Exception e) {
						// TODO: handle exception
//						Loader.getL
					}
					ManagerFrameController display = Loader.getController();
					display.setText(name);
					Parent p = Loader.getRoot();
					Stage stage = new Stage();
					stage.setScene(new Scene(p));
					stage.showAndWait();
					
				//	home_page_parent = FXMLLoader.load(getClass().getResource("ManagerFrame.fxml"));

			} else {
				CurrentState.ShoppingCart = FXCollections.observableArrayList();
				CurrentState.is_manager = false;
				UIControl.changeLayout(event, getClass().getResource("UserFrame.fxml"));	
			}
		}

	}

	private void userNotFoundAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("User not found, Please try again");

		alert.showAndWait();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

}