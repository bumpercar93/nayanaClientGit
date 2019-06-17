package nayana.controller.adminPage.mainPageA;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nayana.Inbody.service.IInbodyService;
import nayana.controller.adminPage.AdNoticeBoardController;
import nayana.controller.adminPage.AdminHCListController;
import nayana.controller.adminPage.adminSelfTest.AdminSelfTestController;
import nayana.member.service.IMemberService;
import nayana.vo.MemberVO;
import util.AlertUtil;
import util.MyButtonEventHandler;
import util.MyImageViewEventHandler;
import util.MyMenuButtonEventHandler;

public class MainAController {

    private IMemberService memberService;
	private IInbodyService inbodyService;
	
	private Stage mainStage;
	
    public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
	
	private static MemberVO memVO = new MemberVO();


	public static MemberVO getMemVO() {
		return memVO;
	}

	public static void setMemVO(MemberVO memVO) {
		MainAController.memVO = memVO;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Label nameTxt;

    @FXML
    private ImageView logoutBtn;

    @FXML
    private Button adminManageBtn;

    @FXML
    private Button FoodCucheonBtn;

    @FXML
    private Button SportsCucheonBtn;

    @FXML
    private Button MyTestBtn;

    @FXML
    private Button HealthcareDataBtn;

    @FXML
    private Button NoticeBtn;

    @FXML
    private BarChart<String,Number> siGraph;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private LineChart<String,Number> ageGraph;

    @FXML
    private PieChart genderGraph;

    @FXML
    void FoodCucheon(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminHealthInfo/HealthDietList.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane) nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void HealthcareData(ActionEvent event) {
    	try {
    		AdminHCListController.setMemVo(memVO);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/AdminHCList.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void Logout(MouseEvent event) {
    	boolean result = AlertUtil.confirmation("로그아웃", "로그아웃 하시겠습니까?", "OK버튼을 누르면 로그아웃 합니다");
    	
    	if(result) {
    		
    		try {
				Stage loginStage = new Stage();
				loginStage.initModality(Modality.WINDOW_MODAL);
				loginStage.setResizable(false);
				loginStage.setTitle("NAYANA");
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/loginPage/Login.fxml"));
				Parent root = loader.load();
				
				Scene scene = new Scene(root);
				loginStage.setScene(scene);
				loginStage.show();
//				Stage s = (Stage) genderGraph.getScene().getWindow();
//				s.close();
				mainStage.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
    	}
    }

    @FXML
    void MyTest(ActionEvent event) {
    	try {
    		AdminSelfTestController.setMemVO(memVO);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminSelfTest/AdminSelfTest.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void Notice(ActionEvent event) {
    	try {
    		AdNoticeBoardController.setMemVO(memVO);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/AdNoticeBoard.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane)nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void SportsCucheon(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminHealthInfo/HealthExeList.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane) nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void adminManage(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/adminPage/adminAccount/AccountMain.fxml"));
			Parent root = loader.load();
			
			borderPane = (BorderPane) nameTxt.getScene().getRoot();
			borderPane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }



    private void genderGraphMethod() { //남여별 비율 - 파이그래프
    	
    	List<MemberVO> memlist = new ArrayList<MemberVO>();
    	
    	try {
			memlist = memberService.getAllMember();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	int men=0;
    	int women=0;
    	
    	String gender=null;
    	
    	for(int i =0;i < memlist.size();i++) {
    		gender = memlist.get(i).getMem_gen();
    		
    		if(gender.equals("M")) {
    			men++;
    		}else if(gender.equals("W")) {
    			women++;
    		}
    		
    	}
    	
    	
    	double menbi = (int)(((double)men/(women+men))*100+0.5);
    	double womenbi = (int)(((double)women/(women+men))*100+0.5);
    	
    	
    	String menbi1 =  menbi + "%";
    	String womenbi1 = womenbi + "%";
    	
    	ObservableList<PieChart.Data>  genderG = FXCollections.observableArrayList(
    			new PieChart.Data("남" + menbi1, men),
    			new PieChart.Data("여" + womenbi1, women)
    			
    			);
    	genderGraph.setData(genderG);
    	
    }
    
    
    private void siGraph() { //시별 가입 회원 비율 - 막대그래프
    	
    	List<MemberVO> memlist = new ArrayList<MemberVO>();
    	
    	try {
			memlist = memberService.getAllMember();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	int daejeon=0;
    	int gwangju=0;
    	int daegu=0;
    	int seoul=0;
    	int busan=0;
    	
    	
    	for(int i=0;i<memlist.size();i++) {
    		if(memlist.get(i).getMem_right().equals("U")) {
    			if(memlist.get(i).getMem_addr1().equals("서울")){
    				seoul++;
    			}else if(memlist.get(i).getMem_addr1().equals("대전")) {
    				daejeon++;
    			}else if(memlist.get(i).getMem_addr1().equals("대구")) {
    				daegu++;
    			}else if(memlist.get(i).getMem_addr1().equals("부산")) {
    				busan++;
    			}else if(memlist.get(i).getMem_addr1().equals("광주")) {
    				gwangju++;
    			}
    		}
    			
    		
    	}
    	
    	double daejeon2 = (int)(((double)daejeon/(daejeon+gwangju+daegu+seoul+busan))*100+0.5);
    	double gwangju2 = (int)(((double)gwangju/(daejeon+gwangju+daegu+seoul+busan))*100+0.5);
    	double daegu2 = (int)(((double)daegu/(daejeon+gwangju+daegu+seoul+busan))*100+0.5);
    	double seoul2 = (int)(((double)seoul/(daejeon+gwangju+daegu+seoul+busan))*100+0.5);
    	double busan2 = (int)(((double)busan/(daejeon+gwangju+daegu+seoul+busan))*100+0.5);
    	
    	
    	XYChart.Series<String, Number> seoul1 = new XYChart.Series();
    	seoul1.setName("서울");
    	seoul1.getData().add(new XYChart.Data<>("분류",seoul2));
    	
    	XYChart.Series<String, Number> daejeon1 = new XYChart.Series();
    	daejeon1.setName("대전");
    	daejeon1.getData().add(new XYChart.Data<>("분류",daejeon2));
    	
    	XYChart.Series<String, Number> daegu1 = new XYChart.Series();
    	daegu1.setName("대구");
    	daegu1.getData().add(new XYChart.Data<>("분류",daegu2));
    	
    	XYChart.Series<String, Number> busan1 = new XYChart.Series();
    	busan1.setName("부산");
    	busan1.getData().add(new XYChart.Data<>("분류",busan2));
    	
    	XYChart.Series<String, Number> gwangju1 = new XYChart.Series();
    	gwangju1.setName("광주");
    	gwangju1.getData().add(new XYChart.Data<>("분류",gwangju2));
    	
    	
    	siGraph.getData().addAll(seoul1,daejeon1,daegu1,busan1,gwangju1);
    	
    	
    }
    
    private void ageGraph() {
    	
    	List<MemberVO> memlist = new ArrayList<MemberVO>();
    	
    	try {
    		memlist = memberService.getAllMember();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	
    	
    	String memAge = "19";
        String age1 = "";
        List<Integer> stlist = new ArrayList<Integer>();
        int sysDate=2019;
        int age =0;
        
        for(int i=0; i <  memlist.size();i++) {
        	if(memlist.get(i).getMem_right().equals("U")) {
	        	age1 = memlist.get(i).getMem_regno1().substring(0, 2);
	        	memAge += age1;
	        	age = sysDate - Integer.parseInt(memAge);
	        	stlist.add(age);
	        	memAge = "19";
        	}
        }
        
        int two=0;
        int three=0;
        int four=0;
        int five=0;
        int six=0;
        int sevenaa=0;
        
        int get=0;
        for(int i=0;i<stlist.size();i++) {
        	get = stlist.get(i);
        	if(get < 29) {
        		two++;
        	}else if(get < 39 ) {
        		three++;
        	}else if(get < 49) {
        		four++;
        	}else if(get < 59) {
        		five++;
        	}else if(get < 69) {
        		six++;
        	}else if(get > 70) {
        		sevenaa++;
        	}
        		
        }
        
        double two1 = (int)(((double)two/(two + three + four + five + six + sevenaa))*100+0.5);
        double three1 = (int)(((double)three/(three + three + four + five + six + sevenaa))*100+0.5);
        double four1 = (int)(((double)four/(four + three + four + five + six + sevenaa))*100+0.5);
        double five1 = (int)(((double)five/(five + three + four + five + six + sevenaa))*100+0.5);
        double six1 = (int)(((double)six/(six + three + four + five + six + sevenaa))*100+0.5);
        double seven1 = (int)(((double)sevenaa/(sevenaa + three + four + five + six + sevenaa))*100+0.5);
        
        
        
        XYChart.Series<String, Number> agea = new XYChart.Series<String, Number>();
        agea.getData().add(new XYChart.Data<String, Number>("20대",two1));
        agea.getData().add(new XYChart.Data<String, Number>("30대",three1));
        agea.getData().add(new XYChart.Data<String, Number>("40대",four1));
        agea.getData().add(new XYChart.Data<String, Number>("50대",five1));
        agea.getData().add(new XYChart.Data<String, Number>("60대",six1));
        agea.getData().add(new XYChart.Data<String, Number>("70대 이상",seven1));
        
        
        ageGraph.getData().addAll(agea);
        
    	
    	
    	
    }
    	

    @FXML
    void initialize() {
        assert borderPane != null : "fx:id=\"borderPane\" was not injected: check your FXML file 'MainA.fxml'.";
        assert nameTxt != null : "fx:id=\"nameTxt\" was not injected: check your FXML file 'MainA.fxml'.";
        assert logoutBtn != null : "fx:id=\"logoutBtn\" was not injected: check your FXML file 'MainA.fxml'.";
        assert adminManageBtn != null : "fx:id=\"adminManageBtn\" was not injected: check your FXML file 'MainA.fxml'.";
        assert FoodCucheonBtn != null : "fx:id=\"FoodCucheonBtn\" was not injected: check your FXML file 'MainA.fxml'.";
        assert SportsCucheonBtn != null : "fx:id=\"SportsCucheonBtn\" was not injected: check your FXML file 'MainA.fxml'.";
        assert MyTestBtn != null : "fx:id=\"MyTestBtn\" was not injected: check your FXML file 'MainA.fxml'.";
        assert HealthcareDataBtn != null : "fx:id=\"HealthcareDataBtn\" was not injected: check your FXML file 'MainA.fxml'.";
        assert NoticeBtn != null : "fx:id=\"NoticeBtn\" was not injected: check your FXML file 'MainA.fxml'.";
        assert siGraph != null : "fx:id=\"siGraph\" was not injected: check your FXML file 'MainA.fxml'.";
        assert xAxis != null : "fx:id=\"xAxis\" was not injected: check your FXML file 'MainA.fxml'.";
        assert yAxis != null : "fx:id=\"yAxis\" was not injected: check your FXML file 'MainA.fxml'.";
        assert ageGraph != null : "fx:id=\"ageGraph\" was not injected: check your FXML file 'MainA.fxml'.";
        assert genderGraph != null : "fx:id=\"genderGraph\" was not injected: check your FXML file 'MainA.fxml'.";


	    logoutBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
	    adminManageBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
	    FoodCucheonBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
	    SportsCucheonBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
	    MyTestBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
	    HealthcareDataBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
	    NoticeBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
          
        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			memberService = (IMemberService) reg.lookup("memberService");
			inbodyService = (IInbodyService) reg.lookup("inbodyService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
        
        nameTxt.setText(memVO.getMem_name());
        
        genderGraphMethod();
        siGraph();
        ageGraph();



    }
}
