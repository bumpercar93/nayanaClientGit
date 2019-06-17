package nayana.controller.healthInfoPage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nayana.SelfTest.service.ISelfTestService;
import nayana.SelfTestInfo.service.ISelfTestInfoService;
import nayana.SelfTestQuestion.service.ISelfTestQuestionService;
import nayana.SelfTestResult.service.ISelfTestResultService;
import nayana.vo.MemberVO;
import nayana.vo.SelfTestVO;
import util.AlertUtil;
import util.MyButtonEventHandler;

public class SelfTestController {
	
	private ISelfTestService stService;
	private static Stage mainStage;
	public static void setMainStage(Stage mainStage) {
		SelfTestController.mainStage = mainStage;
	}

	private static MemberVO memVO;
	
	public static MemberVO getMemVO() {
		return memVO;
	}

	public static void setMemVO(MemberVO memVO) {
		SelfTestController.memVO = memVO;
	}

	private ISelfTestInfoService stiService;
	private ISelfTestQuestionService stqService;
	private ISelfTestResultService strService;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Rectangle rec1;

    @FXML
    private Label num1;

    @FXML
    private Label testLabel1;

    @FXML
    private Label lastTest1;

    @FXML
    private Label lastDate1;

    @FXML
    private Button startBtn1;

    @FXML
    private Button lastResBtn1;

    @FXML
    private Rectangle rec2;

    @FXML
    private Label num2;

    @FXML
    private Label testLabel2;

    @FXML
    private Label lastTest2;

    @FXML
    private Label lastDate2;

    @FXML
    private Button startBtn2;

    @FXML
    private Button lastResBtn2;

    @FXML
    private Rectangle rec3;

    @FXML
    private Label num3;

    @FXML
    private Label testLabel3;

    @FXML
    private Label lastTest3;

    @FXML
    private Label lastDate3;

    @FXML
    private Button startBtn3;

    @FXML
    private Button lastResBtn3;

    @FXML
    private Rectangle rec4;

    @FXML
    private Label num4;

    @FXML
    private Label testLabel4;

    @FXML
    private Label lastTest4;

    @FXML
    private Label lastDate4;

    @FXML
    private Button startBtn4;

    @FXML
    private Button lastResBtn4;

    @FXML
    private Rectangle rec5;

    @FXML
    private Label num5;

    @FXML
    private Label testLabel5;

    @FXML
    private Label lastTest5;

    @FXML
    private Label lastDate5;

    @FXML
    private Button startBtn5;

    @FXML
    private Button lastResBtn5;

