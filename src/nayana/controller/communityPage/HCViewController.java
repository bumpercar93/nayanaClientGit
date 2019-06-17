package nayana.controller.communityPage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nayana.boardHealth.service.IBoardHealthService;
import nayana.member.service.IMemberService;
import nayana.myFile.service.IMyFileService;
import nayana.vo.BoardFlagVO;
import nayana.vo.BoardHealthVO;
import nayana.vo.MemberVO;
import nayana.vo.MyFileVO;
import util.AlertUtil;

public class HCViewController {

	private HCListController hcListController;
	private Stage primaryStage;
	private Stage hcViewStage;
	
	private static BoardHealthVO bhVO;
	private static MemberVO memVO;
	private MyFileVO myfileVO;
	private List<MyFileVO> mfList;
	private List<BoardHealthVO> hcList;
	
	private IBoardHealthService boardHealthService;
	private IMemberService memberService;
	private IMyFileService myFileService;
	
	
    public HCListController getHcListController() {
		return hcListController;
	}

	public void setHcListController(HCListController hcListController) {
		this.hcListController = hcListController;
	}

	public static BoardHealthVO getBhVO() {
		return bhVO;
	}

	public static void setBhVO(BoardHealthVO bhVO) {
		HCViewController.bhVO = bhVO;
	}

	public static MemberVO getMemVo() {
		return memVO;
	}

	public static void setMemVo(MemberVO memVo) {
		HCViewController.memVO = memVo;
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public Stage getHcViewStage() {
		return hcViewStage;
	}

	public void setHcViewStage(Stage hcViewStage) {
		this.hcViewStage = hcViewStage;
	}


	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label viewDate;

    @FXML
    private Label viewTitle;

    @FXML
    private Button btnEdit;

    @FXML
    private ImageView viewImg;

    @FXML
    private TextArea viewTextArea;

    @FXML
    private Button btnList;

    @FXML
    private Button btnDelete;

    @FXML
    void btnDeleteClicked(ActionEvent event) {
    	int result = 0;
    	try {
			result = boardHealthService.deleteBoard(bhVO.getBh_seq());			
			if(result > 0) {
	    		//result가 0보다 크면 insert 성공
				AlertUtil.information("success", "글삭제 성공", "게시글 삭제에 성공하였습니다.");
	    	}else {
	    		AlertUtil.error("error", "글삭제 실패", "게시글 삭제를 실패하였습니다.");
	    		return;
	    	}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	try {
			
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/communityPage/HCList.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) btnEdit.getScene().getRoot();
    		b.setCenter(root);
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void btnEditClicked(ActionEvent event) {
    	try {
    		HCEditController.setHcVo(bhVO);
            HCEditController.setMyfileVO(myfileVO);
            HCEditController.setMemVo(memVO);
			
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/communityPage/HCList.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) btnEdit.getScene().getRoot();
    		b.setCenter(root);
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnListClicked(ActionEvent event) {
    	try {
    		
    		HCListController.setMemVo(memVO);
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/communityPage/HCList.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) btnEdit.getScene().getRoot();
    		b.setCenter(root);
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert viewDate != null : "fx:id=\"viewDate\" was not injected: check your FXML file 'HCView.fxml'.";
        assert viewTitle != null : "fx:id=\"viewTitle\" was not injected: check your FXML file 'HCView.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'HCView.fxml'.";
        assert viewImg != null : "fx:id=\"viewImg\" was not injected: check your FXML file 'HCView.fxml'.";
        assert viewTextArea != null : "fx:id=\"viewTextArea\" was not injected: check your FXML file 'HCView.fxml'.";
        assert btnList != null : "fx:id=\"btnList\" was not injected: check your FXML file 'HCView.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'HCView.fxml'.";
        
        try {
    		Registry reg = LocateRegistry.getRegistry("localhost", 8888);
    		memberService = (IMemberService) reg.lookup("memberService");
    		boardHealthService = (IBoardHealthService) reg.lookup("boardHealthService");
    		myFileService = (IMyFileService) reg.lookup("myFileService");
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	} catch (NotBoundException e) {
    		e.printStackTrace();
    	}
        
        try {
			mfList = myFileService.getAllList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        
        String serverFileName = "";
        String fileExtension = "";
        String fileName = "";
        int fileNum = 0;
        int bcSeq = bhVO.getBh_seq();
        String bdCode = "";
        
        for (int i = 0; i < mfList.size(); i++) {
   	
        	fileNum = mfList.get(i).getFile_bd_num();
        	bdCode = mfList.get(i).getFile_bd_code();
        	
        	if(bcSeq == fileNum && bdCode.equals("HC")) {
            	serverFileName = mfList.get(i).getFile_original_name();
            	fileExtension = mfList.get(i).getFile_extension();
            }
        	
		}
        
        viewDate.setText(bhVO.getBh_date());
        viewTitle.setText(bhVO.getBh_title());
        viewImg.setImage(new Image(getClass().getResourceAsStream("../../../util/images/"+serverFileName+"."+fileExtension)));
        viewTextArea.setText(bhVO.getBh_content());
        
        
        if(memVO.getMem_right().equals("U")) {
        	btnEdit.setVisible(false);
        	btnDelete.setVisible(false);
        	viewTextArea.setEditable(false);
        }else {
        	btnEdit.setVisible(true);
        	btnDelete.setVisible(true);
        	viewTextArea.setEditable(true);
        }


    }
}
