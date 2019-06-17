package nayana.controller.loginPage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nayana.controller.adminPage.mainPageA.MainAController;
import nayana.controller.mainPage.MainController;
import nayana.controller.mainPage.MainTopController;
import nayana.member.service.IMemberService;
import nayana.vo.MemberVO;
import util.MyButtonEventHandler;

public class LoginController {
	
	private IMemberService memberService;
	private Stage primaryStage;

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField input_id;
    
    @FXML
    private Label label;
    
    @FXML
    private PasswordField input_pw;

    @FXML
    private Button loginBtn;

    @FXML
    private Button signupBtn;

    @FXML
    private Button findIdBtn;

    @FXML
    private Button findPwBtn;

    @FXML
    void clickFindIdBtn(ActionEvent event) {
    	try {
			Stage findIDStage = new Stage();
			findIDStage.initModality(Modality.WINDOW_MODAL);
			findIDStage.setResizable(false);
			findIDStage.initOwner(primaryStage);
			findIDStage.setTitle("아이디 찾기");
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/loginPage/FindID.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			findIDStage.setScene(scene);
			findIDStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickFindPwBtn(ActionEvent event) {
    	try {
			Stage findPWStage = new Stage();
			findPWStage.initModality(Modality.WINDOW_MODAL);
			findPWStage.setResizable(false);
			findPWStage.initOwner(primaryStage);
			findPWStage.setTitle("비밀번호 찾기");
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/loginPage/FindPW.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			findPWStage.setScene(scene);
			findPWStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickLoginBtn(ActionEvent event) {
    	String inputID = input_id.getText();
    	String inputPW = input_pw.getText();
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("mem_id", inputID);
    	map.put("mem_pw", inputPW);
    	
    	MemberVO memVO = null;
    	try {
    		memVO = memberService.login(map);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	if(memVO == null) {
    		label.setText("아이디 또는 비밀번호가 일치하지 않습니다.");
    		input_id.clear();
    		input_pw.clear();
    		input_id.requestFocus();
    	}else if(memVO.getMem_right().equals("U")){
    		try {
				Stage mainStage = new Stage();
				mainStage.initModality(Modality.WINDOW_MODAL);
				mainStage.setResizable(false);
				mainStage.setTitle("NAYANA");
//				MainController.setMemVO(memVO);
				MainTopController.setMemVO(memVO);
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/mainPage/MainTop.fxml"));
				Parent root = loader.load();
//				MainController mainController = loader.getController();
//				mainController.setMainStage(mainStage);
				MainTopController mainTopController = loader.getController();
				mainTopController.setMainStage(mainStage);
				mainTopController.mainGOGO();
				
				Scene scene = new Scene(root);
				mainStage.setScene(scene);
				mainStage.show();
				Stage s = (Stage) findPwBtn.getScene().getWindow();
				s.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}else if(memVO.getMem_right().equals("A")) {
    		try {
				Stage adminMainStage = new Stage();
				adminMainStage.initModality(Modality.WINDOW_MODAL);
				adminMainStage.setResizable(false);
				adminMainStage.setTitle("NAYANA Admin");
				MainAController.setMemVO(memVO);
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/adminPage/mainPageA/MainA.fxml"));
				Parent root = loader.load();
				MainAController mainAController = loader.getController();
				mainAController.setMainStage(adminMainStage);
				Scene scene = new Scene(root);
				adminMainStage.setScene(scene);
				adminMainStage.show();
				Stage s = (Stage) findPwBtn.getScene().getWindow();
				s.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	
    }

    @FXML
    void clickSignupBtn(ActionEvent event) {
    	try {
    		Stage agreeStage = new Stage();
    		agreeStage.initModality(Modality.WINDOW_MODAL);
    		agreeStage.setResizable(false);
    		agreeStage.initOwner(primaryStage);
    		agreeStage.setTitle("회원가입 동의사항");
    		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/loginPage/Agree.fxml"));
			Parent root = loader.load();
			
			AgreeController agreeController = loader.getController();
			agreeController.setAgreeStage(agreeStage);
			agreeController.setPrimaryStage(primaryStage);
			
			Scene scene = new Scene(root);
			agreeStage.setScene(scene);
			agreeStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert input_id != null : "fx:id=\"input_id\" was not injected: check your FXML file 'Login.fxml'.";
        assert input_pw != null : "fx:id=\"input_pw\" was not injected: check your FXML file 'Login.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Login.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'Login.fxml'.";
        assert signupBtn != null : "fx:id=\"signupBtn\" was not injected: check your FXML file 'Login.fxml'.";
        assert findIdBtn != null : "fx:id=\"findIdBtn\" was not injected: check your FXML file 'Login.fxml'.";
        assert findPwBtn != null : "fx:id=\"findPwBtn\" was not injected: check your FXML file 'Login.fxml'.";
        
        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			memberService = (IMemberService) reg.lookup("memberService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
        
        loginBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        signupBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        findIdBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        findPwBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
    }
}