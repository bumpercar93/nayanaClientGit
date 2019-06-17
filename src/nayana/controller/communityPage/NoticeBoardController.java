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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nayana.boardNotice.service.IBoardNoticeService;
import nayana.vo.BoardNoticeVO;
import nayana.vo.MemberVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class NoticeBoardController {
   
   private ObservableList<BoardNoticeVO> datalist = null;
   
   private List<BoardNoticeVO> list = null;
   
   private static MemberVO memVO;
   
   public static MemberVO getMemVO() {
      return memVO;
   }

   public static void setMemVO(MemberVO memVO) {
      NoticeBoardController.memVO = memVO;
   }

   private final int rowPerPage = 15; // 한 화면에 보여줄 데이터(레코드) 수
   
   private Stage primaryStage;
   
    public Stage getPrimaryStage() {
      return primaryStage;
   }

   public void setPrimaryStage(Stage primaryStage) {
      this.primaryStage = primaryStage;
   }
   
    private IBoardNoticeService boardNoticeService;
    
    private ArrayList<BoardNoticeVO> boardlist;
   
    public static BoardNoticeVO vo;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<BoardNoticeVO> tableView;

    @FXML
    private TableColumn<?, ?> numberCol;

    @FXML
    private TableColumn<?, ?> titleCol;

    @FXML
    private TableColumn<?, ?> writerCol;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private TableColumn<?, ?> cntCol;

    @FXML
    private Button writeBtn;

    @FXML
    private Pagination pagination;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField SearchtxtField;

    @FXML
    private Button searchBtn;
    
    @FXML
    void comboBoxClicked(ActionEvent event) {

    }

    @FXML
    void searchBtnClicked(ActionEvent event) throws RemoteException {
       
       Map<String, String> map = new HashMap<String, String>();
       String comboValue = comboBox.getSelectionModel().getSelectedItem();
       String text = SearchtxtField.getText();
       
       if(comboValue == null) {
           AlertUtil.error("알림", "검색", "검색조건을 선택해 주세요");
           return;
        }else if (text.trim().length() == 0){
           AlertUtil.warning("알림", "검색", "검색하실 내용을 입력해 주세요");
        }
       
       map.put("keyword", comboValue);
       map.put("value", text);
       
       try {
          list = boardNoticeService.getSearchBoardList(map);
          
          if(list.size() == 0) {
             AlertUtil.information("알림", "검색실패", "검색 조건에 맞는 게시글이 없습니다.");
             return;
          }
          
      } catch (Exception e) {
         e.printStackTrace();
      }
       
       datalist = FXCollections.observableArrayList(list);
       
       tableView.setItems(datalist);
       
       pagination.setPageCount((int) Math.ceil((double)datalist.size()/rowPerPage));
       pagination.setCurrentPageIndex(0);
       pagination.setMaxPageIndicatorCount(10);
       
    }

    @FXML
    void tableViewClicked(MouseEvent event) {
       BoardNoticeVO noticeVo = tableView.getSelectionModel().getSelectedItem();
       vo = tableView.getSelectionModel().getSelectedItem();
       
       if(noticeVo == null) {
          return;
       }
       
       try {
          
          Stage showlist = new Stage();
          showlist.initModality(Modality.WINDOW_MODAL);
          showlist.setResizable(false);
          showlist.initOwner(primaryStage);
          showlist.setTitle("게시글 보여주기");
          
          FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/communityPage/ShowNotice.fxml"));
          Parent shownoti = loader.load();
          
          ShowNoticeController controller = loader.getController(); // ---
          controller.setNoticecvo(vo); // ---
          controller.setNoticeBoardController(this);
          
          Scene scene = new Scene(shownoti);
          showlist.setScene(scene);
          showlist.show();
          
      } catch (IOException e) {
         e.printStackTrace();
      }
       
       if(noticeVo != null) {
          try {
             boardNoticeService.setCountIncrement(noticeVo.getBn_seq());
         } catch (RemoteException e) {
            e.printStackTrace();
         }
       }
       
    }

    @FXML
    void writeBtnClicked(ActionEvent event) {
          
       try {
          
         Stage writeNotice = new Stage();
         writeNotice.initModality(Modality.WINDOW_MODAL);
         writeNotice.setResizable(false);
         writeNotice.initOwner(primaryStage);
         writeNotice.setTitle("글쓰기");
         
         RegisterNoticeController.setMemVO(memVO); ////////////////////// 넘겨주기
          
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/communityPage/RegisterNotice.fxml"));
         Parent root = loader.load();
         
         RegisterNoticeController controller = loader.getController(); // 새로 데이터
         controller.setNoticeBoardController(this); ////////////////////////////////////////////////////////
         
         Scene scene = new Scene(root);
         writeNotice.setScene(scene);
         writeNotice.show();
          
      } catch (IOException e) {
         e.printStackTrace();
      }
       

       
    }
    
    public void setBoardListData() {
       try {
         boardlist = (ArrayList<BoardNoticeVO>) boardNoticeService.getAllBoardList();
      } catch (RemoteException e) {
         e.printStackTrace();
      }
       
       datalist = FXCollections.observableArrayList(boardlist);
       
       tableView.setItems(datalist);
    }
    
    public void changeTableView(int index) {
       
       int fromIndex = index * rowPerPage; // 시작 위치
       int toIndex = Math.min(fromIndex + rowPerPage, datalist.size() ); // 종료 위치
       
       tableView.setItems(FXCollections.observableArrayList( datalist.subList(fromIndex, toIndex) ));
       
    }
    
    public void setPage() {
       pagination.setPageCount( (int)Math.ceil( (double)datalist.size() / rowPerPage) );
       pagination.setCurrentPageIndex(0);
       pagination.setMaxPageIndicatorCount(10);
    }
    
    @FXML
    void initialize() {
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'NoticeBoard.fxml'.";
        assert numberCol != null : "fx:id=\"numberCol\" was not injected: check your FXML file 'NoticeBoard.fxml'.";
        assert titleCol != null : "fx:id=\"titleCol\" was not injected: check your FXML file 'NoticeBoard.fxml'.";
        assert writerCol != null : "fx:id=\"writerCol\" was not injected: check your FXML file 'NoticeBoard.fxml'.";
        assert dateCol != null : "fx:id=\"dateCol\" was not injected: check your FXML file 'NoticeBoard.fxml'.";
        assert cntCol != null : "fx:id=\"cntCol\" was not injected: check your FXML file 'NoticeBoard.fxml'.";
        assert writeBtn != null : "fx:id=\"writeBtn\" was not injected: check your FXML file 'NoticeBoard.fxml'.";
        assert pagination != null : "fx:id=\"pagination\" was not injected: check your FXML file 'NoticeBoard.fxml'.";
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'NoticeBoard.fxml'.";
        assert SearchtxtField != null : "fx:id=\"SearchtxtField\" was not injected: check your FXML file 'NoticeBoard.fxml'.";
        assert searchBtn != null : "fx:id=\"searchBtn\" was not injected: check your FXML file 'NoticeBoard.fxml'.";
        
        writeBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        searchBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        writeBtn.setVisible(false);
        
        try {
         Registry reg = LocateRegistry.getRegistry("localhost",8888);
         boardNoticeService = (IBoardNoticeService) reg.lookup("boardNoticeService");

      } catch (RemoteException e) {
         e.printStackTrace();
      } catch (NotBoundException e) {
         e.printStackTrace();
      }
        
        setBoardListData();
        
        numberCol.setCellValueFactory(new PropertyValueFactory<>("bn_seq"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("bn_title"));
        writerCol.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("bn_date"));
        cntCol.setCellValueFactory(new PropertyValueFactory<>("bn_cnt"));
        
       pagination.setPageCount( (int)Math.ceil( (double)datalist.size() / rowPerPage) );
       pagination.setCurrentPageIndex(0);
       pagination.setMaxPageIndicatorCount(10);
        
       changeTableView(0);
       
       pagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {

         @Override
         public void changed(ObservableValue<? extends Number> observable, 
               Number oldValue, Number newValue) {
            changeTableView(newValue.intValue()); // 선택한 페이지의 index값을
                                         // 인자값으로 changeTableView()메서드 호출
         }
      });
       
        comboBox.getItems().addAll("제목","작성자","내용");
        
    }
}