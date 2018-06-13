









package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.DBSchema;
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


public class AddPublisherController implements Initializable {

	@FXML
	private Label label;

	@FXML
	private Label invalid_label;

	@FXML
	private TextField pub_box;

	@FXML
	private TextField address_box;

	@FXML
	private TextField phone_box;


	@FXML
	private void handleButtonActionConfirmAddPublisher(ActionEvent event) throws IOException {

		System.out.println("addpublisher");

		String name = pub_box.getText();
		String address = address_box.getText();
		String phone = phone_box.getText();

		Parent home_page_parent = null;

		String res = AddPublisher.publisher(name, address,phone);

//		if (res == null) {
//			System.out.println("publisher " + name + " found");
//			userNotFoundAlert();
//		} else {
////			if (res == "manager") {
////				home_page_parent = FXMLLoader.load(getClass().getResource("ManagerFrame.fxml"));
////			} else {
////				//user view
////			}
//	home_page_parent = FXMLLoader.load(getClass().getResource("AddPublisher.fxml"));
//
//			Scene home_page_scene = new Scene(home_page_parent);
//			Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		
//			app_stage.hide(); // optional
//			app_stage.setScene(home_page_scene);
//			app_stage.show();
//		}
		if (res == null) {
			System.out.println("publisher " + name + " is added");
			UIControl.changeLayout(event, getClass().getResource("ManagerFrame.fxml"));
		} else {
			userNotFoundAlert();
		}

	}


	
	
	private void userNotFoundAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("User not found, Please try again");

		alert.showAndWait();
	}

	// private boolean isValidCredentials()
	// {
	// boolean let_in = false;
	// System.out.println( "SELECT * FROM Users WHERE USERNAME= " + "'" +
	// username_box.getText() + "'"
	// + " AND PASSWORD= " + "'" + password_box.getText() + "'" );
	//
	// Connection c = null;
	// java.sql.Statement stmt = null;
	// try {
	// c = DriverManager.getConnection("jdbc:sqlite:first.db");
	// c.setAutoCommit(false);
	//
	// System.out.println("Opened database successfully");
	// stmt = c.createStatement();
	//
	// ResultSet rs = stmt.executeQuery( "SELECT * FROM Users WHERE USERNAME= " +
	// "'" + username_box.getText() + "'"
	// + " AND PASSWORD= " + "'" + password_box.getText() + "'");
	//
	// while ( rs.next() ) {
	// if (rs.getString("USERNAME") != null && rs.getString("PASSWORD") != null) {
	// String username = rs.getString("USERNAME");
	// System.out.println( "USERNAME = " + username );
	// String password = rs.getString("PASSWORD");
	// System.out.println("PASSWORD = " + password);
	// let_in = true;
	// }
	// }
	// rs.close();
	// stmt.close();
	// c.close();
	// } catch ( Exception e ) {
	// System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	// System.exit(0);
	// }
	// System.out.println("isValidCredentials operation done successfully");
	// return let_in;
	//
	// }

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

}









