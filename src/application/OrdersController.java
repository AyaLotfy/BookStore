//package application;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//import UI.UIControl;
//import data.bookOrder;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.text.Text;
//
//public class OrdersController implements Initializable {
//	@FXML
//	private Text text11;
//	@FXML
//	private Text text12;
//	@FXML
//	private Text text13;
//	@FXML
//	private Text text14;
//	@FXML
//	private Text text15;
//	@FXML
//	private Text text16;
//	@FXML
//	private Text text17;
//
//	@FXML
//	private Text text21;
//	@FXML
//	private Text text22;
//	@FXML
//	private Text text23;
//	@FXML
//	private Text text24;
//	@FXML
//	private Text text25;
//	@FXML
//	private Text text26;
//	@FXML
//	private Text text27;
//
//	@FXML
//	private Text text31;
//	@FXML
//	private Text text32;
//	@FXML
//	private Text text33;
//	@FXML
//	private Text text34;
//	@FXML
//	private Text text35;
//	@FXML
//	private Text text36;
//	@FXML
//	private Text text37;
//
//	@FXML
//	private Text text41;
//	@FXML
//	private Text text42;
//	@FXML
//	private Text text43;
//	@FXML
//	private Text text44;
//	@FXML
//	private Text text45;
//	@FXML
//	private Text text46;
//	@FXML
//	private Text text47;
//
//	@FXML
//	private Text text51;
//	@FXML
//	private Text text52;
//	@FXML
//	private Text text53;
//	@FXML
//	private Text text54;
//	@FXML
//	private Text text55;
//	@FXML
//	private Text text56;
//	@FXML
//	private Text text57;
//
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@FXML
//	private void cancelAction(ActionEvent event) throws IOException {
//		UIControl.changeLayout(event, getClass().getResource("ManagerFrame.fxml"));
//
//	}
//
//	@FXML
//	private void conf1(ActionEvent event) throws IOException {
//		new bookOrder().confirmOrder(text11.getText());
//
//	}
//
//	@FXML
//	private void conf2(ActionEvent event) throws IOException {
//		new bookOrder().confirmOrder(text21.getText());
//
//	}
//
//	@FXML
//	private void del1(ActionEvent event) throws IOException {
//		new bookOrder().deleteOrder(text11.getText());
//
//	}
//
//	@FXML
//	private void del2(ActionEvent event) throws IOException {
//		new bookOrder().deleteOrder(text21.getText());
//
//	}
//
//}
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DBInterface.databaseReq;
import DBInterface.managerReq;
import UI.UIControl;
import data.Book;
import data.bookOrder;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class OrdersController implements Initializable {
	@FXML
	private TableView<bookOrder> table;

	@FXML
	private TableColumn<bookOrder, String> title;

	@FXML
	private TableColumn<bookOrder, String> ISBN;

	@FXML
	private TableColumn<bookOrder, String> pub;

	@FXML
	private TableColumn<bookOrder, Double> price;

	@FXML
	private TableColumn<bookOrder, String> cat;

	@FXML
	private TableColumn<bookOrder, Integer> copies;

	@FXML
	private TableColumn<bookOrder, Boolean> status;
	
	@FXML
	private TableColumn<bookOrder, String> confirm;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		title.setCellValueFactory(new PropertyValueFactory<bookOrder, String>("title"));
		ISBN.setCellValueFactory(new PropertyValueFactory<bookOrder, String>("ISBN"));
		pub.setCellValueFactory(new PropertyValueFactory<bookOrder, String>("pub_name"));
		price.setCellValueFactory(new PropertyValueFactory<bookOrder, Double>("price"));
		cat.setCellValueFactory(new PropertyValueFactory<bookOrder, String>("category"));
		copies.setCellValueFactory(new PropertyValueFactory<bookOrder, Integer>("copies"));
		status.setCellValueFactory(new PropertyValueFactory<bookOrder, Boolean>("isAccepted"));
				
		addConfirmButton();

		table.setItems(managerReq.getOrders());

	}
	
	public void addConfirmButton() {
		confirm.setSortable(false);

		confirm.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

		Callback<TableColumn<bookOrder, String>, TableCell<bookOrder, String>> cellFactory = new Callback<TableColumn<bookOrder, String>, TableCell<bookOrder, String>>() {
			@Override
			public TableCell call(final TableColumn<bookOrder, String> param) {
				final TableCell<bookOrder, String> cell = new TableCell<bookOrder, String>() {

					final Button btn = new Button("Add to Cart");

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {
							btn.setOnAction(event -> {
								bookOrder order = getTableView().getItems().get(getIndex());
								String res = managerReq.confirmOrder(order);
								if (res == null) {
									table.getItems().removeAll();
									table.setItems(managerReq.getOrders());
								} else {
									errorAlert(res);
								}
							});
							setGraphic(btn);
							setText(null);
						}
					}
				};
				return cell;
			}
		};

		confirm.setCellFactory(cellFactory);
	}


	private void errorAlert(String m) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(m);
		alert.showAndWait();
	}
	
	@FXML
	private void cancelAction(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("ManagerFrame.fxml"));
	}

}
