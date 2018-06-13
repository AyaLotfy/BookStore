package application;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import DBInterface.databaseReq;
import DBInterface.managerReq;
import UI.UIControl;
import data.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AddBookController implements Initializable {

	@FXML
	private TextField isbn;

	@FXML
	private TextField title;

	@FXML
	private ComboBox<String> pub_ID;

	@FXML
	private TextField pub_year;

	@FXML
	private TextField Price;

	@FXML
	private ComboBox<String> cat_ID;

	@FXML
	private TextField copies;

	@FXML
	private TextField threshold;

	@FXML
	private TextField author;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cat_ID.getItems().addAll(databaseReq.getCategories());
		pub_ID.getItems().addAll(databaseReq.getPublishers());
	}

	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {

		System.out.println("Add new book");

		Book book = new Book();
		book.setISBN(isbn.getText());
		book.setCopies(copies.getText());
		book.setPrice(Price.getText());
		book.setPub_year(pub_year.getText());
		book.setPubName(pub_ID.getValue());
		book.setCategory(cat_ID.getValue());
		book.setTitle(title.getText());
		book.setThreshold(threshold.getText());
		book.setAuthor(author.getText());
		
		String res = managerReq.addNewBook(book);
		if(res == null ) {
			bookAddedAlert();
			UIControl.changeLayout(event, getClass().getResource("ManagerFrame.fxml"));
		} else {
			errorAlert(res);
		}
	}

	private void bookAddedAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText(null);
		alert.setContentText("book is added successfully");
		alert.showAndWait();
	}
	
	private void errorAlert(String m) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(m);
		alert.showAndWait();
	}
	
	@FXML
	private void addNewPublisher(ActionEvent event) throws IOException {
//		Parent home_page_parent = FXMLLoader.load( getClass().getResource("AddPublisher.fxml"));
//		Scene home_page_scene = new Scene(home_page_parent);
//		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		app_stage.setScene(home_page_scene);
//		app_stage.show();
		

		UIControl.newLayout(event, getClass().getResource("AddPublisher.fxml"));

	}
	
	@FXML
	private void cancelAction(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("ManagerFrame.fxml"));

	}

}