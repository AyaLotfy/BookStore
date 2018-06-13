package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DBInterface.databaseReq;
import DBInterface.managerReq;
import UI.UIControl;
import data.Book;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SearchBookController implements Initializable {

	@FXML
	private TextField title;

	@FXML
	private TextField author;

	@FXML
	private ComboBox<String> pub;

	@FXML
	private ComboBox<String> cat;

	@FXML
	private RadioButton titleB;

	@FXML
	private RadioButton AuthorB;

	@FXML
	private RadioButton CatB;

	@FXML
	private RadioButton PubB;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cat.getItems().addAll(databaseReq.getCategories());
		pub.getItems().addAll(databaseReq.getPublishers());
	}
	@FXML
	private void handleBack(ActionEvent event) throws IOException {
		if(CurrentState.is_manager) {
			UIControl.changeLayout(event, getClass().getResource("ManagerFrame.fxml"));			
		} else {
			UIControl.changeLayout(event, getClass().getResource("UserFrame.fxml"));						
		}
	}

	
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {

		System.out.println("search for book");
		
		if (titleB.isSelected()) {
			databaseReq.SearchByISBNORTitle(title.getText());
		}
		if (AuthorB.isSelected()) {
			databaseReq.SearchByAuthor(author.getText());
		}
		if (CatB.isSelected()) {
			databaseReq.SearchByCategory(cat.getValue());
		}
		if (PubB.isSelected()) {
			databaseReq.SearchByPublisher(pub.getValue());
		}

		UIControl.newLayout(event, getClass().getResource("SearchResult.fxml"));	
	}

	@FXML
	private void handleActiveTitle(ActionEvent event) throws IOException {
		title.setDisable(false);
		author.setDisable(true);
		cat.setDisable(true);
		pub.setDisable(true);
	}
	
	@FXML
	private void handleActiveAuthor(ActionEvent event) throws IOException {
		title.setDisable(true);
		author.setDisable(false);
		cat.setDisable(true);
		pub.setDisable(true);
	}
	
	@FXML
	private void handleActiveCat(ActionEvent event) throws IOException {
		title.setDisable(true);
		author.setDisable(true);
		cat.setDisable(false);
		pub.setDisable(true);
	}
	
	@FXML
	private void handleActivePub(ActionEvent event) throws IOException {
		title.setDisable(true);
		author.setDisable(true);
		cat.setDisable(true);
		pub.setDisable(false);
	}
	
	private void bookAddedAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText(null);
		alert.setContentText("book is added successfully");
		alert.showAndWait();
	}

}
