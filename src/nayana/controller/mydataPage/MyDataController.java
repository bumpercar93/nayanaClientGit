package nayana.controller.mydataPage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nayana.docDown.service.IDocDownService;
import nayana.vo.DocDownVO;
import nayana.vo.MemberVO;
import util.AlertUtil;
import util.MyButtonEventHandler;
import util.MyFTP;

public class MyDataController {
	
	private MyFTP mf;
	private IDocDownService docDownService;
	private static MemberVO memVO;
	
	public static MemberVO getMemVO() {
		return memVO;
	}
	public static void setMemVO(MemberVO memVO) {
		MyDataController.memVO = memVO;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button allDownBtn;

    @FXML
    private Rectangle rec1;

    @FXML
    private Label num1;

    @FXML
    private Label jindan;

    @FXML
    private Label jindanDown;

    @FXML
    private Label jindanUpdate;

    @FXML
    private Button viewbtn1;

    @FXML
    private Button jindanDownBtn;

    @FXML
    private Rectangle rec2;

    @FXML
    private Label num2;

    @FXML
    private Label cubang;

    @FXML
    private Label cubangDown;

    @FXML
    private Label cubangUpdate;

    @FXML
    private Button viewBtn2;

    @FXML
    private Button cubangDownBtn;

    @FXML
    private Rectangle rec3;

    @FXML
    private Label num3;

    @FXML
    private Label sogyun;

    @FXML
    private Label sogyunDown;

    @FXML
    private Label sogyunUpdate;

    @FXML
    private Button viewBtn3;

    @FXML
    private Button sogyunDownBtn;

    @FXML
    private Rectangle rec4;

    @FXML
    private Label num4;

    @FXML
    private Label inbody;

    @FXML
    private Label inbodyDown;

    @FXML
    private Label inbodyUpdate;

    @FXML
    private Button viewBtn4;

    @FXML
    private Button inbodyDownBtn;

    @FXML
    private Rectangle rec5;

    @FXML
    private Label num5;

    @FXML
    private Label susul;

    @FXML
    private Label susulDown;

    @FXML
    private Label susulUpdate;

    @FXML
    private Button viewBtn5;

    @FXML
    private Button susulDownBtn;

    @FXML
    void clickAllDownBtn(ActionEvent event) {
    	try {
    		if(cubang.isVisible()) {
    			boolean result1 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "처방전.xlsx");
    			boolean result2 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "처방전.pdf");
        		Map<String, String> map = new HashMap<String, String>();
        		map.put("mem_id", memVO.getMem_id());
        		map.put("down_item_con", "처방전");
        		
        		if(result1 && result2) {
        			String res = docDownService.selectDocDown(map);
        			if(res == null) {
        				DocDownVO ddVO = new DocDownVO();
        				ddVO.setMem_id(memVO.getMem_id());
        				ddVO.setDown_item_con("처방전");
        				docDownService.insertDocDown(ddVO);
        			}else {
        				docDownService.updateDocDown(map);
        			}
        			String docDay = docDownService.selectDocDown(map);
        			cubangUpdate.setText(docDay);
        		}
    		}
    		
    		if(jindan.isVisible()) {
    			boolean result1 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "진단서.xlsx");
    			boolean result2 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "진단서.pdf");
        		Map<String, String> map = new HashMap<String, String>();
        		map.put("mem_id", memVO.getMem_id());
        		map.put("down_item_con", "진단서");
        		
