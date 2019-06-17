package nayana.controller.mainPage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
import nayana.controller.healthInfoPage.Diet01Controller;
import nayana.controller.healthInfoPage.Exercise01Controller;
import nayana.controller.healthInfoPage.SelfTestController;
import nayana.controller.myPage.ModiPerInfoController;
import nayana.controller.mydataPage.MyDataController;
import nayana.controller.mydataPage.SelectMyDataController;
import nayana.controller.mydataPage.SolutionController;
import nayana.member.service.IMemberService;
import nayana.vo.BoardNoticeVO;
import nayana.vo.InbodyVO;
import nayana.vo.MemberVO;
import util.AlertUtil;
import util.MyImageViewEventHandler;
import util.MyMenuButtonEventHandler;

public class MainTopController {

	private static MemberVO memVO;
	public static MemberVO getMemVO() {
		return memVO;
	}

	public static void setMemVO(MemberVO memVO) {
		MainTopController.memVO = memVO;
	}
	
	private static InbodyVO inbodyvo;
	public static InbodyVO getInbodyvo() {
		return inbodyvo;
	}

	public static void setInbodyvo(InbodyVO inbodyvo) {
		MainTopController.inbodyvo = inbodyvo;
	}

	private IMemberService memberService;
	
	private Stage mainStage;
	
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
    private BorderPane borderpaneTop;

    @FXML
    private TextArea chatbotTxtArea;

    @FXML
    private TextField chatbotTxtField;

    @FXML
    private Button chatbotBtn;

