package nayana.controller.mainPage;



import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nayana.Inbody.service.IInbodyService;
import nayana.boardNotice.service.IBoardNoticeService;
import nayana.controller.communityPage.HCListController;
import nayana.controller.communityPage.NoticeBoardController;
import nayana.controller.communityPage.ShowNoticeController;
import nayana.controller.healthInfoPage.Diet01Controller;
import nayana.controller.healthInfoPage.Exercise01Controller;
import nayana.controller.healthInfoPage.SelfTestController;
import nayana.controller.loginPage.LoginController;
import nayana.controller.myPage.ModiPerInfoController;
import nayana.controller.mydataPage.MyDataController;
import nayana.controller.mydataPage.SelectMyDataController;
import nayana.controller.mydataPage.SolutionController;
import nayana.member.service.IMemberService;
import nayana.vo.BoardNoticeVO;
import nayana.vo.InbodyVO;
import nayana.vo.MemberVO;
import util.AlertUtil;
import util.MyButtonEventHandler;
import util.MyImageViewEventHandler;
import util.MyMenuButtonEventHandler;

public class MainController {

	private static MemberVO memVO;
	public static MemberVO getMemVO() {
		return memVO;
	}

	public static void setMemVO(MemberVO memVO) {
		MainController.memVO = memVO;
	}
	
	private static InbodyVO inbodyvo;
	public static InbodyVO getInbodyvo() {
		return inbodyvo;
	}

	public static void setInbodyvo(InbodyVO inbodyvo) {
		MainController.inbodyvo = inbodyvo;
	}

	private IInbodyService inbodyService;
	private IMemberService memberService;
	private IBoardNoticeService boardNoticeService;
	
	private Stage mainStage;
	
	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
	
	List<MemberVO> membervo = new ArrayList<MemberVO>();
	public static int a=0;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public static BorderPane borderPane;

    @FXML
    private TextArea chatbotTxtArea;

    @FXML
    private TextField chatbotTxtField;

    @FXML
    private Button chatbotBtn;

    @FXML
    private ImageView miseImg1;

    @FXML
    private Label miseTxt1;

    @FXML
    private Label nameTxt;

    @FXML
    private ImageView logoutBtn;

    @FXML
    private MenuButton healthSearchList;

    @FXML
    private MenuItem healthSearchMenu;

    @FXML
    private MenuItem healthTotalMenu;

    @FXML
    private MenuItem Solution;

    @FXML
    private MenuButton healthGiveList;

    @FXML
    private MenuItem foodCucheonMenu;

    @FXML
    private MenuItem sportsCucheonMenu;

    @FXML
    private MenuItem meTestMenu;

    @FXML
    private ImageView mainlogo;
    
    @FXML
    private MenuButton communityList;

    @FXML
    private MenuItem HealthcareDataMenu;

    @FXML
    private MenuItem noticeMenu;

    @FXML
    private MenuButton mypageList;

    @FXML
    private MenuItem myPageMenu;

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
    private Label txtName3;

    @FXML
    private Label bmiTxt;

    @FXML
    private Label sleepTimeTxt;

    @FXML
    private PieChart sleepTimeGraph;

    @FXML
    private ImageView sportsCucheonImg;

    @FXML
    private ImageView foodChucheonImg;