    @FXML
    void clickLastResBtn1(ActionEvent event) {
    	if(lastDate1.getText().equals("검사 기록 없음")) {
    		AlertUtil.error("ERROR", "검사 기록 누락", memVO.getMem_name() + "님의 검사 기록이 없습니다\n"
    				+ "검사를 먼저 진행하시고 클릭해주세요");
    		return;
    	}
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("self_seq", list.get(0).getSelf_seq());
    	map.put("mem_id", memVO.getMem_id());
    	int score = 0;
    	try {
    		score = stiService.selectSelfTestInfo(map);
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
    	map2.put("self_seq", list.get(0).getSelf_seq());
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
			selfTestResultStage.initOwner(num5.getScene().getWindow());
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
    	
    }

    @FXML
    void clickLastResBtn2(ActionEvent event) {
    	if(lastDate2.getText().equals("검사 기록 없음")) {
    		AlertUtil.error("ERROR", "검사 기록 누락", memVO.getMem_name() + "님의 검사 기록이 없습니다\n"
    				+ "검사를 먼저 진행하시고 클릭해주세요");
    		return;
    	}
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("self_seq", list.get(1).getSelf_seq());
    	map.put("mem_id", memVO.getMem_id());
    	int score = 0;
    	try {
    		score = stiService.selectSelfTestInfo(map);
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
    	map2.put("self_seq", list.get(1).getSelf_seq());
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
			selfTestResultStage.initOwner(num5.getScene().getWindow());
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
    }

    @FXML
    void clickLastResBtn3(ActionEvent event) {
    	if(lastDate3.getText().equals("검사 기록 없음")) {
    		AlertUtil.error("ERROR", "검사 기록 누락", memVO.getMem_name() + "님의 검사 기록이 없습니다\n"
    				+ "검사를 먼저 진행하시고 클릭해주세요");
    		return;
    	}
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("self_seq", list.get(2).getSelf_seq());
    	map.put("mem_id", memVO.getMem_id());
    	int score = 0;
    	try {
    		score = stiService.selectSelfTestInfo(map);
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
    	map2.put("self_seq", list.get(2).getSelf_seq());
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
			selfTestResultStage.initOwner(num5.getScene().getWindow());
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
    }

    @FXML
    void clickLastResBtn4(ActionEvent event) {
    	if(lastDate4.getText().equals("검사 기록 없음")) {
    		AlertUtil.error("ERROR", "검사 기록 누락", memVO.getMem_name() + "님의 검사 기록이 없습니다\n"
    				+ "검사를 먼저 진행하시고 클릭해주세요");
    		return;
    	}
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("self_seq", list.get(3).getSelf_seq());
    	map.put("mem_id", memVO.getMem_id());
    	int score = 0;
    	try {
    		score = stiService.selectSelfTestInfo(map);
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
    	map2.put("self_seq", list.get(3).getSelf_seq());
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
			selfTestResultStage.initOwner(num5.getScene().getWindow());
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
    }

    @FXML
    void clickLastResBtn5(ActionEvent event) {
    	if(lastDate5.getText().equals("검사 기록 없음")) {
    		AlertUtil.error("ERROR", "검사 기록 누락", memVO.getMem_name() + "님의 검사 기록이 없습니다\n"
    				+ "검사를 먼저 진행하시고 클릭해주세요");
    		return;
    	}
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("self_seq", list.get(4).getSelf_seq());
    	map.put("mem_id", memVO.getMem_id());
    	int score = 0;
    	try {
    		score = stiService.selectSelfTestInfo(map);
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
    	map2.put("self_seq", list.get(4).getSelf_seq());
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
			selfTestResultStage.initOwner(num5.getScene().getWindow());
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
    	
    }

    @FXML
    void clickStartBtn1(ActionEvent event) {
    	
    	List<String> list1 = new ArrayList<String>();
    	
    	try {
			list1 = stqService.getAllSelfTestQuestion(list.get(0).getSelf_seq());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
    	
    	
    	try {
    		Stage SelfStartStage = new Stage();
    		SelfStartStage.initModality(Modality.WINDOW_MODAL);
    		SelfStartStage.setResizable(false);
    		SelfStartStage.initOwner(num1.getScene().getWindow());
    		SelfStartStage.setTitle(list.get(0).getSelf_title());
    		
    		SelfTestStartController.setList(list1);
    		SelfTestStartController.setTitle(list.get(0).getSelf_title());
    		SelfTestStartController.setMemVO(memVO);
    		SelfTestStartController.setSelf_seq(list.get(0).getSelf_seq());
    		SelfTestStartController.setMainStage(mainStage);
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/SelfTestStart.fxml"));
    		Parent root = loader.load();
    		SelfTestStartController stsc = loader.getController();
    		stsc.setThisStage(SelfStartStage);
    		stsc.setStc(this);
    		
    		Scene scene = new Scene(root);
    		SelfStartStage.setScene(scene);
    		SelfStartStage.show();
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void clickStartBtn2(ActionEvent event) {
    	List<String> list1 = new ArrayList<String>();
    	
    	try {
			list1 = stqService.getAllSelfTestQuestion(list.get(1).getSelf_seq());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
    	
    	try {
    		Stage SelfStartStage = new Stage();
    		SelfStartStage.initModality(Modality.WINDOW_MODAL);
    		SelfStartStage.setResizable(false);
    		SelfStartStage.initOwner(num1.getScene().getWindow());
    		SelfStartStage.setTitle(list.get(1).getSelf_title());
    		
    		SelfTestStartController.setList(list1);
    		SelfTestStartController.setTitle(list.get(1).getSelf_title());
    		SelfTestStartController.setMemVO(memVO);
    		SelfTestStartController.setSelf_seq(list.get(1).getSelf_seq());
    		SelfTestStartController.setMainStage(mainStage);
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/SelfTestStart.fxml"));
    		Parent root = loader.load();
    		SelfTestStartController stsc = loader.getController();
    		stsc.setThisStage(SelfStartStage);
    		stsc.setStc(this);
    		
    		Scene scene = new Scene(root);
    		SelfStartStage.setScene(scene);
    		SelfStartStage.show();
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickStartBtn3(ActionEvent event) {
    	List<String> list1 = new ArrayList<String>();
    	
    	try {
			list1 = stqService.getAllSelfTestQuestion(list.get(2).getSelf_seq());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
    	
    	try {
    		Stage SelfStartStage = new Stage();
    		SelfStartStage.initModality(Modality.WINDOW_MODAL);
    		SelfStartStage.setResizable(false);
    		SelfStartStage.initOwner(num1.getScene().getWindow());
    		SelfStartStage.setTitle(list.get(2).getSelf_title());
    		
    		SelfTestStartController.setMainStage(mainStage);
    		SelfTestStartController.setList(list1);
    		SelfTestStartController.setTitle(list.get(2).getSelf_title());
    		SelfTestStartController.setMemVO(memVO);
    		SelfTestStartController.setSelf_seq(list.get(2).getSelf_seq());
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/SelfTestStart.fxml"));
    		Parent root = loader.load();
    		SelfTestStartController stsc = loader.getController();
    		stsc.setThisStage(SelfStartStage);
    		stsc.setStc(this);
    		
    		Scene scene = new Scene(root);
    		SelfStartStage.setScene(scene);
    		SelfStartStage.show();
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickStartBtn4(ActionEvent event) {
    	List<String> list1 = new ArrayList<String>();
    	
    	try {
			list1 = stqService.getAllSelfTestQuestion(list.get(3).getSelf_seq());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
    	
    	try {
    		Stage SelfStartStage = new Stage();
    		SelfStartStage.initModality(Modality.WINDOW_MODAL);
    		SelfStartStage.setResizable(false);
    		SelfStartStage.initOwner(num1.getScene().getWindow());
    		SelfStartStage.setTitle(list.get(3).getSelf_title());
    		
    		SelfTestStartController.setMainStage(mainStage);
    		SelfTestStartController.setList(list1);
    		SelfTestStartController.setTitle(list.get(3).getSelf_title());
    		SelfTestStartController.setMemVO(memVO);
    		SelfTestStartController.setSelf_seq(list.get(3).getSelf_seq());
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/SelfTestStart.fxml"));
    		Parent root = loader.load();
    		SelfTestStartController stsc = loader.getController();
    		stsc.setThisStage(SelfStartStage);
    		stsc.setStc(this);
    		
    		Scene scene = new Scene(root);
    		SelfStartStage.setScene(scene);
    		SelfStartStage.show();
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickStartBtn5(ActionEvent event) {
    	List<String> list1 = new ArrayList<String>();
    	
    	try {
			list1 = stqService.getAllSelfTestQuestion(list.get(4).getSelf_seq());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
    	
    	try {
    		Stage SelfStartStage = new Stage();
    		SelfStartStage.initModality(Modality.WINDOW_MODAL);
    		SelfStartStage.setResizable(false);
    		SelfStartStage.initOwner(num1.getScene().getWindow());
    		SelfStartStage.setTitle(list.get(4).getSelf_title());
    		
    		SelfTestStartController.setList(list1);
    		SelfTestStartController.setTitle(list.get(4).getSelf_title());
    		SelfTestStartController.setMemVO(memVO);
    		SelfTestStartController.setSelf_seq(list.get(4).getSelf_seq());
    		SelfTestStartController.setMainStage(mainStage);
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/healthInfoPage/SelfTestStart.fxml"));
    		Parent root = loader.load();
    		SelfTestStartController stsc = loader.getController();
    		stsc.setThisStage(SelfStartStage);
    		stsc.setStc(this);
    		
    		Scene scene = new Scene(root);
    		SelfStartStage.setScene(scene);
    		SelfStartStage.show();
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void setLastDate() {
		if(list.size() == 5) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("self_seq", list.get(0).getSelf_seq());
			map1.put("mem_id", memVO.getMem_id());
			String myDate1 = null;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("self_seq", list.get(1).getSelf_seq());
			map2.put("mem_id", memVO.getMem_id());
			String myDate2 = null;
			Map<String, Object> map3 = new HashMap<String, Object>();
			map3.put("self_seq", list.get(2).getSelf_seq());
			map3.put("mem_id", memVO.getMem_id());
			String myDate3 = null;
			Map<String, Object> map4 = new HashMap<String, Object>();
			map4.put("self_seq", list.get(3).getSelf_seq());
			map4.put("mem_id", memVO.getMem_id());
			String myDate4 = null;
			Map<String, Object> map5 = new HashMap<String, Object>();
			map5.put("self_seq", list.get(4).getSelf_seq());
			map5.put("mem_id", memVO.getMem_id());
			String myDate5 = null;
			try {
				myDate1 = stiService.getMyTestDate(map1);
				myDate2 = stiService.getMyTestDate(map2);
				myDate3 = stiService.getMyTestDate(map3);
				myDate4 = stiService.getMyTestDate(map4);
				myDate5 = stiService.getMyTestDate(map5);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if (myDate1 == null) {
				lastDate1.setText("검사 기록 없음");
			} else {
				lastDate1.setText(myDate1);
			}
			if (myDate2 == null) {
				lastDate2.setText("검사 기록 없음");
			} else {
				lastDate2.setText(myDate2);
			}
			if (myDate3 == null) {
				lastDate3.setText("검사 기록 없음");
			} else {
				lastDate3.setText(myDate3);
			}
			if (myDate4 == null) {
				lastDate4.setText("검사 기록 없음");
			} else {
				lastDate4.setText(myDate4);
			}
			if (myDate5 == null) {
				lastDate5.setText("검사 기록 없음");
			} else {
				lastDate5.setText(myDate4);
			}

		} else if (list.size() == 4) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("self_seq", list.get(0).getSelf_seq());
			map1.put("mem_id", memVO.getMem_id());
			String myDate1 = null;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("self_seq", list.get(1).getSelf_seq());
			map2.put("mem_id", memVO.getMem_id());
			String myDate2 = null;
			Map<String, Object> map3 = new HashMap<String, Object>();
			map3.put("self_seq", list.get(2).getSelf_seq());
			map3.put("mem_id", memVO.getMem_id());
			String myDate3 = null;
			Map<String, Object> map4 = new HashMap<String, Object>();
			map4.put("self_seq", list.get(3).getSelf_seq());
			map4.put("mem_id", memVO.getMem_id());
			String myDate4 = null;
			try {
				myDate1 = stiService.getMyTestDate(map1);
				myDate2 = stiService.getMyTestDate(map2);
				myDate3 = stiService.getMyTestDate(map3);
				myDate4 = stiService.getMyTestDate(map4);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if (myDate1 == null) {
				lastDate1.setText("검사 기록 없음");
			} else {
				lastDate1.setText(myDate1);
			}
			if (myDate2 == null) {
				lastDate2.setText("검사 기록 없음");
			} else {
				lastDate2.setText(myDate2);
			}
			if (myDate3 == null) {
				lastDate3.setText("검사 기록 없음");
			} else {
				lastDate3.setText(myDate3);
			}
			if (myDate4 == null) {
				lastDate4.setText("검사 기록 없음");
			} else {
				lastDate4.setText(myDate4);
			}

		} else if (list.size() == 3) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("self_seq", list.get(0).getSelf_seq());
			map1.put("mem_id", memVO.getMem_id());
			String myDate1 = null;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("self_seq", list.get(1).getSelf_seq());
			map2.put("mem_id", memVO.getMem_id());
			String myDate2 = null;
			Map<String, Object> map3 = new HashMap<String, Object>();
			map3.put("self_seq", list.get(2).getSelf_seq());
			map3.put("mem_id", memVO.getMem_id());
			String myDate3 = null;
			try {
				myDate1 = stiService.getMyTestDate(map1);
				myDate2 = stiService.getMyTestDate(map2);
				myDate3 = stiService.getMyTestDate(map3);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if (myDate1 == null) {
				lastDate1.setText("검사 기록 없음");
			} else {
				lastDate1.setText(myDate1);
			}
			if (myDate2 == null) {
				lastDate2.setText("검사 기록 없음");
			} else {
				lastDate2.setText(myDate2);
			}
			if (myDate3 == null) {
				lastDate3.setText("검사 기록 없음");
			} else {
				lastDate3.setText(myDate3);
			}

		} else if (list.size() == 2) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("self_seq", list.get(0).getSelf_seq());
			map1.put("mem_id", memVO.getMem_id());
			String myDate1 = null;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("self_seq", list.get(1).getSelf_seq());
			map2.put("mem_id", memVO.getMem_id());
			String myDate2 = null;
			try {
				myDate1 = stiService.getMyTestDate(map1);
				myDate2 = stiService.getMyTestDate(map2);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if (myDate1 == null) {
				lastDate1.setText("검사 기록 없음");
			} else {
				lastDate1.setText(myDate1);
			}
			if (myDate2 == null) {
				lastDate2.setText("검사 기록 없음");
			} else {
				lastDate2.setText(myDate2);
			}

		} else if (list.size() == 1) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("self_seq", list.get(0).getSelf_seq());
			map1.put("mem_id", memVO.getMem_id());
			String myDate1 = null;
			try {
				myDate1 = stiService.getMyTestDate(map1);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if (myDate1 == null) {
				lastDate1.setText("검사 기록 없음");
			} else {
				lastDate1.setText(myDate1);
			}
		}
		
    }
    
    private List<SelfTestVO> list;
    
    @FXML
    void initialize() {
        assert rec1 != null : "fx:id=\"rec1\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert num1 != null : "fx:id=\"num1\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert testLabel1 != null : "fx:id=\"testLabel1\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastTest1 != null : "fx:id=\"lastTest1\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastDate1 != null : "fx:id=\"lastDate1\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert startBtn1 != null : "fx:id=\"startBtn1\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastResBtn1 != null : "fx:id=\"lastResBtn1\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert rec2 != null : "fx:id=\"rec2\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert num2 != null : "fx:id=\"num2\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert testLabel2 != null : "fx:id=\"testLabel2\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastTest2 != null : "fx:id=\"lastTest2\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastDate2 != null : "fx:id=\"lastDate2\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert startBtn2 != null : "fx:id=\"startBtn2\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastResBtn2 != null : "fx:id=\"lastResBtn2\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert rec3 != null : "fx:id=\"rec3\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert num3 != null : "fx:id=\"num3\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert testLabel3 != null : "fx:id=\"testLabel3\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastTest3 != null : "fx:id=\"lastTest3\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastDate3 != null : "fx:id=\"lastDate3\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert startBtn3 != null : "fx:id=\"startBtn3\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastResBtn3 != null : "fx:id=\"lastResBtn3\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert rec4 != null : "fx:id=\"rec4\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert num4 != null : "fx:id=\"num4\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert testLabel4 != null : "fx:id=\"testLabel4\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastTest4 != null : "fx:id=\"lastTest4\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastDate4 != null : "fx:id=\"lastDate4\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert startBtn4 != null : "fx:id=\"startBtn4\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastResBtn4 != null : "fx:id=\"lastResBtn4\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert rec5 != null : "fx:id=\"rec5\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert num5 != null : "fx:id=\"num5\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert testLabel5 != null : "fx:id=\"testLabel5\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastTest5 != null : "fx:id=\"lastTest5\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastDate5 != null : "fx:id=\"lastDate5\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert startBtn5 != null : "fx:id=\"startBtn5\" was not injected: check your FXML file 'SelfTest.fxml'.";
        assert lastResBtn5 != null : "fx:id=\"lastResBtn5\" was not injected: check your FXML file 'SelfTest.fxml'.";
        
        startBtn1.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        startBtn2.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        startBtn3.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        startBtn4.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        startBtn5.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        lastResBtn1.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        lastResBtn2.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        lastResBtn3.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        lastResBtn4.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        lastResBtn5.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        list = new ArrayList<SelfTestVO>();
        
        try {
  			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
  			stiService =  (ISelfTestInfoService) reg.lookup("selfTestInfoService");
  			stqService = (ISelfTestQuestionService) reg.lookup("selfTestQuestionService");
  			strService = (ISelfTestResultService) reg.lookup("selfTestResultService");
  			stService = (ISelfTestService) reg.lookup("selfTestService");
  		} catch (RemoteException e) {
  			e.printStackTrace();
  		} catch (NotBoundException e) {
  			e.printStackTrace();
  		}
        
        try {
        	list = stService.getAllSelfTest();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        
        if(list.size() == 5) {
        	testLabel1.setText(list.get(0).getSelf_title());
        	testLabel2.setText(list.get(1).getSelf_title());
        	testLabel3.setText(list.get(2).getSelf_title());
        	testLabel4.setText(list.get(3).getSelf_title());
        	testLabel5.setText(list.get(4).getSelf_title());
        	
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("self_seq", list.get(0).getSelf_seq());
            map1.put("mem_id", memVO.getMem_id());
            String myDate1 = null;
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("self_seq", list.get(1).getSelf_seq());
            map2.put("mem_id", memVO.getMem_id());
            String myDate2 = null;
            Map<String, Object> map3 = new HashMap<String, Object>();
            map3.put("self_seq", list.get(2).getSelf_seq());
            map3.put("mem_id", memVO.getMem_id());
            String myDate3 = null;
            Map<String, Object> map4 = new HashMap<String, Object>();
            map4.put("self_seq", list.get(3).getSelf_seq());
            map4.put("mem_id", memVO.getMem_id());
            String myDate4 = null;
            Map<String, Object> map5 = new HashMap<String, Object>();
            map5.put("self_seq", list.get(4).getSelf_seq());
            map5.put("mem_id", memVO.getMem_id());
            String myDate5 = null;
            try {
            	myDate1 = stiService.getMyTestDate(map1);
            	myDate2 = stiService.getMyTestDate(map2);
            	myDate3 = stiService.getMyTestDate(map3);
            	myDate4 = stiService.getMyTestDate(map4);
            	myDate5 = stiService.getMyTestDate(map5);
    		} catch (RemoteException e) {
    			e.printStackTrace();
    		}
            if(myDate1 == null) {
            	lastDate1.setText("검사 기록 없음");
            }else {
            	lastDate1.setText(myDate1);
            }
            if(myDate2 == null) {
            	lastDate2.setText("검사 기록 없음");
            }else {
            	lastDate2.setText(myDate2);
            }
            if(myDate3 == null) {
            	lastDate3.setText("검사 기록 없음");
            }else {
            	lastDate3.setText(myDate3);
            }
            if(myDate4 == null) {
            	lastDate4.setText("검사 기록 없음");
            }else {
            	lastDate4.setText(myDate4);
            }
            if(myDate5 == null) {
            	lastDate5.setText("검사 기록 없음");
            }else {
            	lastDate5.setText(myDate4);
            }
        	
        }else if(list.size() == 4) {
        	testLabel1.setText(list.get(0).getSelf_title());
        	testLabel2.setText(list.get(1).getSelf_title());
        	testLabel3.setText(list.get(2).getSelf_title());
        	testLabel4.setText(list.get(3).getSelf_title());
        	rec5.setVisible(false);
        	num5.setVisible(false);
        	testLabel5.setVisible(false);
        	lastTest5.setVisible(false);
        	lastDate5.setVisible(false);
        	startBtn5.setVisible(false);
        	lastResBtn5.setVisible(false);
        	
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("self_seq", list.get(0).getSelf_seq());
            map1.put("mem_id", memVO.getMem_id());
            String myDate1 = null;
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("self_seq", list.get(1).getSelf_seq());
            map2.put("mem_id", memVO.getMem_id());
            String myDate2 = null;
            Map<String, Object> map3 = new HashMap<String, Object>();
            map3.put("self_seq", list.get(2).getSelf_seq());
            map3.put("mem_id", memVO.getMem_id());
            String myDate3 = null;
            Map<String, Object> map4 = new HashMap<String, Object>();
            map4.put("self_seq", list.get(3).getSelf_seq());
            map4.put("mem_id", memVO.getMem_id());
            String myDate4 = null;
            try {
            	myDate1 = stiService.getMyTestDate(map1);
            	myDate2 = stiService.getMyTestDate(map2);
            	myDate3 = stiService.getMyTestDate(map3);
            	myDate4 = stiService.getMyTestDate(map4);
    		} catch (RemoteException e) {
    			e.printStackTrace();
    		}
            if(myDate1 == null) {
            	lastDate1.setText("검사 기록 없음");
            }else {
            	lastDate1.setText(myDate1);
            }
            if(myDate2 == null) {
            	lastDate2.setText("검사 기록 없음");
            }else {
            	lastDate2.setText(myDate2);
            }
            if(myDate3 == null) {
            	lastDate3.setText("검사 기록 없음");
            }else {
            	lastDate3.setText(myDate3);
            }
            if(myDate4 == null) {
            	lastDate4.setText("검사 기록 없음");
            }else {
            	lastDate4.setText(myDate4);
            }
        	
        }else if(list.size() == 3) {
        	testLabel1.setText(list.get(0).getSelf_title());
        	testLabel2.setText(list.get(1).getSelf_title());
        	testLabel3.setText(list.get(2).getSelf_title());
        	rec5.setVisible(false);
        	num5.setVisible(false);
        	testLabel5.setVisible(false);
        	lastTest5.setVisible(false);
        	lastDate5.setVisible(false);
        	startBtn5.setVisible(false);
        	lastResBtn5.setVisible(false);
        	rec4.setVisible(false);
        	num4.setVisible(false);
        	testLabel4.setVisible(false);
        	lastTest4.setVisible(false);
        	lastDate4.setVisible(false);
        	startBtn4.setVisible(false);
        	lastResBtn4.setVisible(false);
        	
        	Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("self_seq", list.get(0).getSelf_seq());
            map1.put("mem_id", memVO.getMem_id());
            String myDate1 = null;
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("self_seq", list.get(1).getSelf_seq());
            map2.put("mem_id", memVO.getMem_id());
            String myDate2 = null;
            Map<String, Object> map3 = new HashMap<String, Object>();
            map3.put("self_seq", list.get(2).getSelf_seq());
            map3.put("mem_id", memVO.getMem_id());
            String myDate3 = null;
            try {
            	myDate1 = stiService.getMyTestDate(map1);
            	myDate2 = stiService.getMyTestDate(map2);
            	myDate3 = stiService.getMyTestDate(map3);
    		} catch (RemoteException e) {
    			e.printStackTrace();
    		}
            if(myDate1 == null) {
            	lastDate1.setText("검사 기록 없음");
            }else {
            	lastDate1.setText(myDate1);
            }
            if(myDate2 == null) {
            	lastDate2.setText("검사 기록 없음");
            }else {
            	lastDate2.setText(myDate2);
            }
            if(myDate3 == null) {
            	lastDate3.setText("검사 기록 없음");
            }else {
            	lastDate3.setText(myDate3);
            }
        	
        }else if(list.size() == 2) {
        	testLabel1.setText(list.get(0).getSelf_title());
        	testLabel2.setText(list.get(1).getSelf_title());
        	rec5.setVisible(false);
        	num5.setVisible(false);
        	testLabel5.setVisible(false);
        	lastTest5.setVisible(false);
        	lastDate5.setVisible(false);
        	startBtn5.setVisible(false);
        	lastResBtn5.setVisible(false);
        	rec4.setVisible(false);
        	num4.setVisible(false);
        	testLabel4.setVisible(false);
        	lastTest4.setVisible(false);
        	lastDate4.setVisible(false);
        	startBtn4.setVisible(false);
        	lastResBtn4.setVisible(false);
        	rec3.setVisible(false);
        	num3.setVisible(false);
        	testLabel3.setVisible(false);
        	lastTest3.setVisible(false);
        	lastDate3.setVisible(false);
        	startBtn3.setVisible(false);
        	lastResBtn3.setVisible(false);
        	
        	Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("self_seq", list.get(0).getSelf_seq());
            map1.put("mem_id", memVO.getMem_id());
            String myDate1 = null;
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("self_seq", list.get(1).getSelf_seq());
            map2.put("mem_id", memVO.getMem_id());
            String myDate2 = null;
            try {
            	myDate1 = stiService.getMyTestDate(map1);
            	myDate2 = stiService.getMyTestDate(map2);
    		} catch (RemoteException e) {
    			e.printStackTrace();
    		}
            if(myDate1 == null) {
            	lastDate1.setText("검사 기록 없음");
            }else {
            	lastDate1.setText(myDate1);
            }
            if(myDate2 == null) {
            	lastDate2.setText("검사 기록 없음");
            }else {
            	lastDate2.setText(myDate2);
            }
        	
        }else if(list.size() == 1) {
        	testLabel1.setText(list.get(0).getSelf_title());
        	rec5.setVisible(false);
        	num5.setVisible(false);
        	testLabel5.setVisible(false);
        	lastTest5.setVisible(false);
        	lastDate5.setVisible(false);
        	startBtn5.setVisible(false);
        	lastResBtn5.setVisible(false);
        	rec4.setVisible(false);
        	num4.setVisible(false);
        	testLabel4.setVisible(false);
        	lastTest4.setVisible(false);
        	lastDate4.setVisible(false);
        	startBtn4.setVisible(false);
        	lastResBtn4.setVisible(false);
        	rec3.setVisible(false);
        	num3.setVisible(false);
        	testLabel3.setVisible(false);
        	lastTest3.setVisible(false);
        	lastDate3.setVisible(false);
        	startBtn3.setVisible(false);
        	lastResBtn3.setVisible(false);
        	rec2.setVisible(false);
        	num2.setVisible(false);
        	testLabel2.setVisible(false);
        	lastTest2.setVisible(false);
        	lastDate2.setVisible(false);
        	startBtn2.setVisible(false);
        	lastResBtn2.setVisible(false);
        	
        	Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("self_seq", list.get(0).getSelf_seq());
            map1.put("mem_id", memVO.getMem_id());
            String myDate1 = null;
            try {
            	myDate1 = stiService.getMyTestDate(map1);
    		} catch (RemoteException e) {
    			e.printStackTrace();
    		}
            if(myDate1 == null) {
            	lastDate1.setText("검사 기록 없음");
            }else {
            	lastDate1.setText(myDate1);
            }
        	
        }else {
        	rec5.setVisible(false);
        	num5.setVisible(false);
        	testLabel5.setVisible(false);
        	lastTest5.setVisible(false);
        	lastDate5.setVisible(false);
        	startBtn5.setVisible(false);
        	lastResBtn5.setVisible(false);
        	rec4.setVisible(false);
        	num4.setVisible(false);
        	testLabel4.setVisible(false);
        	lastTest4.setVisible(false);
        	lastDate4.setVisible(false);
        	startBtn4.setVisible(false);
        	lastResBtn4.setVisible(false);
        	rec3.setVisible(false);
        	num3.setVisible(false);
        	testLabel3.setVisible(false);
        	lastTest3.setVisible(false);
        	lastDate3.setVisible(false);
        	startBtn3.setVisible(false);
        	lastResBtn3.setVisible(false);
        	rec2.setVisible(false);
        	num2.setVisible(false);
        	testLabel2.setVisible(false);
        	lastTest2.setVisible(false);
        	lastDate2.setVisible(false);
        	startBtn2.setVisible(false);
        	lastResBtn2.setVisible(false);
        	rec1.setVisible(false);
        	num1.setVisible(false);
        	testLabel1.setVisible(false);
        	lastTest1.setVisible(false);
        	lastDate1.setVisible(false);
        	startBtn1.setVisible(false);
        	lastResBtn1.setVisible(false);
        }
        
        
        
        
    }//initialize
}
