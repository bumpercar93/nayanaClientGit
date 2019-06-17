package nayana.controller.healthInfoPage;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExerciseMain extends Application{
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise01.fxml"));
			Parent root = loader.load();
			
			Exercise01Controller exercise01Controller = loader.getController();
			exercise01Controller.setPrimaryStage(primaryStage);
			
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			primaryStage.setTitle("맞춤운동 나이 유형 선택");
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
