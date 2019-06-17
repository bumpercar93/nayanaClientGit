package nayana.controller.adminPage.adminHealthInfo;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nayana.controller.communityPage.HCListController;

public class HealthExeUpdate extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminHealthInfo/HealthDietUpdate.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			primaryStage.setTitle("헬스케어 게시판 리스트");
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
