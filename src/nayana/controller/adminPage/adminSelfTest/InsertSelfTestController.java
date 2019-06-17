package nayana.controller.adminPage.adminSelfTest;

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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import nayana.SelfTest.service.ISelfTestService;
import nayana.SelfTestQuestion.service.ISelfTestQuestionService;
import nayana.SelfTestResult.service.ISelfTestResultService;
import nayana.vo.MemberVO;
import nayana.vo.SelfTestQuestionVO;
import nayana.vo.SelfTestResultVO;
import nayana.vo.SelfTestVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class InsertSelfTestController {
	
	private static MemberVO memVO;

    public static void setMemVO(MemberVO memVO) {
		InsertSelfTestController.memVO = memVO;
	}
    
    private Stage thisStage;

	public void setThisStage(Stage thisStage) {
		this.thisStage = thisStage;
	}
	
	private AdminSelfTestController astController;

	public void setAstController(AdminSelfTestController astController) {
		this.astController = astController;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Rectangle rec1;

    @FXML
    private Button insertBtn;

    @FXML
    private TextField title;

    @FXML
    private TextField mun1;

    @FXML
    private TextField mun2;

    @FXML
    private TextField mun3;

    @FXML
    private TextField mun4;

    @FXML
    private TextField mun5;

    @FXML
    private TextField mun6;

    @FXML
    private TextField mun7;

    @FXML
    private TextField mun8;

    @FXML
    private TextField mun9;

    @FXML
    private TextField mun10;

    @FXML
    private TextField mun11;

    @FXML
    private TextField mun12;

    @FXML
    private TextField mun13;

    @FXML
    private TextField mun14;

    @FXML
    private TextField mun15;

    @FXML
    private TextField mun16;

    @FXML
    private TextField mun17;

    @FXML
    private TextField mun18;

    @FXML
    private TextField mun19;

    @FXML
    private TextField mun20;

    @FXML
    private TextField resultGo;

    @FXML
    private TextField resultJoung;

    @FXML
    private TextField resultJu;

    @FXML
    void clickInsertBtn(ActionEvent event) {
    	
    	if(title.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		title.requestFocus();
    		return;
    	}else if(resultGo.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		resultGo.requestFocus();
    		return;
    	}else if(resultJoung.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		resultJoung.requestFocus();
    		return;
    	}else if(resultJu.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		resultJu.requestFocus();
    		return;
    	}else if(mun1.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun1.requestFocus();
    		return;
    	}else if(mun2.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun2.requestFocus();
    		return;
    	}else if(mun3.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun3.requestFocus();
    		return;
    	}else if(mun4.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun4.requestFocus();
    		return;
    	}else if(mun5.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun5.requestFocus();
    		return;
    	}else if(mun6.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun6.requestFocus();
    		return;
    	}else if(mun7.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun7.requestFocus();
    		return;
    	}else if(mun8.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun8.requestFocus();
    		return;
    	}else if(mun9.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun9.requestFocus();
    		return;
    	}else if(mun10.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun10.requestFocus();
    		return;
    	}else if(mun11.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun11.requestFocus();
    		return;
    	}else if(mun12.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun12.requestFocus();
    		return;
    	}else if(mun13.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun13.requestFocus();
    		return;
    	}else if(mun14.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun14.requestFocus();
    		return;
    	}else if(mun15.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun15.requestFocus();
    		return;
    	}else if(mun16.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun16.requestFocus();
    		return;
    	}else if(mun17.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun17.requestFocus();
    		return;
    	}else if(mun18.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun18.requestFocus();
    		return;
    	}else if(mun19.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun19.requestFocus();
    		return;
    	}else if(mun20.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "모든 입력창에 입력을 해주세요");
    		mun20.requestFocus();
    		return;
    	}
    	
    	SelfTestVO stVO = new SelfTestVO();
    	stVO.setMem_id(memVO.getMem_id());
    	stVO.setSelf_title(title.getText());
    	
    	try {
			stService.insertSelfTest(stVO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("mem_id", memVO.getMem_id());
    	map.put("self_title", title.getText());
    	int seq = 0;
    	try {
    		seq = stService.getSeq(map);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	int num = 1;
    	SelfTestQuestionVO stqVO = new SelfTestQuestionVO();
    	
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun1.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
			stqService.insertSelfTestQuestion(stqVO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun2.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
			stqService.insertSelfTestQuestion(stqVO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun3.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun4.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun5.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun6.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun7.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun8.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun9.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun10.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun11.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun12.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun13.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun14.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun15.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun16.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun17.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun18.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun19.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	stqVO.setSelf_seq(seq);
    	stqVO.setSelf_que_con(mun20.getText());
    	stqVO.setSelf_que_num(num);
    	num++;
    	try {
    		stqService.insertSelfTestQuestion(stqVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	
    	
    	SelfTestResultVO strVO = new SelfTestResultVO();
    	strVO.setSelf_seq(seq);
    	strVO.setSelf_rs_score(60);
    	strVO.setSelf_rs_con(resultGo.getText());
    	try {
			strService.insertSelfTestResult(strVO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	strVO.setSelf_seq(seq);
    	strVO.setSelf_rs_score(40);
    	strVO.setSelf_rs_con(resultJoung.getText());
    	try {
    		strService.insertSelfTestResult(strVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	strVO.setSelf_seq(seq);
    	strVO.setSelf_rs_score(20);
    	strVO.setSelf_rs_con(resultJu.getText());
    	try {
    		strService.insertSelfTestResult(strVO);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    	
    	astController.setting();
    	thisStage.close();
    	
    }
    
    private ISelfTestService stService;
    private ISelfTestQuestionService stqService;
    private ISelfTestResultService strService;

    @FXML
    void initialize() {
        assert rec1 != null : "fx:id=\"rec1\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert insertBtn != null : "fx:id=\"insertBtn\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun1 != null : "fx:id=\"mun1\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun2 != null : "fx:id=\"mun2\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun3 != null : "fx:id=\"mun3\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun4 != null : "fx:id=\"mun4\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun5 != null : "fx:id=\"mun5\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun6 != null : "fx:id=\"mun6\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun7 != null : "fx:id=\"mun7\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun8 != null : "fx:id=\"mun8\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun9 != null : "fx:id=\"mun9\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun10 != null : "fx:id=\"mun10\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun11 != null : "fx:id=\"mun11\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun12 != null : "fx:id=\"mun12\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun13 != null : "fx:id=\"mun13\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun14 != null : "fx:id=\"mun14\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun15 != null : "fx:id=\"mun15\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun16 != null : "fx:id=\"mun16\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun17 != null : "fx:id=\"mun17\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun18 != null : "fx:id=\"mun18\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun19 != null : "fx:id=\"mun19\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert mun20 != null : "fx:id=\"mun20\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert resultGo != null : "fx:id=\"resultGo\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert resultJoung != null : "fx:id=\"resultJoung\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";
        assert resultJu != null : "fx:id=\"resultJu\" was not injected: check your FXML file 'InsertSelfTest.fxml'.";

        insertBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        try {
  			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
  			stService = (ISelfTestService) reg.lookup("selfTestService");
  			stqService = (ISelfTestQuestionService) reg.lookup("selfTestQuestionService");
  			strService = (ISelfTestResultService) reg.lookup("selfTestResultService");
  		} catch (RemoteException e) {
  			e.printStackTrace();
  		} catch (NotBoundException e) {
  			e.printStackTrace();
  		}
        
    }
}

