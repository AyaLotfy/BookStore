package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import UI.UIControl;
import data.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class ShoppingCartController implements Initializable {

	@FXML
	private Label totalPrice;

	@FXML
	private TableView<Book> table;

	@FXML
	private TableColumn<Book, String> title;

	@FXML
	private TableColumn<Book, String> ISBN;

	@FXML
	private TableColumn<Book, String> pub;

	@FXML
	private TableColumn<Book, String> author;

	@FXML
	private TableColumn<Book, String> year;

	@FXML
	private TableColumn<Book, Double> price;

	@FXML
	private TableColumn<Book, String> cat;

	@FXML
	private TableColumn<Book, Integer> copies;

	@FXML
	private TableColumn<Book, String> delete;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		title.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		ISBN.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
		pub.setCellValueFactory(new PropertyValueFactory<Book, String>("pub_name"));
		year.setCellValueFactory(new PropertyValueFactory<Book, String>("pub_year"));
		price.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));
		cat.setCellValueFactory(new PropertyValueFactory<Book, String>("category"));
		copies.setCellValueFactory(new PropertyValueFactory<Book, Integer>("copies"));
		author.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));

		calcTotalPrice();

		addDeleteButton();

		table.setItems(CurrentState.ShoppingCart);
	}

	private void addDeleteButton() {
		delete.setSortable(false);

		delete.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

		Callback<TableColumn<Book, String>, TableCell<Book, String>> cellFactory = new Callback<TableColumn<Book, String>, TableCell<Book, String>>() {
			@Override
			public TableCell call(final TableColumn<Book, String> param) {
				final TableCell<Book, String> cell = new TableCell<Book, String>() {

					final Button btn = new Button("Delete");

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {
							btn.setOnAction(event -> {
								Book book = getTableView().getItems().get(getIndex());
								CurrentState.ShoppingCart.remove(book);
								bookDeletedAlert();
								calcTotalPrice();
							});
							setGraphic(btn);
							setText(null);
						}
					}
				};
				return cell;
			}
		};

		delete.setCellFactory(cellFactory);
	}

	private void calcTotalPrice() {
		Double sum = 0.0;
		for (Book b : CurrentState.ShoppingCart) {
			sum += b.getPrice();
		}
		totalPrice.setText(String.valueOf(sum));
	}

	private void bookDeletedAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText(null);
		alert.setContentText("Book is deleted successfully");
		alert.showAndWait();
	}
	
	@FXML
	private void handleBack(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("UserFrame.fxml"));
	}

}
