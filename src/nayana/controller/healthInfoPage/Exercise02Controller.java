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
 * 맞춤운동 상황별 선택 컨트롤러
 * @author 박서경
 */

public class Exercise02Controller {
	
	private Stage exe02Stage;
	private IMemberService memberService;
	private static MemberVO memVo;
	private static String exeAgeCodeNum;
	
    public Stage getExe02Stage() {
		return exe02Stage;
	}

	public void setExe02Stage(Stage exe02Stage) {
		this.exe02Stage = exe02Stage;
	}

	public static MemberVO getMemVo() {
		return memVo;
	}

	public static void setMemVo(MemberVO memVo) {
		Exercise02Controller.memVo = memVo;
	}

	public static String getExeAgeCodeNum() {
		return exeAgeCodeNum;
	}

	public static void setExeAgeCodeNum(String exeAgeCodeNum) {
		Exercise02Controller.exeAgeCodeNum = exeAgeCodeNum;
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
    private Button btnExeNext;

    @FXML
    private Button btnExePrev;

    @FXML
    private Button btnExeStatus01;

    @FXML
    private Button btnExeStatus02;

    @FXML
    private Button btnExeStatus03;

    @FXML
    private Button btnExeStatus04;
    
    String situationCode = "";

    @FXML
    void btnExeNextClicked(ActionEvent event) {
    	if(situationCode.equals("")) {
        	AlertUtil.error("오류", "ERROR", "상황에 맞는 유형을 선택해 주세요.");
    	}else {
	    	try {
	    		Exercise03Controller.setMemVo(memVo);
				Exercise03Controller.setExeAgeCodeNum(exeAgeCodeNum);
				Exercise03Controller.setExeSituCodeNum(situationCode);
				
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise03.fxml"));
    			Parent root = loader.load();
    			
    			BorderPane b = (BorderPane) btnExeStatus04.getScene().getRoot();
    			b.setCenter(root);
	    		
//				Stage Exe03State = new Stage();
//				Exe03State.initModality(Modality.WINDOW_MODAL);
//				Exe03State.setResizable(false);
//				Exe03State.setTitle("맞춤운동 신체부위별 선택");
//				Exercise03Controller.setExeAgeCodeNum(exeAgeCodeNum);
//				Exercise03Controller.setExeSituCodeNum(situationCode);
//				
//				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise03.fxml"));
//				Parent root = loader.load();
//				Exercise03Controller exercise03Controller = loader.getController();
//				exercise03Controller.setExe03Stage(Exe03State);
//				
//				Scene scene = new Scene(root);
//				Exe03State.setScene(scene);
//				Exe03State.show();
//				exe02Stage.close();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void btnExePrevClicked(ActionEvent event) {
    	try {
    		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise01.fxml"));
			Parent root = loader.load();
			
			BorderPane b = (BorderPane) btnExeStatus04.getScene().getRoot();
			b.setCenter(root);
    		
//			Stage Exe01Stage = new Stage();
//			Exe01Stage.initModality(Modality.WINDOW_MODAL);
//			Exe01Stage.setResizable(false);
//			Exe01Stage.setTitle("맞춤운동 나이별 선택");
//			
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise01.fxml"));
//			Parent root = loader.load();
//			Exercise01Controller exercise01Controller = loader.getController();
//			exercise01Controller.setPrimaryStage(Exe01Stage);
//			
//			Scene scene = new Scene(root);
//			Exe01Stage.setScene(scene);
//			Exe01Stage.show();
//			exe02Stage.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnExeStatus01Clicked(ActionEvent event) {
    	situationCode = "실내";
    	if(situationCode.equals("실내")){
    		img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_01_over.png")));
    	}
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_03.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_04.png")));
    }

    @FXML
    void btnExeStatus02Clicked(ActionEvent event) {
    	situationCode = "실외";
    	if(situationCode.equals("실외")){
    		img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_02_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_01.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_03.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_04.png")));
    }

    @FXML
    void btnExeStatus03Clicked(ActionEvent event) {
    	situationCode = "다이어트";
    	if(situationCode.equals("다이어트")){
    		img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_03_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_01.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_02.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_04.png")));
    }

    @FXML
    void btnExeStatus04Clicked(ActionEvent event) {
    	situationCode = "임산부";
    	if(situationCode.equals("임산부")){
    		img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_04_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_01.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/status_03.png")));
    }

    @FXML
    void initialize() {
        assert ExeName != null : "fx:id=\"ExeName\" was not injected: check your FXML file 'Exercise02.fxml'.";
        assert img01 != null : "fx:id=\"img01\" was not injected: check your FXML file 'Exercise02.fxml'.";
        assert img02 != null : "fx:id=\"img02\" was not injected: check your FXML file 'Exercise02.fxml'.";
        assert img03 != null : "fx:id=\"img03\" was not injected: check your FXML file 'Exercise02.fxml'.";
        assert img04 != null : "fx:id=\"img04\" was not injected: check your FXML file 'Exercise02.fxml'.";
        assert btnExeNext != null : "fx:id=\"btnExeNext\" was not injected: check your FXML file 'Exercise02.fxml'.";
        assert btnExePrev != null : "fx:id=\"btnExePrev\" was not injected: check your FXML file 'Exercise02.fxml'.";
        assert btnExeStatus01 != null : "fx:id=\"btnExeStatus01\" was not injected: check your FXML file 'Exercise02.fxml'.";
        assert btnExeStatus02 != null : "fx:id=\"btnExeStatus02\" was not injected: check your FXML file 'Exercise02.fxml'.";
        assert btnExeStatus03 != null : "fx:id=\"btnExeStatus03\" was not injected: check your FXML file 'Exercise02.fxml'.";
        assert btnExeStatus04 != null : "fx:id=\"btnExeStatus04\" was not injected: check your FXML file 'Exercise02.fxml'.";
        
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
        
        btnExeStatus01.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeStatus02.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeStatus03.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeStatus04.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExePrev.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeNext.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
    }
}
