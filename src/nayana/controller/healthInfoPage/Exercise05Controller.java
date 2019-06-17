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

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import nayana.member.service.IMemberService;
import nayana.myFile.service.IMyFileService;
import nayana.rEResult.service.IREResultService;
import nayana.vo.MemberVO;
import nayana.vo.MyFileVO;
import nayana.vo.RDResultVO;
import nayana.vo.REResultVO;
import util.MyButtonEventHandler;

public class Exercise05Controller {
	
	private Stage exe05Stage;
	
	private IMemberService memberService;	
	private IREResultService rEResultService;
	private IMyFileService myFileService;
	
	private static MemberVO memVo;
	private List<REResultVO> dbRerList;
	private ObservableList<REResultVO> rErList;
	private List<MyFileVO> myFileList;
	
	private static String exeAgeCodeNum;
	private static String exeSituCodeNum;
	private static String exeBodyCodeNum;
	private static String exeDssCodeNum;
	
    public Stage getExe05Stage() {
		return exe05Stage;
	}

	public void setExe05Stage(Stage exe05Stage) {
		this.exe05Stage = exe05Stage;
	}

	public static MemberVO getMemVo() {
		return memVo;
	}

	public static void setMemVo(MemberVO memVo) {
		Exercise05Controller.memVo = memVo;
	}

	public static String getExeAgeCodeNum() {
		return exeAgeCodeNum;
	}

	public static void setExeAgeCodeNum(String exeAgeCodeNum) {
		Exercise05Controller.exeAgeCodeNum = exeAgeCodeNum;
	}

	public static String getExeSituCodeNum() {
		return exeSituCodeNum;
	}

	public static void setExeSituCodeNum(String exeSituCodeNum) {
		Exercise05Controller.exeSituCodeNum = exeSituCodeNum;
	}

	public static String getExeBodyCodeNum() {
		return exeBodyCodeNum;
	}

	public static void setExeBodyCodeNum(String exeBodyCodeNum) {
		Exercise05Controller.exeBodyCodeNum = exeBodyCodeNum;
	}

	public static String getExeDssCodeNum() {
		return exeDssCodeNum;
	}

	public static void setExeDssCodeNum(String exeDssCodeNum) {
		Exercise05Controller.exeDssCodeNum = exeDssCodeNum;
	}

	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label DietName;

    @FXML
    private Button btnDietHome;

    @FXML
    private ImageView exeImg01;

    @FXML
    private Label exeTitle01;

    @FXML
    private Label exeCon01;

    @FXML
    private ImageView exeImg02;

    @FXML
    private Label exeTitle02;

    @FXML
    private Label exeCon02;
    
    @FXML
    private Button btnDietHome1;

    @FXML
    void btnDietHome1Clicked(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Exercise01.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) btnDietHome.getScene().getRoot();
    		b.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnDietHomeClicked(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/mainPage/MainCenter.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) btnDietHome.getScene().getRoot();
    		b.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert DietName != null : "fx:id=\"DietName\" was not injected: check your FXML file 'Exercise05.fxml'.";
        assert btnDietHome != null : "fx:id=\"btnDietHome\" was not injected: check your FXML file 'Exercise05.fxml'.";
        assert exeImg01 != null : "fx:id=\"exeImg01\" was not injected: check your FXML file 'Exercise05.fxml'.";
        assert exeTitle01 != null : "fx:id=\"exeTitle01\" was not injected: check your FXML file 'Exercise05.fxml'.";
        assert exeCon01 != null : "fx:id=\"exeCon01\" was not injected: check your FXML file 'Exercise05.fxml'.";
        assert exeImg02 != null : "fx:id=\"exeImg02\" was not injected: check your FXML file 'Exercise05.fxml'.";
        assert exeTitle02 != null : "fx:id=\"exeTitle02\" was not injected: check your FXML file 'Exercise05.fxml'.";
        assert exeCon02 != null : "fx:id=\"exeCon02\" was not injected: check your FXML file 'Exercise05.fxml'.";
        assert btnDietHome1 != null : "fx:id=\"btnDietHome1\" was not injected: check your FXML file 'Exercise05.fxml'.";
        
        try {
    		Registry reg = LocateRegistry.getRegistry("localhost", 8888);
    		memberService = (IMemberService) reg.lookup("memberService");
    		rEResultService = (IREResultService) reg.lookup("rEResultService");
    		myFileService = (IMyFileService) reg.lookup("myFileService");
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	} catch (NotBoundException e) {
    		e.printStackTrace();
    	}
        
        Map<String, String> map = new HashMap<String, String>();
    	map.put("ra_code_age", exeAgeCodeNum);
    	map.put("res_code_situ", exeSituCodeNum);
    	map.put("rer_code_body", exeBodyCodeNum);
    	map.put("rd_code_dss", exeDssCodeNum);
    	
    	try {
    		dbRerList = rEResultService.reResult(map);
    		myFileList = myFileService.getAllList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	String serverFileName1 = "";
        String fileExtension1 = "";
        String serverFileName2 = "";
        String fileExtension2 = "";
        int fileNum = 0;
        int rerSeq1 = dbRerList.get(0).getRer_seq();
        int rerSeq2 = dbRerList.get(1).getRer_seq();
        String bdCode = "";
        
    	for (int i=0; i<myFileList.size(); i++) {
    		fileNum = myFileList.get(i).getFile_bd_num();
        	bdCode = myFileList.get(i).getFile_bd_code();
    		
    		if(rerSeq1 == fileNum && bdCode.equals("RE")) {
    			serverFileName1 = myFileList.get(i).getFile_original_name();
    			fileExtension1 = myFileList.get(i).getFile_extension();
            }
    		if(rerSeq2 == fileNum && bdCode.equals("RE")) {
            	serverFileName2 = myFileList.get(i).getFile_original_name();
    			fileExtension2 = myFileList.get(i).getFile_extension();
            }
		}
    	
    	
    	exeTitle01.setText(dbRerList.get(0).getRer_name());
    	exeCon01.setText(dbRerList.get(0).getRer_content());
    	exeImg01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/"+serverFileName1+"."+fileExtension1)));
    	
    	exeTitle02.setText(dbRerList.get(1).getRer_name());
    	exeCon02.setText(dbRerList.get(1).getRer_content());
    	exeImg02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/"+serverFileName2+"."+fileExtension2)));
    	
        //로그인한 회원의 이름
    	DietName.setText(memVo.getMem_name());

    }
}
