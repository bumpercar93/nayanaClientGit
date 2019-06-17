package nayana.controller.healthInfoPage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import nayana.vo.MemberVO;
import util.MyButtonEventHandler;

public class SelfTestResultController {
	
	private Stage thisStage;
	
	public void setThisStage(Stage thisStage) {
		this.thisStage = thisStage;
	}

	private static MemberVO memVO;

    public static void setMemVO(MemberVO memVO) {
		SelfTestResultController.memVO = memVO;
	}
    
    private static String testResult;
    private static int testScore;
    
	public static void setTestResult(String testResult) {
		SelfTestResultController.testResult = testResult;
	}

	public static void setTestScore(int testScore) {
		SelfTestResultController.testScore = testScore;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Label score;

    @FXML
    private Label result;

    @FXML
    private Button confirmBtn;

    @FXML
    void clickconfirmBtn(ActionEvent event) {
    	thisStage.close();
    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'SelfTestResult.fxml'.";
        assert score != null : "fx:id=\"score\" was not injected: check your FXML file 'SelfTestResult.fxml'.";
        assert result != null : "fx:id=\"result\" was not injected: check your FXML file 'SelfTestResult.fxml'.";
        assert confirmBtn != null : "fx:id=\"confirmBtn\" was not injected: check your FXML file 'SelfTestResult.fxml'.";
        
        confirmBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        label.setText(memVO.getMem_name() + "님의 검사 결과");
        score.setText("점수 : " + testScore + "점");
        result.setText("결과 : " + testResult);
    }
}
