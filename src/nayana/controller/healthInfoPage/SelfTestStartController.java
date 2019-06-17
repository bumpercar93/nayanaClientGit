package nayana.controller.healthInfoPage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nayana.SelfTestInfo.service.ISelfTestInfoService;
import nayana.SelfTestResult.service.ISelfTestResultService;
import nayana.vo.MemberVO;
import nayana.vo.SelfTestInfoVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class SelfTestStartController {
	
	private static Stage mainStage;
	
	public static void setMainStage(Stage mainStage) {
		SelfTestStartController.mainStage = mainStage;
	}

	private SelfTestController stc;
	
	public void setStc(SelfTestController stc) {
		this.stc = stc;
	}

	private ISelfTestResultService strService;
	private static int self_seq;
	
	public static void setSelf_seq(int self_seq) {
		SelfTestStartController.self_seq = self_seq;
	}

	private static MemberVO memVO;

	public static void setMemVO(MemberVO memVO) {
		SelfTestStartController.memVO = memVO;
	}

	private ISelfTestInfoService stiService;
	
	private static List<String> list;
	
	public static void setList(List<String> list) {
		SelfTestStartController.list = list;
	}

	private static String title;
	
	public static void setTitle(String title) {
		SelfTestStartController.title = title;
	}

	private Stage thisStage;
	
    public Stage getThisStage() {
		return thisStage;
	}

	public void setThisStage(Stage thisStage) {
		this.thisStage = thisStage;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label TitleLabel;

    @FXML
    private Label Question1;

    @FXML
    private ToggleGroup Toggle1;

    @FXML
    private Label Question2;

    @FXML
    private ToggleGroup Toggle2;

    @FXML
    private Label Question3;

    @FXML
    private ToggleGroup Toggle3;

    @FXML
    private Label Question4;

    @FXML
    private ToggleGroup Toggle4;

    @FXML
    private Label Question5;

    @FXML
    private ToggleGroup Toggle5;

    @FXML
    private Label Question6;

    @FXML
    private ToggleGroup Toggle6;

    @FXML
    private Label Question7;

    @FXML
    private ToggleGroup Toggle7;

    @FXML
    private Label Question8;

    @FXML
    private ToggleGroup Toggle8;

    @FXML
    private Label Question9;

    @FXML
    private ToggleGroup Toggle9;

    @FXML
    private Label Question10;

    @FXML
    private ToggleGroup Toggle10;

    @FXML
    private Label Question11;

    @FXML
    private ToggleGroup Toggle11;

    @FXML
    private Label Question12;

    @FXML
    private ToggleGroup Toggle12;

    @FXML
    private Label Question13;

    @FXML
    private ToggleGroup Toggle13;

    @FXML
    private Label Question14;

    @FXML
    private ToggleGroup Toggle14;

    @FXML
    private Label Question15;

    @FXML
    private ToggleGroup Toggle15;

    @FXML
    private Label Question16;

    @FXML
    private ToggleGroup Toggle16;

    @FXML
    private Label Question17;

    @FXML
    private ToggleGroup Toggle17;

    @FXML
    private Label Question18;

    @FXML
    private ToggleGroup Toggle18;

    @FXML
    private Label Question19;

    @FXML
    private ToggleGroup Toggle19;

    @FXML
    private Label Question20;

    @FXML
    private ToggleGroup Toggle20;

    @FXML
    private Button FinishBtn;

    @FXML
    void ClickFinishBtn(ActionEvent event) {
    	
    	if(Toggle1.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle2.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle3.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle4.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle5.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle6.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle7.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle8.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle9.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle10.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle11.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle12.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle13.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle14.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle15.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle16.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle17.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle18.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle19.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	if(Toggle20.getSelectedToggle() == null) {
    		AlertUtil.error("ERROR", "선택 누락", "선택되지 않은 값이 있습니다\n모든 항목에 체크를 해주세요");
    		return;
    	}
    	
    	RadioButton b1 = (RadioButton) Toggle1.getSelectedToggle();
    	String result1 = b1.getText();
    	RadioButton b2 = (RadioButton) Toggle2.getSelectedToggle();
    	String result2 = b2.getText();
    	RadioButton b3 = (RadioButton) Toggle3.getSelectedToggle();
    	String result3 = b3.getText();
    	RadioButton b4 = (RadioButton) Toggle4.getSelectedToggle();
    	String result4 = b4.getText();
    	RadioButton b5 = (RadioButton) Toggle5.getSelectedToggle();
    	String result5 = b5.getText();
    	RadioButton b6 = (RadioButton) Toggle6.getSelectedToggle();
    	String result6 = b6.getText();
    	RadioButton b7 = (RadioButton) Toggle7.getSelectedToggle();
    	String result7 = b7.getText();
    	RadioButton b8 = (RadioButton) Toggle8.getSelectedToggle();
    	String result8 = b8.getText();
    	RadioButton b9 = (RadioButton) Toggle9.getSelectedToggle();
    	String result9 = b9.getText();
    	RadioButton b10 = (RadioButton) Toggle10.getSelectedToggle();
    	String result10 = b10.getText();
    	RadioButton b11 = (RadioButton) Toggle11.getSelectedToggle();
    	String result11 = b11.getText();
    	RadioButton b12 = (RadioButton) Toggle12.getSelectedToggle();
    	String result12 = b12.getText();
    	RadioButton b13 = (RadioButton) Toggle13.getSelectedToggle();
    	String result13 = b13.getText();
    	RadioButton b14 = (RadioButton) Toggle14.getSelectedToggle();
    	String result14 = b14.getText();
    	RadioButton b15 = (RadioButton) Toggle15.getSelectedToggle();
    	String result15 = b15.getText();
    	RadioButton b16 = (RadioButton) Toggle16.getSelectedToggle();
    	String result16 = b16.getText();
    	RadioButton b17 = (RadioButton) Toggle17.getSelectedToggle();
    	String result17 = b17.getText();
    	RadioButton b18 = (RadioButton) Toggle18.getSelectedToggle();
    	String result18 = b18.getText();
    	RadioButton b19 = (RadioButton) Toggle19.getSelectedToggle();
    	String result19 = b19.getText();
    	RadioButton b20 = (RadioButton) Toggle20.getSelectedToggle();
    	String result20 = b20.getText();
    	
    	int score = 0;
    	if(result1.equals("항상")) {
    		score += 3;
    	}else if(result1.equals("자주")) {
    		score += 2;
    	}else if(result1.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result2.equals("항상")) {
    		score += 3;
    	}else if(result2.equals("자주")) {
    		score += 2;
    	}else if(result2.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result3.equals("항상")) {
    		score += 3;
    	}else if(result3.equals("자주")) {
    		score += 2;
    	}else if(result3.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result4.equals("항상")) {
    		score += 3;
    	}else if(result4.equals("자주")) {
    		score += 2;
    	}else if(result4.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result5.equals("항상")) {
    		score += 3;
    	}else if(result5.equals("자주")) {
    		score += 2;
    	}else if(result5.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result6.equals("항상")) {
    		score += 3;
    	}else if(result6.equals("자주")) {
    		score += 2;
    	}else if(result6.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result7.equals("항상")) {
    		score += 3;
    	}else if(result7.equals("자주")) {
    		score += 2;
    	}else if(result7.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result8.equals("항상")) {
    		score += 3;
    	}else if(result8.equals("자주")) {
    		score += 2;
    	}else if(result8.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result9.equals("항상")) {
    		score += 3;
    	}else if(result9.equals("자주")) {
    		score += 2;
    	}else if(result9.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result10.equals("항상")) {
    		score += 3;
    	}else if(result10.equals("자주")) {
    		score += 2;
    	}else if(result10.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result11.equals("항상")) {
    		score += 3;
    	}else if(result11.equals("자주")) {
    		score += 2;
    	}else if(result11.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result12.equals("항상")) {
    		score += 3;
    	}else if(result12.equals("자주")) {
    		score += 2;
    	}else if(result12.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result13.equals("항상")) {
    		score += 3;
    	}else if(result13.equals("자주")) {
    		score += 2;
    	}else if(result13.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result14.equals("항상")) {
    		score += 3;
    	}else if(result14.equals("자주")) {
    		score += 2;
    	}else if(result14.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result15.equals("항상")) {
    		score += 3;
    	}else if(result15.equals("자주")) {
    		score += 2;
    	}else if(result15.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result16.equals("항상")) {
    		score += 3;
    	}else if(result16.equals("자주")) {
    		score += 2;
    	}else if(result16.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result17.equals("항상")) {
    		score += 3;
    	}else if(result17.equals("자주")) {
    		score += 2;
    	}else if(result17.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result18.equals("항상")) {
    		score += 3;
    	}else if(result18.equals("자주")) {
    		score += 2;
    	}else if(result18.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result19.equals("항상")) {
    		score += 3;
    	}else if(result19.equals("자주")) {
    		score += 2;
    	}else if(result19.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	if(result20.equals("항상")) {
    		score += 3;
    	}else if(result20.equals("자주")) {
    		score += 2;
    	}else if(result20.equals("가끔")) {
    		score += 1;
    	}else {
    		
    	}
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("self_seq", self_seq);
    	map.put("mem_id", memVO.getMem_id());
    	try {
			String res = stiService.getMyTestDate(map);
			if(res == null) {
				SelfTestInfoVO stiVO = new SelfTestInfoVO();
				stiVO.setSelf_seq(self_seq);
				stiVO.setSelf_test_score(score);
				stiVO.setMem_id(memVO.getMem_id());
				stiService.insertSelfTestInfo(stiVO);
			}else {
				Map<String, Object> map2 = new HashMap<String, Object>();
				map2.put("self_test_score", score);
				map2.put("self_seq", self_seq);
				map2.put("mem_id", memVO.getMem_id());
				stiService.updateSelfTestInfo(map2);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	
    	int temp = 0;
    	if(score <= 20) {
    		temp = 20;
    	}else if(score <= 40) {
    		temp = 40;
    	}else {
    		temp = 60;
    	}
    	
    	Map<String, Integer> map2 = new HashMap<String, Integer>();
    	map2.put("self_seq", self_seq);
    	map2.put("self_rs_score", temp);
    	String result = "";
    	try {
    		result = strService.selectSelfTestResult(map2);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	try {
			Stage selfTestResultStage = new Stage();
			selfTestResultStage.initModality(Modality.WINDOW_MODAL);
			selfTestResultStage.setResizable(false);
			selfTestResultStage.initOwner(mainStage);
			selfTestResultStage.setTitle("RESULT");
			
			SelfTestResultController.setMemVO(memVO);
			SelfTestResultController.setTestResult(result);
			SelfTestResultController.setTestScore(score);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/SelfTestResult.fxml"));
			Parent root = loader.load();
			SelfTestResultController sc = loader.getController();
			sc.setThisStage(selfTestResultStage);
			
			Scene scene = new Scene(root);
			selfTestResultStage.setScene(scene);
			selfTestResultStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	thisStage.close();
    	stc.setLastDate();
    }

    @FXML
    void initialize() {
        assert TitleLabel != null : "fx:id=\"TitleLabel\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question1 != null : "fx:id=\"Question1\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle1 != null : "fx:id=\"Toggle1\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question2 != null : "fx:id=\"Question2\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle2 != null : "fx:id=\"Toggle2\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question3 != null : "fx:id=\"Question3\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle3 != null : "fx:id=\"Toggle3\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question4 != null : "fx:id=\"Question4\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle4 != null : "fx:id=\"Toggle4\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question5 != null : "fx:id=\"Question5\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle5 != null : "fx:id=\"Toggle5\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question6 != null : "fx:id=\"Question6\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle6 != null : "fx:id=\"Toggle6\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question7 != null : "fx:id=\"Question7\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle7 != null : "fx:id=\"Toggle7\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question8 != null : "fx:id=\"Question8\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle8 != null : "fx:id=\"Toggle8\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question9 != null : "fx:id=\"Question9\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle9 != null : "fx:id=\"Toggle9\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question10 != null : "fx:id=\"Question10\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle10 != null : "fx:id=\"Toggle10\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question11 != null : "fx:id=\"Question11\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle11 != null : "fx:id=\"Toggle11\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question12 != null : "fx:id=\"Question12\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle12 != null : "fx:id=\"Toggle12\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question13 != null : "fx:id=\"Question13\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle13 != null : "fx:id=\"Toggle13\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question14 != null : "fx:id=\"Question14\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle14 != null : "fx:id=\"Toggle14\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question15 != null : "fx:id=\"Question15\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle15 != null : "fx:id=\"Toggle15\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question16 != null : "fx:id=\"Question16\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle16 != null : "fx:id=\"Toggle16\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question17 != null : "fx:id=\"Question17\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle17 != null : "fx:id=\"Toggle17\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question18 != null : "fx:id=\"Question18\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle18 != null : "fx:id=\"Toggle18\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question19 != null : "fx:id=\"Question19\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle19 != null : "fx:id=\"Toggle19\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Question20 != null : "fx:id=\"Question20\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert Toggle20 != null : "fx:id=\"Toggle20\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        assert FinishBtn != null : "fx:id=\"FinishBtn\" was not injected: check your FXML file 'SelfTestStart.fxml'.";
        
        FinishBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        try {
  			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
  			stiService =  (ISelfTestInfoService) reg.lookup("selfTestInfoService");
  			strService = (ISelfTestResultService) reg.lookup("selfTestResultService");
  		} catch (RemoteException e) {
  			e.printStackTrace();
  		} catch (NotBoundException e) {
  			e.printStackTrace();
  		}
        
        TitleLabel.setText(title);
        Question1.setText("1. " + list.get(0));
        Question2.setText("2. " + list.get(1));
        Question3.setText("3. " + list.get(2));
        Question4.setText("4. " + list.get(3));
        Question5.setText("5. " + list.get(4));
        Question6.setText("6. " + list.get(5));
        Question7.setText("7. " + list.get(6));
        Question8.setText("8. " + list.get(7));
        Question9.setText("9. " + list.get(8));
        Question10.setText("10. " + list.get(9));
        Question11.setText("11. " + list.get(10));
        Question12.setText("12. " + list.get(11));
        Question13.setText("13. " + list.get(12));
        Question14.setText("14. " + list.get(13));
        Question15.setText("15. " + list.get(14));
        Question16.setText("16. " + list.get(15));
        Question17.setText("17. " + list.get(16));
        Question18.setText("18. " + list.get(17));
        Question19.setText("19. " + list.get(18));
        Question20.setText("20. " + list.get(19));
        
    }
}