    @FXML
    private StackedBarChart<String,Number> bmiGraph;

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
    void noticegogo(ActionEvent event) {
    	try {
    		NoticeBoardController.setMemVO(memVO);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/communityPage/NoticeBoard.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void FoodCucheon(MouseEvent event) {
    	try {
    		Diet01Controller.setMemVo(memVO);
    		Diet01Controller.setMainStage(mainStage);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet01.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    
    @FXML
    void Logout(MouseEvent event) {
//    	Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
//    	alertConfirm.setTitle("로그아웃");
//    	alertConfirm.setHeaderText("로그아웃하시겠습니까?");
//    	
//    	//사용자가 누른 버튼의 종류를 읽어옴
//    	ButtonType result = alertConfirm.showAndWait().get();
    	
    	boolean result = AlertUtil.confirmation("로그아웃", "로그아웃 하시겠습니까?", "OK버튼을 누르면 로그아웃 합니다");
    	
    	
    	if(result) {
    		
    		try {
    			Stage loginStage = new Stage();
				loginStage.initModality(Modality.WINDOW_MODAL);
				loginStage.setResizable(false);
				loginStage.setTitle("NAYANA");
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/loginPage/Login.fxml"));
				Parent root = loader.load();
				
				Scene scene = new Scene(root);
				loginStage.setScene(scene);
				loginStage.show();
				mainStage.close();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
    	}else {
    		
    	}
    }

    @FXML
    void SportsCucheon(MouseEvent event) {
    	try {
    		Exercise01Controller.setMemVo(memVO);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise01.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void chatbotBtnClicked(ActionEvent event) {
    	String uText = chatbotTxtField.getText();
    	chatbotTxtArea.appendText("YOU : " + uText + "\n");
	
    	BoardNoticeVO noticeVo = new BoardNoticeVO();
//    	noticeVo.setBn_title(boardNoticeService.getSearchBoardList("공지","범휘"));
		
		if(uText.contains("NAYANA") || uText.contains("nayana") || uText.contains("na") || uText.contains("ya") ) {
//			chatbotTxtArea.appendText("아래에 문의할 텍스트를 입력해주세요.\n\n");
			botSay("NAYANA는 MYDATA기반으로 개인이\n "
				 + "비구조화된 데이터의 주체가 되어\n "
				 + "개인의 동의 하에 정부나 사업자에게\n "
				 + "정보를 제공하여 맞춤형 서비스를\n "
				 + "받거나 혜택을 받는 서비스로 NAYANA는\n"
				 + " 건강 데이터를 제공하고 있습니다.");
			    		
		}else if(uText.contains("날씨") || uText.contains("미세먼지")) {
		            
			botSay("대전광역시 중구 대흥동 날씨는\n"
				 + "최저기온 14˚ 최고기온 28˚\n"
				 + "미세먼지 115㎍/㎥나쁨\n"
				 + "초미세먼지 35㎍/㎥보통\n"
				 + "오존지수 0.017ppm좋음");
		            
		}else if(uText.contains("잠")) {

			botSay("불면증이 있으시면 상단메뉴에서\n "
				 + "건강정보제공-자가진단에서\n "
				 + "불면증 검사를 해보세요");
			
		}else if(uText.contains("우울")) {
			
			botSay("피로감이 있으면 상단메뉴에서\n"
				 + "건강정보제공-자가진단에서\n"
				 + "우울증 검사를 해보세요");
			
		}else if(uText.contains("누구")) {
			botSay("저는 NAYANA chatbot입니다.");
			
		}else if(uText.contains("1+1")) {
			
			botSay("귀요미");
		}else if(uText.contains("2+2")) {
			
			botSay("귀귀요미");
		}else if(uText.contains("3+3")) {
			
			botSay("귀귀귀요미");
		}else if(uText.contains("4+4")) {
			
			botSay("귀귀귀귀요미");
		}else if(uText.contains("5+5")) {
			
			botSay("귀귀귀귀귀요미");
			
		}else if(uText.contains("정보")) {
			
			botSay("회원정보 수정은 상단 메뉴에서"
				 + "\n 개인 정보 수정에서 변경할수 있습니다");
		
		}else if(uText.contains("정보")) {
			
			botSay("회원정보 수정은 상단 메뉴에서"
				 + "\n 개인 정보 수정에서 변경할수 있습니다");
		}else if(uText.contains("가입")) {
			
			botSay("회원탈퇴는 상단 메뉴에서 \n"
				 + "개인정보 수정에서 할수 있습니다.");
		}else if(uText.contains("탄")) {
			
			botSay("도박판에서 쓰는 은어. \n"
					+ "화투나 포커등의 카드게임에서"
					+ " 화투나 포커등의 카드게임에서"
					+ "사람마다 정해진 패가 돌아가도록"
					+ "미리 순서를 짜둔 카드더미를"
					+ "탄이라고 한다.");
		}else {
			int decider = (int) (Math.random()*3+1);
			
			if(decider==1) {
				botSay("다시 입력해주세요.");
			}else if(decider==2){
				botSay("무슨 말인지 모르겠어요.");
			}else if(decider==3){
				botSay("???");
			}else if(decider==4) {
				botSay("아직 학습되지 않은 질문입니다.");
			}
		}
	    	
		chatbotTxtField.setText("");
		chatbotTxtArea.appendText("\n");
	    chatbotTxtField.requestFocus();
    	
    } // submitBtnClicked 끝
    
    public void botSay(String s){
    	chatbotTxtArea.appendText("AI : " + s + "\n");
     }
    
    
    @FXML
    void clickSolution(ActionEvent event) {
    	try {
    		SolutionController.setMemVO(memVO);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/mydataPage/Solution.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void foodCucheon(ActionEvent event) {
    	try {
    		Diet01Controller.setMemVo(memVO);
    		Diet01Controller.setMainStage(mainStage);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet01.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }


    @FXML
    void healthSearch(ActionEvent event) {
    	try {
    		MyDataController.setMemVO(memVO);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/mydataPage/MyData.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void healthTotal(ActionEvent event) {
    	try {
    		SelectMyDataController.setMemVO(memVO);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/mydataPage/SelectMyData.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void healthcareData(ActionEvent event) {
    	try {
    		HCListController.setMemVo(memVO);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/communityPage/HCList.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

 
    
    @FXML
    void MainGoGo(MouseEvent event) {
    
    }

    @FXML
    void meTest(ActionEvent event) {
    	try {
    		SelfTestController.setMemVO(memVO);
    		SelfTestController.setMainStage(mainStage);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/SelfTest.fxml"));
			Parent root = loader.load();
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void myPage(ActionEvent event) {
    	try {
    		ModiPerInfoController.setMemVO(memVO);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/myPage/ModiPerInfo.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void notice(ActionEvent event) {
    	try {
    		NoticeBoardController.setMemVO(memVO);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/communityPage/NoticeBoard.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void sprotsCucheon(ActionEvent event) {
    	try {
    		Exercise01Controller.setMemVo(memVO);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise01.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
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
						miseTxt1.setText("공기 좋음");
						miseTxt2.setText("좋음");
						miseComent.setText("공기가 맑아요");
						miseImg1.setImage(new Image(getClass().getResourceAsStream("../../../util/images/miseSmile.png")));
						miseImg2.setImage(new Image(getClass().getResourceAsStream("../../../util/images/BmiseSmile.png")));
					}else if(30 < pmvalue && pmvalue <=80) {
						miseTxt1.setText("공기 보통");
						miseTxt2.setText("보통");
						miseComent.setText("공기가 보통이에요");
						miseImg1.setImage(new Image(getClass().getResourceAsStream("../../../util/images/miseSoso.png")));
						miseImg2.setImage(new Image(getClass().getResourceAsStream("../../../util/images/BmiseSoso.png")));
					}else if(80 < pmvalue && pmvalue <= 150) {
						miseTxt1.setText("공기 나쁨");
						miseTxt2.setText("나쁨");
						miseComent.setText("공기가 안좋아요");
						miseImg1.setImage(new Image(getClass().getResourceAsStream("../../../util/images/sad.png")));
						miseImg2.setImage(new Image(getClass().getResourceAsStream("../../../util/images/BmiseSad.png")));
					}else if(150 < pmvalue && pmvalue > 150) {
						miseTxt1.setText("매우 나쁨");
						miseTxt2.setText("매우나쁨");
						miseComent.setText("공기가 겁나 안좋아요");
						miseImg1.setImage(new Image(getClass().getResourceAsStream("../../../util/images/sad.png")));
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
    void initialize() {
    	 assert borderPane != null : "fx:id=\"borderPane\" was not injected: check your FXML file 'Main.fxml'.";
         assert chatbotTxtArea != null : "fx:id=\"chatbotTxtArea\" was not injected: check your FXML file 'Main.fxml'.";
         assert chatbotTxtField != null : "fx:id=\"chatbotTxtField\" was not injected: check your FXML file 'Main.fxml'.";
         assert chatbotBtn != null : "fx:id=\"chatbotBtn\" was not injected: check your FXML file 'Main.fxml'.";
         assert mainlogo != null : "fx:id=\"mainlogo\" was not injected: check your FXML file 'Main.fxml'.";
         assert miseImg1 != null : "fx:id=\"miseImg1\" was not injected: check your FXML file 'Main.fxml'.";
         assert miseTxt1 != null : "fx:id=\"miseTxt1\" was not injected: check your FXML file 'Main.fxml'.";
         assert nameTxt != null : "fx:id=\"nameTxt\" was not injected: check your FXML file 'Main.fxml'.";
         assert logoutBtn != null : "fx:id=\"logoutBtn\" was not injected: check your FXML file 'Main.fxml'.";
         assert healthSearchList != null : "fx:id=\"healthSearchList\" was not injected: check your FXML file 'Main.fxml'.";
         assert healthSearchMenu != null : "fx:id=\"healthSearchMenu\" was not injected: check your FXML file 'Main.fxml'.";
         assert healthTotalMenu != null : "fx:id=\"healthTotalMenu\" was not injected: check your FXML file 'Main.fxml'.";
         assert Solution != null : "fx:id=\"Solution\" was not injected: check your FXML file 'Main.fxml'.";
         assert healthGiveList != null : "fx:id=\"healthGiveList\" was not injected: check your FXML file 'Main.fxml'.";
         assert foodCucheonMenu != null : "fx:id=\"foodCucheonMenu\" was not injected: check your FXML file 'Main.fxml'.";
         assert sportsCucheonMenu != null : "fx:id=\"sportsCucheonMenu\" was not injected: check your FXML file 'Main.fxml'.";
         assert meTestMenu != null : "fx:id=\"meTestMenu\" was not injected: check your FXML file 'Main.fxml'.";
         assert communityList != null : "fx:id=\"communityList\" was not injected: check your FXML file 'Main.fxml'.";
         assert HealthcareDataMenu != null : "fx:id=\"HealthcareDataMenu\" was not injected: check your FXML file 'Main.fxml'.";
         assert noticeMenu != null : "fx:id=\"noticeMenu\" was not injected: check your FXML file 'Main.fxml'.";
         assert mypageList != null : "fx:id=\"mypageList\" was not injected: check your FXML file 'Main.fxml'.";
         assert myPageMenu != null : "fx:id=\"myPageMenu\" was not injected: check your FXML file 'Main.fxml'.";
         assert ageTxt != null : "fx:id=\"ageTxt\" was not injected: check your FXML file 'Main.fxml'.";
         assert tallTxt != null : "fx:id=\"tallTxt\" was not injected: check your FXML file 'Main.fxml'.";
         assert weightTxt != null : "fx:id=\"weightTxt\" was not injected: check your FXML file 'Main.fxml'.";
         assert miseImg2 != null : "fx:id=\"miseImg2\" was not injected: check your FXML file 'Main.fxml'.";
         assert miseTxt2 != null : "fx:id=\"miseTxt2\" was not injected: check your FXML file 'Main.fxml'.";
         assert miseSize != null : "fx:id=\"miseSize\" was not injected: check your FXML file 'Main.fxml'.";
         assert miseComent != null : "fx:id=\"miseComent\" was not injected: check your FXML file 'Main.fxml'.";
         assert nameTxt1 != null : "fx:id=\"nameTxt1\" was not injected: check your FXML file 'Main.fxml'.";
         assert bmiTxt != null : "fx:id=\"bmiTxt\" was not injected: check your FXML file 'Main.fxml'.";
         assert txtName3 != null : "fx:id=\"txtName3\" was not injected: check your FXML file 'Main.fxml'.";
         assert sleepTimeTxt != null : "fx:id=\"sleepTimeTxt\" was not injected: check your FXML file 'Main.fxml'.";
         assert sleepTimeGraph != null : "fx:id=\"sleepTimeGraph\" was not injected: check your FXML file 'Main.fxml'.";
         assert sportsCucheonImg != null : "fx:id=\"sportsCucheonImg\" was not injected: check your FXML file 'Main.fxml'.";
         assert foodChucheonImg != null : "fx:id=\"foodChucheonImg\" was not injected: check your FXML file 'Main.fxml'.";
         assert bmiGraph != null : "fx:id=\"bmiGraph\" was not injected: check your FXML file 'Main.fxml'.";
         assert gonziTable != null : "fx:id=\"gonziTable\" was not injected: check your FXML file 'Main.fxml'.";
         assert gongziTitle != null : "fx:id=\"gongziTitle\" was not injected: check your FXML file 'Main.fxml'.";
         assert contentsImg1 != null : "fx:id=\"contentsImg1\" was not injected: check your FXML file 'Main.fxml'.";
         assert contentsTxt1 != null : "fx:id=\"contentsTxt1\" was not injected: check your FXML file 'Main.fxml'.";
         assert contentsImg2 != null : "fx:id=\"contentsImg2\" was not injected: check your FXML file 'Main.fxml'.";
         assert contentsTxt2 != null : "fx:id=\"contentsTxt2\" was not injected: check your FXML file 'Main.fxml'.";
         assert contentsImg3 != null : "fx:id=\"contentsImg3\" was not injected: check your FXML file 'Main.fxml'.";
         assert contentsTxt3 != null : "fx:id=\"contentsTxt3\" was not injected: check your FXML file 'Main.fxml'.";
         assert contentsImg4 != null : "fx:id=\"contentsImg4\" was not injected: check your FXML file 'Main.fxml'.";
         assert contentsTxt4 != null : "fx:id=\"contentsTxt4\" was not injected: check your FXML file 'Main.fxml'.";
         assert noticegogoBtn != null : "fx:id=\"noticegogoBtn\" was not injected: check your FXML file 'Main.fxml'.";
    	
    	
        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			memberService = (IMemberService) reg.lookup("memberService");
			inbodyService = (IInbodyService) reg.lookup("inbodyService");
			boardNoticeService = (IBoardNoticeService) reg.lookup("boardNoticeService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
       
       nameTxt.setText(memVO.getMem_name());
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
  	   int sleepTime = 0;
  	   
  	   if(14 <= age && age <= 17) {
  		   sleepTimeTxt.setText("8~10");
  		   sleepTime = 9;
  	   }else if(18 <= age && age <= 64) {
  		   sleepTimeTxt.setText("7~9");
  		   sleepTime = 8;
  	   }else if(65 <= age) {
  		   sleepTimeTxt.setText("7~8");
  		   sleepTime = 8;
  	   }
  	   
  	   misemunzi(memVO); //미세먼지 정보 입력
  	   bmiGraphCreate(memVO); //bmi그래프 그리기, bmi 정보 텍스트에 넣기
  	   
  	   //수면 시간 그래프
  	   sleep = FXCollections.observableArrayList(
  			   new PieChart.Data("수면시간:" + sleepTime, sleepTime),
  			   new PieChart.Data("활동시간 ", (24-sleepTime))
  			   
  			   );
  	   
  	   sleepTimeGraph.setData(sleep);
  	   
//  	 // 챗봇
		chatbotTxtArea.appendText("채팅으로 요청 하셨습니다.\n");
		chatbotTxtArea.appendText("아래에 문의할 텍스트를 입력해주세요.\n\n");
		chatbotTxtArea.setFocusTraversable(false);
		chatbotTxtField.requestFocus();
		        	
		chatbotBtn.setDefaultButton(true);
  	   
		noticeInitialize();
  	   
        logoutBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
        sportsCucheonImg.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
        foodChucheonImg.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
        contentsImg1.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
        contentsImg2.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
        contentsImg3.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
        contentsImg4.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
        healthSearchList.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyMenuButtonEventHandler());
        healthGiveList.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyMenuButtonEventHandler());
        communityList.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyMenuButtonEventHandler());
        mypageList.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyMenuButtonEventHandler());
        
        

        
        
        
    }
}
