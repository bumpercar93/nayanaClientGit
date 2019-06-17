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

/**
 * 맞춤운동 나이별 선택 컨트롤러
 * @author 박서경
 */

public class Exercise01Controller {
	
	private Stage primaryStage;
	private IMemberService memberService;
	private static MemberVO memVo;

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
		Exercise01Controller.memVo = memVo;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label exeName;

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
    private Button btnExeAge01;

    @FXML
    private Button btnExeAge02;

    @FXML
    private Button btnExeAge03;

    @FXML
    private Button btnExeAge04;

    @FXML
    private Button btnExeAge05;

    @FXML
    private Button btnExeNext;

    String exeAgeCode = "";
    
    @FXML
    void btnExeAge01Clicked(ActionEvent event) {
    	exeAgeCode = "어린이E";
    	if(exeAgeCode.equals("어린이E")){
    		age01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_01_over.png")));
    	}
		age02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_02.png")));
		age03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_03.png")));
		age04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_04.png")));
		age05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_05.png")));
    }

    @FXML
    void btnExeAge02Clicked(ActionEvent event) {
    	exeAgeCode = "청소년E";
    	if(exeAgeCode.equals("청소년E")){
    		age02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_02_over.png")));
    	}
		age01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_01.png")));
		age03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_03.png")));
		age04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_04.png")));
		age05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_05.png")));
    }

    @FXML
    void btnExeAge03Clicked(ActionEvent event) {
    	exeAgeCode = "청년E";
    	if(exeAgeCode.equals("청년E")){
    		age03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_03_over.png")));
    	}
    	age01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_01.png")));
		age02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_02.png")));
		age04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_04.png")));
		age05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_05.png")));
    }

    @FXML
    void btnExeAge04Clicked(ActionEvent event) {
    	exeAgeCode = "중년E";
    	if(exeAgeCode.equals("중년E")){
    		age04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_04_over.png")));
    	}
    	age01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_01.png")));
		age02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_02.png")));
		age03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_03.png")));
		age05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_05.png")));
    }

    @FXML
    void btnExeAge05Clicked(ActionEvent event) {
    	exeAgeCode = "노년E";
    	if(exeAgeCode.equals("노년E")){
    		age05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_05_over.png")));
    	}
    	age01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_01.png")));
		age02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_02.png")));
		age03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_03.png")));
		age04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/age_04.png")));
    }

    @FXML
    void btnExeNextClicked(ActionEvent event) {
    	if(exeAgeCode.equals("")) {
    		AlertUtil.error("오류", "ERROR", "나이의 유형을 선택해 주세요.");
    	}else {
    		try {
    			Exercise02Controller.setMemVo(memVo);
    			Exercise02Controller.setExeAgeCodeNum(exeAgeCode);
    			
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise02.fxml"));
    			Parent root = loader.load();
    			
    			BorderPane b = (BorderPane) btnExeAge05.getScene().getRoot();
    			b.setCenter(root);
    			
//    			Stage Exe02Stage = new Stage();
//    			Exe02Stage.initModality(Modality.WINDOW_MODAL);
//    			Exe02Stage.setResizable(false);
//    			Exe02Stage.setTitle("맞춤운동 상황별 선택");
//    			Exercise02Controller.setExeAgeCodeNum(exeAgeCode);
//    			
//    			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise02.fxml"));
//    			Parent root = loader.load();
//    			Exercise02Controller Exercise02Controller = loader.getController();
//    			Exercise02Controller.setExe02Stage(Exe02Stage);
//    			
//    			Scene scene = new Scene(root);
//    			Exe02Stage.setScene(scene);
//    			Exe02Stage.show();
//    			primaryStage.close();
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		
    	}
    }

    @FXML
    void initialize() {
        assert exeName != null : "fx:id=\"exeName\" was not injected: check your FXML file 'Exercise01.fxml'.";
        assert age01 != null : "fx:id=\"age01\" was not injected: check your FXML file 'Exercise01.fxml'.";
        assert age02 != null : "fx:id=\"age02\" was not injected: check your FXML file 'Exercise01.fxml'.";
        assert age03 != null : "fx:id=\"age03\" was not injected: check your FXML file 'Exercise01.fxml'.";
        assert age04 != null : "fx:id=\"age04\" was not injected: check your FXML file 'Exercise01.fxml'.";
        assert age05 != null : "fx:id=\"age05\" was not injected: check your FXML file 'Exercise01.fxml'.";
        assert btnExeAge01 != null : "fx:id=\"btnExeAge01\" was not injected: check your FXML file 'Exercise01.fxml'.";
        assert btnExeAge02 != null : "fx:id=\"btnExeAge02\" was not injected: check your FXML file 'Exercise01.fxml'.";
        assert btnExeAge03 != null : "fx:id=\"btnExeAge03\" was not injected: check your FXML file 'Exercise01.fxml'.";
        assert btnExeAge04 != null : "fx:id=\"btnExeAge04\" was not injected: check your FXML file 'Exercise01.fxml'.";
        assert btnExeAge05 != null : "fx:id=\"btnExeAge05\" was not injected: check your FXML file 'Exercise01.fxml'.";
        assert btnExeNext != null : "fx:id=\"btnExeNext\" was not injected: check your FXML file 'Exercise01.fxml'.";
        
        try {
    		Registry reg = LocateRegistry.getRegistry("localhost", 8888);
    		memberService = (IMemberService) reg.lookup("memberService");
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	} catch (NotBoundException e) {
    		e.printStackTrace();
    	}
        
        //로그인한 회원의 이름
        exeName.setText(memVo.getMem_name());

        btnExeAge01.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeAge02.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeAge03.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeAge04.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeAge05.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeNext.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());

    }
}
