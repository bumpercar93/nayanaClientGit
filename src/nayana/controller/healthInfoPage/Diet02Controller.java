package nayana.controller.healthInfoPage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nayana.member.service.IMemberService;
import nayana.vo.MemberVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class Diet02Controller {
	
	private Stage diet02Stage;
	private static String ageCodeNum;
	private IMemberService memberService;
	private static MemberVO memVo;
	private static Stage mainStage;
	
	public static void setMainStage(Stage mainStage) {
		Diet02Controller.mainStage = mainStage;
	}

	public static MemberVO getMemVo() {
		return memVo;
	}

	public static void setMemVo(MemberVO memVo) {
		Diet02Controller.memVo = memVo;
	}

	public Stage getDiet02Stage() {
		return diet02Stage;
	}

	public void setDiet02Stage(Stage diet02Stage) {
		this.diet02Stage = diet02Stage;
	}

	public static String getAgeCodeNum() {
		return ageCodeNum;
	}

	public static void setAgeCodeNum(String ageCodeNum) {
		Diet02Controller.ageCodeNum = ageCodeNum;
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label DietName;

    @FXML
    private ImageView img01;

    @FXML
    private ImageView img02;

    @FXML
    private ImageView img03;

    @FXML
    private Button btnDietNext;

    @FXML
    private Button btnDietPrev;

    @FXML
    private Button btnWeight01;

    @FXML
    private Button btnWeight02;

    @FXML
    private Button btnWeight03;
    
    String weightCode = "";
    
    @FXML
    void btnDietNextClicked(ActionEvent event) {
    	if(weightCode.equals("")) {
    		AlertUtil.error("오류", "ERROR", "체중의 유형을 선택해 주세요.");
    	}else {
	    	try {
	    		Diet03Controller.setMemVo(memVo);
				Diet03Controller.setAgeCodeNum(ageCodeNum);
				Diet03Controller.setWeightCodeNum(weightCode);
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet03.fxml"));
				Parent root = loader.load();
				
				BorderPane b = (BorderPane) btnWeight03.getScene().getRoot();
				b.setCenter(root);
	    		
	//			Stage Diet03Stage = new Stage();
	//			Diet03Stage.initModality(Modality.WINDOW_MODAL);
	//			Diet03Stage.setResizable(false);
	//			Diet03Stage.setTitle("추천식단 질병 선택");
	//			Diet03Controller.setAgeCodeNum(ageCodeNum);
	//			Diet03Controller.setWeightCodeNum(weightCode);
	//			
	//			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet03.fxml"));
	//			Parent root = loader.load();
	//			Diet03Controller Diet03Controller = loader.getController();
	//			Diet03Controller.setDiet03Stage(Diet03Stage);
	//			
	//			Scene scene = new Scene(root);
	//			Diet03Stage.setScene(scene);
	//			Diet03Stage.show();
	//			diet02Stage.close();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void btnDietPrevClicked(ActionEvent event) {
    	try {
    		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet01.fxml"));
			Parent root = loader.load();
			
			BorderPane b = (BorderPane) btnWeight03.getScene().getRoot();
			b.setCenter(root);
    		
//			Stage Diet01Stage = new Stage();
//			Diet01Stage.initModality(Modality.WINDOW_MODAL);
//			Diet01Stage.setResizable(false);
//			Diet01Stage.setTitle("추천식단 체형 선택");
//			Diet02Controller.setAgeCodeNum("");
//			
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet01.fxml"));
//			Parent root = loader.load();
//			Diet01Controller Diet01Controller = loader.getController();
//			Diet01Controller.setPrimaryStage(Diet01Stage);
//			
//			Scene scene = new Scene(root);
//			Diet01Stage.setScene(scene);
//			Diet01Stage.show();
//			diet02Stage.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	//System.out.println(ageCodeNum);
    	//System.out.println(weightCode);
    }

    @FXML
    void btnWeight01Clicked(ActionEvent event) {
    	weightCode = "저체중";
    	if(weightCode.equals("저체중")){
    		img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/weight_01_over.png")));
    	}
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/weight_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/weight_03.png")));
    }

    @FXML
    void btnWeight02Clicked(ActionEvent event) {
    	weightCode = "정상체중";
    	if(weightCode.equals("정상체중")){
    		img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/weight_02_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/weight_01.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/weight_03.png")));
    }

    @FXML
    void btnWeight03Clicked(ActionEvent event) {
    	weightCode = "과체중";
    	if(weightCode.equals("과체중")){
    		img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/weight_03_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/weight_01.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/weight_02.png")));
    }

    @FXML
    void initialize() {
        assert DietName != null : "fx:id=\"DietName\" was not injected: check your FXML file 'Diet02.fxml'.";
        assert img01 != null : "fx:id=\"img01\" was not injected: check your FXML file 'Diet02.fxml'.";
        assert img02 != null : "fx:id=\"img02\" was not injected: check your FXML file 'Diet02.fxml'.";
        assert img03 != null : "fx:id=\"img03\" was not injected: check your FXML file 'Diet02.fxml'.";
        assert btnDietNext != null : "fx:id=\"btnDietNext\" was not injected: check your FXML file 'Diet02.fxml'.";
        assert btnDietPrev != null : "fx:id=\"btnDietPrev\" was not injected: check your FXML file 'Diet02.fxml'.";
        assert btnWeight01 != null : "fx:id=\"btnWeight01\" was not injected: check your FXML file 'Diet02.fxml'.";
        assert btnWeight02 != null : "fx:id=\"btnWeight02\" was not injected: check your FXML file 'Diet02.fxml'.";
        assert btnWeight03 != null : "fx:id=\"btnWeight03\" was not injected: check your FXML file 'Diet02.fxml'.";
        
        try {
    		Registry reg = LocateRegistry.getRegistry("localhost", 8888);
    		memberService = (IMemberService) reg.lookup("memberService");
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	} catch (NotBoundException e) {
    		e.printStackTrace();
    	}
        
        //로그인한 회원의 이름
        DietName.setText(memVo.getMem_name());
        
        btnWeight02.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnWeight03.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnWeight01.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnDietNext.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnDietPrev.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());

    }
}
