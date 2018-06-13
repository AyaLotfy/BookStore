package application;

import java.awt.TextField;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

//import com.lowagie.text.pdf.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ModifyBookController implements Initializable {

	@FXML
	private TextField newQuantity;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private void handleConfirmAction(ActionEvent event) throws IOException {
	
	
	}
	
	@FXML
	private void handleCancelAction(ActionEvent event) throws IOException {
		
	}
}