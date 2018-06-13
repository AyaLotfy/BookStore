package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import UI.UIControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class StaticticsController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void cancelAction(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("ManagerFrame.fxml"));

	}

	@FXML
	private void topbooksAction(ActionEvent event) throws IOException {
//		UIControl.changeLayout(event, getClass().getResource("TopBooks.fxml"));
		UIControl.changeLayout(event, getClass().getResource("f4.fxml"));

	}

	@FXML
	private void totSalesAction(ActionEvent event) throws IOException {
//		UIControl.changeLayout(event, getClass().getResource("Sales.fxml"));
		System.out.println("sta cont");
//	UIControl.changeLayout(event, getClass().getResource("FrontEnd.fxml"));
//		UIControl.changeLayout(event, getClass().getResource("f.fxml"));
		UIControl.changeLayout(event, getClass().getResource("Sales2.fxml"));



	}

	@FXML
	private void topCustAction(ActionEvent event) throws IOException {
//		UIControl.changeLayout(event, getClass().getResource("TopCustomers.fxml"));
//		UIControl.changeLayout(event, getClass().getResource("f.fxml"));
		UIControl.changeLayout(event, getClass().getResource("f2.fxml"));

	}

}
