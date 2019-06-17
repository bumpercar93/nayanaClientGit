package nayana.controller.healthInfoPage;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nayana.controller.loginPage.LoginController;

public class DietMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet01.fxml"));
			Parent root = loader.load();
			
			Diet01Controller diet01Controller = loader.getController();
			diet01Controller.setPrimaryStage(primaryStage);
			
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			primaryStage.setTitle("추천식단");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
