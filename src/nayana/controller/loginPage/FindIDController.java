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

public class FindIDController {
	
	private IMemberService memberService;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputName;

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
    	String mem_name = inputName.getText();
    	String mem_regno1 = inputRegNo1.getText();
    	String mem_regno2 = inputRegNo2.getText();
    	
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("mem_name", mem_name);
    	map.put("mem_regno1", mem_regno1);
    	map.put("mem_regno2", mem_regno2);
    	
    	String mem_id = null;
		try {
			mem_id = memberService.findID(map);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	resultLabel.setVisible(true);
    	resultCon.setVisible(true);
    	
    	if(mem_id == null) {
    		resultCon.setText("입력하신 정보와 일치하는 회원정보가 없습니다");
    	}else {
    		resultCon.setText("입력하신 정보와 일치하는 회원ID는 " + mem_id + " 입니다");
    	}
		inputName.clear();
		inputRegNo1.clear();
		inputRegNo2.clear();
		inputName.requestFocus();
    }

    @FXML
    void initialize() {
        assert inputName != null : "fx:id=\"inputName\" was not injected: check your FXML file 'FindID.fxml'.";
        assert inputRegNo1 != null : "fx:id=\"inputRegNo1\" was not injected: check your FXML file 'FindID.fxml'.";
        assert inputRegNo2 != null : "fx:id=\"inputRegNo2\" was not injected: check your FXML file 'FindID.fxml'.";
        assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file 'FindID.fxml'.";
        assert resultCon != null : "fx:id=\"resultCon\" was not injected: check your FXML file 'FindID.fxml'.";
        assert findBtn != null : "fx:id=\"findBtn\" was not injected: check your FXML file 'FindID.fxml'.";
        
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
