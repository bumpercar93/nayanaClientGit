package nayana.controller.loginPage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class AgreeController {
	
	private Stage agreeStage;
	private Stage primaryStage;
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Stage getAgreeStage() {
		return agreeStage;
	}

	public void setAgreeStage(Stage agreeStage) {
		this.agreeStage = agreeStage;
	}
	
	private CheckBox[] chkboxs;
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox agree1;

    @FXML
    private CheckBox agree2;

    @FXML
    private CheckBox agree3;

    @FXML
    private Button noneAgreeBtn;

    @FXML
    private Button agreeBtn;

    @FXML
    void clickAgreeBtn(ActionEvent event) {
    	try {
			Stage signupStage = new Stage();
			signupStage.initModality(Modality.WINDOW_MODAL);
			signupStage.setResizable(false);
			signupStage.initOwner(primaryStage);
			signupStage.setTitle("회원가입");
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/loginPage/SignUp.fxml"));
			Parent root = loader.load();
			SignUpController signUpController = loader.getController();
			signUpController.setSignUpStage(signupStage);
			signUpController.setPrimaryStage(primaryStage);
			
			Scene scene = new Scene(root);
			signupStage.setScene(scene);
			signupStage.show();
			agreeStage.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickNoneAgreeBtn(ActionEvent event) {
    	agreeStage.close();
    }

    @FXML
    void initialize() {
        assert agree1 != null : "fx:id=\"agree1\" was not injected: check your FXML file 'Agree.fxml'.";
        assert agree2 != null : "fx:id=\"agree2\" was not injected: check your FXML file 'Agree.fxml'.";
        assert agree3 != null : "fx:id=\"agree3\" was not injected: check your FXML file 'Agree.fxml'.";
        assert noneAgreeBtn != null : "fx:id=\"noneAgreeBtn\" was not injected: check your FXML file 'Agree.fxml'.";
        assert agreeBtn != null : "fx:id=\"agreeBtn\" was not injected: check your FXML file 'Agree.fxml'.";
        
        chkboxs = new CheckBox[]{agree1, agree2, agree3};
        
        agreeBtn.setDisable(true);
        noneAgreeBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        agreeBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
    	for (int i = 0; i < chkboxs.length; i++) {
			chkboxs[i].selectedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if(agree1.isSelected() == true && agree2.isSelected() == true && agree3.isSelected() == true) {
						agreeBtn.setDisable(false);
					}else {
						agreeBtn.setDisable(true);
					}
				}
			});
		}// for문
    }
    
}
