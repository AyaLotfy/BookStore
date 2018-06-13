package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import UI.UIControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ManagerFrameController implements Initializable {
	@FXML
	private Label usernameid;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void addPubAc(ActionEvent event) throws IOException {

		UIControl.changeLayout(event, getClass().getResource("AddPublisher.fxml"));

	}

	@FXML
	private void statisticsAction(ActionEvent event) throws IOException {

		UIControl.changeLayout(event, getClass().getResource("Statistics.fxml"));

	}

	@FXML
	private void handleButtonShoppingCart(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("ShoppingChart.fxml"));
	}

	@FXML
	private void promoteAction(ActionEvent event) throws IOException {

		UIControl.changeLayout(event, getClass().getResource("PromoteUser.fxml"));

	}

	@FXML
	private void addBookAction(ActionEvent event) throws IOException {

		System.out.println("Change layout to add book");

		UIControl.changeLayout(event, getClass().getResource("AddBook.fxml"));

	}

	@FXML
	private void updateAccountAction(ActionEvent event) throws IOException {

		System.out.println("Change layout to update account");

		UIControl.changeLayout(event, getClass().getResource("UpdateAccount.fxml"));

	}

	@FXML
	private void handleButtonActionSearch(ActionEvent event) throws IOException {

		UIControl.changeLayout(event, getClass().getResource("SearchBook.fxml"));

	}

	@FXML
	private void orderAction(ActionEvent event) throws IOException {

		UIControl.changeLayout(event, getClass().getResource("pO.fxml"));

	}

	@FXML
	private void showOrderAction(ActionEvent event) throws IOException {

		UIControl.changeLayout(event, getClass().getResource("Orders.fxml"));

	}

	@FXML
	private void addPublisher(ActionEvent event) throws IOException {

		UIControl.changeLayout(event, getClass().getResource("AddPublisher.fxml"));

	}

	@FXML
	private void handleCheckOut(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("CheckOut.fxml"));
	}

	@FXML
	private void handleLogOut(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("MainFrame.fxml"));
	}

	public void setText(String name) {

		usernameid.setText(name);

	}

}
