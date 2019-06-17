package nayana.controller.adminPage;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import nayana.boardNotice.service.IBoardNoticeService;
import nayana.vo.BoardNoticeVO;
import nayana.vo.MemberVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class AdShowNoticeController {
	
private AdNoticeBoardController controller;
	
	public void setNoticeBoardController(AdNoticeBoardController controller) {
		this.controller = controller;
	}
	
	// --- //
	private static MemberVO memVO;
	
	public static MemberVO getMemVO() {
		return memVO;
	}

	public static void setMemVO(MemberVO memVO) {
		AdShowNoticeController.memVO = memVO;
	}
	
	// --- //
    private IBoardNoticeService boardNoticeService;
    
    private Stage primaryStage;
    
    public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	private AdNoticeBoardController noticeBoardCtr;
	
    public AdNoticeBoardController getNoticeBoardCtr() {
		return noticeBoardCtr;
	}

	public void setNoticeBoardCtr(AdNoticeBoardController noticeBoardCtr) {
		this.noticeBoardCtr = noticeBoardCtr;
	}
	
	// --- //
	private BoardNoticeVO noticecvo;
	
	public BoardNoticeVO getNoticecvo() {
		return noticecvo;
	}

	public void setNoticecvo(BoardNoticeVO noticecvo) {
		this.noticecvo = noticecvo;
	}
	
	public void setContentData() {
		txtFieldTitle.setText(noticecvo.getBn_title());
		txtFieldWriter.setText(noticecvo.getMem_id());
		txtFieldDate.setText(noticecvo.getBn_date().toString());
//		txtFieldCnt.setText(noticecvo.getBn_cnt());
		txtAreaContent.setText(noticecvo.getBn_content());
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane showPane;

    @FXML
    private TextField txtFieldTitle;

    @FXML
    private TextField txtFieldWriter;

    @FXML
    private TextField txtFieldDate;

    @FXML
    private TextField txtFieldCnt;

    @FXML
    private TextArea txtAreaContent;

    @FXML
    private Button modifyBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button returnBtn;

    @FXML
    void deleteBtnClicked(ActionEvent event) {
    	boolean confirm = AlertUtil.confirmation("삭제 확인", "정말 삭제하시겠습니까?", "OK버튼을 누르면 삭제됩니다");
    	
    	if(confirm == false) {
    		return;
    	}
    	
    	int result = 0;
    	try {
			result = boardNoticeService.deleteBoard(noticecvo.getBn_seq());
			
			if( result > 0) {
				AlertUtil.information("확인", "작업 성공", "게시글 삭제 성공");
			} else {
				AlertUtil.error("에러", "작업 실패", "게시글 삭제 실패");
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	controller.setBoardListData();////////////////////////////////
    	controller.setPage();
    	Stage stage = (Stage) deleteBtn.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void modifyBtnClicked(ActionEvent event) {
    	
    	boolean confirm = AlertUtil.confirmation("수정 확인", "제목과 내용을 수정하시겠습니까?", "현재 입력된 제목과 내용으로 내용을 변경합니다");
    	
    	if(confirm == false) {
    		return;
    	}
    	
    	String title = txtFieldTitle.getText();
    	String content = txtAreaContent.getText();
    	
    	noticecvo.setBn_title(title);
    	noticecvo.setBn_content(content);
    	
    	int result = 0;
    	try {
			result = boardNoticeService.updateBoard(noticecvo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	if(result > 0) {
    		AlertUtil.information("성공", "수정 성공", "입력하신 내용으로 수정이 완료되었습니다");
    	}else {
    		AlertUtil.error("실패", "수정 실패", "수정을 실패하였습니다");
    	}
    	
    	controller.setPage();
    	controller.setBoardListData();
    	Stage stage = (Stage) modifyBtn.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void returnBtnClicked(ActionEvent event) {
    	controller.setBoardListData();
    	Stage stage = (Stage) returnBtn.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void initialize() {
        assert showPane != null : "fx:id=\"showPane\" was not injected: check your FXML file 'AdShowNotice.fxml'.";
        assert txtFieldTitle != null : "fx:id=\"txtFieldTitle\" was not injected: check your FXML file 'AdShowNotice.fxml'.";
        assert txtFieldWriter != null : "fx:id=\"txtFieldWriter\" was not injected: check your FXML file 'AdShowNotice.fxml'.";
        assert txtFieldDate != null : "fx:id=\"txtFieldDate\" was not injected: check your FXML file 'AdShowNotice.fxml'.";
        assert txtFieldCnt != null : "fx:id=\"txtFieldCnt\" was not injected: check your FXML file 'AdShowNotice.fxml'.";
        assert txtAreaContent != null : "fx:id=\"txtAreaContent\" was not injected: check your FXML file 'AdShowNotice.fxml'.";
        assert modifyBtn != null : "fx:id=\"modifyBtn\" was not injected: check your FXML file 'AdShowNotice.fxml'.";
        assert deleteBtn != null : "fx:id=\"deleteBtn\" was not injected: check your FXML file 'AdShowNotice.fxml'.";
        assert returnBtn != null : "fx:id=\"returnBtn\" was not injected: check your FXML file 'AdShowNotice.fxml'.";
        
        modifyBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        deleteBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        returnBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        txtFieldWriter.setEditable(false);
        txtFieldDate.setEditable(false);
        txtFieldCnt.setEditable(false);
        
        
        try {
			
        	Registry reg = LocateRegistry.getRegistry("localhost", 8888);
        	boardNoticeService = (IBoardNoticeService) reg.lookup("boardNoticeService");
        	
        	txtFieldTitle.setText(controller.vo.getBn_title());
        	txtFieldWriter.setText(controller.vo.getMem_id());
        	txtFieldDate.setText(controller.vo.getBn_date());
        	String bn_cnt = "";
        	bn_cnt += controller.vo.getBn_cnt();
        	txtFieldCnt.setText(bn_cnt);
        	txtAreaContent.setText(controller.vo.getBn_content());
        	
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    }
}
