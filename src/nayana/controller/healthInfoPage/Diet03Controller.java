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
import nayana.vo.RDResultVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class Diet03Controller {
	
	private Stage diet03Stage;
	private static String ageCodeNum;
	private static String weightCodeNum;
	private IMemberService memberService;
	private static MemberVO memVo;
	private static Stage mainStage;

    public static void setMainStage(Stage mainStage) {
		Diet03Controller.mainStage = mainStage;
	}

	public Stage getDiet03Stage() {
		return diet03Stage;
	}

	public void setDiet03Stage(Stage diet03Stage) {
		this.diet03Stage = diet03Stage;
	}

	public static String getAgeCodeNum() {
		return ageCodeNum;
	}

	public static void setAgeCodeNum(String ageCodeNum) {
		Diet03Controller.ageCodeNum = ageCodeNum;
	}

	public static String getWeightCodeNum() {
		return weightCodeNum;
	}

	public static void setWeightCodeNum(String weightCodeNum) {
		Diet03Controller.weightCodeNum = weightCodeNum;
	}

	public static MemberVO getMemVo() {
		return memVo;
	}

	public static void setMemVo(MemberVO memVo) {
		Diet03Controller.memVo = memVo;
	}

	public Label getDietName() {
		return DietName;
	}

	public void setDietName(Label dietName) {
		DietName = dietName;
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
    private Button btnDietNext;

    @FXML
    private Button btnDietPrev;

    @FXML
    private Button btnDietDss01;

    @FXML
    private Button btnDietDss02;

    @FXML
    private Button btnDietDss03;

    @FXML
    private Button btnDietDss04;

    @FXML
    private Button btnDietDss05;

    @FXML
    private Button btnDietDss06;

    String dssCode = "";
    @FXML
    void btnDietDss01Clicked(ActionEvent event) {
    	dssCode = "암D";
    	if(dssCode.equals("암D")){
    		img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_01_over.png")));
    	}
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_03.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_04.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_05.png")));
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_06.png")));
    }

    @FXML
    void btnDietDss02Clicked(ActionEvent event) {
    	dssCode = "심혈관D";
    	if(dssCode.equals("심혈관D")){
    		img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_02_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_01.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_03.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_04.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_05.png")));
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_06.png")));
    }

    @FXML
    void btnDietDss03Clicked(ActionEvent event) {
    	dssCode = "당뇨D";
    	if(dssCode.equals("당뇨D")){
    		img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_03_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_01.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_02.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_04.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_05.png")));
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_06.png")));
    }

    @FXML
    void btnDietDss04Clicked(ActionEvent event) {
    	dssCode = "관절D";
    	if(dssCode.equals("관절D")){
    		img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_04_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_01.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_03.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_05.png")));
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_06.png")));
    }

    @FXML
    void btnDietDss05Clicked(ActionEvent event) {
    	dssCode = "뇌질환D";
    	if(dssCode.equals("뇌질환D")){
    		img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_05_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_01.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_03.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_04.png")));
    	img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_06.png")));
    }

    @FXML
    void btnDietDss06Clicked(ActionEvent event) {
    	dssCode = "없음D";
    	if(dssCode.equals("없음D")){
    		img06.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_06_over.png")));
    	}
    	img01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_01.png")));
    	img02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_02.png")));
    	img03.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_03.png")));
    	img04.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_04.png")));
    	img05.setImage(new Image(getClass().getResourceAsStream("../../../util/images/dss_05.png")));
    }

    @FXML
    void btnDietNextClicked(ActionEvent event) {
    	if(dssCode.equals("")) {
    		AlertUtil.error("오류", "ERROR", "질병의 유형을 선택해 주세요.");
    	}else {
	    	try {
	    		Diet04Controller.setMemVo(memVo);
				Diet04Controller.setAgeCodeNum(ageCodeNum);
				Diet04Controller.setWeightCodeNum(weightCodeNum);
				Diet04Controller.setDssCodeNum(dssCode);
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet04.fxml"));
				Parent root = loader.load();
				
				BorderPane b = (BorderPane) btnDietDss06.getScene().getRoot();
				b.setCenter(root);
				
				
	//			Stage Diet04Stage = new Stage();
	//			Diet04Stage.initModality(Modality.WINDOW_MODAL);
	//			Diet04Stage.setResizable(false);
	//			Diet04Stage.setTitle("추천식단");
	//			Diet04Controller.setAgeCodeNum(ageCodeNum);
	//			Diet04Controller.setWeightCodeNum(weightCodeNum);
	//			Diet04Controller.setDssCodeNum(dssCode);
	//			
	//			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet04.fxml"));
	//			Parent root = loader.load();
	//			Diet04Controller Diet04Controller = loader.getController();
	//			Diet04Controller.setDiet04Stage(Diet04Stage);
	//			
	//			Scene scene = new Scene(root);
	//			Diet04Stage.setScene(scene);
	//			Diet04Stage.show();
	//			diet03Stage.close();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void btnDietPrevClicked(ActionEvent event) {
    	
    	try {
    		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet02.fxml"));
			Parent root = loader.load();
			
			BorderPane b = (BorderPane) btnDietDss06.getScene().getRoot();
			b.setCenter(root);
    		
//			Stage Diet02Stage = new Stage();
//			Diet02Stage.initModality(Modality.WINDOW_MODAL);
//			Diet02Stage.setResizable(false);
//			Diet02Stage.setTitle("추천식단 체형 선택");
//
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet02.fxml"));
//			Parent root = loader.load();
//			Diet02Controller Diet02Controller = loader.getController();
//			Diet02Controller.setDiet02Stage(Diet02Stage);
//			
//			Scene scene = new Scene(root);
//			Diet02Stage.setScene(scene);
//			Diet02Stage.show();
//			diet03Stage.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//    	System.out.println(ageCodeNum);
//    	System.out.println(weightCodeNum);
//    	System.out.println(dssCode);
    }

    @FXML
    void initialize() { 
        assert DietName != null : "fx:id=\"DietName\" was not injected: check your FXML file 'Diet03.fxml'.";
        assert img01 != null : "fx:id=\"img01\" was not injected: check your FXML file 'Diet03.fxml'.";
        assert img02 != null : "fx:id=\"img02\" was not injected: check your FXML file 'Diet03.fxml'.";
        assert img03 != null : "fx:id=\"img03\" was not injected: check your FXML file 'Diet03.fxml'.";
        assert img04 != null : "fx:id=\"img04\" was not injected: check your FXML file 'Diet03.fxml'.";
        assert img05 != null : "fx:id=\"img05\" was not injected: check your FXML file 'Diet03.fxml'.";
        assert img06 != null : "fx:id=\"img06\" was not injected: check your FXML file 'Diet03.fxml'.";
        assert btnDietNext != null : "fx:id=\"btnDietNext\" was not injected: check your FXML file 'Diet03.fxml'.";
        assert btnDietPrev != null : "fx:id=\"btnDietPrev\" was not injected: check your FXML file 'Diet03.fxml'.";
        assert btnDietDss01 != null : "fx:id=\"btnDietDss01\" was not injected: check your FXML file 'Diet03.fxml'.";
        assert btnDietDss02 != null : "fx:id=\"btnDietDss02\" was not injected: check your FXML file 'Diet03.fxml'.";
        assert btnDietDss03 != null : "fx:id=\"btnDietDss03\" was not injected: check your FXML file 'Diet03.fxml'.";
        assert btnDietDss04 != null : "fx:id=\"btnDietDss04\" was not injected: check your FXML file 'Diet03.fxml'.";
        assert btnDietDss05 != null : "fx:id=\"btnDietDss05\" was not injected: check your FXML file 'Diet03.fxml'.";
        assert btnDietDss06 != null : "fx:id=\"btnDietDss06\" was not injected: check your FXML file 'Diet03.fxml'.";
        
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
        
        btnDietDss01.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnDietDss02.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnDietDss03.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnDietDss04.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnDietDss05.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnDietDss06.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnDietNext.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        btnDietPrev.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());

    }
}
