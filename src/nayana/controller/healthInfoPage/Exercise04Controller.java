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
 * 맞춤운동 질병별 선택 컨트롤러
 * @author 박서경
 */
public class Exercise04Controller {
	
	private Stage exe04Stage;
	private IMemberService memberService;
	private static MemberVO memVo;
	private static String exeAgeCodeNum;
	private static String exeSituCodeNum;
	private static String exeBodyCodeNum;
	
    public Stage getExe04Stage() {
		return exe04Stage;
	}

	public void setExe04Stage(Stage exe04Stage) {
		this.exe04Stage = exe04Stage;
	}

	public static MemberVO getMemVo() {
		return memVo;
	}

	public static void setMemVo(MemberVO memVo) {
		Exercise04Controller.memVo = memVo;
	}

	public static String getExeAgeCodeNum() {
		return exeAgeCodeNum;
	}

	public static void setExeAgeCodeNum(String exeAgeCodeNum) {
		Exercise04Controller.exeAgeCodeNum = exeAgeCodeNum;
	}

	public static String getExeSituCodeNum() {
		return exeSituCodeNum;
	}

	public static void setExeSituCodeNum(String exeSituCodeNum) {
		Exercise04Controller.exeSituCodeNum = exeSituCodeNum;
	}

	public static String getExeBodyCodeNum() {
		return exeBodyCodeNum;
	}

