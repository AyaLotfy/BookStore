package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import UI.UIControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class UserFrameController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void handleUpdateAction(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("UpdateAccount.fxml"));
	}

	@FXML
	private void handleSearchAction(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("SearchBook.fxml"));
	}

	@FXML
	private void handleShoppingCart(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("ShoppingChart.fxml"));
	}

	@FXML
	private void handleCheckOut(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("CheckOut.fxml"));
	}

	@FXML
	private void handleLogOut(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("MainFrame.fxml"));
	}

}
