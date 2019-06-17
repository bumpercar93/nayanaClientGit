package nayana.controller.adminPage.adminSelfTest;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminSelfTestMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminSelfTest/AdminSelfTest.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			primaryStage.setTitle("NAYANA");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) { 
			e.printStackTrace();
		}}

	public static void main(String[] args) {
		launch(args);
	}
}
