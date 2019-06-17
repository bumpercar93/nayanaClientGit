package nayana.controller.adminPage;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nayana.boardNotice.service.IBoardNoticeService;
import nayana.controller.communityPage.NoticeBoardController;
import nayana.vo.BoardNoticeVO;
import nayana.vo.MemberVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class AdRegisterNoticeController {
	
	private static MemberVO memVO;
	
	public static MemberVO getMemVO() {
		return memVO;
	}

	public static void setMemVO(MemberVO memVO) {
		AdRegisterNoticeController.memVO = memVO;
	}
	
	// --- //
	private IBoardNoticeService boardNoticeService;
	
	private AdNoticeBoardController noticeBoardController; 
	
	public void setNoticeBoardController(AdNoticeBoardController noticeBoardController) {
		this.noticeBoardController = noticeBoardController;
	}

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
    private TextField txtFieldTitle;

    @FXML
    private TextArea txtAreaContent;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button risisterBtn;

    @FXML
    void cancelBtnClicked(ActionEvent event) {

    	Stage stage = (Stage) cancelBtn.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void resisterBtnClicked(ActionEvent event) {
    	
    	try {
    		BoardNoticeVO vo = new BoardNoticeVO();
    		vo.setBn_title(txtFieldTitle.getText());
    		vo.setBn_content(txtAreaContent.getText());
    		vo.setMem_id(memVO.getMem_id());
    		vo.setBn_updatewt(memVO.getMem_id());
//    		vo.setMem_id("kim52");
//    		vo.setBn_updatewt("kim52");
    		
    		int result = boardNoticeService.insertBoard(vo);
    		if(result > 0) {
    			AlertUtil.information("성공", "추가 작업 성공", "추가에 성공");
    		}else {
    			AlertUtil.error("실패", "추가 작업 실패", "추가에 실패");
    		}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	noticeBoardController.setBoardListData();
    	noticeBoardController.setPage();
    	
    	Stage stage = (Stage) risisterBtn.getScene().getWindow();
    	stage.close();
    	
    }
    
    @FXML
    void initialize() {
        assert txtFieldTitle != null : "fx:id=\"txtFieldTitle\" was not injected: check your FXML file 'RegisterNotice.fxml'.";
        assert txtAreaContent != null : "fx:id=\"txtAreaContent\" was not injected: check your FXML file 'RegisterNotice.fxml'.";
        assert cancelBtn != null : "fx:id=\"cancelBtn\" was not injected: check your FXML file 'RegisterNotice.fxml'.";
        assert risisterBtn != null : "fx:id=\"risisterBtn\" was not injected: check your FXML file 'RegisterNotice.fxml'.";
        
        cancelBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        risisterBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        try {
        	Registry reg = LocateRegistry.getRegistry("localhost",8888);
        	boardNoticeService = (IBoardNoticeService) reg.lookup("boardNoticeService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
        
    }
    
}
