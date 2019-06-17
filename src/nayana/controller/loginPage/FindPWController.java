package nayana.controller.loginPage;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import nayana.member.service.IMemberService;
import util.MyButtonEventHandler;
import util.MyMail;

public class FindPWController {
	
	private IMemberService memberService;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputID;

    @FXML
    private TextField inputRegNo1;

    @FXML
    private TextField inputRegNo2;

    @FXML
    private Label resultLabel;

    @FXML
    private Label resultCon;

    @FXML
    private Button findBtn;

    @FXML
    void clickFindBtn(ActionEvent event) {
    	MyMail mm = new MyMail();
    	String mem_id = inputID.getText();
    	String mem_regno1 = inputRegNo1.getText();
    	String mem_regno2 = inputRegNo2.getText();
    	
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("mem_id", mem_id);
    	map.put("mem_regno1", mem_regno1);
    	map.put("mem_regno2", mem_regno2);
    	
    	String mail = null;
		try {
			mail = memberService.findPW(map);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	resultLabel.setVisible(true);
    	resultCon.setVisible(true);
    	Map<String, String> map2 = new HashMap<String, String>();
    	String mem_pw = null;
    	if(mail == null) {
    		resultCon.setText("입력하신 정보와 일치하는 회원정보가 없습니다");
    	}else {
    		resultCon.setText("새로운 비밀번호를 회원님의 email주소로 보내드렸습니다");
    		mem_pw = mm.sendMail(mail, mem_id);
    		map2.put("mem_pw", mem_pw);
    		map2.put("mem_id", mem_id);
    		try {
				memberService.updatePW(map2);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    	}
		inputID.clear();
		inputRegNo1.clear();
		inputRegNo2.clear();
		inputID.requestFocus();
    	
    }

    @FXML
    void initialize() {
        assert inputID != null : "fx:id=\"inputID\" was not injected: check your FXML file 'FindPW.fxml'.";
        assert inputRegNo1 != null : "fx:id=\"inputRegNo1\" was not injected: check your FXML file 'FindPW.fxml'.";
        assert inputRegNo2 != null : "fx:id=\"inputRegNo2\" was not injected: check your FXML file 'FindPW.fxml'.";
        assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file 'FindPW.fxml'.";
        assert resultCon != null : "fx:id=\"resultCon\" was not injected: check your FXML file 'FindPW.fxml'.";
        assert findBtn != null : "fx:id=\"findBtn\" was not injected: check your FXML file 'FindPW.fxml'.";
        
        findBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			memberService = (IMemberService) reg.lookup("memberService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    }
}
