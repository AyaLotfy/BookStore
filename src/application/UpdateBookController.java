//
//
//
//
//package application;
//
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.time.Year;
//import java.util.ResourceBundle;
//
//import DBInterface.registeration;
//import data.customer;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.control.Alert.AlertType;
//import javafx.stage.Stage;
////import jdk.nashorn.internal.ir.Statement;
//
///**
// *
// * @author Phil
// */
//public class UpdateBookController implements Initializable {
//
//	@FXML
//	private TextField isbn;
//
//	@FXML
//	private TextField title;
//
//	@FXML
//	private ComboBox<String> Pub_ID;
//
//	@FXML
//	private TextField Pub_year;
//
//	@FXML
//	private TextField Price;
//
//	@FXML
//	private ComboBox<String> cat_ID;
//
//	@FXML
//	private TextField copies;
//
//	@FXML
//	private TextField threshold;
//
//	@FXML
//	private TextField author;
//
//
//
//	@FXML
//	private void updateBookAction(ActionEvent event) throws IOException {
//
//		System.out.println("update book");
//		
//		String[] attributes = new String[] {
//				isbn.getText(), title.getText(),
//				 "", Pub_year.getText(),
//				Price.getText(), cat_ID,
//				copies.getText(), threshold.getText()
//		};
//		
//		
//		String res = registeration.updateCustomer("admin", attributes);
//
//		if (res == null) {
//			Parent home_page_parent = FXMLLoader.load(getClass().getResource("UserFrame.fxml"));
//			Scene home_page_scene = new Scene(home_page_parent);
//			Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//			app_stage.hide(); // optional
//			app_stage.setScene(home_page_scene);
//
//			app_stage.show();
//		} else {
//			userAlreadyExistAlert();
//			System.out.println(res);
//		}
//
//	}
//	
//	private void userAlreadyExistAlert() {
//		Alert alert = new Alert(AlertType.INFORMATION);
//		alert.setTitle("Error");
//		alert.setHeaderText(null);
//		alert.setContentText("User already exist");
//
//		alert.showAndWait();
//	}
////	@FXML
////	private void handleLogInAction(ActionEvent event) throws IOException {
////		Parent home_page_parent = FXMLLoader.load(getClass().getResource("MainFrame.fxml"));
////		Scene home_page_scene = new Scene(home_page_parent);
////		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
////		app_stage.hide(); // optional
////		app_stage.setScene(home_page_scene);
////
////		app_stage.show();
////	}
//	
//	// private boolean isValidCredentials()
//	// {
//	// boolean let_in = false;
//	// System.out.println( "SELECT * FROM Users WHERE USERNAME= " + "'" +
//	// username_box.getText() + "'"
//	// + " AND PASSWORD= " + "'" + password_box.getText() + "'" );
//	//
//	// Connection c = null;
//	// java.sql.Statement stmt = null;
//	// try {
//	// c = DriverManager.getConnection("jdbc:sqlite:first.db");
//	// c.setAutoCommit(false);
//	//
//	// System.out.println("Opened database successfully");
//	// stmt = c.createStatement();
//	//
//	// ResultSet rs = stmt.executeQuery( "SELECT * FROM Users WHERE USERNAME= " +
//	// "'" + username_box.getText() + "'"
//	// + " AND PASSWORD= " + "'" + password_box.getText() + "'");
//	//
//	// while ( rs.next() ) {
//	// if (rs.getString("USERNAME") != null && rs.getString("PASSWORD") != null) {
//	// String username = rs.getString("USERNAME");
//	// System.out.println( "USERNAME = " + username );
//	// String password = rs.getString("PASSWORD");
//	// System.out.println("PASSWORD = " + password);
//	// let_in = true;
//	// }
//	// }
//	// rs.close();
//	// stmt.close();
//	// c.close();
//	// } catch ( Exception e ) {
//	// System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//	// System.exit(0);
//	// }
//	// System.out.println("isValidCredentials operation done successfully");
//	// return let_in;
//	//
//	// }
//
//	@Override
//	public void initialize(URL url, ResourceBundle rb) {
//		// TODO
//	}
//
//}