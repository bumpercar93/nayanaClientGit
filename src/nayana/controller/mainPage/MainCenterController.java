package nayana.controller.mainPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nayana.Inbody.service.IInbodyService;
import nayana.boardHealth.service.IBoardHealthService;
import nayana.boardNotice.service.IBoardNoticeService;
import nayana.controller.communityPage.HCViewController;
import nayana.controller.communityPage.NoticeBoardController;
import nayana.controller.communityPage.ShowNoticeController;
import nayana.controller.healthInfoPage.Diet01Controller;
import nayana.controller.healthInfoPage.Exercise01Controller;
import nayana.member.service.IMemberService;
import nayana.myFile.service.IMyFileService;
import nayana.vo.BoardHealthVO;
import nayana.vo.BoardNoticeVO;
import nayana.vo.InbodyVO;
import nayana.vo.MemberVO;
import nayana.vo.MyFileVO;
import util.MyButtonEventHandler;
import util.MyImageViewEventHandler;
import util.MyMenuButtonEventHandler;

public class MainCenterController {
	
	private static MemberVO memVO;
	public static MemberVO getMemVO() {
		return memVO;
	}

	public static void setMemVO(MemberVO memVO) {
		MainCenterController.memVO = memVO;
	}
	
	private static InbodyVO inbodyvo;
	public static InbodyVO getInbodyvo() {
		return inbodyvo;
	}

	public static void setInbodyvo(InbodyVO inbodyvo) {
		MainCenterController.inbodyvo = inbodyvo;
	}

	private IInbodyService inbodyService;
	private IMemberService memberService;
	private IBoardNoticeService boardNoticeService;
	private IBoardHealthService boardHealthService;
	
	private Stage mainStage;
	
	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
	
	List<MemberVO> membervo = new ArrayList<MemberVO>();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ageTxt;

    @FXML
    private Label tallTxt;

    @FXML
    private Label weightTxt;

    @FXML
    private ImageView miseImg2;

    @FXML
    private Label miseTxt2;

    @FXML
    private Label miseSize;

    @FXML
    private Label miseComent;

    @FXML
    private Label nameTxt1;

    @FXML
    private Label bmiTxt;

    @FXML
    private Label txtName3;

    @FXML
    private Label sleepTimeTxt;

    @FXML
    private PieChart sleepTimeGraph;

    @FXML
    private ImageView sportsCucheonImg;

    @FXML
    private ImageView foodChucheonImg;

    @FXML
    private StackedBarChart<String, Number> bmiGraph;

    @FXML
    private TableView<BoardNoticeVO> gonziTable;

    @FXML
    private TableColumn<?, ?> gongziTitle;

    @FXML
    private ImageView contentsImg1;

    @FXML
    private Label contentsTxt1;

    @FXML
    private ImageView contentsImg2;

    @FXML
    private Label contentsTxt2;

    @FXML
    private ImageView contentsImg3;

    @FXML
    private Label contentsTxt3;

    @FXML
    private ImageView contentsImg4;

    @FXML
    private Label contentsTxt4;

    @FXML
    private Button noticegogoBtn;

