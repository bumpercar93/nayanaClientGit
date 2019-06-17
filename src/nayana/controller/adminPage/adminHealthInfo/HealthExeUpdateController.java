package nayana.controller.adminPage.adminHealthInfo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import nayana.myFile.service.IMyFileService;
import nayana.rEResult.service.IREResultService;
import nayana.vo.MyFileVO;
import nayana.vo.REResultVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class HealthExeUpdateController {
	
	private IREResultService reResultService;
	private IMyFileService myFileService;
	
	private Stage fileStage;
	private static REResultVO reResultVo;
	private static MyFileVO mfVO;

	public static void setMfVO(MyFileVO mfVO) {
		HealthExeUpdateController.mfVO = mfVO;
	}

	public static REResultVO getReResultVo() {
		return reResultVo;
	}

	public static void setReResultVo(REResultVO reResultVo) {
		HealthExeUpdateController.reResultVo = reResultVo;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button registBtn;

    @FXML
    private ComboBox<String> selectAge;

    @FXML
    private ComboBox<String> selectSitu;

    @FXML
    private ComboBox<String> selectDss;

    @FXML
    private TextField exeTitle;

    @FXML
    private TextArea exeContents;

    @FXML
    private TextField exeFileName;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<String> selectPart;

    @FXML
    private ComboBox<String> selectExe;

    @FXML
    void btnCancelCliked(ActionEvent event) {
    	try {
			
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminHealthInfo/HealthExeList.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) btnCancel.getScene().getRoot();
    		b.setCenter(root);
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnRegisterClicked(ActionEvent event) {
    	
    	if(exeTitle.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력누락", "추천 운동 이름을 입력해주세요");
    		exeTitle.requestFocus();
    		return;
    	}else if(exeContents.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력누락", "추천 운동 설명을 입력해주세요");
    		exeContents.requestFocus();
    		return;
    	}
    	
    	if(exeFileName.getText().trim().length() == 0) {
        	REResultVO rerVO = new REResultVO();
        	rerVO.setRa_code_age(selectAge.getSelectionModel().getSelectedItem());
        	rerVO.setRes_code_situ(selectSitu.getSelectionModel().getSelectedItem());
        	rerVO.setRer_code_body(selectPart.getSelectionModel().getSelectedItem());
        	rerVO.setRd_code_dss(selectDss.getSelectionModel().getSelectedItem());
        	rerVO.setRer_code_exe(selectExe.getSelectionModel().getSelectedItem());
        	rerVO.setRer_name(exeTitle.getText());
        	rerVO.setRer_content(exeContents.getText());
        	rerVO.setRer_seq(reResultVo.getRer_seq());
        	
        	int cnt = 0;
        	try {
    			cnt = reResultService.updateExersize(rerVO);
    		} catch (RemoteException e) {
    			e.printStackTrace();
    		}
        	
        	if(cnt > 0) {
        		AlertUtil.information("성공", "수정 성공", "정상적으로 수정되었습니다");
        		
            	try {
        			
            		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminHealthInfo/HealthExeList.fxml"));
            		Parent root = loader.load();
            		
            		BorderPane b = (BorderPane) btnCancel.getScene().getRoot();
            		b.setCenter(root);
            		
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        		
        	}else {
        		AlertUtil.error("실패", "수정 실패", "수정을 실패하였습니다");
        	}
        	
        	
    	}else {
    		REResultVO rerVO = new REResultVO();
    		rerVO.setRa_code_age(selectAge.getSelectionModel().getSelectedItem());
    		rerVO.setRes_code_situ(selectSitu.getSelectionModel().getSelectedItem());
    		rerVO.setRer_code_body(selectPart.getSelectionModel().getSelectedItem());
    		rerVO.setRd_code_dss(selectDss.getSelectionModel().getSelectedItem());
    		rerVO.setRer_code_exe(selectExe.getSelectionModel().getSelectedItem());
    		rerVO.setRer_name(exeTitle.getText());
    		rerVO.setRer_content(exeContents.getText());
    		rerVO.setRer_seq(reResultVo.getRer_seq());
    		
    		int cnt = 0;
    		try {
    			cnt = reResultService.updateExersize(rerVO);
    		} catch (RemoteException e) {
    			e.printStackTrace();
    		}
    		
    		if(cnt <= 0) {
    			AlertUtil.error("ERROR", "수정 실패", "운동 수정을 실패 하였습니다.");
    			return;
    		}
    		
    		MyFileVO myfileVO = new MyFileVO();
    		myfileVO.setFile_bd_code("RE"); //게시판 코드
    		myfileVO.setFile_bd_num(reResultVo.getRer_seq()); //게시판 글 시퀀스
    		myfileVO.setFile_original_name(fileOriginalName); //파일 이름
    		myfileVO.setFile_server_name("nyn_"+ reResultVo.getRer_seq()); //서버 파일 이름
    		myfileVO.setFile_extension(fileExtension); //파일 확장자
    		myfileVO.setFile_size(fileSize);
    		
      		int fileResult = 0;
    		try {
    			fileResult = myFileService.updateFile(myfileVO);
			} catch (RemoteException e) {
				fileResult = 0;
				e.printStackTrace();
			}
    		
    		if(fileResult <= 0) {
    			AlertUtil.error("ERRORFILEVO", "수정 실패", "운동 수정을 실패 하였습니다.");
    			return;
    		}else {
    			AlertUtil.information("INFORMATION", "수정 성공", "운동 수정을 성공 하였습니다.");
    			
    	    	try {
    	    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminHealthInfo/HealthExeList.fxml"));
    	    		Parent root = loader.load();
    	    		
    	    		BorderPane b = (BorderPane) btnCancel.getScene().getRoot();
    	    		b.setCenter(root);
    	    		
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    			
    		}
    		
    	}
    	
    }

    String rootName = "";
    String fileOriginalName = "";
	String fileDdCode = "";
	String fileExtension = "";
	String fileSize = "";
	int bhSeq = reResultVo.getRer_seq();
    
    @FXML
    void regist(ActionEvent event) {
		FileChooser filechooser = new FileChooser();
    	
    	//열기할 파일종류 선택
    	filechooser.getExtensionFilters().addAll(
			new ExtensionFilter("Image Files","*.png","*.jpg","*.gif")
		);
    	
    	//창을 열었을떄 보여줄 폴더
		filechooser.setInitialDirectory(new File("D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\nayanaClient\\src\\util\\images"));
		
		//선택한 파일의 이름과 경로를 보여줌
		File selectedFile = filechooser.showOpenDialog(fileStage);
	
		if(selectedFile != null) {
			String name = selectedFile.getName();
			int index = name.lastIndexOf(".");
			fileOriginalName = name.substring(0, index).trim();
			
			exeFileName.setText(name);
			
			rootName = selectedFile.getPath();
			int idx = rootName.lastIndexOf(".");			
			fileExtension = rootName.substring(idx+1).trim();		
			fileSize = rootName.length() + "Bytes";
			
		}
    }

    @FXML
    void initialize() {
        assert registBtn != null : "fx:id=\"registBtn\" was not injected: check your FXML file 'HealthExeUpdate.fxml'.";
        assert selectAge != null : "fx:id=\"selectAge\" was not injected: check your FXML file 'HealthExeUpdate.fxml'.";
        assert selectSitu != null : "fx:id=\"selectSitu\" was not injected: check your FXML file 'HealthExeUpdate.fxml'.";
        assert selectPart != null : "fx:id=\"selectPart\" was not injected: check your FXML file 'HealthExeUpdate.fxml'.";
        assert selectDss != null : "fx:id=\"selectDss\" was not injected: check your FXML file 'HealthExeUpdate.fxml'.";
        assert selectExe != null : "fx:id=\"selectExe\" was not injected: check your FXML file 'HealthExeUpdate.fxml'.";
        assert exeTitle != null : "fx:id=\"exeTitle\" was not injected: check your FXML file 'HealthExeUpdate.fxml'.";
        assert exeContents != null : "fx:id=\"exeContents\" was not injected: check your FXML file 'HealthExeUpdate.fxml'.";
        assert exeFileName != null : "fx:id=\"exeFileName\" was not injected: check your FXML file 'HealthExeUpdate.fxml'.";
        assert btnRegister != null : "fx:id=\"btnRegister\" was not injected: check your FXML file 'HealthExeUpdate.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'HealthExeUpdate.fxml'.";
        
        btnRegister.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnCancel.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        registBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        try {
			Registry reg = LocateRegistry.getRegistry("localhost",8888);
			reResultService = (IREResultService) reg.lookup("rEResultService");
			myFileService = (IMyFileService) reg.lookup("myFileService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} 
        
        selectAge.getItems().addAll("어린이E","청소년E","청년E","중년E","노년E");
        selectSitu.getItems().addAll("실내","실외","다이어트","임산부");
        selectPart.getItems().addAll("복부","등","어깨","가슴","다리","팔");
        selectDss.getItems().addAll("암E","심혈관E","당뇨E","관절E","뇌질환E","없음E");
        selectExe.getItems().addAll("유산소운동","무산소운동");
  
        selectAge.setValue(reResultVo.getRa_code_age());
        selectSitu.setValue(reResultVo.getRes_code_situ());
        selectPart.setValue(reResultVo.getRer_code_body());
        selectDss.setValue(reResultVo.getRd_code_dss());
        selectExe.setValue(reResultVo.getRer_code_exe());
        exeTitle.setText(reResultVo.getRer_name());
        exeContents.setText(reResultVo.getRer_content());
//      exeFileName.setText(mfVO.getFile_original_name() + "." + mfVO.getFile_extension());
      
    }
}
