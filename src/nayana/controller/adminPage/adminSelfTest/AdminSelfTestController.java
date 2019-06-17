package nayana.controller.adminPage.adminSelfTest;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nayana.SelfTest.service.ISelfTestService;
import nayana.vo.MemberVO;
import nayana.vo.SelfTestVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class AdminSelfTestController {
	
	private static MemberVO memVO;

	public static void setMemVO(MemberVO memVO) {
		AdminSelfTestController.memVO = memVO;
	}

	private ISelfTestService stService;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Rectangle rec1;

    @FXML
    private Label num1;

    @FXML
    private Label testLabel1;

    @FXML
    private Label lastTest1;

    @FXML
    private Label lastDate1;

    @FXML
    private Button deleteBtn1;

    @FXML
    private Rectangle rec2;

    @FXML
    private Label num2;

    @FXML
    private Label testLabel2;

    @FXML
    private Label lastTest2;

    @FXML
    private Label lastDate2;

    @FXML
    private Button deleteBtn2;

    @FXML
    private Rectangle rec3;

    @FXML
    private Label num3;

    @FXML
    private Label testLabel3;

    @FXML
    private Label lastTest3;

    @FXML
    private Label lastDate3;

    @FXML
    private Button deleteBtn3;

    @FXML
    private Rectangle rec4;

    @FXML
    private Label num4;

    @FXML
    private Label testLabel4;

    @FXML
    private Label lastTest4;

    @FXML
    private Label lastDate4;

    @FXML
    private Button deleteBtn4;

    @FXML
    private Rectangle rec5;

    @FXML
    private Label num5;

    @FXML
    private Label testLabel5;

    @FXML
    private Label lastTest5;

    @FXML
    private Label lastDate5;

    @FXML
    private Button deleteBtn5;

    @FXML
    private Label writer1;

    @FXML
    private Label writer2;

    @FXML
    private Label writer3;

    @FXML
    private Label writer4;

    @FXML
    private Label writer5;

    @FXML
    private Label lastWriter1;

    @FXML
    private Label lastWriter2;

    @FXML
    private Label lastWriter3;

    @FXML
    private Label lastWriter4;

    @FXML
    private Label lastWriter5;
    
    @FXML
    private Button insertBtn;
    
    @FXML
    private Button resetBtn;
    
    @FXML
    void clickInsertBtn(ActionEvent event) {
    	try {
			Stage insertState = new Stage();
			insertState.initModality(Modality.WINDOW_MODAL);
			insertState.setResizable(false);
			insertState.initOwner(insertBtn.getScene().getWindow());
			insertState.setTitle("INSERT");
			InsertSelfTestController.setMemVO(memVO);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminSelfTest/InsertSelfTest.fxml"));
			Parent root = loader.load();
			InsertSelfTestController istc = loader.getController();
			istc.setThisStage(insertState);
			istc.setAstController(this);
			
			Scene scene = new Scene(root);
			insertState.setScene(scene);
			insertState.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickdeleteBtn1(ActionEvent event) {
    	int cnt = 0;
    	try {
			cnt = stService.deleteSelfTest(stVOList.get(0).getSelf_seq());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	if(cnt > 0) {
    		AlertUtil.information("성공", "삭제 완료", stVOList.get(0).getSelf_title() + "이 삭제되었습니다");
    		setting();
    	}else {
    		AlertUtil.error("실패", "삭제 실패", "삭제 실패하였습니다");
    	}
    	
    }

    @FXML
    void clickdeleteBtn2(ActionEvent event) {
    	int cnt = 0;
    	try {
			cnt = stService.deleteSelfTest(stVOList.get(1).getSelf_seq());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	if(cnt > 0) {
    		AlertUtil.information("성공", "삭제 완료", stVOList.get(1).getSelf_title() + "이 삭제되었습니다");
    		setting();
    	}else {
    		AlertUtil.error("실패", "삭제 실패", "삭제 실패하였습니다");
    	}
    }

    @FXML
    void clickdeleteBtn3(ActionEvent event) {
    	int cnt = 0;
    	try {
			cnt = stService.deleteSelfTest(stVOList.get(2).getSelf_seq());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	if(cnt > 0) {
    		AlertUtil.information("성공", "삭제 완료", stVOList.get(2).getSelf_title() + "이 삭제되었습니다");
    		setting();
    	}else {
    		AlertUtil.error("실패", "삭제 실패", "삭제 실패하였습니다");
    	}
    }

    @FXML
    void clickdeleteBtn4(ActionEvent event) {
    	int cnt = 0;
    	try {
			cnt = stService.deleteSelfTest(stVOList.get(3).getSelf_seq());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	if(cnt > 0) {
    		AlertUtil.information("성공", "삭제 완료", stVOList.get(3).getSelf_title() + "이 삭제되었습니다");
    		setting();
    	}else {
    		AlertUtil.error("실패", "삭제 실패", "삭제 실패하였습니다");
    	}
    }

    @FXML
    void clickdeleteBtn5(ActionEvent event) {
    	int cnt = 0;
    	try {
			cnt = stService.deleteSelfTest(stVOList.get(4).getSelf_seq());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	if(cnt > 0) {
    		AlertUtil.information("성공", "삭제 완료", stVOList.get(4).getSelf_title() + "이 삭제되었습니다");
    		setting();
    	}else {
    		AlertUtil.error("실패", "삭제 실패", "삭제 실패하였습니다");
    	}
    }

    private List<SelfTestVO> stVOList;
    
    public void setting() {
    	stVOList = new ArrayList<SelfTestVO>();
        try {
        	stVOList = stService.getAllSelfTest();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        
        if(stVOList.size() == 5) {
        	rec5.setVisible(true);
        	num5.setVisible(true);
        	testLabel5.setVisible(true);
        	lastTest5.setVisible(true);
        	lastDate5.setVisible(true);
        	deleteBtn5.setVisible(true);
        	writer5.setVisible(true);
        	lastWriter5.setVisible(true);
        	rec4.setVisible(true);
        	num4.setVisible(true);
        	testLabel4.setVisible(true);
        	lastTest4.setVisible(true);
        	lastDate4.setVisible(true);
        	deleteBtn4.setVisible(true);
        	writer4.setVisible(true);
        	lastWriter4.setVisible(true);
        	rec3.setVisible(true);
        	num3.setVisible(true);
        	testLabel3.setVisible(true);
        	lastTest3.setVisible(true);
        	lastDate3.setVisible(true);
        	deleteBtn3.setVisible(true);
        	writer3.setVisible(true);
        	lastWriter3.setVisible(true);
        	rec2.setVisible(true);
        	num2.setVisible(true);
        	testLabel2.setVisible(true);
        	lastTest2.setVisible(true);
        	lastDate2.setVisible(true);
        	deleteBtn2.setVisible(true);
        	writer2.setVisible(true);
        	lastWriter2.setVisible(true);
        	rec1.setVisible(true);
        	num1.setVisible(true);
        	testLabel1.setVisible(true);
        	lastTest1.setVisible(true);
        	lastDate1.setVisible(true);
        	deleteBtn1.setVisible(true);
        	writer1.setVisible(true);
        	lastWriter1.setVisible(true);
        	
        	testLabel1.setText(stVOList.get(0).getSelf_title());
        	testLabel2.setText(stVOList.get(1).getSelf_title());
        	testLabel3.setText(stVOList.get(2).getSelf_title());
        	testLabel4.setText(stVOList.get(3).getSelf_title());
        	testLabel5.setText(stVOList.get(4).getSelf_title());
        	
        	SelfTestVO stVO1 = new SelfTestVO();
        	SelfTestVO stVO2 = new SelfTestVO();
        	SelfTestVO stVO3 = new SelfTestVO();
        	SelfTestVO stVO4 = new SelfTestVO();
        	SelfTestVO stVO5 = new SelfTestVO();
        	try {
				stVO1 = stService.getSelfTestVO(stVOList.get(0).getSelf_seq());
				stVO2 = stService.getSelfTestVO(stVOList.get(1).getSelf_seq());
				stVO3 = stService.getSelfTestVO(stVOList.get(2).getSelf_seq());
				stVO4 = stService.getSelfTestVO(stVOList.get(3).getSelf_seq());
				stVO5 = stService.getSelfTestVO(stVOList.get(4).getSelf_seq());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
        	lastWriter1.setText(stVO1.getMem_id());
        	lastWriter2.setText(stVO2.getMem_id());
        	lastWriter3.setText(stVO3.getMem_id());
        	lastWriter4.setText(stVO4.getMem_id());
        	lastWriter5.setText(stVO5.getMem_id());
        	
        	lastDate1.setText(stVO1.getSelf_update());
        	lastDate2.setText(stVO2.getSelf_update());
        	lastDate3.setText(stVO3.getSelf_update());
        	lastDate4.setText(stVO4.getSelf_update());
        	lastDate5.setText(stVO5.getSelf_update());
        	
        	
        	
        }else if(stVOList.size() == 4) {
        	rec1.setVisible(true);
        	num1.setVisible(true);
        	testLabel1.setVisible(true);
        	lastTest1.setVisible(true);
        	lastDate1.setVisible(true);
        	deleteBtn1.setVisible(true);
        	writer1.setVisible(true);
        	lastWriter1.setVisible(true);
        	rec2.setVisible(true);
        	num2.setVisible(true);
        	testLabel2.setVisible(true);
        	lastTest2.setVisible(true);
        	lastDate2.setVisible(true);
        	deleteBtn2.setVisible(true);
        	writer2.setVisible(true);
        	lastWriter2.setVisible(true);
        	rec3.setVisible(true);
        	num3.setVisible(true);
        	testLabel3.setVisible(true);
        	lastTest3.setVisible(true);
        	lastDate3.setVisible(true);
        	deleteBtn3.setVisible(true);
        	writer3.setVisible(true);
        	lastWriter3.setVisible(true);
        	rec4.setVisible(true);
        	num4.setVisible(true);
        	testLabel4.setVisible(true);
        	lastTest4.setVisible(true);
        	lastDate4.setVisible(true);
        	deleteBtn4.setVisible(true);
        	writer4.setVisible(true);
        	lastWriter4.setVisible(true);
        	
        	testLabel1.setText(stVOList.get(0).getSelf_title());
        	testLabel2.setText(stVOList.get(1).getSelf_title());
        	testLabel3.setText(stVOList.get(2).getSelf_title());
        	testLabel4.setText(stVOList.get(3).getSelf_title());
        	rec5.setVisible(false);
        	num5.setVisible(false);
        	testLabel5.setVisible(false);
        	lastTest5.setVisible(false);
        	lastDate5.setVisible(false);
        	deleteBtn5.setVisible(false);
        	writer5.setVisible(false);
        	lastWriter5.setVisible(false);
        	
        	SelfTestVO stVO1 = new SelfTestVO();
        	SelfTestVO stVO2 = new SelfTestVO();
        	SelfTestVO stVO3 = new SelfTestVO();
        	SelfTestVO stVO4 = new SelfTestVO();
        	try {
				stVO1 = stService.getSelfTestVO(stVOList.get(0).getSelf_seq());
				stVO2 = stService.getSelfTestVO(stVOList.get(1).getSelf_seq());
				stVO3 = stService.getSelfTestVO(stVOList.get(2).getSelf_seq());
				stVO4 = stService.getSelfTestVO(stVOList.get(3).getSelf_seq());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
        	lastWriter1.setText(stVO1.getMem_id());
        	lastWriter2.setText(stVO2.getMem_id());
        	lastWriter3.setText(stVO3.getMem_id());
        	lastWriter4.setText(stVO4.getMem_id());
        	
        	lastDate1.setText(stVO1.getSelf_update());
        	lastDate2.setText(stVO2.getSelf_update());
        	lastDate3.setText(stVO3.getSelf_update());
        	lastDate4.setText(stVO4.getSelf_update());
        	
        }else if(stVOList.size() == 3) {
        	rec1.setVisible(true);
        	num1.setVisible(true);
        	testLabel1.setVisible(true);
        	lastTest1.setVisible(true);
        	lastDate1.setVisible(true);
        	deleteBtn1.setVisible(true);
        	writer1.setVisible(true);
        	lastWriter1.setVisible(true);
        	rec2.setVisible(true);
        	num2.setVisible(true);
        	testLabel2.setVisible(true);
        	lastTest2.setVisible(true);
        	lastDate2.setVisible(true);
        	deleteBtn2.setVisible(true);
        	writer2.setVisible(true);
        	lastWriter2.setVisible(true);
        	rec3.setVisible(true);
        	num3.setVisible(true);
        	testLabel3.setVisible(true);
        	lastTest3.setVisible(true);
        	lastDate3.setVisible(true);
        	deleteBtn3.setVisible(true);
        	writer3.setVisible(true);
        	lastWriter3.setVisible(true);
        	
        	testLabel1.setText(stVOList.get(0).getSelf_title());
        	testLabel2.setText(stVOList.get(1).getSelf_title());
        	testLabel3.setText(stVOList.get(2).getSelf_title());
        	rec5.setVisible(false);
        	num5.setVisible(false);
        	testLabel5.setVisible(false);
        	lastTest5.setVisible(false);
        	lastDate5.setVisible(false);
        	deleteBtn5.setVisible(false);
        	writer5.setVisible(false);
        	lastWriter5.setVisible(false);
        	rec4.setVisible(false);
        	num4.setVisible(false);
        	testLabel4.setVisible(false);
        	lastTest4.setVisible(false);
        	lastDate4.setVisible(false);
        	deleteBtn4.setVisible(false);
        	writer4.setVisible(false);
        	lastWriter4.setVisible(false);
        	
        	SelfTestVO stVO1 = new SelfTestVO();
        	SelfTestVO stVO2 = new SelfTestVO();
        	SelfTestVO stVO3 = new SelfTestVO();
        	try {
				stVO1 = stService.getSelfTestVO(stVOList.get(0).getSelf_seq());
				stVO2 = stService.getSelfTestVO(stVOList.get(1).getSelf_seq());
				stVO3 = stService.getSelfTestVO(stVOList.get(2).getSelf_seq());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
        	lastWriter1.setText(stVO1.getMem_id());
        	lastWriter2.setText(stVO2.getMem_id());
        	lastWriter3.setText(stVO3.getMem_id());
        	
        	lastDate1.setText(stVO1.getSelf_update());
        	lastDate2.setText(stVO2.getSelf_update());
        	lastDate3.setText(stVO3.getSelf_update());
        	
        }else if(stVOList.size() == 2) {
        	rec1.setVisible(true);
        	num1.setVisible(true);
        	testLabel1.setVisible(true);
        	lastTest1.setVisible(true);
        	lastDate1.setVisible(true);
        	deleteBtn1.setVisible(true);
        	writer1.setVisible(true);
        	lastWriter1.setVisible(true);
        	rec2.setVisible(true);
        	num2.setVisible(true);
        	testLabel2.setVisible(true);
        	lastTest2.setVisible(true);
        	lastDate2.setVisible(true);
        	deleteBtn2.setVisible(true);
        	writer2.setVisible(true);
        	lastWriter2.setVisible(true);
        	
        	testLabel1.setText(stVOList.get(0).getSelf_title());
        	testLabel2.setText(stVOList.get(1).getSelf_title());
        	
        	rec5.setVisible(false);
        	num5.setVisible(false);
        	testLabel5.setVisible(false);
        	lastTest5.setVisible(false);
        	lastDate5.setVisible(false);
        	deleteBtn5.setVisible(false);
        	writer5.setVisible(false);
        	lastWriter5.setVisible(false);
        	rec4.setVisible(false);
        	num4.setVisible(false);
        	testLabel4.setVisible(false);
        	lastTest4.setVisible(false);
        	lastDate4.setVisible(false);
        	deleteBtn4.setVisible(false);
        	writer4.setVisible(false);
        	lastWriter4.setVisible(false);
        	rec3.setVisible(false);
        	num3.setVisible(false);
        	testLabel3.setVisible(false);
        	lastTest3.setVisible(false);
        	lastDate3.setVisible(false);
        	deleteBtn3.setVisible(false);
        	writer3.setVisible(false);
        	lastWriter3.setVisible(false);
        	
        	SelfTestVO stVO1 = new SelfTestVO();
        	SelfTestVO stVO2 = new SelfTestVO();
        	try {
				stVO1 = stService.getSelfTestVO(stVOList.get(0).getSelf_seq());
				stVO2 = stService.getSelfTestVO(stVOList.get(1).getSelf_seq());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
        	lastWriter1.setText(stVO1.getMem_id());
        	lastWriter2.setText(stVO2.getMem_id());
        	
        	lastDate1.setText(stVO1.getSelf_update());
        	lastDate2.setText(stVO2.getSelf_update());
        	
        }else if(stVOList.size() == 1) {
        	rec1.setVisible(true);
        	num1.setVisible(true);
        	testLabel1.setVisible(true);
        	lastTest1.setVisible(true);
        	lastDate1.setVisible(true);
        	deleteBtn1.setVisible(true);
        	writer1.setVisible(true);
        	lastWriter1.setVisible(true);
        	
        	testLabel1.setText(stVOList.get(0).getSelf_title());
        	
        	rec5.setVisible(false);
        	num5.setVisible(false);
        	testLabel5.setVisible(false);
        	lastTest5.setVisible(false);
        	lastDate5.setVisible(false);
        	deleteBtn5.setVisible(false);
        	rec4.setVisible(false);
        	num4.setVisible(false);
        	testLabel4.setVisible(false);
        	lastTest4.setVisible(false);
        	lastDate4.setVisible(false);
        	deleteBtn4.setVisible(false);
        	rec3.setVisible(false);
        	num3.setVisible(false);
        	testLabel3.setVisible(false);
        	lastTest3.setVisible(false);
        	lastDate3.setVisible(false);
        	deleteBtn3.setVisible(false);
        	rec2.setVisible(false);
        	num2.setVisible(false);
        	testLabel2.setVisible(false);
        	lastTest2.setVisible(false);
        	lastDate2.setVisible(false);
        	deleteBtn2.setVisible(false);
        	writer5.setVisible(false);
        	lastWriter5.setVisible(false);
        	writer4.setVisible(false);
        	lastWriter4.setVisible(false);
        	writer3.setVisible(false);
        	lastWriter3.setVisible(false);
        	writer2.setVisible(false);
        	lastWriter2.setVisible(false);
        	
        	SelfTestVO stVO1 = new SelfTestVO();
        	try {
				stVO1 = stService.getSelfTestVO(stVOList.get(0).getSelf_seq());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
        	
        	lastWriter1.setText(stVO1.getMem_id());
        	
        	lastDate1.setText(stVO1.getSelf_update());
        	
        }else {
        	rec5.setVisible(false);
        	num5.setVisible(false);
        	testLabel5.setVisible(false);
        	lastTest5.setVisible(false);
        	lastDate5.setVisible(false);
        	deleteBtn5.setVisible(false);
        	rec4.setVisible(false);
        	num4.setVisible(false);
        	testLabel4.setVisible(false);
        	lastTest4.setVisible(false);
        	lastDate4.setVisible(false);
        	deleteBtn4.setVisible(false);
        	rec3.setVisible(false);
        	num3.setVisible(false);
        	testLabel3.setVisible(false);
        	lastTest3.setVisible(false);
        	lastDate3.setVisible(false);
        	deleteBtn3.setVisible(false);
        	rec2.setVisible(false);
        	num2.setVisible(false);
        	testLabel2.setVisible(false);
        	lastTest2.setVisible(false);
        	lastDate2.setVisible(false);
        	deleteBtn2.setVisible(false);
        	rec1.setVisible(false);
        	num1.setVisible(false);
        	testLabel1.setVisible(false);
        	lastTest1.setVisible(false);
        	lastDate1.setVisible(false);
        	deleteBtn1.setVisible(false);
        	writer5.setVisible(false);
        	lastWriter5.setVisible(false);
        	writer4.setVisible(false);
        	lastWriter4.setVisible(false);
        	writer3.setVisible(false);
        	lastWriter3.setVisible(false);
        	writer2.setVisible(false);
        	lastWriter2.setVisible(false);
        	writer1.setVisible(false);
        	lastWriter1.setVisible(false);
        }
    }
    

    @FXML
    void clickresetBtn(ActionEvent event) {
    	setting();
    }

    @FXML
    void initialize() {
        assert rec1 != null : "fx:id=\"rec1\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert num1 != null : "fx:id=\"num1\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert testLabel1 != null : "fx:id=\"testLabel1\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastTest1 != null : "fx:id=\"lastTest1\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastDate1 != null : "fx:id=\"lastDate1\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert deleteBtn1 != null : "fx:id=\"deleteBtn1\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert rec2 != null : "fx:id=\"rec2\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert num2 != null : "fx:id=\"num2\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert testLabel2 != null : "fx:id=\"testLabel2\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastTest2 != null : "fx:id=\"lastTest2\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastDate2 != null : "fx:id=\"lastDate2\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert deleteBtn2 != null : "fx:id=\"deleteBtn2\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert rec3 != null : "fx:id=\"rec3\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert num3 != null : "fx:id=\"num3\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert testLabel3 != null : "fx:id=\"testLabel3\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastTest3 != null : "fx:id=\"lastTest3\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastDate3 != null : "fx:id=\"lastDate3\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert deleteBtn3 != null : "fx:id=\"deleteBtn3\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert rec4 != null : "fx:id=\"rec4\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert num4 != null : "fx:id=\"num4\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert testLabel4 != null : "fx:id=\"testLabel4\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastTest4 != null : "fx:id=\"lastTest4\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastDate4 != null : "fx:id=\"lastDate4\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert deleteBtn4 != null : "fx:id=\"deleteBtn4\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert rec5 != null : "fx:id=\"rec5\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert num5 != null : "fx:id=\"num5\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert testLabel5 != null : "fx:id=\"testLabel5\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastTest5 != null : "fx:id=\"lastTest5\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastDate5 != null : "fx:id=\"lastDate5\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert deleteBtn5 != null : "fx:id=\"deleteBtn5\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert writer1 != null : "fx:id=\"writer1\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert writer2 != null : "fx:id=\"writer2\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert writer3 != null : "fx:id=\"writer3\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert writer4 != null : "fx:id=\"writer4\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert writer5 != null : "fx:id=\"writer5\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastWriter1 != null : "fx:id=\"lastWriter1\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastWriter2 != null : "fx:id=\"lastWriter2\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastWriter3 != null : "fx:id=\"lastWriter3\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastWriter4 != null : "fx:id=\"lastWriter4\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert lastWriter5 != null : "fx:id=\"lastWriter5\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert insertBtn != null : "fx:id=\"insertBtn\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        assert resetBtn != null : "fx:id=\"resetBtn\" was not injected: check your FXML file 'AdminSelfTest.fxml'.";
        
        insertBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        resetBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        deleteBtn1.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        deleteBtn2.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        deleteBtn3.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        deleteBtn4.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        deleteBtn5.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        try {
  			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
  			stService = (ISelfTestService) reg.lookup("selfTestService");
  		} catch (RemoteException e) {
  			e.printStackTrace();
  		} catch (NotBoundException e) {
  			e.printStackTrace();
  		}
        
        setting();
        
    }
}
