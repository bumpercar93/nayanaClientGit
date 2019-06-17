package nayana.controller.adminPage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import nayana.boardFlag.service.IBoardFlagService;
import nayana.boardHealth.service.IBoardHealthService;
import nayana.controller.communityPage.HCWriteController;
import nayana.myFile.service.IMyFileService;
import nayana.vo.BoardFlagVO;
import nayana.vo.BoardHealthVO;
import nayana.vo.MemberVO;
import nayana.vo.MyFileVO;
import util.AlertUtil;

public class AdminHCWriteController {
	
	private Stage primaryStage;
	private Stage fileStage;
	private BoardHealthVO hcVo;
	private static MemberVO memVo;
	private static MyFileVO myfileVO;
	private ArrayList<BoardFlagVO> bdflagList;
	
	private IBoardFlagService boardFlagService;
	private IBoardHealthService boardHealthService;
	private IMyFileService myFileService;


	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Stage getFileStage() {
		return fileStage;
	}

	public void setFileStage(Stage fileStage) {
		this.fileStage = fileStage;
	}

	public BoardHealthVO getHcVo() {
		return hcVo;
	}

	public void setHcVo(BoardHealthVO hcVo) {
		this.hcVo = hcVo;
	}

	public static MemberVO getMemVo() {
		return memVo;
	}

	public static void setMemVo(MemberVO memVo) {
		AdminHCWriteController.memVo = memVo;
	}

	public MyFileVO getMyfileVO() {
		return myfileVO;
	}

	public void setMyfileVO(MyFileVO myfileVO) {
		this.myfileVO = myfileVO;
	}

	public ArrayList<BoardFlagVO> getBdflagList() {
		return bdflagList;
	}

	public void setBdflagList(ArrayList<BoardFlagVO> bdflagList) {
		this.bdflagList = bdflagList;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnWrite;

    @FXML
    private TextField writeTitle;

    @FXML
    private TextArea writeContent;

    @FXML
    private TextField writeFile;

    @FXML
    private Button btnFile;

    @FXML
    private Button btnCancel;
    
    String rootName = "";
    String fileOriginalName = "";
	String fileDdCode = "";
	String fileExtension = "";
	String fileSize = "";

    @FXML
    void btnCancelClicked(ActionEvent event) {
    	try {
			
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/adminPage/AdminHCList.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) btnWrite.getScene().getRoot();
    		b.setCenter(root);
    		
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }

    @FXML
    void btnFileClicked(ActionEvent event) {
    	FileChooser filechooser = new FileChooser();
    	
    	//열기할 파일종류 선택
    	filechooser.getExtensionFilters().addAll(
			new ExtensionFilter("Image Files","*.png","*.jpg","*.gif")
		);
    	
    	//창을 열었을떄 보여줄 폴더
		filechooser.setInitialDirectory(new File("D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\nayanaClient\\src\\util\\images"));
		
		//선택한 파일의 이름과 경로를 보여줌
		File selectedFile = filechooser.showOpenDialog(fileStage);
	
		if(selectedFile != null) {
			String name = selectedFile.getName();
			int index = name.lastIndexOf(".");
			fileOriginalName = name.substring(0, index).trim();
			
			writeFile.setText(name);
			
			rootName = selectedFile.getPath();
			int idx = rootName.lastIndexOf(".");			
			fileExtension = rootName.substring(idx+1).trim();		
			fileSize = rootName.length() + "Bytes";
					
		}
    }

    @FXML
    void btnWriteClicked(ActionEvent event) {
    	//등록 버튼 시작
    	hcVo = new BoardHealthVO();
    	hcVo.setBh_title(writeTitle.getText());
    	hcVo.setBh_content(writeContent.getText());
    	hcVo.setBh_mem_id(memVo.getMem_id());
    	hcVo.setBh_updatewt(memVo.getMem_id());
    	
    	int result;
		try {
			result = boardHealthService.insertBoard(hcVo);
			if(result > 0) {
	    		//result가 0보다 크면 insert 성공
				AlertUtil.information("success", "글쓰기 성공", "게시글 등록에 성공하였습니다.");
	    	}else {
	    		AlertUtil.error("error", "글쓰기 실패", "게시글 등록을 실패하였습니다.");
	    		return;
	    	}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("bh_mem_id", memVo.getMem_id());
		map.put("bh_title", writeTitle.getText());
		
		int seq = 0;
		
		try {
			seq = boardHealthService.getSeq(map);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		
		try {
			bdflagList = (ArrayList<BoardFlagVO>) boardFlagService.getAllList();
			fileDdCode = bdflagList.get(0).getBd_code();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		myfileVO = new MyFileVO();
		myfileVO.setFile_bd_code(fileDdCode);
		myfileVO.setFile_bd_num(seq);
		myfileVO.setFile_original_name(fileOriginalName);
		myfileVO.setFile_server_name("nya_" + seq);
		myfileVO.setFile_extension(fileExtension);
		myfileVO.setFile_size(fileSize);
		
		int fileResult = 0;
		try {
			fileResult = myFileService.insertFile(myfileVO);
			if(fileResult > 0) {
	    		//result가 0보다 크면 insert 성공
				System.out.println("insert성공");
	    	}else {
	    		System.out.println("insert실패 ");
	    	}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		try {
			
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/adminPage/AdminHCList.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) btnWrite.getScene().getRoot();
    		b.setCenter(root);
    		
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }
    
    

    @FXML
    void initialize() {
        assert btnWrite != null : "fx:id=\"btnWrite\" was not injected: check your FXML file 'AdminHCWrite.fxml'.";
        assert writeTitle != null : "fx:id=\"writeTitle\" was not injected: check your FXML file 'AdminHCWrite.fxml'.";
        assert writeContent != null : "fx:id=\"writeContent\" was not injected: check your FXML file 'AdminHCWrite.fxml'.";
        assert writeFile != null : "fx:id=\"writeFile\" was not injected: check your FXML file 'AdminHCWrite.fxml'.";
        assert btnFile != null : "fx:id=\"btnFile\" was not injected: check your FXML file 'AdminHCWrite.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'AdminHCWrite.fxml'.";
        
        try {
    		Registry reg = LocateRegistry.getRegistry("localhost", 8888);
    		boardHealthService = (IBoardHealthService) reg.lookup("boardHealthService");
    		boardFlagService = (IBoardFlagService) reg.lookup("boardFlagService");
    		myFileService = (IMyFileService) reg.lookup("myFileService");
    		
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	} catch (NotBoundException e) {
    		e.printStackTrace();
    	}
        
    }
}
