package nayana.controller.adminPage.adminHealthInfo;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import nayana.myFile.service.IMyFileService;
import nayana.rEResult.service.IREResultService;
import nayana.vo.MemberVO;
import nayana.vo.MyFileVO;
import nayana.vo.REResultVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class HealthExeListController {
	
	private static MemberVO memVO;
	
	private IREResultService reResultService;
	private IMyFileService myFileService;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<REResultVO> dietTable;

    @FXML
    private TableColumn<?, ?> ageCol;

    @FXML
    private TableColumn<?, ?> ageCol1;

    @FXML
    private TableColumn<?, ?> wghCol;

    @FXML
    private TableColumn<?, ?> dssCol;

    @FXML
    private TableColumn<?, ?> cateCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> contentCol;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancelCliked(ActionEvent event) { // 수정 버튼 클릭시
    	if(dietTable.getSelectionModel().getSelectedItem()==null) {
    		AlertUtil.warning("WARNING", "선택 누락", "수정하실 목록을 선택해주세요");
    		return;
    	}
    	
    	REResultVO reResultvo= new REResultVO();
    	reResultvo = (REResultVO) dietTable.getSelectionModel().getSelectedItem();
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("file_bd_code", "RE");
    	map.put("file_bd_num", reResultvo.getRer_seq());
    	
    	MyFileVO mfVO = new MyFileVO();
    	
    	try {
    		mfVO = myFileService.getFileName(map);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
    	
    	try {
    		HealthExeUpdateController.setReResultVo(reResultvo);
    		HealthExeUpdateController.setMfVO(mfVO);
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminHealthInfo/HealthExeUpdate.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) btnCancel.getScene().getRoot();
    		b.setCenter(root);
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnRegisterClicked(ActionEvent event) {
    	try {
    		HealthExeWriteController.setMemVO(memVO);
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminHealthInfo/HealthExeWrite.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) btnCancel.getScene().getRoot();
    		b.setCenter(root);
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void dietTableClicked(MouseEvent event) { // 구현 안함
    	
    }

    private List<REResultVO> reList;
    private ObservableList<REResultVO> obList;
    
    public void setting() {
        try {
        	reList = reResultService.getAllList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        
        obList = FXCollections.observableArrayList(reList);
        dietTable.setItems(obList);
        
    }
    
    @FXML
    void initialize() {
        assert dietTable != null : "fx:id=\"dietTable\" was not injected: check your FXML file 'HealthExeList.fxml'.";
        assert ageCol != null : "fx:id=\"ageCol\" was not injected: check your FXML file 'HealthExeList.fxml'.";
        assert ageCol1 != null : "fx:id=\"ageCol1\" was not injected: check your FXML file 'HealthExeList.fxml'.";
        assert wghCol != null : "fx:id=\"wghCol\" was not injected: check your FXML file 'HealthExeList.fxml'.";
        assert dssCol != null : "fx:id=\"dssCol\" was not injected: check your FXML file 'HealthExeList.fxml'.";
        assert cateCol != null : "fx:id=\"cateCol\" was not injected: check your FXML file 'HealthExeList.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'HealthExeList.fxml'.";
        assert contentCol != null : "fx:id=\"contentCol\" was not injected: check your FXML file 'HealthExeList.fxml'.";
        assert btnRegister != null : "fx:id=\"btnRegister\" was not injected: check your FXML file 'HealthExeList.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'HealthExeList.fxml'.";
        
        btnRegister.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnCancel.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        try {
			Registry reg = LocateRegistry.getRegistry("localhost",8888);
			reResultService = (IREResultService) reg.lookup("rEResultService");
			myFileService = (IMyFileService) reg.lookup("myFileService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} 
        
        ageCol.setCellValueFactory(new PropertyValueFactory<>("ra_code_age"));
        ageCol1.setCellValueFactory(new PropertyValueFactory<>("res_code_situ"));
        wghCol.setCellValueFactory(new PropertyValueFactory<>("rer_code_body"));
        dssCol.setCellValueFactory(new PropertyValueFactory<>("rd_code_dss"));
        cateCol.setCellValueFactory(new PropertyValueFactory<>("rer_code_exe"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("rer_name"));
        contentCol.setCellValueFactory(new PropertyValueFactory<>("rer_content"));
        
        setting();
        
        

    }
}
