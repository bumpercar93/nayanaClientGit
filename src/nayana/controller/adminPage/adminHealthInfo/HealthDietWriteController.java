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
import java.util.Map;
import java.util.ResourceBundle;

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
import nayana.vo.MemberVO;
import nayana.vo.MyFileVO;
import nayana.vo.RDResultVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class HealthDietWriteController {
	
	private Stage fileStage;
	
	private static MemberVO memVO;
	
	private ObservableList<RDResultVO> itemList;
	private ArrayList<RDResultVO> boardList;
	
	private IRDResultService rDResultService;
	private IMyFileService myFileService;

	
    public static MemberVO getMemVO() {
		return memVO;
	}

	public static void setMemVO(MemberVO memVO) {
		HealthDietWriteController.memVO = memVO;
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
    private ComboBox<String> selectFood;

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
    	
    	if (dietTitle.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "추천 식단 이름이 입력되지 않았습니다.");
    		dietTitle.requestFocus();
    		return;
    	}else if(dietContents.getText().trim().length() == 0) {
    		AlertUtil.error("ERROR", "입력 누락", "추천 식단 내용이 입력되지 않았습니다.");
    		dietContents.requestFocus();
    		return;
    	}
    	
    	RDResultVO rdresultVO = new RDResultVO(); 
		rdresultVO.setRa_code_age(selectAge.getSelectionModel().getSelectedItem());
		rdresultVO.setRdw_code_wt(selectWgh.getSelectionModel().getSelectedItem());
		rdresultVO.setRd_code_dss(selectDss.getSelectionModel().getSelectedItem());
		rdresultVO.setRdf_code_food(selectFood.getSelectionModel().getSelectedItem());
		rdresultVO.setRdr_name(dietTitle.getText());
		rdresultVO.setRdr_content(dietContents.getText());
		
		int result = 0;

		try {
			result = rDResultService.insertResult(rdresultVO);
			if(result > 0) {
	    		//result가 0보다 크면 insert 성공
				AlertUtil.information("success", "글쓰기 성공", "게시글 등록에 성공하였습니다.");
				try {
					
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminHealthInfo/HealthDietList.fxml"));
					Parent root = loader.load();
					
					BorderPane b = (BorderPane) btnCancel.getScene().getRoot();
					b.setCenter(root);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	}else {
	    		AlertUtil.error("error", "글쓰기 실패", "게시글 등록을 실패하였습니다.");
	    		return;
	    	}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("ra_code_age", selectAge.getSelectionModel().getSelectedItem());
		map.put("rd_code_dss", selectDss.getSelectionModel().getSelectedItem());
		map.put("rdw_code_wt", selectWgh.getSelectionModel().getSelectedItem());
		map.put("rdr_name", dietTitle.getText());
		
		int seq = 0;
		try {
			seq = rDResultService.getSeq(map);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(seq <= 0) {
			AlertUtil.error("ERRORFILE", "등록 실패", "식단 등록을 실패 하였습니다.");
			return;
		}
		
		MyFileVO myfileVO = new MyFileVO();
		myfileVO.setFile_bd_code("RD"); //게시판 코드
		myfileVO.setFile_bd_num(seq); //게시판 글 시퀀스
		myfileVO.setFile_original_name(fileOriginalName); //파일 이름
		myfileVO.setFile_server_name("nyn_"+ seq); //서버 파일 이름
		myfileVO.setFile_extension(fileExtension); //파일 확장자
		myfileVO.setFile_size(fileSize); //파일 사이즈
		
		int fileResult = 0;
		try {
			fileResult = myFileService.insertFile(myfileVO);
		} catch (RemoteException e) {
			fileResult = 0;
			e.printStackTrace();
		}
		
		if(fileResult <= 0) {
			AlertUtil.error("ERRORFILEVO", "등록 실패", "식단 등록을 실패 하였습니다.");
			return;
		}else {
			AlertUtil.information("INFORMATION", "등록 성공", "식단 등록을 성공 하였습니다.");
			
		}
    }

    String rootName = "";
    String fileOriginalName = "";
	String fileDdCode = "";
	String fileExtension = "";
	String fileSize = "";
	
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
        assert registBtn != null : "fx:id=\"registBtn\" was not injected: check your FXML file 'HealthDietWrite.fxml'.";
        assert selectAge != null : "fx:id=\"selectAge\" was not injected: check your FXML file 'HealthDietWrite.fxml'.";
        assert selectWgh != null : "fx:id=\"selectWgh\" was not injected: check your FXML file 'HealthDietWrite.fxml'.";
        assert selectDss != null : "fx:id=\"selectDss\" was not injected: check your FXML file 'HealthDietWrite.fxml'.";
        assert selectFood != null : "fx:id=\"selectFood\" was not injected: check your FXML file 'HealthDietWrite.fxml'.";
        assert dietTitle != null : "fx:id=\"dietTitle\" was not injected: check your FXML file 'HealthDietWrite.fxml'.";
        assert dietContents != null : "fx:id=\"dietContents\" was not injected: check your FXML file 'HealthDietWrite.fxml'.";
        assert dietFileName != null : "fx:id=\"dietFileName\" was not injected: check your FXML file 'HealthDietWrite.fxml'.";
        assert btnRegister != null : "fx:id=\"btnRegister\" was not injected: check your FXML file 'HealthDietWrite.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'HealthDietWrite.fxml'.";
        
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
        selectFood.getItems().addAll("밥", "국", "찌개", "찜", "구이", "조림", "볶음");
        
    }
}
