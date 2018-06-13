package UI;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UIControl {

	public static void changeLayout(ActionEvent event, URL location) throws IOException {
		
		Parent home_page_parent = FXMLLoader.load(location);
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		app_stage.hide(); // optional
		app_stage.setScene(home_page_scene);
		app_stage.show();
		
	}
public static void newLayout(ActionEvent event, URL location) throws IOException {
		
		Parent home_page_parent = FXMLLoader.load(location);
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = new Stage();

		app_stage.setScene(home_page_scene);
		app_stage.show();	
	}

}
