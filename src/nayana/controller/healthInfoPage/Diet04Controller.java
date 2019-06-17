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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Callback;
import nayana.member.service.IMemberService;
import nayana.myFile.service.IMyFileService;
import nayana.rDResult.service.IRDResultService;
import nayana.vo.MemberVO;
import nayana.vo.MyFileVO;
import nayana.vo.RDResultVO;

public class Diet04Controller {
	
	private Stage diet04Stage;
	private static String ageCodeNum;
	private static String weightCodeNum;
	private static String dssCodeNum;
	
	private IMemberService memberService;
	private IRDResultService rdresultService;
	private IMyFileService myFileService;
	
	private static MemberVO memVo;
	private RDResultVO rdresultVo;
	private List<RDResultVO> dbRdrList;
	private ObservableList<RDResultVO> RdrList;
	private List<MyFileVO> myFileList;
	
    public Stage getDiet04Stage() {
		return diet04Stage;
	}
	public void setDiet04Stage(Stage diet04Stage) {
		this.diet04Stage = diet04Stage;
	}
	public static String getAgeCodeNum() {
		return ageCodeNum;
	}
	public static void setAgeCodeNum(String ageCodeNum) {
		Diet04Controller.ageCodeNum = ageCodeNum;
	}
	public static String getWeightCodeNum() {
		return weightCodeNum;
	}
	public static void setWeightCodeNum(String weightCodeNum) {
		Diet04Controller.weightCodeNum = weightCodeNum;
	}
	public static String getDssCodeNum() {
		return dssCodeNum;
	}
	public static void setDssCodeNum(String dssCodeNum) {
		Diet04Controller.dssCodeNum = dssCodeNum;
	}
	public static MemberVO getMemVo() {
		return memVo;
	}
	public static void setMemVo(MemberVO memVo) {
		Diet04Controller.memVo = memVo;
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
    private ImageView dietImg01;

    @FXML
    private Label dietTitle01;

    @FXML
    private Label dietCon01;

    @FXML
    private ImageView dietImg02;

    @FXML
    private Label dietTitle02;

    @FXML
    private Label dietCon02;
    
    @FXML
    private Button btnDietHome1;

    @FXML
    void btnDietHome1Clicked(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/Diet01.fxml"));
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
        assert DietName != null : "fx:id=\"DietName\" was not injected: check your FXML file 'Diet04.fxml'.";
        assert btnDietHome != null : "fx:id=\"btnDietHome\" was not injected: check your FXML file 'Diet04.fxml'.";
        assert dietImg01 != null : "fx:id=\"dietImg01\" was not injected: check your FXML file 'Diet04.fxml'.";
        assert dietTitle01 != null : "fx:id=\"dietTitle01\" was not injected: check your FXML file 'Diet04.fxml'.";
        assert dietCon01 != null : "fx:id=\"dietCon01\" was not injected: check your FXML file 'Diet04.fxml'.";
        assert dietImg02 != null : "fx:id=\"dietImg02\" was not injected: check your FXML file 'Diet04.fxml'.";
        assert dietTitle02 != null : "fx:id=\"dietTitle02\" was not injected: check your FXML file 'Diet04.fxml'.";
        assert dietCon02 != null : "fx:id=\"dietCon02\" was not injected: check your FXML file 'Diet04.fxml'.";
        assert btnDietHome1 != null : "fx:id=\"btnDietHome1\" was not injected: check your FXML file 'Diet04.fxml'.";
        
        try {
    		Registry reg = LocateRegistry.getRegistry("localhost", 8888);
    		memberService = (IMemberService) reg.lookup("memberService");
    		rdresultService = (IRDResultService) reg.lookup("rDResultService");
    		myFileService = (IMyFileService) reg.lookup("myFileService");
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	} catch (NotBoundException e) {
    		e.printStackTrace();
    	}
        
        Map<String, String> map = new HashMap<String, String>();
    	map.put("ra_code_age", ageCodeNum);
    	map.put("rdw_code_wt", weightCodeNum);
    	map.put("rd_code_dss", dssCodeNum);
    	
    	try {
    		dbRdrList = rdresultService.rdResult(map);
    		myFileList = myFileService.getAllList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	
    	//RECOMM_DIET_RESULT의 시퀀스 
    	//RECOMM_DIET_RESULT의 코드 = "RD"
    	
    	
    	String serverFileName1 = "";
        String fileExtension1 = "";
        String serverFileName2 = "";
        String fileExtension2 = "";
        int fileNum = 0;
        int rerSeq1 = dbRdrList.get(0).getRdr_seq();
        int rerSeq2 = dbRdrList.get(1).getRdr_seq();
        String bdCode = "";
        
    	for (int i=0; i<myFileList.size(); i++) {
    		fileNum = myFileList.get(i).getFile_bd_num();
        	bdCode = myFileList.get(i).getFile_bd_code();
    		
    		if(rerSeq1 == fileNum && bdCode.equals("RD")) {
    			serverFileName1 = myFileList.get(i).getFile_original_name();
    			fileExtension1 = myFileList.get(i).getFile_extension();
            }
    		if(rerSeq2 == fileNum && bdCode.equals("RD")) {
            	serverFileName2 = myFileList.get(i).getFile_original_name();
    			fileExtension2 = myFileList.get(i).getFile_extension();
            }
		}

    	DietName.setText(memVo.getMem_name());
    	
    	dietTitle01.setText(dbRdrList.get(0).getRdr_name());
    	dietCon01.setText(dbRdrList.get(0).getRdr_content());
    	dietImg01.setImage(new Image(getClass().getResourceAsStream("../../../util/images/"+serverFileName1+"."+fileExtension1)));
    	
    	dietTitle02.setText(dbRdrList.get(1).getRdr_name());
    	dietCon02.setText(dbRdrList.get(1).getRdr_content());
    	dietImg02.setImage(new Image(getClass().getResourceAsStream("../../../util/images/"+serverFileName2+"."+fileExtension2)));
    }
}
