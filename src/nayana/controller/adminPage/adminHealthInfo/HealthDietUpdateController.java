package nayana.controller.adminPage.adminHealthInfo;

import java.io.File;
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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import nayana.rDResult.service.IRDResultService;
import nayana.vo.MyFileVO;
import nayana.vo.RDResultVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class HealthDietUpdateController {
	
	private Stage fileStage;
	
	private static RDResultVO rdrVO;
	
	private ObservableList<RDResultVO> itemList;
	private ArrayList<RDResultVO> boardList;
	
	private IRDResultService rDResultService;
	private IMyFileService myFileService;
	

    public static RDResultVO getRdrVO() {
		return rdrVO;
	}

	public static void setRdrVO(RDResultVO rdrVO) {
		HealthDietUpdateController.rdrVO = rdrVO;
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
    private ComboBox<String> selectWgh;

    @FXML
    private ComboBox<String> selectDss;

    @FXML
    private TextField dietTitle;

    @FXML
    private TextArea dietContents;

    @FXML
    private TextField dietFileName;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<String> s;

    @FXML
    void btnCancelCliked(ActionEvent event) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminHealthInfo/HealthDietList.fxml"));
			Parent root = loader.load();
			
			BorderPane b = (BorderPane) btnCancel.getScene().getRoot();
			b.setCenter(root);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnRegisterClicked(ActionEvent event) {
    	
    	if(dietTitle.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "추천 식단 이름이 입력되지 않았습니다.");
    		dietTitle.requestFocus();
    		return;
    	}else if(dietContents.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "추천 식단 내용이 입력되지 않았습니다.");
    		dietContents.requestFocus();
    		return;
    	}
    	
    	if(dietFileName.getText().trim().length() == 0) {
    		RDResultVO rdresultVO = new RDResultVO(); 
    		rdresultVO.setRa_code_age(selectAge.getSelectionModel().getSelectedItem());
    		rdresultVO.setRdw_code_wt(selectWgh.getSelectionModel().getSelectedItem());
    		rdresultVO.setRd_code_dss(selectDss.getSelectionModel().getSelectedItem());
    		rdresultVO.setRdf_code_food(s.getSelectionModel().getSelectedItem());
    		rdresultVO.setRdr_name(dietTitle.getText());
    		rdresultVO.setRdr_content(dietContents.getText());
    		
    		int result = 0;
    		try {
				result = rDResultService.updateResult(rdresultVO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		
    		if(result > 0) {
    			AlertUtil.information("INFORMATION", "수정 성공", "식단 수정을 성공 하였습니다.");
    			try {
    				
    				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminHealthInfo/HealthDietList.fxml"));
    				Parent root = loader.load();
    				
    				BorderPane b = (BorderPane) btnCancel.getScene().getRoot();
    				b.setCenter(root);
    				
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}else {
    			AlertUtil.error("ERROR", "수정 실패", "식단 수정을 실패 하였습니다.");
    		}
    		
    	}else {
    		
    		//파일첨부가 됐누냥
    		RDResultVO rdresultVO = new RDResultVO(); 
    		rdresultVO.setRdr_seq(rdrVO.getRdr_seq());
    		rdresultVO.setRa_code_age(selectAge.getSelectionModel().getSelectedItem());
    		rdresultVO.setRdw_code_wt(selectWgh.getSelectionModel().getSelectedItem());
    		rdresultVO.setRd_code_dss(selectDss.getSelectionModel().getSelectedItem());
    		rdresultVO.setRdf_code_food(s.getSelectionModel().getSelectedItem());
    		rdresultVO.setRdr_name(dietTitle.getText());
    		rdresultVO.setRdr_content(dietContents.getText());
    		
    		int result = 0;
    		try {
				result = rDResultService.updateResult(rdresultVO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		
    		if(result <= 0) {
    			AlertUtil.error("ERROR", "수정 실패", "식단 수정을 실패 하였습니다.");
    			return;
    		}
    		
    		
    		MyFileVO myfileVO = new MyFileVO();
    		myfileVO.setFile_bd_code("RD"); //게시판 코드
    		myfileVO.setFile_bd_num(rdrVO.getRdr_seq()); //게시판 글 시퀀스
    		myfileVO.setFile_original_name(fileOriginalName); //파일 이름
    		myfileVO.setFile_server_name("nyn_"+ rdrVO.getRdr_seq()); //서버 파일 이름
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
    			AlertUtil.error("ERRORFILEVO", "수정 실패", "식단 수정을 실패 하였습니다.");
    			return;
    		}else {
    			AlertUtil.information("INFORMATION", "수정 성공", "식단 수정을 성공 하였습니다.");
    			
    	    	try {
    	    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminHealthInfo/HealthDietList.fxml"));
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
	int bhSeq = rdrVO.getRdr_seq();

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
			
			dietFileName.setText(name);
			
			rootName = selectedFile.getPath();
			int idx = rootName.lastIndexOf(".");			
			fileExtension = rootName.substring(idx+1).trim();		
			fileSize = rootName.length() + "Bytes";
			
		}
    }

    @FXML
    void initialize() {
        assert registBtn != null : "fx:id=\"registBtn\" was not injected: check your FXML file 'HealthDietUpdate.fxml'.";
        assert selectAge != null : "fx:id=\"selectAge\" was not injected: check your FXML file 'HealthDietUpdate.fxml'.";
        assert selectWgh != null : "fx:id=\"selectWgh\" was not injected: check your FXML file 'HealthDietUpdate.fxml'.";
        assert selectDss != null : "fx:id=\"selectDss\" was not injected: check your FXML file 'HealthDietUpdate.fxml'.";
        assert dietTitle != null : "fx:id=\"dietTitle\" was not injected: check your FXML file 'HealthDietUpdate.fxml'.";
        assert dietContents != null : "fx:id=\"dietContents\" was not injected: check your FXML file 'HealthDietUpdate.fxml'.";
        assert dietFileName != null : "fx:id=\"dietFileName\" was not injected: check your FXML file 'HealthDietUpdate.fxml'.";
        assert btnRegister != null : "fx:id=\"btnRegister\" was not injected: check your FXML file 'HealthDietUpdate.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'HealthDietUpdate.fxml'.";
        assert s != null : "fx:id=\"s\" was not injected: check your FXML file 'HealthDietUpdate.fxml'.";
        
        registBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnRegister.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnCancel.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        try {
    		Registry reg = LocateRegistry.getRegistry("localhost", 8888);
    		rDResultService = (IRDResultService) reg.lookup("rDResultService");
    		myFileService = (IMyFileService) reg.lookup("myFileService");
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	} catch (NotBoundException e) {
    		e.printStackTrace();
    	}
        
        selectAge.getItems().addAll("어린이D", "청소년D", "청년D", "중년D", "노년D");
        selectWgh.getItems().addAll("저체중", "정상체중", "과체중");
        selectDss.getItems().addAll("암D", "심혈관D", "당뇨D", "관절D", "뇌질환D", "없음D");
        s.getItems().addAll("밥", "국", "찌개", "찜", "구이", "조림", "볶음");
        
        selectAge.setValue(rdrVO.getRa_code_age());
        selectWgh.setValue(rdrVO.getRdw_code_wt());
        selectDss.setValue(rdrVO.getRd_code_dss());
        s.setValue(rdrVO.getRdf_code_food());
        
        dietTitle.setText(rdrVO.getRdr_name());
        dietContents.setText(rdrVO.getRdr_content());
       
    }

}
