package nayana.controller.loginPage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.MyButtonEventHandler;

public class SignUpCompleteController {

	private Stage signUpCompleteStage;

    public Stage getSignUpCompleteStage() {
		return signUpCompleteStage;
	}

	public void setSignUpCompleteStage(Stage signUpCompleteStage) {
		this.signUpCompleteStage = signUpCompleteStage;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Button confirmBtn;
    
    @FXML
    void clickconfirmBtn(ActionEvent event) {
    	signUpCompleteStage.close();
    }
    
    public void setName(String name) {
    	label.setText(name + "님, 환영합니다");
    }
    
    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'SignUpComplete.fxml'.";
        assert confirmBtn != null : "fx:id=\"confirmBtn\" was not injected: check your FXML file 'SignUpComplete.fxml'.";
        
        confirmBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
    }
}