	public static void setExeBodyCodeNum(String exeBodyCodeNum) {
		Exercise04Controller.exeBodyCodeNum = exeBodyCodeNum;
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
    private Button btnExeDss01;

    @FXML
    private Button btnExeDss02;

    @FXML
    private Button btnExeDss03;

    @FXML
    private Button btnExeDss04;

    @FXML
    private Button btnExeDss05;

    @FXML
    private Button btnExeDss06;
    
    String exeDssCode = "";
    @FXML
    void btnExeDss01Clicked(ActionEvent event) {
    	exeDssCode = "암E";
    	if(exeDssCode.equals("암E")){
    		img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_01_over.png")));
    	}
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_03.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_04.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_05.png")));
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_06.png")));
    }

    @FXML
    void btnExeDss02Clicked(ActionEvent event) {
    	exeDssCode = "심혈관E";
    	if(exeDssCode.equals("심혈관E")){
    		img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_02_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_01.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_03.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_04.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_05.png")));
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_06.png")));
    }

    @FXML
    void btnExeDss03Clicked(ActionEvent event) {
    	exeDssCode = "당뇨E";
    	if(exeDssCode.equals("당뇨E")){
    		img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_03_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_01.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_02.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_04.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_05.png")));
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_06.png")));
    }

    @FXML
    void btnExeDss04Clicked(ActionEvent event) {
    	exeDssCode = "관절E";
    	if(exeDssCode.equals("관절E")){
    		img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_04_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_01.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_03.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_05.png")));
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_06.png")));
    }

    @FXML
    void btnExeDss05Clicked(ActionEvent event) {
    	exeDssCode = "뇌질환E";
    	if(exeDssCode.equals("뇌질환E")){
    		img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_05_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_01.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_03.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_04.png")));
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_06.png")));
    }

    @FXML
    void btnExeDss06Clicked(ActionEvent event) {
    	exeDssCode = "없음E";
    	if(exeDssCode.equals("없음E")){
    		img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_06_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_01.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_03.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_04.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_05.png")));
    }

    @FXML
    void btnExeNextClicked(ActionEvent event) {
    	
    	if(exeDssCode.equals("")) {
    		AlertUtil.error("오류", "ERROR", "질병 유형을 선택해 주세요.");
    	}else {
	    	try {
	    		Exercise05Controller.setMemVo(memVo);
				Exercise05Controller.setExeAgeCodeNum(exeAgeCodeNum);
				Exercise05Controller.setExeSituCodeNum(exeSituCodeNum);
				Exercise05Controller.setExeBodyCodeNum(exeBodyCodeNum);
				Exercise05Controller.setExeDssCodeNum(exeDssCode);
	    		
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise05.fxml"));
				Parent root = loader.load();
				
				BorderPane b = (BorderPane) btnExeDss06.getScene().getRoot();
				b.setCenter(root);
	    		
//				Stage Exe05State = new Stage();
//				Exe05State.initModality(Modality.WINDOW_MODAL);
//				Exe05State.setResizable(false);
//				Exe05State.setTitle("추천식단 결과");
//				Exercise05Controller.setExeAgeCodeNum(exeAgeCodeNum);
//				Exercise05Controller.setExeSituCodeNum(exeSituCodeNum);
//				Exercise05Controller.setExeBodyCodeNum(exeBodyCodeNum);
//				Exercise05Controller.setExeDssCodeNum(exeDssCode);
//				
//				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise05.fxml"));
//				Parent root = loader.load();
//				Exercise05Controller exercise05Controller = loader.getController();
//				exercise05Controller.setExe05Stage(Exe05State);
//				
//				Scene scene = new Scene(root);
//				Exe05State.setScene(scene);
//				Exe05State.show();
//				exe04Stage.close();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void btnExePrevClicked(ActionEvent event) {
    	try {
    		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise03.fxml"));
			Parent root = loader.load();
			
			BorderPane b = (BorderPane) btnExeDss06.getScene().getRoot();
			b.setCenter(root);
    		
//			Stage Exe03Stage = new Stage();
//			Exe03Stage.initModality(Modality.WINDOW_MODAL);
//			Exe03Stage.setResizable(false);
//			Exe03Stage.setTitle("맞춤운동 신체부위별 선택");
//			
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise03.fxml"));
//			Parent root = loader.load();
//			Exercise03Controller exercise03Controller = loader.getController();
//			exercise03Controller.setExe03Stage(Exe03Stage);
//			
//			Scene scene = new Scene(root);
//			Exe03Stage.setScene(scene);
//			Exe03Stage.show();
//			exe04Stage.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert DietName != null : "fx:id=\"DietName\" was not injected: check your FXML file 'Exercise04.fxml'.";
        assert img01 != null : "fx:id=\"img01\" was not injected: check your FXML file 'Exercise04.fxml'.";
        assert img02 != null : "fx:id=\"img02\" was not injected: check your FXML file 'Exercise04.fxml'.";
        assert img03 != null : "fx:id=\"img03\" was not injected: check your FXML file 'Exercise04.fxml'.";
        assert img04 != null : "fx:id=\"img04\" was not injected: check your FXML file 'Exercise04.fxml'.";
        assert img05 != null : "fx:id=\"img05\" was not injected: check your FXML file 'Exercise04.fxml'.";
        assert img06 != null : "fx:id=\"img06\" was not injected: check your FXML file 'Exercise04.fxml'.";
        assert btnExeNext != null : "fx:id=\"btnExeNext\" was not injected: check your FXML file 'Exercise04.fxml'.";
        assert btnExePrev != null : "fx:id=\"btnExePrev\" was not injected: check your FXML file 'Exercise04.fxml'.";
        assert btnExeDss01 != null : "fx:id=\"btnExeDss01\" was not injected: check your FXML file 'Exercise04.fxml'.";
        assert btnExeDss02 != null : "fx:id=\"btnExeDss02\" was not injected: check your FXML file 'Exercise04.fxml'.";
        assert btnExeDss03 != null : "fx:id=\"btnExeDss03\" was not injected: check your FXML file 'Exercise04.fxml'.";
        assert btnExeDss04 != null : "fx:id=\"btnExeDss04\" was not injected: check your FXML file 'Exercise04.fxml'.";
        assert btnExeDss05 != null : "fx:id=\"btnExeDss05\" was not injected: check your FXML file 'Exercise04.fxml'.";
        assert btnExeDss06 != null : "fx:id=\"btnExeDss06\" was not injected: check your FXML file 'Exercise04.fxml'.";
        
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
        
        btnExeDss01.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeDss02.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeDss03.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeDss04.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeDss05.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeDss06.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExePrev.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnExeNext.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
    }
}