        		if(result1 && result2) {
        			String res = docDownService.selectDocDown(map);
        			if(res == null) {
        				DocDownVO ddVO = new DocDownVO();
        				ddVO.setMem_id(memVO.getMem_id());
        				ddVO.setDown_item_con("진단서");
        				docDownService.insertDocDown(ddVO);
        			}else {
        				docDownService.updateDocDown(map);
        			}
        			String docDay = docDownService.selectDocDown(map);
        			jindanUpdate.setText(docDay);
        		}
    		}
    		if(sogyun.isVisible()) {
    			boolean result1 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "소견서.xlsx");
    			boolean result2 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "소견서.pdf");
        		Map<String, String> map = new HashMap<String, String>();
        		map.put("mem_id", memVO.getMem_id());
        		map.put("down_item_con", "소견서");
        		
        		if(result1 && result2) {
        			String res = docDownService.selectDocDown(map);
        			if(res == null) {
        				DocDownVO ddVO = new DocDownVO();
        				ddVO.setMem_id(memVO.getMem_id());
        				ddVO.setDown_item_con("소견서");
        				docDownService.insertDocDown(ddVO);
        			}else {
        				docDownService.updateDocDown(map);
        			}
        			String docDay = docDownService.selectDocDown(map);
        			sogyunUpdate.setText(docDay);
        		}
    		}
    		if(inbody.isVisible()) {
    			boolean result1 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "인바디.xlsx");
    			boolean result2 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "인바디.pdf");
        		Map<String, String> map = new HashMap<String, String>();
        		map.put("mem_id", memVO.getMem_id());
        		map.put("down_item_con", "인바디");
        		
        		if(result1 && result2) {
        			String res = docDownService.selectDocDown(map);
        			if(res == null) {
        				DocDownVO ddVO = new DocDownVO();
        				ddVO.setMem_id(memVO.getMem_id());
        				ddVO.setDown_item_con("인바디");
        				docDownService.insertDocDown(ddVO);
        			}else {
        				docDownService.updateDocDown(map);
        			}
        			String docDay = docDownService.selectDocDown(map);
        			inbodyUpdate.setText(docDay);
        		}
    		}
    		if(susul.isVisible()) {
    			boolean result1 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "수술확인서.xlsx");
    			boolean result2 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "수술확인서.pdf");
        		Map<String, String> map = new HashMap<String, String>();
        		map.put("mem_id", memVO.getMem_id());
        		map.put("down_item_con", "수술확인서");
        		
        		if(result1 && result2) {
        			String res = docDownService.selectDocDown(map);
        			if(res == null) {
        				DocDownVO ddVO = new DocDownVO();
        				ddVO.setMem_id(memVO.getMem_id());
        				ddVO.setDown_item_con("수술확인서");
        				docDownService.insertDocDown(ddVO);
        			}else {
        				docDownService.updateDocDown(map);
        			}
        			String docDay = docDownService.selectDocDown(map);
        			susulUpdate.setText(docDay);
        		}
    		}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	AlertUtil.information("성공", "다운로드 성공", memVO.getMem_name() + "님의 모든 파일이 정상적으로 다운로드 되었습니다"
    			+ "\n\n다운로드 경로 : C:\\NAYANA");
    	
    }

    @FXML
    void clickCubangDownBtn(ActionEvent event) {
    	try {
    		boolean result1 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "처방전.xlsx");
    		boolean result2 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "처방전.pdf");
    		Map<String, String> map = new HashMap<String, String>();
    		map.put("mem_id", memVO.getMem_id());
    		map.put("down_item_con", "처방전");
    		
    		if(result1 && result2) {
    			String res = docDownService.selectDocDown(map);
    			if(res == null) {
    				DocDownVO ddVO = new DocDownVO();
    				ddVO.setMem_id(memVO.getMem_id());
    				ddVO.setDown_item_con("처방전");
    				docDownService.insertDocDown(ddVO);
    			}else {
    				docDownService.updateDocDown(map);
    			}
    			String docDay = docDownService.selectDocDown(map);
    			cubangUpdate.setText(docDay);
    			AlertUtil.information("성공", "다운로드 성공", memVO.getMem_name() + "님의 처방전.xlsx, 처방전.pdf 파일이 정상적으로 다운로드 되었습니다"
    					+ "\n\n다운로드 경로 : C:\\NAYANA");
    		}else {
    			AlertUtil.error("실패", "다운로드 실패", memVO.getMem_name() + "님의 처방전.xlsx, 처방전.pdf 파일의 다운로드가 비정상적으로 종료되었습니다");
    		}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void clickInbodyDownBtn(ActionEvent event) {
    	try {
    		boolean result1 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "인바디.xlsx");
    		boolean result2 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "인바디.pdf");
    		
    		Map<String, String> map = new HashMap<String, String>();
    		map.put("mem_id", memVO.getMem_id());
    		map.put("down_item_con", "인바디");
    		
    		if(result1 && result2) {
    			String res = docDownService.selectDocDown(map);
    			if(res == null) {
    				DocDownVO ddVO = new DocDownVO();
    				ddVO.setMem_id(memVO.getMem_id());
    				ddVO.setDown_item_con("인바디");
    				docDownService.insertDocDown(ddVO);
    			}else {
    				docDownService.updateDocDown(map);
    			}
    			String docDay = docDownService.selectDocDown(map);
    			inbodyUpdate.setText(docDay);
    			AlertUtil.information("성공", "다운로드 성공", memVO.getMem_name() + "님의 처방전.xlsx, 처방전.pdf 파일이 정상적으로 다운로드 되었습니다"
    					+ "\n\n다운로드 경로 : C:\\NAYANA");
    		}else {
    			AlertUtil.error("실패", "다운로드 실패", memVO.getMem_name() + "님의 처방전.xlsx, 처방전.pdf 파일의 다운로드가 비정상적으로 종료되었습니다");
    		}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickJindanDownBtn(ActionEvent event) {
    	try {
    		boolean result1 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "진단서.xlsx");
    		boolean result2 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "진단서.pdf");
    		
    		Map<String, String> map = new HashMap<String, String>();
    		map.put("mem_id", memVO.getMem_id());
    		map.put("down_item_con", "진단서");
    		
    		if(result1 && result2) {
    			String res = docDownService.selectDocDown(map);
    			if(res == null) {
    				DocDownVO ddVO = new DocDownVO();
    				ddVO.setMem_id(memVO.getMem_id());
    				ddVO.setDown_item_con("진단서");
    				docDownService.insertDocDown(ddVO);
    			}else {
    				docDownService.updateDocDown(map);
    			}
    			String docDay = docDownService.selectDocDown(map);
    			jindanUpdate.setText(docDay);
    			AlertUtil.information("성공", "다운로드 성공", memVO.getMem_name() + "님의 처방전.xlsx, 처방전.pdf 파일이 정상적으로 다운로드 되었습니다"
    					+ "\n\n다운로드 경로 : C:\\NAYANA");
    		}else {
    			AlertUtil.error("실패", "다운로드 실패", memVO.getMem_name() + "님의 처방전.xlsx, 처방전.pdf 파일의 다운로드가 비정상적으로 종료되었습니다");
    		}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickSogyunDownBtn(ActionEvent event) {
    	try {
    		boolean result1 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "소견서.xlsx");
    		boolean result2 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "소견서.pdf");
    		
    		Map<String, String> map = new HashMap<String, String>();
    		map.put("mem_id", memVO.getMem_id());
    		map.put("down_item_con", "소견서");
    		
    		if(result1 && result2) {
    			String res = docDownService.selectDocDown(map);
    			if(res == null) {
    				DocDownVO ddVO = new DocDownVO();
    				ddVO.setMem_id(memVO.getMem_id());
    				ddVO.setDown_item_con("소견서");
    				docDownService.insertDocDown(ddVO);
    			}else {
    				docDownService.updateDocDown(map);
    			}
    			String docDay = docDownService.selectDocDown(map);
    			sogyunUpdate.setText(docDay);
    			AlertUtil.information("성공", "다운로드 성공", memVO.getMem_name() + "님의 처방전.xlsx, 처방전.pdf 파일이 정상적으로 다운로드 되었습니다"
    					+ "\n\n다운로드 경로 : C:\\NAYANA");
    		}else {
    			AlertUtil.error("실패", "다운로드 실패", memVO.getMem_name() + "님의 처방전.xlsx, 처방전.pdf 파일의 다운로드가 비정상적으로 종료되었습니다");
    		}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickSusulDownBtn(ActionEvent event) {
    	try {
    		boolean result1 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "수술확인서.xlsx");
    		boolean result2 = mf.myDataDownload(memVO.getMem_regno1(), memVO.getMem_regno2(), "수술확인서.pdf");
    		
    		Map<String, String> map = new HashMap<String, String>();
    		map.put("mem_id", memVO.getMem_id());
    		map.put("down_item_con", "수술확인서");
    		
    		if(result1 && result2) {
    			String res = docDownService.selectDocDown(map);
    			if(res == null) {
    				DocDownVO ddVO = new DocDownVO();
    				ddVO.setMem_id(memVO.getMem_id());
    				ddVO.setDown_item_con("수술확인서");
    				docDownService.insertDocDown(ddVO);
    			}else {
    				docDownService.updateDocDown(map);
    			}
    			String docDay = docDownService.selectDocDown(map);
    			susulUpdate.setText(docDay);
    			AlertUtil.information("성공", "다운로드 성공", memVO.getMem_name() + "님의 처방전.xlsx, 처방전.pdf 파일이 정상적으로 다운로드 되었습니다"
    					+ "\n\n다운로드 경로 : C:\\NAYANA");
    		}else {
    			AlertUtil.error("실패", "다운로드 실패", memVO.getMem_name() + "님의 처방전.xlsx, 처방전.pdf 파일의 다운로드가 비정상적으로 종료되었습니다");
    		}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void cubangC(ActionEvent event) {
    	// View.fxml을 열고 현재 로그인한 사람의 주민등록번호와 처방전이라는 String을 보내준다
    	// View.fxml에서는 주민등록번호를 받아와서 ftp서버로 찾고 그사람의 처방전을 imageView에 셋팅해서 보여준다.
    	try {
    		String regNo = memVO.getMem_regno1() + "-" + memVO.getMem_regno2();
    		String fileName = "처방전.jpg";
    		
			Stage viewStage = new Stage();
			viewStage.initModality(Modality.WINDOW_MODAL);
			viewStage.setResizable(false);
			viewStage.setTitle("미리보기");
			ViewController.setFileName(fileName);
			ViewController.setRegNo(regNo);
			
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/mydataPage/View.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			viewStage.setScene(scene);
			viewStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void inbodyC(ActionEvent event) {
    	try {
    		String regNo = memVO.getMem_regno1() + "-" + memVO.getMem_regno2();
    		String fileName = "인바디.jpg";
			Stage viewStage = new Stage();
			viewStage.initModality(Modality.WINDOW_MODAL);
			viewStage.setResizable(false);
			viewStage.setTitle("미리보기");
			ViewController.setFileName(fileName);
			ViewController.setRegNo(regNo);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/mydataPage/View.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			viewStage.setScene(scene);
			viewStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void jindanC(ActionEvent event) {
    	try {
    		String regNo = memVO.getMem_regno1() + "-" + memVO.getMem_regno2();
    		String fileName = "진단서.jpg";
			Stage viewStage = new Stage();
			viewStage.initModality(Modality.WINDOW_MODAL);
			viewStage.setResizable(false);
			viewStage.setTitle("미리보기");
			ViewController.setFileName(fileName);
			ViewController.setRegNo(regNo);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/mydataPage/View.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			viewStage.setScene(scene);
			viewStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void sogyunC(ActionEvent event) {
    	try {
    		String regNo = memVO.getMem_regno1() + "-" + memVO.getMem_regno2();
    		String fileName = "소견서.jpg";
			Stage viewStage = new Stage();
			viewStage.initModality(Modality.WINDOW_MODAL);
			viewStage.setResizable(false);
			viewStage.setTitle("미리보기");
			ViewController.setFileName(fileName);
			ViewController.setRegNo(regNo);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/mydataPage/View.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			viewStage.setScene(scene);
			viewStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void susulC(ActionEvent event) {
    	try {
    		String regNo = memVO.getMem_regno1() + "-" + memVO.getMem_regno2();
    		String fileName = "수술확인서.jpg";
			Stage viewStage = new Stage();
			viewStage.initModality(Modality.WINDOW_MODAL);
			viewStage.setResizable(false);
			viewStage.setTitle("미리보기");
			ViewController.setFileName(fileName);
			ViewController.setRegNo(regNo);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/mydataPage/View.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			viewStage.setScene(scene);
			viewStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert allDownBtn != null : "fx:id=\"allDownBtn\" was not injected: check your FXML file 'MyData.fxml'.";
        assert rec1 != null : "fx:id=\"rec1\" was not injected: check your FXML file 'MyData.fxml'.";
        assert num1 != null : "fx:id=\"num1\" was not injected: check your FXML file 'MyData.fxml'.";
        assert jindan != null : "fx:id=\"jindan\" was not injected: check your FXML file 'MyData.fxml'.";
        assert jindanDown != null : "fx:id=\"jindanDown\" was not injected: check your FXML file 'MyData.fxml'.";
        assert jindanUpdate != null : "fx:id=\"jindanUpdate\" was not injected: check your FXML file 'MyData.fxml'.";
        assert viewbtn1 != null : "fx:id=\"viewbtn1\" was not injected: check your FXML file 'MyData.fxml'.";
        assert jindanDownBtn != null : "fx:id=\"jindanDownBtn\" was not injected: check your FXML file 'MyData.fxml'.";
        assert rec2 != null : "fx:id=\"rec2\" was not injected: check your FXML file 'MyData.fxml'.";
        assert num2 != null : "fx:id=\"num2\" was not injected: check your FXML file 'MyData.fxml'.";
        assert cubang != null : "fx:id=\"cubang\" was not injected: check your FXML file 'MyData.fxml'.";
        assert cubangDown != null : "fx:id=\"cubangDown\" was not injected: check your FXML file 'MyData.fxml'.";
        assert cubangUpdate != null : "fx:id=\"cubangUpdate\" was not injected: check your FXML file 'MyData.fxml'.";
        assert viewBtn2 != null : "fx:id=\"viewBtn2\" was not injected: check your FXML file 'MyData.fxml'.";
        assert cubangDownBtn != null : "fx:id=\"cubangDownBtn\" was not injected: check your FXML file 'MyData.fxml'.";
        assert rec3 != null : "fx:id=\"rec3\" was not injected: check your FXML file 'MyData.fxml'.";
        assert num3 != null : "fx:id=\"num3\" was not injected: check your FXML file 'MyData.fxml'.";
        assert sogyun != null : "fx:id=\"sogyun\" was not injected: check your FXML file 'MyData.fxml'.";
        assert sogyunDown != null : "fx:id=\"sogyunDown\" was not injected: check your FXML file 'MyData.fxml'.";
        assert sogyunUpdate != null : "fx:id=\"sogyunUpdate\" was not injected: check your FXML file 'MyData.fxml'.";
        assert viewBtn3 != null : "fx:id=\"viewBtn3\" was not injected: check your FXML file 'MyData.fxml'.";
        assert sogyunDownBtn != null : "fx:id=\"sogyunDownBtn\" was not injected: check your FXML file 'MyData.fxml'.";
        assert rec4 != null : "fx:id=\"rec4\" was not injected: check your FXML file 'MyData.fxml'.";
        assert num4 != null : "fx:id=\"num4\" was not injected: check your FXML file 'MyData.fxml'.";
        assert inbody != null : "fx:id=\"inbody\" was not injected: check your FXML file 'MyData.fxml'.";
        assert inbodyDown != null : "fx:id=\"inbodyDown\" was not injected: check your FXML file 'MyData.fxml'.";
        assert inbodyUpdate != null : "fx:id=\"inbodyUpdate\" was not injected: check your FXML file 'MyData.fxml'.";
        assert viewBtn4 != null : "fx:id=\"viewBtn4\" was not injected: check your FXML file 'MyData.fxml'.";
        assert inbodyDownBtn != null : "fx:id=\"inbodyDownBtn\" was not injected: check your FXML file 'MyData.fxml'.";
        assert rec5 != null : "fx:id=\"rec5\" was not injected: check your FXML file 'MyData.fxml'.";
        assert num5 != null : "fx:id=\"num5\" was not injected: check your FXML file 'MyData.fxml'.";
        assert susul != null : "fx:id=\"susul\" was not injected: check your FXML file 'MyData.fxml'.";
        assert susulDown != null : "fx:id=\"susulDown\" was not injected: check your FXML file 'MyData.fxml'.";
        assert susulUpdate != null : "fx:id=\"susulUpdate\" was not injected: check your FXML file 'MyData.fxml'.";
        assert viewBtn5 != null : "fx:id=\"viewBtn5\" was not injected: check your FXML file 'MyData.fxml'.";
        assert susulDownBtn != null : "fx:id=\"susulDownBtn\" was not injected: check your FXML file 'MyData.fxml'.";
        
        
      try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			docDownService = (IDocDownService) reg.lookup("docDownService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
        
        mf = new MyFTP();
        
		num1.setVisible(false);
		num2.setVisible(false);
		num3.setVisible(false);
		num4.setVisible(false);
		num5.setVisible(false);
		jindan.setVisible(false);
		cubang.setVisible(false);
		sogyun.setVisible(false);
		inbody.setVisible(false);
		susul.setVisible(false);
		rec1.setVisible(false);
		rec2.setVisible(false);
		rec3.setVisible(false);
		rec4.setVisible(false);
		rec5.setVisible(false);
		jindanDown.setVisible(false);
		cubangDown.setVisible(false);
		sogyunDown.setVisible(false);
		inbodyDown.setVisible(false);
		susulDown.setVisible(false);
		jindanUpdate.setVisible(false);
		cubangUpdate.setVisible(false);
		sogyunUpdate.setVisible(false);
		inbodyUpdate.setVisible(false);
		susulUpdate.setVisible(false);
		viewbtn1.setVisible(false);
		viewBtn2.setVisible(false);
		viewBtn3.setVisible(false);
		viewBtn4.setVisible(false);
		viewBtn5.setVisible(false);
		jindanDownBtn.setVisible(false);
		cubangDownBtn.setVisible(false);
		sogyunDownBtn.setVisible(false);
		inbodyDownBtn.setVisible(false);
		susulDownBtn.setVisible(false);

		viewbtn1.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
		viewBtn2.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
		viewBtn3.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
		viewBtn4.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
		viewBtn5.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
		jindanDownBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
		cubangDownBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
		sogyunDownBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
		inbodyDownBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
		susulDownBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
		allDownBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
      
      String[] fileArr = mf.mdmsDirectoryRead("/" + memVO.getMem_regno1() + "-" + memVO.getMem_regno2());
      for (int i = 0; i < fileArr.length; i++) {
			if(fileArr[i].contains("진단서.txt")) {
				num1.setVisible(true);
				jindan.setVisible(true);
				rec1.setVisible(true);
				jindanDown.setVisible(true);
				jindanUpdate.setVisible(true);
				viewbtn1.setVisible(true);
				jindanDownBtn.setVisible(true);
			}else if(fileArr[i].contains("처방전.txt")) {
				num2.setVisible(true);
				cubang.setVisible(true);
				rec2.setVisible(true);
				cubangDown.setVisible(true);
				cubangUpdate.setVisible(true);
				viewBtn2.setVisible(true);
				cubangDownBtn.setVisible(true);
			}else if(fileArr[i].contains("소견서.txt")) {
				num3.setVisible(true);
				sogyun.setVisible(true);
				rec3.setVisible(true);
				sogyunDown.setVisible(true);
				sogyunUpdate.setVisible(true);
				viewBtn3.setVisible(true);
				sogyunDownBtn.setVisible(true);
			}else if(fileArr[i].contains("인바디.txt")) {
				num4.setVisible(true);
				inbody.setVisible(true);
				rec4.setVisible(true);
				inbodyDown.setVisible(true);
				inbodyUpdate.setVisible(true);
				viewBtn4.setVisible(true);
				inbodyDownBtn.setVisible(true);
			}else if(fileArr[i].contains("수술확인서.txt")) {
				num5.setVisible(true);
				susul.setVisible(true);
				rec5.setVisible(true);
				susulDown.setVisible(true);
				susulUpdate.setVisible(true);
				viewBtn5.setVisible(true);
				susulDownBtn.setVisible(true);
			}
		}//for
		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("mem_id", memVO.getMem_id());
		map1.put("down_item_con", "인바디");
		try {
			String res = docDownService.selectDocDown(map1);
			if(res == null) {
				inbodyUpdate.setText("다운로드 기록 없음");
			}else {
				inbodyUpdate.setText(res);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
      
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("mem_id", memVO.getMem_id());
		map2.put("down_item_con", "진단서");
		try {
			String res = docDownService.selectDocDown(map2);
			if(res == null) {
				jindanUpdate.setText("다운로드 기록 없음");
			}else {
				jindanUpdate.setText(res);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
      
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("mem_id", memVO.getMem_id());
		map3.put("down_item_con", "소견서");
		try {
			String res = docDownService.selectDocDown(map3);
			if(res == null) {
				sogyunUpdate.setText("다운로드 기록 없음");
			}else {
				sogyunUpdate.setText(res);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		Map<String, String> map4 = new HashMap<String, String>();
		map4.put("mem_id", memVO.getMem_id());
		map4.put("down_item_con", "처방전");
		try {
			String res = docDownService.selectDocDown(map4);
			if(res == null) {
				cubangUpdate.setText("다운로드 기록 없음");
			}else {
				cubangUpdate.setText(res);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		Map<String, String> map5 = new HashMap<String, String>();
		map5.put("mem_id", memVO.getMem_id());
		map5.put("down_item_con", "수술확인서");
		try {
			String res = docDownService.selectDocDown(map5);
			if(res == null) {
				susulUpdate.setText("다운로드 기록 없음");
			}else {
				susulUpdate.setText(res);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		
    } // initialize
}
