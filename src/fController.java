//
//package application;
//
//import java.net.URL;
//
//import java.util.ResourceBundle;
//
//import DBInterface.DBAccess;
//import data.ITable;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.Initializable;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//public class TopCustomersController implements Initializable {
//	public TableView<GameOfThronesCharacter2> table;
//	public TableColumn<GameOfThronesCharacter2, String> nameColumn;
//	public TableColumn<GameOfThronesCharacter2, String> isbnColumn;
//	public TableColumn<GameOfThronesCharacter2, String> copies;
//	public TableColumn<GameOfThronesCharacter2, String> sellDate;
//	public TableColumn<GameOfThronesCharacter2, String> price;
//	private TableColumn address;
//	private TableColumn sales;
//
//	private ObservableList<GameOfThronesCharacter2> getCharacters() {
//		ObservableList<GameOfThronesCharacter2> characters = FXCollections.observableArrayList();
//		ITable tab = new DBAccess().getTopCustomers();
//		String[][] data3 = tab.getData();
//		int lll = data3.length;
//		System.out.println(lll);
//		for (int i = 0; i < data3.length; i++) {
//			System.out.println(data3[i][0] + "ayaCust");
//			characters.add(new GameOfThronesCharacter2(data3[i][0], data3[i][1], data3[i][2], data3[i][3], data3[i][4],
//					data3[i][5], data3[i][6]));
//
//		}
//
//		return characters;
//	}
//
//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		// nameColumn
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
//		//
//		// price2 = new TableColumn<>("Price2");
//		// price2.setCellValueFactory(new PropertyValueFactory<>("price2"));
//		// table = new TableView<>();
//		table.setItems(getCharacters());
//		table.getColumns().addAll(nameColumn, isbnColumn, copies, sellDate, price, address,sales);
//
//	}
//
//}
