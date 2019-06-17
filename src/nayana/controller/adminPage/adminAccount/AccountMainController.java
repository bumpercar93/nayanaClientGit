package nayana.controller.adminPage.adminAccount;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import nayana.controller.adminPage.mainPageA.MainAController;
import nayana.controller.communityPage.NoticeBoardController;
import nayana.member.service.IMemberService;
import nayana.vo.MemberVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class AccountMainController {

	private IMemberService memberService;
	private static MemberVO memvo;
	private static ObservableList<MemberVO> dataList;
	private Stage mainStage;
	
    public static MemberVO getMemvo() {
		return memvo;
	}


	public static ObservableList<MemberVO> getDataList() {
		return dataList;
	}

	public static void setDataList(ObservableList<MemberVO> dataList) {
		AccountMainController.dataList = dataList;
	}

	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
	
	
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<MemberVO> table;

    @FXML
    private TableColumn<MemberVO, String> memRightCol;

    @FXML
    private TableColumn<MemberVO, String> memIdCol;

    @FXML
    private TableColumn<MemberVO, String> memPassCol;

    @FXML
    private TableColumn<MemberVO, String> memNameCol;

    @FXML
    private TableColumn<MemberVO, String> memMailCol;

    @FXML
    private Button registBtn;
    
    @FXML
    private Button adjustBtn;

    @FXML
    private Button deleteBtn;
    
    MemberVO memIndex = null;

    @FXML
    void adjustMem(ActionEvent event) { //멤버 수정하기
    	try {
    		Stage adjustStage = new Stage(StageStyle.DECORATED);
    		adjustStage.initModality(Modality.WINDOW_MODAL);
    		//childStage.initOwner(부모창의 Stage객체);
    		adjustStage.initOwner(mainStage);
    		AccountAdjustController adjustAdmin= null;
    		adjustAdmin.setMemVO(memIndex); // 멤버 정보 넘겨주기
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminAccount/AccountAdjust.fxml"));
    		Parent childRoot = loader.load();
    		adjustAdmin = loader.getController();
    		adjustAdmin.setAdjustStage(adjustStage);
    		
    		AccountAdjustController controller =loader.getController();
    		controller.setAccountmaincontroller(this);
    		
    		Scene scene = new Scene(childRoot);
    		
    		adjustStage.setTitle("계정 수정");
    		adjustStage.setScene(scene);
    		adjustStage.show();

			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    }

    @FXML
    void deleteMem(ActionEvent event) {

    	int cnt=0;
    	
    	System.out.println(memIndex.getMem_id());
    	try {
			cnt = memberService.deleteMember(memIndex.getMem_id());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	System.out.println(cnt);
    	
    	Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
    	if(cnt>0) {
	    	alertConfirm.setTitle("계정삭제완료");
	    	alertConfirm.setHeaderText("계정삭제에 성공하였습니다");
	    	alertConfirm.showAndWait();
		}else {
			alertConfirm.setTitle("계정삭제실패");
	    	alertConfirm.setHeaderText("계정삭제에 실패하였습니다");
	    	alertConfirm.showAndWait();
			
		}
    	
    	settingList();
    
    	
    }

    @FXML
    void memClick(MouseEvent event) {

    	memIndex = table.getSelectionModel().getSelectedItem();
    	
    	
    }

    @FXML
    void registMem(ActionEvent event) {

    	try {
    		Stage signUpStage = new Stage(StageStyle.DECORATED);
    		signUpStage.initModality(Modality.WINDOW_MODAL);
    		//childStage.initOwner(부모창의 Stage객체);
    		signUpStage.initOwner(mainStage);
    		
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminAccount/SignUpAdmin.fxml"));
    		Parent childRoot = loader.load();
    		SignUpAdminController signUpAdmin = loader.getController();
    		signUpAdmin.setSignUpStage(signUpStage);
    		signUpAdmin.setAccountmaincontroller(this);
    		Scene scene = new Scene(childRoot);
    		
    		signUpStage.setTitle("관리자 계정 등록");
    		signUpStage.setScene(scene);
    		signUpStage.show();
    		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    	
    }
    
    
    public void settingList() {
        List<MemberVO> memvo = new ArrayList<MemberVO>();
        try {
			memvo = memberService.getAllMember();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        
        
        dataList = FXCollections.observableArrayList(memvo);
        
        table.setItems(dataList);
    	
    }
    
    @FXML
    void initialize() {
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'AccountMain.fxml'.";
        assert memRightCol != null : "fx:id=\"memRightCol\" was not injected: check your FXML file 'AccountMain.fxml'.";
        assert memIdCol != null : "fx:id=\"memIdCol\" was not injected: check your FXML file 'AccountMain.fxml'.";
        assert memPassCol != null : "fx:id=\"memPassCol\" was not injected: check your FXML file 'AccountMain.fxml'.";
        assert memNameCol != null : "fx:id=\"memNameCol\" was not injected: check your FXML file 'AccountMain.fxml'.";
        assert memMailCol != null : "fx:id=\"memMailCol\" was not injected: check your FXML file 'AccountMain.fxml'.";
        assert adjustBtn != null : "fx:id=\"adjustBtn\" was not injected: check your FXML file 'AccountMain.fxml'.";
        assert deleteBtn != null : "fx:id=\"deleteBtn\" was not injected: check your FXML file 'AccountMain.fxml'.";
        assert registBtn != null : "fx:id=\"registBtn\" was not injected: check your FXML file 'AccountMain.fxml'.";
        
        try {
			Registry reg = LocateRegistry.getRegistry("localhost",8888);
			memberService = (IMemberService) reg.lookup("memberService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch(NotBoundException e) {
			e.printStackTrace();
		}
        
        adjustBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        deleteBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        registBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        
        memRightCol.setCellValueFactory(new PropertyValueFactory<>("mem_right"));
        memIdCol.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
        memPassCol.setCellValueFactory(new PropertyValueFactory<>("mem_pw"));
        memNameCol.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
        memMailCol.setCellValueFactory(new PropertyValueFactory<>("mem_email"));
        
        
        settingList();
    }
}
