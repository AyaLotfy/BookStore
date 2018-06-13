//package application;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
////import Report.ReportMaker;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//

package application;

//import Report.ReportMaker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	 
    @Override
    public void start(Stage stage) throws Exception {
    	
    	DBconnection.createConnection();
    	 
    	//ReportMaker.make();
    	
        Parent root = FXMLLoader.load(getClass().getResource("MainFrame.fxml"));
        
        Scene scene = new Scene(root);
//        String css = "LoginStyle.css";
//        scene.getStylesheets().add(css);
        stage.setScene(scene);
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
//public class Main extends Application {
//
//static Stage window;
//static Scene FrontEnd;
//
//@Override
//public void start(Stage primaryStage)throws IOException {
//    window = primaryStage;
//     initialize();
//
//        window.setTitle("Database Interface v1.0");
//        window.setResizable(true);
//        window.setScene(FrontEnd);
//        window.show();
//}
//
//private void initialize() throws IOException {
//    FrontEnd = new Scene(FXMLLoader.load(getClass().getResource("Frontend.fxml")));
//    FrontEnd.getStylesheets().add("application.css");
//}
//
//public static void main(String[] args) {
//    launch(args);
//    }
//}