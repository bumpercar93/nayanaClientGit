package nayana.controller.adminPage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nayana.boardHealth.service.IBoardHealthService;
import nayana.controller.adminPage.adminHealthInfo.HealthDietUpdateController;
import nayana.controller.communityPage.HCListController;
import nayana.controller.communityPage.HCViewController;
import nayana.controller.communityPage.HCWriteController;
import nayana.member.service.IMemberService;
import nayana.vo.BoardHealthVO;
import nayana.vo.MemberVO;
import util.AlertUtil;

public class AdminHCListController {
	
	private static MemberVO memVo;
	private BoardHealthVO bhVo;
	
	private ObservableList<BoardHealthVO> itemList;
	private ArrayList<BoardHealthVO> boardList;
	
	private Stage primaryStage;
	
	private IMemberService memberService;
	private IBoardHealthService boardHealthService;


	public static MemberVO getMemVo() {
		return memVo;
	}

	public static void setMemVo(MemberVO memVo) {
		AdminHCListController.memVo = memVo;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	private ObservableList<BoardHealthVO> datalist = null;
	
	private final int rowPerPage = 15;
	
	public void setPage() {
	       pagination.setPageCount( (int)Math.ceil( (double)itemList.size() / rowPerPage) );
	       pagination.setCurrentPageIndex(0);
	       pagination.setMaxPageIndicatorCount(10);
	    }
	
	public void changeTableView(int index) {
	       
	       int fromIndex = index * rowPerPage; // 시작 위치
	       int toIndex = Math.min(fromIndex + rowPerPage, itemList.size() ); // 종료 위치
	       
	       HCTable.setItems(FXCollections.observableArrayList( itemList.subList(fromIndex, toIndex) ));
	       
	    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnWrite;

    @FXML
    private Rectangle rec1;

    @FXML
    private TableView<BoardHealthVO> HCTable;

    @FXML
    private TableColumn<?, ?> HCNum;

    @FXML
    private TableColumn<?, ?> HCTitle;

    @FXML
    private TableColumn<?, ?> HCDate;

    @FXML
    private TableColumn<?, ?> HCCnt;

    @FXML
    private Pagination pagination;

    @FXML
    private TextField searchField;

    @FXML
    private Button btnSearch;

    @FXML
    void HCTableClicked(MouseEvent event) {
    	BoardHealthVO healthvo =  HCTable.getSelectionModel().getSelectedItem();
    	bhVo = HCTable.getSelectionModel().getSelectedItem();
        
        if(bhVo != null) {
        	try {
    			
        		AdminHCViewController.setBhVO(bhVo);
        		AdminHCViewController.setMemVo(memVo);
        		
        		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/adminPage/AdminHCView.fxml"));
        		Parent root = loader.load();
        		
        		BorderPane b = (BorderPane) btnSearch.getScene().getRoot();
        		b.setCenter(root);
        		
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
        
        if(healthvo != null) {
            try {
            	boardHealthService.boardCnt(bhVo.getBh_seq());
           } catch (RemoteException e) {
              e.printStackTrace();
           }
         }
        
        HCTable.getSelectionModel().clearSelection();
		setBoardListData();  
    }

    @FXML
    void btnSearchClicked(ActionEvent event) {
    	String keyword = searchField.getText().trim();
    	
    	if(searchField.getText().length() == 0) {
    		AlertUtil.warning("warning", "검색오류", "검색어를 입력해주세요.");
    		searchField.requestFocus();
    		return;
    	}
    	
    	ArrayList<BoardHealthVO> searchList = null;
    	
    	try {
			searchList = (ArrayList<BoardHealthVO>) boardHealthService.searchBoard(keyword);
			
			if(searchList.isEmpty()) {
	    		searchList = (ArrayList<BoardHealthVO>) boardHealthService.getAllBoard();
	    		 AlertUtil.information("information", "검색실패", "검색 조건에 맞는 게시글이 없습니다.");
	             return;
	    	}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

    	itemList = FXCollections.observableArrayList(searchList);
    	HCTable.setItems(itemList);
    	
    	pagination.setPageCount((int) Math.ceil((double)datalist.size()/rowPerPage));
        pagination.setCurrentPageIndex(0);
        pagination.setMaxPageIndicatorCount(10);
    }

    @FXML
    void btnWriteClicked(ActionEvent event) {
    	try {
			
    		AdminHCWriteController.setMemVo(memVo);
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/adminPage/AdminHCWrite.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) btnSearch.getScene().getRoot();
    		b.setCenter(root);
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void setBoardListData() {
    	try {
			boardList = (ArrayList<BoardHealthVO>) boardHealthService.getAllBoard();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	itemList = FXCollections.observableArrayList(boardList);
		HCTable.setItems(itemList);
    }

    @FXML
    void initialize() {
        assert btnWrite != null : "fx:id=\"btnWrite\" was not injected: check your FXML file 'AdminHCList.fxml'.";
        assert rec1 != null : "fx:id=\"rec1\" was not injected: check your FXML file 'AdminHCList.fxml'.";
        assert HCTable != null : "fx:id=\"HCTable\" was not injected: check your FXML file 'AdminHCList.fxml'.";
        assert HCNum != null : "fx:id=\"HCNum\" was not injected: check your FXML file 'AdminHCList.fxml'.";
        assert HCTitle != null : "fx:id=\"HCTitle\" was not injected: check your FXML file 'AdminHCList.fxml'.";
        assert HCDate != null : "fx:id=\"HCDate\" was not injected: check your FXML file 'AdminHCList.fxml'.";
        assert HCCnt != null : "fx:id=\"HCCnt\" was not injected: check your FXML file 'AdminHCList.fxml'.";
        assert pagination != null : "fx:id=\"pagination\" was not injected: check your FXML file 'AdminHCList.fxml'.";
        assert searchField != null : "fx:id=\"searchField\" was not injected: check your FXML file 'AdminHCList.fxml'.";
        assert btnSearch != null : "fx:id=\"btnSearch\" was not injected: check your FXML file 'AdminHCList.fxml'.";
        
        try {
    		Registry reg = LocateRegistry.getRegistry("localhost", 8888);
    		memberService = (IMemberService) reg.lookup("memberService");
    		boardHealthService = (IBoardHealthService) reg.lookup("boardHealthService");
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	} catch (NotBoundException e) {
    		e.printStackTrace();
    	}

        setBoardListData();
        
        HCNum.setCellValueFactory(new PropertyValueFactory<>("bh_seq"));
        HCTitle.setCellValueFactory(new PropertyValueFactory<>("bh_title"));
        HCDate.setCellValueFactory(new PropertyValueFactory<>("bh_date"));
        HCCnt.setCellValueFactory(new PropertyValueFactory<>("bh_cnt"));
        
        setPage();
        
        pagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, 
                  Number oldValue, Number newValue) {
               changeTableView(newValue.intValue()); // 선택한 페이지의 index값을
                                            // 인자값으로 changeTableView()메서드 호출
            }
         });
    }
}
