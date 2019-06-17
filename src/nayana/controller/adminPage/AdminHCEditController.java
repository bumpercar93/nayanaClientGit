package nayana.controller.adminPage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
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
import nayana.member.service.IMemberService;
import nayana.myFile.service.IMyFileService;
import nayana.vo.BoardFlagVO;
import nayana.vo.BoardHealthVO;
import nayana.vo.MemberVO;
import nayana.vo.MyFileVO;
import util.AlertUtil;

public class AdminHCEditController {
	
	private Stage primaryStage;
	private Stage fileStage;
	private Stage hcEditStage;
	private static BoardHealthVO hcVO;
	private static MemberVO memVo;
	private static MyFileVO myfileVO;
	
	private List<MyFileVO> mfList;
	private ArrayList<BoardFlagVO> bdflagList;
	
	private IBoardFlagService boardFlagService;
	private IBoardHealthService boardHealthService;
	private IMyFileService myFileService;
	private IMemberService memberService;
	

    public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}


	public Stage getHcEditStage() {
		return hcEditStage;
	}

	public void setHcEditStage(Stage hcEditStage) {
		this.hcEditStage = hcEditStage;
	}

	public static BoardHealthVO getHcVo() {
		return hcVO;
	}

	public static void setHcVo(BoardHealthVO hcVO) {
		AdminHCEditController.hcVO = hcVO;
	}

	public static MemberVO getMemVo() {
		return memVo;
	}

	public static void setMemVo(MemberVO memVo) {
		AdminHCEditController.memVo = memVo;
	}


	public static MyFileVO getMyfileVO() {
		return myfileVO;
	}

	public static void setMyfileVO(MyFileVO myfileVO) {
		AdminHCEditController.myfileVO = myfileVO;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEdit;

    @FXML
    private TextField editTitle;

    @FXML
    private TextArea editContent;

    @FXML
    private TextField editFile;

    @FXML
    private Button btnFile;

    @FXML
    private Button btnCancel;
    
    String rootName = "";
    String fileOriginalName = "";
	String fileDdCode = "";
	String fileExtension = "";
	String fileSize = "";
	int bhSeq = hcVO.getBh_seq();

    @FXML
    void btnCancelClicked(ActionEvent event) {
    	try {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/adminPage/AdminHCList.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) editTitle.getScene().getRoot();
    		b.setCenter(root);
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnEditClicked(ActionEvent event) {
    	String title = editTitle.getText();
    	String content = editContent.getText();
    	
    	if(title.isEmpty()) {
    		AlertUtil.warning("warning", "입력오류", "제목을 입력해 주세요.");
    		editTitle.requestFocus();
    		return;
    	}
    	if(content.isEmpty()) {
    		AlertUtil.warning("warning", "입력오류", "내용을 입력해 주세요.");
    		editContent.requestFocus();
    		return;
    	}
    	
    	hcVO.setBh_title(title);
    	hcVO.setBh_content(content);
    	hcVO.setBh_mem_id(memVo.getMem_id());
    	hcVO.setBh_updatewt(memVo.getMem_id());
    	
    	int result = 0;
		try {
			result = boardHealthService.updateBoard(hcVO);
			if(result > 0) {
	    		//result가 0보다 크면 insert 성공
				AlertUtil.information("success", "글수정 성공", "게시글 수정에 성공하였습니다.");
	    	}else {
	    		AlertUtil.error("error", "글수정 실패", "게시글 수정을 실패하였습니다.");
	    		return;
	    	}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		System.out.println(hcVO.getBh_seq());
		
		MyFileVO mfVO = new MyFileVO();
		mfVO.setFile_original_name(fileOriginalName);
		mfVO.setFile_server_name("nyn_"+hcVO.getBh_seq());
		mfVO.setFile_extension(fileExtension);
		mfVO.setFile_size(fileSize);
		mfVO.setFile_bd_code("HC");
		mfVO.setFile_bd_num(hcVO.getBh_seq());
		
		int fileResult = 0;
		try {
			System.out.println("여까진 오냐");
			fileResult = myFileService.updateFile(mfVO);
			if(fileResult > 0) {
	    		//result가 0보다 크면 insert 성공
				System.out.println("insert성공");
	    	}else {
	    		System.out.println("insert실패");
	    	}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		try {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/adminPage/AdminHCList.fxml"));
    		Parent root = loader.load();
    		
    		BorderPane b = (BorderPane) editTitle.getScene().getRoot();
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
			
			editFile.setText(name);
			
			rootName = selectedFile.getPath();
			int idx = rootName.lastIndexOf(".");			
			fileExtension = rootName.substring(idx+1).trim();		
			fileSize = rootName.length() + "Bytes";
			
		}
    }

    @FXML
    void initialize() {
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'AdminHCEdit.fxml'.";
        assert editTitle != null : "fx:id=\"editTitle\" was not injected: check your FXML file 'AdminHCEdit.fxml'.";
        assert editContent != null : "fx:id=\"editContent\" was not injected: check your FXML file 'AdminHCEdit.fxml'.";
        assert editFile != null : "fx:id=\"editFile\" was not injected: check your FXML file 'AdminHCEdit.fxml'.";
        assert btnFile != null : "fx:id=\"btnFile\" was not injected: check your FXML file 'AdminHCEdit.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'AdminHCEdit.fxml'.";
        
        try {
    		Registry reg = LocateRegistry.getRegistry("localhost", 8888);
    		memberService = (IMemberService) reg.lookup("memberService");
    		boardHealthService = (IBoardHealthService) reg.lookup("boardHealthService");
    		boardFlagService = (IBoardFlagService) reg.lookup("boardFlagService");
    		myFileService = (IMyFileService) reg.lookup("myFileService");
    		
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	} catch (NotBoundException e) {
    		e.printStackTrace();
    	}
        
        try {
			mfList = myFileService.getAllList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        
        String serverFileName = "";
        String fileExtension = "";
        String fileName = "";
        int fileNum = 0;
        int bcSeq = hcVO.getBh_seq();
        String bdCode = "";
        
        for (int i = 0; i < mfList.size(); i++) {
   	
        	fileNum = mfList.get(i).getFile_bd_num();
        	bdCode = mfList.get(i).getFile_bd_code();
        	
        	if(bcSeq == fileNum && bdCode.equals("HC")) {
            	serverFileName = mfList.get(i).getFile_original_name();
            	fileExtension = mfList.get(i).getFile_extension();
            }
        	
		}
        
        editTitle.setText(hcVO.getBh_title());
        editContent.setText(hcVO.getBh_content());
        editFile.setText(serverFileName+"."+fileExtension);

    }
}
