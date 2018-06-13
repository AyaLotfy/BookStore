package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DBInterface.DBAccess;
import DBInterface.managerReq;
import UI.UIControl;
import data.ITable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class PromoteUserController implements Initializable{
	@FXML
	private TextField usernameId;
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
		System.out.println("promote user");
		String res = managerReq.promote(usernameId.getText());
		if(res == null) {
			userPromotedAlert();
			UIControl.changeLayout(event, getClass().getResource("ManagerFrame.fxml"));
		} else {
			errorAlert(res);
		}

	}
	
	private void userPromotedAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText(null);
		alert.setContentText("user is promoted successfully");
		alert.showAndWait();
	}

	private void errorAlert(String m) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(m);
		alert.showAndWait();
	}


}