    @FXML
    void FoodCucheon(MouseEvent event) {
    	try {
    		Diet01Controller.setMemVo(memVO);
    		Diet01Controller.setMainStage(mainStage);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet01.fxml"));
			Parent root = loader.load();
			
			BorderPane borderPane = (BorderPane)nameTxt1.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void SportsCucheon(MouseEvent event) {
    	try {
    		Exercise01Controller.setMemVo(memVO);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise01.fxml"));
			Parent root = loader.load();
			
			BorderPane borderPane = (BorderPane)nameTxt1.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

  //미세먼지 보여주는 함수
    private void misemunzi(MemberVO memVO) {
    	int pmvalue=0;
    	
    	try {
			
			HttpResponse<String> response = Unirest.get("http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureSidoLIst?pageNo=1&numOfRows=10&ServiceKey=gz64Pt5OQ%2BuHPVmcbb6%2Bbcfz1awF9TN8Qk1frgJRqk6bqm3DAHt0TmfMlftw9R8ZNsMp9laZFEnHaAXHUV10Ww%3D%3D&searchCondition=DAILY&sidoName=%EB%8C%80%EC%A0%84&_returnType=json")
					  .header("Content-Type", "application/x-www-form-urlencoded")
					  .header("User-Agent", "PostmanRuntime/7.11.0")
					  .header("Accept", "*/*")
					  .header("Cache-Control", "no-cache")
					  .header("Postman-Token", "534b6b6d-d990-4210-836b-2960d72df37e,734afd69-a337-416e-b66f-217273807fff")
					  .header("Host", "openapi.airkorea.or.kr")
					  .header("cookie", "JSESSIONID=IM7zScGV+AjqQ0YSYThFPemq")
					  .header("accept-encoding", "gzip, deflate")
					  .header("Connection", "keep-alive")
					  .header("cache-control", "no-cache")
					  .asString();
		
			String result = response.getBody();
			JSONObject resultObj = new JSONObject(result);
			JSONArray list = resultObj.getJSONArray("list");
			
			
			for(int i=0; i < 5;i++) {
				JSONObject listObj = list.getJSONObject(i);
				
				if(listObj.get("cityName").toString().equals(memVO.getMem_addr2()) ) {
					miseSize.setText(listObj.get("pm10Value").toString());
					pmvalue = Integer.parseInt(listObj.get("pm10Value").toString());
					
					//Image img = new Image("../util/images/btn_diet.png");
					
					if(pmvalue<=30) {
						miseTxt2.setText("좋음");
						miseComent.setText("외출하기 좋아요");
						miseImg2.setImage(new Image(getClass().getResourceAsStream("../../../util/images/BmiseSmile.png")));
					}else if(30 < pmvalue && pmvalue <=80) {
						miseTxt2.setText("보통");
						miseComent.setText("외출하기 적당해요");
						miseImg2.setImage(new Image(getClass().getResourceAsStream("../../../util/images/BmiseSoso.png")));
					}else if(80 < pmvalue && pmvalue <= 150) {
						miseTxt2.setText("나쁨");
						miseComent.setText("마스크를 쓰세요");
						miseImg2.setImage(new Image(getClass().getResourceAsStream("../../../util/images/BmiseSad.png")));
					}else if(150 < pmvalue && pmvalue > 150) {
						miseTxt2.setText("매우나쁨");
						miseComent.setText("마스크를 꼭 쓰세요");
						miseImg2.setImage(new Image(getClass().getResourceAsStream("../../../util/images/BmiseSad.png")));
					}
					
					break;
					
				}
			
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
    	
    }
    
  //BMI 그래프 그리기
    private void bmiGraphCreate(MemberVO memvo) {
    	InbodyVO inbd = new InbodyVO();
 	   
   	   try {
   		  inbd = inbodyService.callData(memvo.getMem_id());
   	   } catch (RemoteException e) {
   		   e.printStackTrace();
   	   }
    	
   	   double bmi = Double.parseDouble(inbd.getIb_bmi());
   	   
   	   
	   if(bmi < 18.5) {
		   bmiTxt.setText(bmi +"(마름)");
	   }else if(bmi < 23) {
		   bmiTxt.setText(bmi + "(정상)");
	   }else if(bmi < 25) {
		   bmiTxt.setText(bmi + "(위험체중)");
	   }else if(bmi < 30) {
		   bmiTxt.setText(bmi + "(경도비만)");
	   }else if(bmi < 35) {
		   bmiTxt.setText(bmi + "(중도비만)");
	   }else if(bmi >= 35) {
		   bmiTxt.setText(bmi + "(극도비만)");
	   }
   	   
   		   
	   
	   CategoryAxis xAxis = new CategoryAxis();
	   xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("분류",memvo.getMem_name())));
	   
	   NumberAxis yAxis = new NumberAxis();
	   yAxis.setLabel("비만도");
   	
	   //bmiGraph = new StackedBarChart<String, Number>(xAxis, yAxis);
	   double membmiCh = Double.parseDouble(inbd.getIb_bmi());
	   System.out.println(membmiCh);
	   XYChart.Series<String, Number> bmi1 = new XYChart.Series<>();//마름
	   XYChart.Series<String, Number> bmi2 = new XYChart.Series<>();//정상
	   XYChart.Series<String, Number> bmi3 = new XYChart.Series<>();//위험체중
	   XYChart.Series<String, Number> bmi4 = new XYChart.Series<>();//경도비만
	   XYChart.Series<String, Number> bmi5 = new XYChart.Series<>();//중도비만
	   XYChart.Series<String, Number> bmi6 = new XYChart.Series<>();//극도비만
	   
	   bmi1.setName("마름");
	   bmi1.getData().add(new XYChart.Data<>("분류",18.5));
	   bmi2.setName("정상");
	   bmi2.getData().add(new XYChart.Data<>("분류",4.5));
	   bmi3.setName("위험체중");
	   bmi3.getData().add(new XYChart.Data<>("분류",2));
	   bmi4.setName("경도비만");
	   bmi4.getData().add(new XYChart.Data<>("분류",5));
	   bmi5.setName("중도비만");
	   bmi5.getData().add(new XYChart.Data<>("분류",5));
	   bmi6.setName("극도비만");
	   bmi6.getData().add(new XYChart.Data<>("분류",10));
	   
	   while(true) {
		   if((membmiCh-18.5) > 0) {
			   bmi1.getData().add(new XYChart.Data<>(memvo.getMem_name(),18.5));
			   
		   }else {
			   bmi1.getData().add(new XYChart.Data<>(memvo.getMem_name(),membmiCh));
		   }
		   
		   membmiCh -= 18.5;
	   		
		   if((membmiCh-4.5) > 0) {
			   bmi2.getData().add(new XYChart.Data<>(memvo.getMem_name(),4.5));
		   }else {
			   bmi2.getData().add(new XYChart.Data<>(memvo.getMem_name(),membmiCh));
			   break;
		   }
		   membmiCh -= 4.5;
		   
		   if((membmiCh-2) > 0) {
			   bmi3.getData().add(new XYChart.Data<>(memvo.getMem_name(),2));
		   }else {
			   bmi3.getData().add(new XYChart.Data<>(memvo.getMem_name(),membmiCh));
			   break;
		   }
		   membmiCh -= 2;
		   
		   if((membmiCh-5) > 0) {
			   bmi4.getData().add(new XYChart.Data<>(memvo.getMem_name(),5));
		   }else {
			   bmi4.getData().add(new XYChart.Data<>(memvo.getMem_name(),membmiCh));
			   break;
		   }
		   membmiCh -= 5;
		   
		   if((membmiCh-5) > 0) {
			   bmi5.getData().add(new XYChart.Data<>(memvo.getMem_name(),5));
		   }else {
			   bmi5.getData().add(new XYChart.Data<>(memvo.getMem_name(),membmiCh));
			   break;
		   }
		   membmiCh -= 5;
		   
		   if((membmiCh-10) > 0) {
			   bmi6.getData().add(new XYChart.Data<>(memvo.getMem_name(),10));
		   }else {
			   bmi6.getData().add(new XYChart.Data<>(memvo.getMem_name(),membmiCh));
			   break;
		   }
		   membmiCh -= 15;
	   }
	   
	   
   	   bmiGraph.getData().addAll(bmi1,bmi2,bmi3,bmi4,bmi5,bmi6);
   	   
    }
    
    private void noticeInitialize() {
    	
    	gongziTitle.setCellValueFactory(new PropertyValueFactory<>("bn_title"));
    	
    	List<BoardNoticeVO> boardlist = null;
    	ObservableList<BoardNoticeVO> datalist = null;
    	
    	try {
    		boardlist = (ArrayList<BoardNoticeVO>) boardNoticeService.getAllBoardList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	List<BoardNoticeVO> list2 = new ArrayList<BoardNoticeVO>();
    	
    	for(int i=0; i<5 ;i++) {
    		list2.add(boardlist.get(i));
    	}
    	
    	
    	datalist = FXCollections.observableArrayList(list2);
    	
    	gonziTable.setItems(datalist);
    }
    
    BoardNoticeVO noticeIndex = null;
    
    @FXML
    void boardClick(MouseEvent event) {
    	noticeIndex = gonziTable.getSelectionModel().getSelectedItem();
    	clickTableShow();
    }

    private void clickTableShow() {
    	
    	if(noticeIndex == null) {
            return;
         }
         
         try {
            
            Stage showlist = new Stage();
            showlist.initModality(Modality.WINDOW_MODAL);
            showlist.setResizable(false);
            showlist.initOwner(mainStage);
            showlist.setTitle("게시글 보여주기");
            ShowNoticeController.setNoticecvo(noticeIndex);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/communityPage/ShowNotice.fxml"));
            Parent shownoti = loader.load();
            
            ShowNoticeController controller = loader.getController(); // ---
            
            controller.setPrimaryStage(showlist);
            
            Scene scene = new Scene(shownoti);
            showlist.setScene(scene);
            showlist.show();
            
        } catch (IOException e) {
           e.printStackTrace();
        }
         
         if(noticeIndex != null) {
            try {
               boardNoticeService.setCountIncrement(noticeIndex.getBn_seq());
           } catch (RemoteException e) {
              e.printStackTrace();
           }
         }
    	
    	
    }
    
    
    private ObservableList<PieChart.Data> sleep;
    
    
    
    @FXML
    void noticegogo(ActionEvent event) {
    	try {
    		NoticeBoardController.setMemVO(memVO);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/communityPage/NoticeBoard.fxml"));
			Parent root = loader.load();
			
			BorderPane borderPane = (BorderPane)nameTxt1.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    //메인에 헬스정보 주는 부분
    private void healthContent() {
    	
    	List<BoardHealthVO> list = new ArrayList<BoardHealthVO>();
    	
    	try {
     		  list = boardHealthService.recentData();
     	   } catch (RemoteException e) {
     		   e.printStackTrace();
     	   }
    	
    }
    

    @FXML
    void clickImg1(MouseEvent event) {
    	try {
			
    		HCViewController.setBhVO(bumList.get(0));
            HCViewController.setMemVo(memVO);
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/communityPage/HCView.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) bmiTxt.getScene().getRoot();
    		b.setCenter(root);
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickImg2(MouseEvent event) {
    	try {
			
    		HCViewController.setBhVO(bumList.get(1));
            HCViewController.setMemVo(memVO);
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/communityPage/HCView.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) bmiTxt.getScene().getRoot();
    		b.setCenter(root);
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickImg3(MouseEvent event) {
    	try {
			
    		HCViewController.setBhVO(bumList.get(2));
            HCViewController.setMemVo(memVO);
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/communityPage/HCView.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) bmiTxt.getScene().getRoot();
    		b.setCenter(root);
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickImg4(MouseEvent event) {
    	try {
			
    		HCViewController.setBhVO(bumList.get(3));
            HCViewController.setMemVo(memVO);
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/communityPage/HCView.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) bmiTxt.getScene().getRoot();
    		b.setCenter(root);
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    private IMyFileService myFileService;
    private List<BoardHealthVO> bumList;
    @FXML
    void initialize() {
        assert ageTxt != null : "fx:id=\"ageTxt\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert tallTxt != null : "fx:id=\"tallTxt\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert weightTxt != null : "fx:id=\"weightTxt\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert miseImg2 != null : "fx:id=\"miseImg2\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert miseTxt2 != null : "fx:id=\"miseTxt2\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert miseSize != null : "fx:id=\"miseSize\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert miseComent != null : "fx:id=\"miseComent\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert nameTxt1 != null : "fx:id=\"nameTxt1\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert bmiTxt != null : "fx:id=\"bmiTxt\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert txtName3 != null : "fx:id=\"txtName3\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert sleepTimeTxt != null : "fx:id=\"sleepTimeTxt\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert sleepTimeGraph != null : "fx:id=\"sleepTimeGraph\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert sportsCucheonImg != null : "fx:id=\"sportsCucheonImg\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert foodChucheonImg != null : "fx:id=\"foodChucheonImg\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert bmiGraph != null : "fx:id=\"bmiGraph\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert gonziTable != null : "fx:id=\"gonziTable\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert gongziTitle != null : "fx:id=\"gongziTitle\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert contentsImg1 != null : "fx:id=\"contentsImg1\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert contentsTxt1 != null : "fx:id=\"contentsTxt1\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert contentsImg2 != null : "fx:id=\"contentsImg2\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert contentsTxt2 != null : "fx:id=\"contentsTxt2\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert contentsImg3 != null : "fx:id=\"contentsImg3\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert contentsTxt3 != null : "fx:id=\"contentsTxt3\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert contentsImg4 != null : "fx:id=\"contentsImg4\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert contentsTxt4 != null : "fx:id=\"contentsTxt4\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert noticegogoBtn != null : "fx:id=\"noticegogoBtn\" was not injected: check your FXML file 'MainCenter.fxml'.";

        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			memberService = (IMemberService) reg.lookup("memberService");
			inbodyService = (IInbodyService) reg.lookup("inbodyService");
			boardNoticeService = (IBoardNoticeService) reg.lookup("boardNoticeService");
			boardHealthService = (IBoardHealthService) reg.lookup("boardHealthService");
			myFileService = (IMyFileService) reg.lookup("myFileService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
        
        nameTxt1.setText(memVO.getMem_name());
        txtName3.setText(memVO.getMem_name());
         
   	   InbodyVO inbdvo = new InbodyVO();
 	   
   	   try {
   		  inbdvo = inbodyService.callData(memVO.getMem_id());
   	   } catch (RemoteException e) {
   		   e.printStackTrace();
   	   }
   	   ageTxt.setText(inbdvo.getIb_age());
       tallTxt.setText(inbdvo.getIb_height()); 
   	   weightTxt.setText(inbdvo.getIb_weight());
   	   
   	   float bmi =  Float.parseFloat(inbdvo.getIb_bmi());
   	   
   	   if(18.5 <= bmi && bmi <= 23) {
   		   bmiTxt.setText(inbdvo.getIb_bmi() + "(정상)");
   	   }else if(18.5 > bmi) {
   		   bmiTxt.setText(inbdvo.getIb_bmi() + "(저제충)");
   	   }else if(bmi > 23) {
   		 bmiTxt.setText(inbdvo.getIb_bmi() + "(과체중)");
   	   }
   	   
   	   int age = Integer.parseInt(inbdvo.getIb_age());
   	   String sleepTime = "";
   	   int sleeptime1=0;
   	   
   	   if(14 <= age && age <= 17) {
   		   sleepTimeTxt.setText("8~10");
   		   sleepTime = "8~10";
   		   sleeptime1=9;
   	   }else if(18 <= age && age <= 64) {
   		   sleepTimeTxt.setText("7~9");
   		   sleepTime = "7~9";
   		   sleeptime1=8;
   	   }else if(65 <= age) {
   		   sleepTimeTxt.setText("7~8");
   		   sleepTime = "7~8";
   		   sleeptime1 = 8;
   	   }
   	   
   	   misemunzi(memVO); //미세먼지 정보 입력
   	   bmiGraphCreate(memVO); //bmi그래프 그리기, bmi 정보 텍스트에 넣기
   	   
   	   //수면 시간 그래프
   	   sleep = FXCollections.observableArrayList(
   			   new PieChart.Data("수면시간:" + sleepTime, sleeptime1),
   			   new PieChart.Data("활동시간 ", (24-sleeptime1))
   			   
   			   );
   	   
   	   sleepTimeGraph.setData(sleep);
   	   

   	   
 		noticeInitialize();
   	   
         sportsCucheonImg.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
         foodChucheonImg.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
         contentsImg1.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
         contentsImg2.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
         contentsImg3.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
         contentsImg4.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
         noticegogoBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
         
         
        bumList = new ArrayList<BoardHealthVO>();
         
         try {
        	 bumList = boardHealthService.recentData();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
         
         if(bumList.size() < 4) {
        	 
         }else {
        	 
         }
         
         contentsTxt1.setText(bumList.get(0).getBh_title());
         contentsTxt2.setText(bumList.get(1).getBh_title());
         contentsTxt3.setText(bumList.get(2).getBh_title());
         contentsTxt4.setText(bumList.get(3).getBh_title());
         
         
         Map<String, Object> map0 = new HashMap<String, Object>();
         map0.put("file_bd_code", "HC");
         map0.put("file_bd_num", bumList.get(0).getBh_seq());
         MyFileVO mfVO0 = new MyFileVO();
         try {
        	 mfVO0 = myFileService.getFileName(map0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
         // 경로 바꿔줘야함
        String f0 = "D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\nayanaClient\\src\\util\\images\\"
        		+ mfVO0.getFile_original_name() + "." + mfVO0.getFile_extension();
         Image img0 = new Image("file:///" + f0);
         contentsImg1.setImage(img0);
         
         
         Map<String, Object> map1 = new HashMap<String, Object>();
         map1.put("file_bd_code", "HC");
         map1.put("file_bd_num", bumList.get(1).getBh_seq());
         MyFileVO mfVO1 = new MyFileVO();
         try {
        	 mfVO1 = myFileService.getFileName(map1);
         } catch (RemoteException e) {
        	 e.printStackTrace();
         }
      // 경로 바꿔줘야함
         String f1 = "D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\nayanaClient\\src\\util\\images\\"
        		 + mfVO1.getFile_original_name() + "." + mfVO1.getFile_extension();
         Image img1 = new Image("file:///" + f1);
         contentsImg2.setImage(img1);
         
         
         Map<String, Object> map2 = new HashMap<String, Object>();
         map2.put("file_bd_code", "HC");
         map2.put("file_bd_num", bumList.get(2).getBh_seq());
         MyFileVO mfVO2 = new MyFileVO();
         try {
        	 mfVO2 = myFileService.getFileName(map2);
         } catch (RemoteException e) {
        	 e.printStackTrace();
         }
      // 경로 바꿔줘야함
         String f2 = "D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\nayanaClient\\src\\util\\images\\"
        		 + mfVO2.getFile_original_name() + "." + mfVO2.getFile_extension();
         Image img2 = new Image("file:///" + f2);
         contentsImg3.setImage(img2);
         
         
         Map<String, Object> map3 = new HashMap<String, Object>();
         map3.put("file_bd_code", "HC");
         map3.put("file_bd_num", bumList.get(3).getBh_seq());
         MyFileVO mfVO3 = new MyFileVO();
         try {
        	 mfVO3 = myFileService.getFileName(map3);
         } catch (RemoteException e) {
        	 e.printStackTrace();
         }
      // 경로 바꿔줘야함
         String f3 = "D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\nayanaClient\\src\\util\\images\\"
        		 + mfVO3.getFile_original_name() + "." + mfVO3.getFile_extension();
         Image img3 = new Image("file:///" + f3);
         contentsImg4.setImage(img3);
         
         
         
         
         
         
         
         
         
         
         
    }
}
