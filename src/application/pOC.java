package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DBInterface.DBAccess;
import DBInterface.managerReq;
import DBInterface.registeration;
import UI.UIControl;
import data.bookOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class pOC implements Initializable {

	@FXML
	private TextField isbnid;

	@FXML
	private TextField copiesid;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	private void cancelAction(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("ManagerFrame.fxml"));

	}

	@FXML
	private void confirmAction(ActionEvent event) throws IOException {

		bookOrder order = new bookOrder();
		order.ISBN = isbnid.getText();
		order.copies = Integer.parseInt(copiesid.getText());
		order.isAccepted = false;

		String res = managerReq.addOrder(order);
		if (res == null) {
			UIControl.changeLayout(event, getClass().getResource("ManagerFrame.fxml"));
		} else {
			errorAlert(res);
		}

	}

	private void errorAlert(String m) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(m);
		alert.showAndWait();
	}


}
