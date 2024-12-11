package application;
	
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import application.services.SiyoServices;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


//public class Main extends Application {
//	@Override
//	public void start(Stage primaryStage) {
//		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void main(String[] args) {
//		launch(args);
//	}
//}

public class Main {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		// test sql 
		ResultSet rs = SiyoServices.getAllSiyo();
		while (rs.next()) {
			System.out.print("SIYO_ID : " + rs.getInt("SIYO_ID") + " ");
			System.out.print("KOUJI_NUMBER : " + rs.getString("KOUJI_NUM") + " ");
			System.out.print("SHOHIN_CODE: " + rs.getString("SHOHIN_CD") + " ");
			System.out.println("");
		}
		
		// test sql with parameter
		System.out.print("Enter SHOHIN_CD: ");
		String shohinCode = scanner.nextLine();
		
		rs = SiyoServices.getSiyoByShohinCode(shohinCode);
		while (rs.next()) {
			System.out.print("SIYO_ID : " + rs.getInt("SIYO_ID") + " ");
			System.out.print("KOUJI_NUMBER : " + rs.getString("KOUJI_NUM") + " ");
			System.out.print("SHOHIN_CODE: " + rs.getString("SHOHIN_CD") + " ");
			System.out.println("");
		}
	}
}
