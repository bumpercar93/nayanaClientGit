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
import nayana.controller.mainPage.MainController;
import nayana.member.service.IMemberService;
import nayana.vo.MemberVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class Diet01Controller {

	private Stage primaryStage;
	private IMemberService memberService;
	private static MemberVO memVo;
	private static Stage mainStage;
	
	public static void setMainStage(Stage mainStage) {
		Diet01Controller.mainStage = mainStage;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

    public static MemberVO getMemVo() {
		return memVo;
	}

	public static void setMemVo(MemberVO memVo) {
		Diet01Controller.memVo = memVo;
	}



	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label DietName;
    
    @FXML
    private ImageView age01;

    @FXML
    private ImageView age02;

    @FXML
    private ImageView age03;

    @FXML
    private ImageView age04;

    @FXML
    private ImageView age05;

    @FXML
    private Button btnDietAge01;

    @FXML
    private Button btnDietAge02;

    @FXML
    private Button btnDietAge03;

    @FXML
    private Button btnDietAge04;

    @FXML
    private Button btnDietAge05;

    @FXML
    private Button btnDietNext;

    String ageCode = "";
    
    @FXML
    void btnDietAge01Clicked(ActionEvent event) {
    	ageCode = "어린이D";
    	
    	if(ageCode.equals("어린이D")){
    		age01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_01_over.png")));
    	}
		age02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_02.png")));
		age03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_03.png")));
		age04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_04.png")));
		age05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_05.png")));
    }

    @FXML
    void btnDietAge02Clicked(ActionEvent event) {
    	ageCode = "청소년D";
    	
    	if(ageCode.equals("청소년D")){
    		age02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_02_over.png")));
    	}
		age01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_01.png")));
		age03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_03.png")));
		age04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_04.png")));
		age05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_05.png")));
    }

    @FXML
    void btnDietAge03Clicked(ActionEvent event) {
    	ageCode = "청년D";
    	
    	if(ageCode.equals("청년D")){
    		age03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_03_over.png")));
    	}
    	age01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_01.png")));
		age02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_02.png")));
		age04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_04.png")));
		age05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_05.png")));
    }

    @FXML
    void btnDietAge04Clicked(ActionEvent event) {
    	ageCode = "중년D";
    	if(ageCode.equals("중년D")){
    		age04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_04_over.png")));
    	}
    	age01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_01.png")));
		age02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_02.png")));
		age03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_03.png")));
		age05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_05.png")));
    }

    @FXML
    void btnDietAge05Clicked(ActionEvent event) {
    	ageCode = "노년D";
    	if(ageCode.equals("노년D")){
    		age05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_05_over.png")));
    	}
    	age01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_01.png")));
		age02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_02.png")));
		age03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_03.png")));
		age04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_04.png")));
    }

    @FXML
    void btnDietNextClicked(ActionEvent event) {
//    	Alert confirm = new Alert(AlertType.ERROR);
//    	confirm.setTitle("오류");
//    	confirm.setHeaderText("나이 유형을 선택해 주세요.");
    	
    	if(ageCode.equals("")) {
    		AlertUtil.error("오류", "ERROR", "나이의 유형을 선택해 주세요.");
    	}else {
    		try {
    			Diet02Controller.setMemVo(memVo);
    			Diet02Controller.setAgeCodeNum(ageCode);
    			
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet02.fxml"));
    			Parent root = loader.load();
    			
    			BorderPane b = (BorderPane) mainStage.getScene().getRoot();
    			b.setCenter(root);
    			
//    			Stage Diet02Stage = new Stage();
//    			Diet02Stage.initModality(Modality.WINDOW_MODAL);
//    			Diet02Stage.setResizable(false);
//    			Diet02Stage.setTitle("추천식단 체형별 선택");
//    			Diet02Controller.setAgeCodeNum(ageCode);
//    			
//    			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet02.fxml"));
//    			Parent root = loader.load();
//    			Diet02Controller Diet02Controller = loader.getController();
//    			Diet02Controller.setDiet02Stage(Diet02Stage);
//    			
//    			Scene scene = new Scene(root);
//    			Diet02Stage.setScene(scene);
//    			Diet02Stage.show();
//    			primaryStage.close();
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    }

    @FXML
    void initialize() {
    	assert DietName != null : "fx:id=\"DietName\" was not injected: check your FXML file 'Diet01.fxml'.";
        assert age01 != null : "fx:id=\"age01\" was not injected: check your FXML file 'Diet01.fxml'.";
        assert age02 != null : "fx:id=\"age02\" was not injected: check your FXML file 'Diet01.fxml'.";
        assert age03 != null : "fx:id=\"age03\" was not injected: check your FXML file 'Diet01.fxml'.";
        assert age04 != null : "fx:id=\"age04\" was not injected: check your FXML file 'Diet01.fxml'.";
        assert age05 != null : "fx:id=\"age05\" was not injected: check your FXML file 'Diet01.fxml'.";
        assert btnDietAge01 != null : "fx:id=\"btnDietAge01\" was not injected: check your FXML file 'Diet01.fxml'.";
        assert btnDietAge02 != null : "fx:id=\"btnDietAge02\" was not injected: check your FXML file 'Diet01.fxml'.";
        assert btnDietAge03 != null : "fx:id=\"btnDietAge03\" was not injected: check your FXML file 'Diet01.fxml'.";
        assert btnDietAge04 != null : "fx:id=\"btnDietAge04\" was not injected: check your FXML file 'Diet01.fxml'.";
        assert btnDietAge05 != null : "fx:id=\"btnDietAge05\" was not injected: check your FXML file 'Diet01.fxml'.";
        assert btnDietNext != null : "fx:id=\"btnDietNext\" was not injected: check your FXML file 'Diet01.fxml'.";
        
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

        btnDietAge01.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnDietAge02.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnDietAge03.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnDietAge04.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnDietAge05.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnDietNext.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());

    }
}
