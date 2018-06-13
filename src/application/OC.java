//package application;
//
//public class OC {
//
//}
package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import DBInterface.DBAccess;
import UI.UIControl;
import data.DBSchema;
import data.ITable;
import data.bookOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class OC implements Initializable {
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
		ITable tab = new bookOrder().getUnConfirmedOrders();
		String[][] data3 = tab.getData();
		int lll = data3.length;
		System.out.println(lll);

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

		return;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		getCharacters();

	}

	@FXML
	private void cancelAction(ActionEvent event) throws IOException {
		UIControl.changeLayout(event, getClass().getResource("ManagerFrame.fxml"));

	}

	@FXML
	private void conf1(ActionEvent event) throws IOException {
		new bookOrder().confirmOrder(text11.getText());
		getCharacters();

	}

	@FXML
	private void conf2(ActionEvent event) throws IOException {
		new bookOrder().confirmOrder(text21.getText());

	}

	@FXML
	private void del1(ActionEvent event) throws IOException {
		System.out.println("dellllllllllll");
		System.out.println(text11.getText());

		String query = "DELETE FROM " + DBSchema.ORDER + " WHERE " + DBSchema.ISBN + " = '" + text11.getText() + "'";
		System.out.println(query +"  que\n");
		try {
			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet set = stmt.executeQuery(query);
		} catch (Exception ex) {

		}
		// new bookOrder().deleteOrder(text11.getText());
		// getCharacters();
		System.out.println("table\n");
		ITable tab = new bookOrder().getUnConfirmedOrders();
		String[][] data3 = tab.getData();
		for (int i = 0; i < data3.length; i++) {
			for (int j = 0; j < data3.length; j++) {
				System.out.println(data3[i][j]+" data");
			}
		}
		// getCharacters();

	}

	@FXML
	private void del2(ActionEvent event) throws IOException {
		new bookOrder().deleteOrder(text21.getText());

	}

}

// delete from Library_User where User_Id = 3 ;
// INSERT INTO Library_User (Username, F_Name, L_Name, Email, User_Password,
// Phone, Address, is_manager) VALUES ('admin','aya', 'lotfy',
// 'aialotf2014@gmail.com','1234', '01221930396', 'Alexandria, Egypt', true);
//
// INSERT INTO Library_User (Username, F_Name, L_Name, Email, User_Password,
// Phone, Address) VALUES
// ('salmayehia','salma','yehia','sdvohsophvo','1234','iegfiowe','null');
//
// select * from library_user;
//
// select * from library_user;
//
// SELECT * FROM Library_User WHERE Username='admin' AND User_Password = '1234';
//
//
// insert into category values ("comedy", 1), ("action", 2), ("fiction", 3) ,
// ("drama", 4);
// SELECT Cat_name from Category;
//
// insert into publisher values ( 5, "basha", "address of publlisger",
// "31546546");
//
// SELECT * FROM BOOK WHERE (TITLE = 'isbn' OR ISBN = 'isbn')ORDER BY BOOK_ID
// LIMIT 3;
//
// SELECT * FROM BOOK NATURAL JOIN PUBLISHER NATURAL JOIN CATEGORY NATURAL JOIN
// BOOK_AUTHORS WHERE ISBN = 'isbn';
//
// SELECT * FROM BOOK WHERE (TITLE = 'isbn' OR ISBN = 'isbn') ORDER BY BOOK_ID
// LIMIT 10;
//
// select * from book WHERE ISBN = 'isbn';
//
//
//
// -- INSERT INTO Library_User (Username, F_Name, L_Name, Email, User_Password,
// Phone, Address,Is_Manager) VALUES ('admin','aya', 'lotfy',
// 'aialotf2014@gmail.com','1234', '01221930396', 'Alexandria, Egypt', true);
// INSERT INTO Library_User (Username, F_Name, L_Name, Email, User_Password,
// Phone, Address,Is_Manager) VALUES ('admin2','aya', 'lotfy',
// 'hdfj@gmail.com','1234', '01221930396', 'Alexandria, Egypt', true);
// INSERT INTO Library_User (Username, F_Name, L_Name, Email, User_Password,
// Phone, Address,Is_Manager) VALUES ('admin3','aya', 'lotfy',
// 'ajhsjk@gmail.com','1234', '01221930396', 'Alexandria, Egypt', true);
// -- INSERT INTO Library_User (Username, F_Name, L_Name, Email, User_Password,
// Phone, Address) VALUES
// ('salmayehia','salma','yehia','sdvohsophvo','1234','iegfiowe','null');
//
//
//
// insert into PUBLISHER values ('1','aya','srejhj','erkjk');
// -- insert into CATEGORY values ('action',1);
// insert into BOOK values (1,'1','name','1','1',2556,1,5,10);
// insert into BOOK values (2,'2','name','1','1',2556,1,5,10);
// insert into BOOK values (3,'3','name','1','1',2556,1,5,10);
//
//
//
//
// insert into Sales values ('1' ,'1',5,'2018-09-09',20);
// insert into Sales values ('2' ,'1',5,'2018-5-12',20);
// insert into Sales values ('3' ,'1',5,'2018-5-12',20);
// insert into Sales values ('1' ,'2',5,'2018-5-12',20);
// insert into Sales values ('1' ,'3',5,'2018-5-12',20);
// insert into Sales values ('2' ,'2',5,'2018-5-12',20);
// insert into Sales values ('2' ,'3',5,'2018-5-12',20);
// insert into Sales values ('3' ,'2',5,'2018-5-12',20);
// insert into Sales values ('3' ,'3',5,'2018-5-12',20);
//
//
//
// SELECT
// F_Name,
// L_NAME,
// U.Username,
// EMAIL,
// Phone,
// Address,
// SUM(S.Price)
// FROM
// SALES AS S,
// library_user AS U
// WHERE
// -- S.Username = U.Username
// S.User_Id = U.User_Id
// AND S.SELL_DATE <= CURDATE()
// -- AND S.SELL_DATE
// -- <= ' getLastThreeMonth()
// -- between date '2018-08-08' and date '2018-10-10'
// -- add_months(to_date(:p_start_date, 'MON-YYYY'),-3))
// -- and to_date(:p_start_date, 'MON-YYYY'),-1)'
// -- and SELL_DATE >= dateadd(mm,datediff(mm,0,getdate())-3,0)
// GROUP BY U.User_Id
// ORDER BY SUM(S.Price) DESC
// LIMIT 5;
//
//
//
// SELECT
// *
// FROM
// library_user;
//
// SELECT
// *
// FROM
// library_user;
//
// SELECT
// *
// FROM
// Library_User
// WHERE
// Username = 'admin'
// AND User_Password = '1234';
//
// SELECT
// *
// FROM
// sales;
//
//
// insert into Book_Order values ('1',5,false);
//
// insert into Book_Order values ('2',5,false);
//
// insert into Book_Order values ('3',5,false);
//
//
// select * from Book_Order;
//
// SELECT B.ISBN,Title,Pub_name,
// year(Pub_Year),Price,Cat_Name,O.Copies,Threshold FROM Book AS B, Book_Order
// AS O, Category AS C,Publisher AS P WHERE B.ISBN = O.ISBN AND B.Cat_Id =
// C.Cat_Id AND Accepted = FALSE AND P.Pub_Id= B.Pub_Id;

//////////////////////////
