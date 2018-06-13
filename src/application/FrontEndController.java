package application;

import java.net.URL;
import java.util.ResourceBundle;
import DBInterface.DBAccess;
import data.ITable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FrontEndController implements Initializable {
	public TableView<GameOfThronesCharacter> table;
	public TableColumn<GameOfThronesCharacter, String> nameColumn;
	public TableColumn<GameOfThronesCharacter, String> isbnColumn;
	public TableColumn<GameOfThronesCharacter, String> copies;
	public TableColumn<GameOfThronesCharacter, String> sellDate;
	public TableColumn<GameOfThronesCharacter, String> price;
//	private TableColumn<GameOfThronesCharacter, String> temp;

	private ObservableList<GameOfThronesCharacter> getCharacters() {
		ObservableList<GameOfThronesCharacter> characters = FXCollections.observableArrayList();
		ITable tab = new DBAccess().getTotalSales();
		String[][] data3 = tab.getData();
		int lll = data3.length;
		System.out.println(lll);
		for (int i = 0; i < data3.length; i++) {
			//System.out.println(data3[i][4] + "aya");
			characters.add(new GameOfThronesCharacter(data3[i][0], data3[i][1], data3[i][2], data3[i][3], data3[i][4]));

		}
		// characters.add(new GameOfThronesCharacter("Cersei", "Lannister", "Queen
		// Regent", 100000));
		// characters.add(new GameOfThronesCharacter("Jaime", "Lannister", "King
		// Slayer", 80000));
		// characters.add(new GameOfThronesCharacter("Tyrion", "Lannister", "Queen's
		// Hand", 60000));

		return characters;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// nameColumn
		nameColumn = new TableColumn<>("User Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		// nameColumn.setCellValueFactory(new PropertyValueFactory("firstName"));

		// isbnColumn
		isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("allegiance"));

		// copies
		copies = new TableColumn<>("Copies");
		copies.setCellValueFactory(new PropertyValueFactory<>("position"));

		// sellDate
		sellDate = new TableColumn<>("Sell Date");
		sellDate.setCellValueFactory(new PropertyValueFactory<>("salary"));

		// sellDate
		price = new TableColumn<>("Price");
		price.setCellValueFactory(new PropertyValueFactory<>("sajdhkjas"));
		//
//		 temp = new TableColumn<>("Price2");
//		 temp.setCellValueFactory(new PropertyValueFactory<>("price2"));
		// table = new TableView<>();
		table.setItems(getCharacters());
		table.getColumns().addAll(nameColumn, isbnColumn, copies, sellDate, price);

	}

}
