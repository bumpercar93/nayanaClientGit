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
 * 맞춤운동 신체부위별 선택 컨트롤러
 * @author 박서경
 */
public class Exercise03Controller {
	
	private Stage exe03Stage;
	private IMemberService memberService;
	private static MemberVO memVo;
	private static String exeAgeCodeNum;
	private static String exeSituCodeNum;

	public Stage getExe03Stage() {
		return exe03Stage;
	}

	public void setExe03Stage(Stage exe03Stage) {
		this.exe03Stage = exe03Stage;
	}

	public static MemberVO getMemVo() {
		return memVo;
	}

	public static void setMemVo(MemberVO memVo) {
		Exercise03Controller.memVo = memVo;
	}

	public static String getExeAgeCodeNum() {
		return exeAgeCodeNum;
	}

	public static void setExeAgeCodeNum(String exeAgeCodeNum) {
		Exercise03Controller.exeAgeCodeNum = exeAgeCodeNum;
	}

	public static String getExeSituCodeNum() {
		return exeSituCodeNum;
	}

	public static void setExeSituCodeNum(String exeSituCodeNum) {
		Exercise03Controller.exeSituCodeNum = exeSituCodeNum;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ExeName;

    @FXML
    private ImageView img01;

    @FXML
    private ImageView img02;

    @FXML
    private ImageView img03;

    @FXML
    private ImageView img04;

    @FXML
    private ImageView img05;

    @FXML
    private ImageView img06;

    @FXML
    private Button btnExeNext;

    @FXML
    private Button btnExePrev;

    @FXML
    private Button btnExeBody01;

    @FXML
    private Button btnExeBody02;

    @FXML
    private Button btnExeBody03;

    @FXML
    private Button btnExeBody04;

    @FXML
    private Button btnExeBody05;

    @FXML
    private Button btnExeBody06;
    
    String bodyCode = "";
    
    @FXML
    void btnExeBody01Clicked(ActionEvent event) {
    	bodyCode = "팔";
    	if(bodyCode.equals("팔")){
    		img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_01_over.png")));
    	}
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_03.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_04.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_05.png")));
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_06.png")));
    }

    @FXML
    void btnExeBody02Clicked(ActionEvent event) {
    	bodyCode = "다리";
    	if(bodyCode.equals("다리")){
    		img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_02_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_01.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_03.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_04.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_05.png")));
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_06.png")));
    }

    @FXML
    void btnExeBody03Clicked(ActionEvent event) {
    	bodyCode = "가슴";
    	if(bodyCode.equals("가슴")){
    		img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_03_over.png")));
    	}
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_06.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_05.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_03.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_02.png")));
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_01.png")));
    }

    @FXML
    void btnExeBody04Clicked(ActionEvent event) {
    	bodyCode = "어깨";
    	if(bodyCode.equals("어깨")){
    		img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_04_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_01.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_03.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_05.png")));
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_06.png")));
    }

    @FXML
    void btnExeBody05Clicked(ActionEvent event) {
    	bodyCode = "등";
    	if(bodyCode.equals("등")){
    		img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_05_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_01.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_03.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_04.png")));
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_06.png")));
    }

    @FXML
    void btnExeBody06Clicked(ActionEvent event) {
    	bodyCode = "복부";
    	if(bodyCode.equals("복부")){
    		img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_06_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_01.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_03.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_04.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/body_05.png")));
    }

    @FXML
    void btnExeNextClicked(ActionEvent event) {
    	if(bodyCode.equals("")) {
        	AlertUtil.error("오류", "ERROR", "신체부위를 선택해 주세요.");
    	}else {
	    	try {
	    		Exercise04Controller.setMemVo(memVo);
				Exercise04Controller.setExeAgeCodeNum(exeAgeCodeNum);
				Exercise04Controller.setExeSituCodeNum(exeSituCodeNum);
				Exercise04Controller.setExeBodyCodeNum(bodyCode);
	    		
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise04.fxml"));
				Parent root = loader.load();
				
				BorderPane b = (BorderPane) btnExeBody05.getScene().getRoot();
				b.setCenter(root);
	    		
//				Stage Exe04State = new Stage();
//				Exe04State.initModality(Modality.WINDOW_MODAL);
//				Exe04State.setResizable(false);
//				Exe04State.setTitle("맞춤운동 신체부위별 선택");
//				Exercise04Controller.setExeAgeCodeNum(exeAgeCodeNum);
//				Exercise04Controller.setExeSituCodeNum(exeSituCodeNum);
//				Exercise04Controller.setExeBodyCodeNum(bodyCode);
//				
//				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise04.fxml"));
//				Parent root = loader.load();
//				Exercise04Controller exercise04Controller = loader.getController();
//				exercise04Controller.setExe04Stage(Exe04State);
//				
//				Scene scene = new Scene(root);
//				Exe04State.setScene(scene);
//				Exe04State.show();
//				exe03Stage.close();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void btnExePrevClicked(ActionEvent event) {
    	try {
    		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise02.fxml"));
			Parent root = loader.load();
			
			BorderPane b = (BorderPane) btnExeBody05.getScene().getRoot();
			b.setCenter(root);
    		
//			Stage Exe02Stage = new Stage();
//			Exe02Stage.initModality(Modality.WINDOW_MODAL);
//			Exe02Stage.setResizable(false);
//			Exe02Stage.setTitle("맞춤운동 상황별 선택");
//			
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise02.fxml"));
//			Parent root = loader.load();
//			Exercise02Controller exercise02Controller = loader.getController();
//			exercise02Controller.setExe02Stage(Exe02Stage);
//			
//			Scene scene = new Scene(root);
//			Exe02Stage.setScene(scene);
//			Exe02Stage.show();
//			exe03Stage.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert ExeName != null : "fx:id=\"ExeName\" was not injected: check your FXML file 'Exercise03.fxml'.";
        assert img01 != null : "fx:id=\"img01\" was not injected: check your FXML file 'Exercise03.fxml'.";
        assert img02 != null : "fx:id=\"img02\" was not injected: check your FXML file 'Exercise03.fxml'.";
        assert img03 != null : "fx:id=\"img03\" was not injected: check your FXML file 'Exercise03.fxml'.";
        assert img04 != null : "fx:id=\"img04\" was not injected: check your FXML file 'Exercise03.fxml'.";
        assert img05 != null : "fx:id=\"img05\" was not injected: check your FXML file 'Exercise03.fxml'.";
        assert img06 != null : "fx:id=\"img06\" was not injected: check your FXML file 'Exercise03.fxml'.";
        assert btnExeNext != null : "fx:id=\"btnExeNext\" was not injected: check your FXML file 'Exercise03.fxml'.";
        assert btnExePrev != null : "fx:id=\"btnExePrev\" was not injected: check your FXML file 'Exercise03.fxml'.";
        assert btnExeBody01 != null : "fx:id=\"btnExeBody01\" was not injected: check your FXML file 'Exercise03.fxml'.";
        assert btnExeBody02 != null : "fx:id=\"btnExeBody02\" was not injected: check your FXML file 'Exercise03.fxml'.";
        assert btnExeBody03 != null : "fx:id=\"btnExeBody03\" was not injected: check your FXML file 'Exercise03.fxml'.";
        assert btnExeBody04 != null : "fx:id=\"btnExeBody04\" was not injected: check your FXML file 'Exercise03.fxml'.";
        assert btnExeBody05 != null : "fx:id=\"btnExeBody05\" was not injected: check your FXML file 'Exercise03.fxml'.";
        assert btnExeBody06 != null : "fx:id=\"btnExeBody06\" was not injected: check your FXML file 'Exercise03.fxml'.";
        
        try {
    		Registry reg = LocateRegistry.getRegistry("localhost", 8888);
    		memberService = (IMemberService) reg.lookup("memberService");
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	} catch (NotBoundException e) {
    		e.printStackTrace();
    	}
        
        //로그인한 회원의 이름
        ExeName.setText(memVo.getMem_name());
        
        btnExeBody01.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeBody02.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeBody03.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeBody04.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeBody05.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeBody06.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExePrev.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeNext.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
    }
}
