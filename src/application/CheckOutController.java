package application;

import java.io.IOException;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

//import org.exolab.castor.types.Date;

import DBInterface.customerReq;
import UI.UIControl;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CheckOutController implements Initializable {

	@FXML
	private TextField card_number;

	@FXML
	private DatePicker date_picker;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private void handleConfirmAction(ActionEvent event) throws IOException {
		//if ( date_picker.getValue().isAfter(Calendar.getInstance().))
		//check valid data
		
		String res = customerReq.checkOut();
		if(res == null) {
			SuccessAlert(); 
			CurrentState.ShoppingCart = FXCollections.observableArrayList();
			UIControl.changeLayout(event, getClass().getResource("UserFrame.fxml"));
		} else {
			errorAlert(res);
		}
	}
	
	private void SuccessAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText(null);
		alert.setContentText("Successful Checkout");
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
	private void handleBackAction(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("UserFrame.fxml"));
	}
}
