package application;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import DBInterface.databaseReq;
import DBInterface.managerReq;
import data.Book;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class SearchResultController implements Initializable {

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
	private TableColumn<Book, Integer> threshold;

	@FXML
	private TableColumn<Book, String> action;

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
		threshold.setCellValueFactory(new PropertyValueFactory<Book, Integer>("threshold"));

		if (CurrentState.is_manager) {
			// edit button
			modifyButton();
		} else {
			// addtocart button
			addToCartButton();
		}

		table.setItems(databaseReq.getResult());
	}

	public void addToCartButton() {
		action.setSortable(false);

		action.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

		Callback<TableColumn<Book, String>, TableCell<Book, String>> cellFactory = new Callback<TableColumn<Book, String>, TableCell<Book, String>>() {
			@Override
			public TableCell call(final TableColumn<Book, String> param) {
				final TableCell<Book, String> cell = new TableCell<Book, String>() {

					final Button btn = new Button("Add to Cart");

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {
							btn.setOnAction(event -> {
								Book book = getTableView().getItems().get(getIndex());
								addToCart(book);
							});
							setGraphic(btn);
							setText(null);
						}
					}
				};
				return cell;
			}
		};

		action.setCellFactory(cellFactory);
	}

	public void modifyButton() {
		action.setSortable(false);

		action.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

		Callback<TableColumn<Book, String>, TableCell<Book, String>> cellFactory = new Callback<TableColumn<Book, String>, TableCell<Book, String>>() {
			@Override
			public TableCell call(final TableColumn<Book, String> param) {
				final TableCell<Book, String> cell = new TableCell<Book, String>() {

					final Button btn = new Button("Modify");

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {
							btn.setOnAction(event -> {
								Book book = getTableView().getItems().get(getIndex());
								editBook(book);
							});
							setGraphic(btn);
							setText(null);
						}
					}
				};
				return cell;
			}
		};

		action.setCellFactory(cellFactory);
	}

	public void editBook(Book book) {
		System.out.println("edit book");

		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Editing Quantity");
		dialog.setContentText("New Quantity : ");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			String res = managerReq.editQuantity(book, result.get());
			if (res == null) {
				book.setCopies(result.get());
				table.getItems().removeAll();
				table.setItems(databaseReq.getResult());
			} else {
				errorAlert(res);
			}
		}

	}

	private void errorAlert(String m) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(m);
		alert.showAndWait();
	}

	public void addToCart(Book book) {
		CurrentState.ShoppingCart.add(book);
		bookAddedAlert();
	}

	private void bookAddedAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText(null);
		alert.setContentText("Book is added successfully");
		alert.showAndWait();
	}
	

	@FXML
	private void handleNextAction(ActionEvent event) throws IOException {
		ObservableList<Book> res = databaseReq.getNext();
		if(res != null && res.size() > 0) {
			table.setItems(databaseReq.getResult());	
		}
	}
	

	@FXML
	private void handlePrevAction(ActionEvent event) throws IOException {
		ObservableList<Book> res = databaseReq.getPrev();
		if(res != null && res.size() > 0) {
			table.setItems(databaseReq.getResult());	
		}
	}
}
