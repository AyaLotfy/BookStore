package application;

import java.net.URL;
import java.util.ResourceBundle;

import org.junit.FixMethodOrder;

import DBInterface.DBAccess;
import data.ITable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;




public class f2C implements Initializable{

	@FXML
	private Text text11;
	@FXML
	private Text text12;
	@FXML
	private Text text13;
	@FXML
	private Text text14;
	@FXML
	private Text text15;
	@FXML
	private Text text16;
	@FXML
	private Text text17;
	
	@FXML
	private Text text21;
	@FXML
	private Text text22;
	@FXML
	private Text text23;
	@FXML
	private Text text24;
	@FXML
	private Text text25;
	@FXML
	private Text text26;
	@FXML
	private Text text27;
	
	@FXML
	private Text text31;
	@FXML
	private Text text32;
	@FXML
	private Text text33;
	@FXML
	private Text text34;
	@FXML
	private Text text35;
	@FXML
	private Text text36;
	@FXML
	private Text text37;
	
	@FXML
	private Text text41;
	@FXML
	private Text text42;
	@FXML
	private Text text43;
	@FXML
	private Text text44;
	@FXML
	private Text text45;
	@FXML
	private Text text46;
	@FXML
	private Text text47;
	
	@FXML
	private Text text51;
	@FXML
	private Text text52;
	@FXML
	private Text text53;
	@FXML
	private Text text54;
	@FXML
	private Text text55;
	@FXML
	private Text text56;
	@FXML
	private Text text57;
	
	private void getCharacters() {
	//	ObservableList<GameOfThronesCharacter2> characters = FXCollections.observableArrayList();
		ITable tab = new DBAccess().getTopCustomers();
		String[][] data3 = tab.getData();
		int lll = data3.length;
		System.out.println(lll);
//		for (int i = 0; i < data3.length; i++) {
//			for (int j = 0; j < data3.length; j++) {
//				text11.setText(data3[i][j]);
//			}
//		//	System.out.println(data3[i][0] + "ayaCust");
////			characters.add(new GameOfThronesCharacter2(data3[i][0], data3[i][1], data3[i][2], data3[i][3], data3[i][4],
////					data3[i][5], data3[i][6]));
//
//		}
		try {
			
			text11.setText(data3[0][0]);
			text12.setText(data3[0][1]);
			text13.setText(data3[0][2]);
			text14.setText(data3[0][3]);
			text15.setText(data3[0][4]);
			text16.setText(data3[0][5]);
			text17.setText(data3[0][6]);
			
			text21.setText(data3[1][0]);
			text22.setText(data3[1][1]);
			text23.setText(data3[1][2]);
			text24.setText(data3[1][3]);
			text25.setText(data3[1][4]);
			text26.setText(data3[1][5]);
			text27.setText(data3[1][6]);
			
			text31.setText(data3[2][0]);
			text32.setText(data3[2][1]);
			text33.setText(data3[2][2]);
			text34.setText(data3[2][3]);
			text35.setText(data3[2][4]);
			text36.setText(data3[2][5]);
			text37.setText(data3[2][6]);
			
			
			text41.setText(data3[3][0]);
			text42.setText(data3[3][1]);
			text43.setText(data3[3][2]);
			text44.setText(data3[3][3]);
			text45.setText(data3[3][4]);
			text46.setText(data3[3][5]);
			text47.setText(data3[3][6]);
			
			text51.setText(data3[4][0]);
			text52.setText(data3[4][1]);
			text53.setText(data3[4][2]);
			text54.setText(data3[4][3]);
			text55.setText(data3[4][4]);
			text56.setText(data3[4][5]);
			text57.setText(data3[4][6]);
			
		} catch (Exception e) {
		}

		return ;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// nameColumn
//		nameColumn = new TableColumn<>("First Name");
//		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//		// nameColumn.setCellValueFactory(new PropertyValueFactory("firstName"));
//
//		// isbnColumn
//		isbnColumn = new TableColumn<>("Last Name");
//		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("allegiance"));
//
//		// copies
//		copies = new TableColumn<>("User Name");
//		copies.setCellValueFactory(new PropertyValueFactory<>("position"));
//
//		// sellDate
//		sellDate = new TableColumn<>("Email");
//		sellDate.setCellValueFactory(new PropertyValueFactory<>("salary"));
//
//		// sellDate
//		price = new TableColumn<>("Phone");
//		price.setCellValueFactory(new PropertyValueFactory<>("price"));
//		
//		address = new TableColumn<>("Address");
//		address.setCellValueFactory(new PropertyValueFactory<>("address2"));
//		sales = new TableColumn<>("sales");
//		sales.setCellValueFactory(new PropertyValueFactory<>("sales2"));
		//
		// price2 = new TableColumn<>("Price2");
		// price2.setCellValueFactory(new PropertyValueFactory<>("price2"));
		// table = new TableView<>();
//		table.setItems(getCharacters());
//		table.getColumns().addAll(nameColumn, isbnColumn, copies, sellDate, price, address,sales);
		getCharacters();

	}
}
