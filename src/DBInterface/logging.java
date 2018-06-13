package DBInterface;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import application.DBconnection;
import data.DBSchema;
import data.User;

public class logging {

	public static User logUser(String name, String password) {

		// Statement stmt;
		// try {
		// stmt = DBconnection.getConnection().createStatement();
		// ResultSet set = stmt.executeQuery(query);
		// System.out.println(sql);
		//
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		String sql = "SELECT * FROM Library_User WHERE " + DBSchema.USER_NAME + " = '" + name + "' AND "
				+ DBSchema.PASSWORD + " = '" + password + "'";

		System.out.println("query is : " + sql);

		byte is_manager = 0;
		boolean found = false;

		try {
		

			Statement stmt = DBconnection.getConnection().createStatement();
			// stmt.execute(sql2);
			// stmt.execute("insert into category values ('comedy', 1), ('action', 2),
			// ('fiction', 3) , ('drama', 4);");
			// stmt.execute("insert into publisher values ( 5, \"basha\", \"address of
			// publlisger\", \"31546546\"); ");

			// String query = " " +
			//
//			stmt.execute( "INSERT INTO Library_User (Username, F_Name, L_Name, Email, User_Password,Phone, Address) VALUES ('salmayehia','salma','yehia','sdvohsophvo','1234','iegfiowe','null'); ");
//			stmt.execute( "insert into category values (\"comedy\", 1), (\"action\", 2),(\"fiction\", 3) , (\"drama\", 4); ");
//			stmt.execute("insert into publisher values ( 5, \"basha\", \"address of publlisger\", \"31546546\"); ");
//			 stmt.execute( "INSERT INTO Library_User (Username, F_Name, L_Name, Email,User_Password, Phone, Address,Is_Manager) VALUES ('admin2','aya', 'lotfy', 'hdfj@gmail.com','1234', '01221930396', 'Alexandria, Egypt', true); ");
//			stmt.execute(
//					"INSERT INTO Library_User (Username, F_Name, L_Name, Email, User_Password, Phone, Address,Is_Manager)  VALUES ('admin3','aya', 'lotfy', 'ajhsjk@gmail.com','1234', '01221930396', 'Alexandria, Egypt', true);  ");
//			stmt.execute("    insert into  PUBLISHER values ('1','aya','srejhj','erkjk');  ");
//			stmt.execute("	insert into BOOK values (1,'1','name','1','1',2556,1,5,10);  ");
//			stmt.execute("    	insert into BOOK values (2,'2','name','1','1',2556,1,5,10);  ");
//		stmt.execute("	insert into BOOK values (3,'3','name','1','1',2556,1,5,10);      ");
//			stmt.execute("    		insert into Sales values ('1' ,'1',5,'2018-09-09',20);  ");
//		stmt.execute("		insert into Sales values ('2' ,'1',5,'2018-5-12',20);  ");
//			//Cannot add or update a child row: a foreign key constraint fails (`bookstore`.`sales`, CONSTRAINT `fk6` FOREIGN KEY (`User_Id`) REFERENCES `library_user` (`User_Id`) ON UPDATE CASCADE)
//			stmt.execute("		insert into Sales values ('3' ,'1',5,'2018-5-12',20);  ");
//			stmt.execute("		insert into Sales values ('1' ,'2',5,'2018-5-12',20);  ");
//			stmt.execute("		insert into Sales values ('1' ,'3',5,'2018-5-12',20);    ");
//			stmt.execute("		insert into Sales values ('2' ,'2',5,'2018-5-12',20);  ");
//			stmt.execute("		insert into Sales values ('2' ,'3',5,'2018-5-12',20);  ");
//		// //	cannot 2
//			//stmt.execute("		insert into Sales values ('3' ,'2',5,'2018-5-12',20);  ");
//		//	stmt.execute("		insert into Sales values ('3' ,'3',5,'2018-5-12',20);  ");
//			stmt.execute("insert into Book_Order values ('1',5,false);  ");
//		stmt.execute("insert into Book_Order values ('2',5,false);  ");
//		stmt.execute("insert into Book_Order values ('3',5,false); ");
			ResultSet rs = stmt.executeQuery(sql);
			User user = null;

			// Extract data from result set
			if (rs.next()) {
				found = true;
				user = new User();
				user.setId(rs.getInt(DBSchema.USER_ID));
				user.setName(rs.getString(DBSchema.USER_NAME));
				user.setIs_manager(rs.getByte(DBSchema.IS_MANAGER));
			}

			// Clean-up environment
			rs.close();
			stmt.close();
			return user;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();

		} // end try

		return null;
	}


}

//"INSERT INTO Library_User (Username, F_Name, L_Name, Email, User_Password,Phone, Address) VALUES ('salmayehia','salma','yehia','sdvohsophvo','1234','iegfiowe','null'); insert into category values (\"comedy\", 1), (\"action\", 2),(\"fiction\", 3) , (\"drama\", 4); insert into publisher values ( 5, \"basha\", \"address of publlisger\", \"31546546\"); INSERT INTO Library_User (Username, F_Name, L_Name, Email,User_Password, Phone, Address,Is_Manager) VALUES ('admin2','aya', 'lotfy', 'hdfj@gmail.com','1234', '01221930396', 'Alexandria, Egypt', true); ");"INSERT INTO Library_User (Username, F_Name, L_Name, Email, User_Password, Phone, Address,Is_Manager)  VALUES ('admin3','aya', 'lotfy', 'ajhsjk@gmail.com','1234', '01221930396', 'Alexandria, Egypt', true);  ");"    insert into  PUBLISHER values ('1','aya','srejhj','erkjk');  	insert into BOOK values (1,'1','name','1','1',2556,1,5,10);      	insert into BOOK values (2,'2','name','1','1',2556,1,5,10);  	insert into BOOK values (3,'3','name','1','1',2556,1,5,10);          		insert into Sales values ('1' ,'1',5,'2018-09-09',20);  		insert into Sales values ('2' ,'1',5,'2018-5-12',20);  		insert into Sales values ('3' ,'1',5,'2018-5-12',20);  		insert into Sales values ('1' ,'2',5,'2018-5-12',20);  		insert into Sales values ('1' ,'3',5,'2018-5-12',20);    		insert into Sales values ('2' ,'2',5,'2018-5-12',20);  		insert into Sales values ('2' ,'3',5,'2018-5-12',20);  insert into Book_Order values ('1',5,false);  insert into Book_Order values ('2',5,false);  insert into Book_Order values ('3',5,false); ";