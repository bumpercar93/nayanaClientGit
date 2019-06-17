package nayana.controller.adminPage.adminHealthInfo;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
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
import nayana.controller.healthInfoPage.Diet02Controller;
import nayana.rDResult.service.IRDResultService;
import nayana.vo.BoardHealthVO;
import nayana.vo.MemberVO;
import nayana.vo.RDResultVO;
import nayana.vo.REResultVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class HealthDietListController {
	
	private static RDResultVO rdrVO;
	private static MemberVO memVO;
	
	private ObservableList<RDResultVO> itemList;
	private ArrayList<RDResultVO> boardList;
	
	private IRDResultService rDResultService;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<RDResultVO> dietTable;

    @FXML
    private TableColumn<RDResultVO, String> ageCol;

    @FXML
    private TableColumn<RDResultVO, String> wghCol;

    @FXML
    private TableColumn<RDResultVO, String> dssCol;

    @FXML
    private TableColumn<RDResultVO, String> cateCol;

    @FXML
    private TableColumn<RDResultVO, String> nameCol;

    @FXML
    private TableColumn<RDResultVO, String> contentCol;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancelCliked(ActionEvent event) {
    	if(dietTable.getSelectionModel().getSelectedItem()==null) {
    		AlertUtil.warning("WARNING", "선택 누락", "수정하실 목록을 선택해주세요");
    		return;
    	}
    	
    	RDResultVO reResultvo= new RDResultVO();
    	reResultvo = (RDResultVO) dietTable.getSelectionModel().getSelectedItem();
    	
    	try {
			
    		HealthDietUpdateController.setRdrVO(reResultvo);
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminHealthInfo/HealthDietUpdate.fxml"));
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
    		HealthDietWriteController.setMemVO(memVO);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminHealthInfo/HealthDietWrite.fxml"));
			Parent root = loader.load();
			
			BorderPane b = (BorderPane) btnCancel.getScene().getRoot();
			b.setCenter(root);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void dietTableClicked(MouseEvent event) {
    }

    @FXML
    void initialize() {
        assert dietTable != null : "fx:id=\"dietTable\" was not injected: check your FXML file 'HealthDietList.fxml'.";
        assert ageCol != null : "fx:id=\"ageCol\" was not injected: check your FXML file 'HealthDietList.fxml'.";
        assert wghCol != null : "fx:id=\"wghCol\" was not injected: check your FXML file 'HealthDietList.fxml'.";
        assert dssCol != null : "fx:id=\"dssCol\" was not injected: check your FXML file 'HealthDietList.fxml'.";
        assert cateCol != null : "fx:id=\"cateCol\" was not injected: check your FXML file 'HealthDietList.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'HealthDietList.fxml'.";
        assert contentCol != null : "fx:id=\"contentCol\" was not injected: check your FXML file 'HealthDietList.fxml'.";
        assert btnRegister != null : "fx:id=\"btnRegister\" was not injected: check your FXML file 'HealthDietList.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'HealthDietList.fxml'.";
        
        btnRegister.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnCancel.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        try {
    		Registry reg = LocateRegistry.getRegistry("localhost", 8888);
    		rDResultService = (IRDResultService) reg.lookup("rDResultService");
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	} catch (NotBoundException e) {
    		e.printStackTrace();
    	}
        
        ageCol.setCellValueFactory(new PropertyValueFactory<>("ra_code_age"));
        wghCol.setCellValueFactory(new PropertyValueFactory<>("rdw_code_wt"));
        dssCol.setCellValueFactory(new PropertyValueFactory<>("rd_code_dss"));
        cateCol.setCellValueFactory(new PropertyValueFactory<>("rdf_code_food"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("rdr_name"));
        contentCol.setCellValueFactory(new PropertyValueFactory<>("rdr_content"));
        
        //리스트 셋팅
        setBoardListData();
    }
    
    public void setBoardListData() {
    	try {
			boardList = (ArrayList<RDResultVO>) rDResultService.getAllList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	itemList = FXCollections.observableArrayList(boardList);
    	dietTable.setItems(itemList);
    }
}