    @FXML
    private ImageView mainlogo;

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
    void Logout(MouseEvent event) {
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
    		
    	}
    }

    @FXML
    void MainGoGo(MouseEvent event) {
    	mainGOGO();
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
			
		}else if(uText.contains("누구야")) {
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
		}else if(uText.contains("발표자")) {
			
			botSay("유다연");
			
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
					+ "화투나 포커등의 카드게임에서\n"
					+ " 화투나 포커등의 카드게임에서\n"
					+ "사람마다 정해진 패가 돌아가도록\n"
					+ "미리 순서를 짜둔 카드더미를\n"
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
			
			borderpaneTop = (BorderPane)nameTxt.getScene().getRoot();
			borderpaneTop.setCenter(root);
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
			
			borderpaneTop = (BorderPane)nameTxt.getScene().getRoot();
			borderpaneTop.setCenter(root);
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
			
			borderpaneTop = (BorderPane)nameTxt.getScene().getRoot();
			borderpaneTop.setCenter(root);
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
			
			borderpaneTop = (BorderPane)nameTxt.getScene().getRoot();
			borderpaneTop.setCenter(root);
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
			
			borderpaneTop = (BorderPane)nameTxt.getScene().getRoot();
			borderpaneTop.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void meTest(ActionEvent event) {
    	try {
    		SelfTestController.setMemVO(memVO);
    		SelfTestController.setMainStage(mainStage);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/SelfTest.fxml"));
			Parent root = loader.load();
			borderpaneTop = (BorderPane)nameTxt.getScene().getRoot();
			borderpaneTop.setCenter(root);
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
			ModiPerInfoController mc = loader.getController();
			mc.setMainController(this);
			
			borderpaneTop = (BorderPane)nameTxt.getScene().getRoot();
			borderpaneTop.setCenter(root);
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
			
			borderpaneTop = (BorderPane)nameTxt.getScene().getRoot();
			borderpaneTop.setCenter(root);
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
			
			borderpaneTop = (BorderPane)nameTxt.getScene().getRoot();
			borderpaneTop.setCenter(root);
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
					pmvalue = Integer.parseInt(listObj.get("pm10Value").toString());
					
					//Image img = new Image("../util/images/btn_diet.png");
					
					if(pmvalue<=30) {
						miseTxt1.setText("공기 좋음");
						miseImg1.setImage(new Image(getClass().getResourceAsStream("../../../util/images/miseSmile.png")));
					}else if(30 < pmvalue && pmvalue <=80) {
						miseTxt1.setText("공기 보통");
						miseImg1.setImage(new Image(getClass().getResourceAsStream("../../../util/images/miseSoso.png")));
					}else if(80 < pmvalue && pmvalue <= 150) {
						miseTxt1.setText("공기 나쁨");
						miseImg1.setImage(new Image(getClass().getResourceAsStream("../../../util/images/sad.png")));
					}else if(150 < pmvalue && pmvalue > 150) {
						miseTxt1.setText("매우 나쁨");
						miseImg1.setImage(new Image(getClass().getResourceAsStream("../../../util/images/sad.png")));
					}
					
					break;
					
				}
			
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
    	
    }
    
    public void mainGOGO() {
    	 try {
     		MainCenterController.setMemVO(memVO);
     		
 			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/mainPage/MainCenter.fxml"));
 			Parent root = loader.load();
 			
 			//borderpaneTop = (BorderPane)nameTxt.getScene().getRoot();
 			MainCenterController mainCenterController = loader.getController();
 			mainCenterController.setMainStage(mainStage);
			
 			borderpaneTop.setCenter(root);
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
    	
    	
    }
    
    @FXML
    void initialize() {
        assert borderpaneTop != null : "fx:id=\"borderpaneTop\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert chatbotTxtArea != null : "fx:id=\"chatbotTxtArea\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert chatbotTxtField != null : "fx:id=\"chatbotTxtField\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert chatbotBtn != null : "fx:id=\"chatbotBtn\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert mainlogo != null : "fx:id=\"mainlogo\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert miseImg1 != null : "fx:id=\"miseImg1\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert miseTxt1 != null : "fx:id=\"miseTxt1\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert nameTxt != null : "fx:id=\"nameTxt\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert logoutBtn != null : "fx:id=\"logoutBtn\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert healthSearchList != null : "fx:id=\"healthSearchList\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert healthSearchMenu != null : "fx:id=\"healthSearchMenu\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert healthTotalMenu != null : "fx:id=\"healthTotalMenu\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert Solution != null : "fx:id=\"Solution\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert healthGiveList != null : "fx:id=\"healthGiveList\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert foodCucheonMenu != null : "fx:id=\"foodCucheonMenu\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert sportsCucheonMenu != null : "fx:id=\"sportsCucheonMenu\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert meTestMenu != null : "fx:id=\"meTestMenu\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert communityList != null : "fx:id=\"communityList\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert HealthcareDataMenu != null : "fx:id=\"HealthcareDataMenu\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert noticeMenu != null : "fx:id=\"noticeMenu\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert mypageList != null : "fx:id=\"mypageList\" was not injected: check your FXML file 'MainTop.fxml'.";
        assert myPageMenu != null : "fx:id=\"myPageMenu\" was not injected: check your FXML file 'MainTop.fxml'.";

        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			memberService = (IMemberService) reg.lookup("memberService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
        
        MainCenterController.setMemVO(memVO);
        nameTxt.setText(memVO.getMem_name());
        
        // 챗봇
		chatbotTxtArea.appendText("채팅으로 요청 하셨습니다.\n");
		chatbotTxtArea.appendText("아래에 문의할 텍스트를 입력해주세요.\n\n");
		chatbotTxtArea.setFocusTraversable(false);
		chatbotTxtField.requestFocus();
		        	
		chatbotBtn.setDefaultButton(true);
        
		logoutBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
		mainlogo.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyImageViewEventHandler());
        healthSearchList.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyMenuButtonEventHandler());
        healthGiveList.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyMenuButtonEventHandler());
        communityList.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyMenuButtonEventHandler());
        mypageList.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyMenuButtonEventHandler());
        chatbotBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyMenuButtonEventHandler());
        
        
        misemunzi(memVO); //미세먼지 정보 입력
        //mainGOGO();
       
        
    }
}
