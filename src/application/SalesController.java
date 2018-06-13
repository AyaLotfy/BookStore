package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import UI.UIControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

//public class SalesController implements Initializable {
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@FXML
//	private void backAction(ActionEvent event) throws IOException {
//		//UIControl.changeLayout(event, getClass().getResource("ManagerFrameController.fxml"));
//
//	}
//
//
//}





import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SalesController implements Initializable {
	  public TableView<GameOfThronesCharacter> table;
	    public TableColumn<GameOfThronesCharacter,String> nameColumn;
	    public TableColumn<GameOfThronesCharacter,String> allegianceColumn;
	    public TableColumn<GameOfThronesCharacter,String> positionColumn;
	    public TableColumn<GameOfThronesCharacter,Double> salaryColumn;



	    private ObservableList<GameOfThronesCharacter> getCharacters(){
	        ObservableList<GameOfThronesCharacter> characters = FXCollections.observableArrayList();
	        
	        
	        
//	        
//	        characters.add(new GameOfThronesCharacter("Cersei","Lannister","Queen Regent",100000));
//	        characters.add(new GameOfThronesCharacter("Jaime","Lannister","King Slayer",80000));
//	        characters.add(new GameOfThronesCharacter("Tyrion","Lannister","Queen's Hand",60000));

	        return characters;
	    }



	    @Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
	        //nameColumn
	        nameColumn = new TableColumn<>("User Name");
	        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

	        //allegianceColumn
	        allegianceColumn = new TableColumn<>("ISBN");
	        allegianceColumn.setCellValueFactory(new PropertyValueFactory<>("allegiance"));

	        //positionColumn
	        positionColumn = new TableColumn<>("Copies");
	        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));

	        //salaryColumn
	        salaryColumn = new TableColumn<>("Sell Date");
	        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

	        //table = new TableView<>();
	        table.setItems(getCharacters());
	        table.getColumns().addAll(nameColumn,allegianceColumn,positionColumn,salaryColumn);

	    }



		
}

