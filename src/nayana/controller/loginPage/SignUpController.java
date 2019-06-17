package nayana.controller.loginPage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nayana.Inbody.service.IInbodyService;
import nayana.MedicalCertficate.service.IMedicalCertficateService;
import nayana.MedicalReport.service.IMedicalReportService;
import nayana.Prescription.service.IPrescriptionService;
import nayana.SurgicalConfirmation.service.ISurgicalConfirmationService;
import nayana.member.service.IMemberService;
import nayana.vo.InbodyVO;
import nayana.vo.MedicalCertificateVO;
import nayana.vo.MedicalReportVO;
import nayana.vo.MemberVO;
import nayana.vo.PrescriptionVO;
import nayana.vo.SurgicalConfirmationVO;
import util.AlertUtil;
import util.MyButtonEventHandler;
import util.MyFTP;
import util.MyFileReader;
import util.Reg;

public class SignUpController {
	private IMemberService memberService;
	private IMedicalCertficateService mcService;
	private IInbodyService inbodyService;
	private IMedicalReportService mrService;
	private IPrescriptionService preService;
	private ISurgicalConfirmationService scService;
	private Stage signUpStage;
	private Stage primaryStage;
	private String name;
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Stage getSignUpStage() {
		return signUpStage;
	}

	public void setSignUpStage(Stage signUpStage) {
		this.signUpStage = signUpStage;
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputID;

    @FXML
    private TextField inputName;

    @FXML
    private ComboBox<String> inputGender;

    @FXML
    private TextField inputRegNo1;

    @FXML
    private TextField inputRegNo2;

    @FXML
    private TextField inputTel;

    @FXML
    private TextField inputMail;

    @FXML
    private TextField inputAddr1;

    @FXML
    private TextField inputAddr2;

    @FXML
    private Button signupBtn;

    @FXML
    private Button checkIDBtn;

    @FXML
    private PasswordField inputPW;

    @FXML
    private PasswordField inputRePW;

    @FXML
    private Label regID;

    @FXML
    private Label regPW;

    @FXML
    private Label regRePW;

    @FXML
    private Label regName;

    @FXML
    private Label regGender;

    @FXML
    private Label regRegNo1;

    @FXML
    private Label regTel;

    @FXML
    private Label regAddr1;

    @FXML
    private Label regMail;

    @FXML
    private Label regRegNo2;

    @FXML
    private Label regAddr2;

    @FXML
    void clickCheckIDBtn(ActionEvent event) {
    	String result = "";
    	try {
    		result = memberService.idCheck(inputID.getText());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	if(result == null) {
    		regID.setText("사용가능한 ID입니다");
    		regID.setStyle("-fx-text-fill:#4ab834");
    		signupBtn.setDisable(false);
    	}else {
    		regID.setText("중복된 ID입니다");
    		regID.setStyle("-fx-text-fill:#ff847c");
    		inputID.clear();
    	}
    	
    }

    @FXML
    void clickSignupBtn(ActionEvent event) {
    	if(inputID.getText().trim().length() < 1) {
    		regID.setText("필수 입력사항 입니다");
    		regID.setStyle("-fx-text-fill:#ff847c");
    		inputID.requestFocus();
    		return;
    	}else if(inputPW.getText().trim().length() < 1) {
    		regPW.setText("필수 입력사항 입니다");
    		regPW.setStyle("-fx-text-fill:#ff847c");
    		inputPW.requestFocus();
    		return;
    	}else if(inputRePW.getText().trim().length() < 1) {
    		regRePW.setText("필수 입력사항 입니다");
    		regRePW.setStyle("-fx-text-fill:#ff847c");
    		inputRePW.requestFocus();
    		return;
    	}else if(inputName.getText().trim().length() < 1) {
    		regName.setText("필수 입력사항 입니다");
    		regName.setStyle("-fx-text-fill:#ff847c");
    		inputName.requestFocus();
    		return;
    	}else if(inputAddr1.getText().trim().length() < 1) {
    		regAddr1.setText("필수 입력사항 입니다");
    		regAddr1.setStyle("-fx-text-fill:#ff847c");
    		inputAddr1.requestFocus();
    		return;
    	}else if(inputAddr2.getText().trim().length() < 1) {
    		regAddr2.setText("필수 입력사항 입니다");
    		regAddr2.setStyle("-fx-text-fill:#ff847c");
    		inputAddr2.requestFocus();
    		return;
    	}else if(inputMail.getText().trim().length() < 1) {
    		regMail.setText("필수 입력사항 입니다");
    		regMail.setStyle("-fx-text-fill:#ff847c");
    		inputMail.requestFocus();
    		return;
    	}else if(inputTel.getText().trim().length() < 1) {
    		regTel.setText("필수 입력사항 입니다");
    		regTel.setStyle("-fx-text-fill:#ff847c");
    		inputTel.requestFocus();
    		return;
    	}else if(inputRegNo1.getText().trim().length() < 1) {
    		regRegNo1.setText("필수 입력사항 입니다");
    		regRegNo1.setStyle("-fx-text-fill:#ff847c");
    		inputRegNo1.requestFocus();
    		return;
    	}else if(inputRegNo2.getText().trim().length() < 1) {
    		regRegNo2.setText("필수 입력사항 입니다");
    		regRegNo2.setStyle("-fx-text-fill:#ff847c");
    		inputRegNo2.requestFocus();
    		return;
    	}
    	
    	String gender = "";
    	name = inputName.getText();
    	if(inputGender.getSelectionModel().getSelectedItem().equals("남자")){
    		gender = "M";
    	}else {
    		gender = "W";
    	}
    	
    	MemberVO mVO = new MemberVO();
    	mVO.setMem_id(inputID.getText());
    	mVO.setMem_pw(inputPW.getText());
    	mVO.setMem_name(name);
    	mVO.setMem_gen(gender);
    	mVO.setMem_regno1(inputRegNo1.getText());
    	mVO.setMem_regno2(inputRegNo2.getText());
    	mVO.setMem_phone(inputTel.getText());
    	mVO.setMem_email(inputMail.getText());
    	mVO.setMem_addr1(inputAddr1.getText());
    	mVO.setMem_addr2(inputAddr2.getText()+"구");
    	mVO.setMem_status("N");
    	mVO.setMem_right("U");
    	
    	int cnt = 0;
    	try {
			cnt = memberService.signUp(mVO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	if(cnt > 0) {
    		try {
    			MyFTP mf = new MyFTP();
    			String[] fileNames = mf.FtpDirectoryRead("/" + inputRegNo1.getText() + "-" + inputRegNo2.getText());
    			for (int i = 0; i < fileNames.length; i++) {
    				if(fileNames[i] == null) {
    					break;
    				}
					mf.FtpDownLoad(inputRegNo1.getText(), inputRegNo2.getText(), fileNames[i]);
				}
    			
    			MyFileReader mfr = new MyFileReader();
    			for(int i = 0; i < fileNames.length; i++) {
					if(fileNames[i].contains("진단서.txt")) {
						Map<String, String> map = new HashMap<String, String>();
						MedicalCertificateVO mcVO = new MedicalCertificateVO();
						map = mfr.fileRead(inputRegNo1.getText(), inputRegNo2.getText(), fileNames[i]);
						mcVO.setMem_id(inputID.getText());
						mcVO.setMc_pt_name(map.get("환자성명"));
						mcVO.setMc_pt_gen(map.get("환자성별"));
						mcVO.setMc_pt_bir(map.get("환자생년월일"));
						mcVO.setMc_pt_age(map.get("환자나이"));
						mcVO.setMc_pt_addr(map.get("환자주소"));
						mcVO.setMc_pt_phone(map.get("환자전화"));
						mcVO.setMc_pt_dss_name(map.get("환자병명"));
						mcVO.setMc_dss_num(map.get("한국질병분류번호"));
						mcVO.setMc_onsetdate(map.get("진단서발병일"));
						mcVO.setMc_dgs_date(map.get("진단서진단일"));
						mcVO.setMc_afteropinion(map.get("진단서향후치료의견"));
						mcVO.setMc_remarks(map.get("진단서비고"));
						mcVO.setMc_usage(map.get("진단서용도"));
						mcVO.setMc_isu_agency(map.get("진단서발급기관"));
						mcVO.setMc_hp_addr(map.get("진단서병원주소"));
						mcVO.setMc_hp_tel(map.get("진단서병원전화"));
						mcVO.setMc_dr_name(map.get("진단서의사성명"));
						mcVO.setMc_dr_num(map.get("진단서의사면허번호"));
						mcService.insertMedcalCertficate(mcVO);
					}else if(fileNames[i].contains("인바디.txt")) {
						Map<String, String> map = new HashMap<String, String>();
						map = mfr.fileRead(inputRegNo1.getText(), inputRegNo2.getText(), fileNames[i]);
						InbodyVO ibVO = new InbodyVO();
						ibVO.setMem_id(inputID.getText());
						ibVO.setIb_num(map.get("회원번호"));
						ibVO.setIb_height(map.get("키"));
						ibVO.setIb_weight(map.get("체중"));
						ibVO.setIb_age(map.get("나이"));
						ibVO.setIb_gen(map.get("성별"));
						ibVO.setIb_date(map.get("검사일"));
						ibVO.setIb_muscle(map.get("골격근량"));
						ibVO.setIb_fat(map.get("체지방량"));
						ibVO.setIb_bmi(map.get("BMI"));
						ibVO.setIb_fat_rate(map.get("체지방률"));
						ibVO.setIb_abd_rate(map.get("복부지방률"));
						ibVO.setIb_score(map.get("인바디점수"));
						ibVO.setIb_mb_rate(map.get("기초대사량"));
						inbodyService.insertInbody(ibVO);
					}else if(fileNames[i].contains("소견서.txt")) {
						Map<String, String> map = new HashMap<String, String>();
						map = mfr.fileRead(inputRegNo1.getText(), inputRegNo2.getText(), fileNames[i]);
						MedicalReportVO mrVO = new MedicalReportVO();
						mrVO.setMem_id(inputID.getText());
						mrVO.setMr_medi_part(map.get("진료과"));
						mrVO.setMr_serial_num(map.get("일련번호"));
						mrVO.setMr_writer(map.get("작성자"));
						mrVO.setMr_date(map.get("진료소견서일자"));
						mrVO.setMr_pt_regno(map.get("주민등록번호"));
						mrVO.setMr_pt_addr(map.get("환자주소"));
						mrVO.setMr_pt_name(map.get("환자성명"));
						mrVO.setMr_pt_gen(map.get("성별"));
						mrVO.setMr_pt_bir(map.get("생년월일"));
						mrVO.setMr_pt_age(map.get("환자나이"));
						mrVO.setMr_pt_dss_name(map.get("병명"));
						mrVO.setMr_tt_finding(map.get("치료소견"));
						mrService.insertMedicalReport(mrVO);
					}else if(fileNames[i].contains("처방전.txt")) {
						Map<String, String> map = new HashMap<String, String>();
						map = mfr.fileRead(inputRegNo1.getText(), inputRegNo2.getText(), fileNames[i]);
						PrescriptionVO pVO = new PrescriptionVO();
						pVO.setMem_id(inputID.getText());
						pVO.setPs_pt_name(map.get("처방전환자성명"));
						pVO.setPs_pt_regno(map.get("처방전환자주민번호"));
						pVO.setPs_isu_date(map.get("처방전발행일"));
						pVO.setPs_isu_agency(map.get("처방전발급기관"));
						pVO.setPs_hp_tel(map.get("처방전병원전화"));
						pVO.setPs_hp_fax(map.get("처방전병원팩스번호"));
						pVO.setPs_dss_num(map.get("처방전질병분류번호"));
						pVO.setPs_dr_name(map.get("처방전의사성명"));
						pVO.setPs_dr_num(map.get("처방전의사면허번호"));
						pVO.setPs_medicine(map.get("처방전처방의약품명칭"));
						pVO.setPs_doses_medi(map.get("처방전1회투약량"));
						pVO.setPs_doses_num(map.get("처방전1일투여횟수"));
						pVO.setPs_all_doses_day(map.get("처방전총투약일수"));
						pVO.setPs_usage(map.get("처방전용법"));
						preService.insertPrescription(pVO);
					}else if(fileNames[i].contains("수술확인서.txt")) {
						Map<String, String> map = new HashMap<String, String>();
						map = mfr.fileRead(inputRegNo1.getText(), inputRegNo2.getText(), fileNames[i]);
						SurgicalConfirmationVO scVO = new SurgicalConfirmationVO();
						scVO.setMem_id(inputID.getText());
						scVO.setSc_medi_part(map.get("진료과"));
						scVO.setSc_date(map.get("일자"));
						scVO.setSc_serial_num(map.get("일련번호"));
						scVO.setSc_regno(map.get("주민등록번호"));
						scVO.setSc_hz_part(map.get("입원과"));
						scVO.setSc_hz_date(map.get("입원일자"));
						scVO.setSc_pt_name(map.get("환자성명"));
						scVO.setSc_pt_gen(map.get("성별"));
						scVO.setSc_pt_bir(map.get("생년월일"));
						scVO.setSc_pt_age(map.get("연령"));
						scVO.setSc_pt_addr(map.get("주소"));
						scVO.setSc_dgs_name(map.get("진단명"));
						scVO.setSc_dgs_con(map.get("진단내용"));
						scVO.setSc_op_date(map.get("수술일"));
						scVO.setSc_isu_date(map.get("발행일"));
						scVO.setSc_dr_name(map.get("의사성명"));
						scVO.setSc_dr_num(map.get("면허번호"));
						scService.insertSurgicalConfirmation(scVO);
					}
				}// for
    			
    			Stage SignUpCompleteStage = new Stage();
    			SignUpCompleteStage.initModality(Modality.WINDOW_MODAL);
    			SignUpCompleteStage.setResizable(false);
    			SignUpCompleteStage.initOwner(primaryStage);
    			SignUpCompleteStage.setTitle("회원가입 완료");
    			
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/loginPage/SignUpComplete.fxml"));
    			Parent root = loader.load();
    			SignUpCompleteController signUpCompleteController = loader.getController();
    			signUpCompleteController.setSignUpCompleteStage(SignUpCompleteStage);
    			signUpCompleteController.setName(name);
    			
    			Scene scene = new Scene(root);
    			SignUpCompleteStage.setScene(scene);
    			SignUpCompleteStage.show();
    			signUpStage.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}else {
    		AlertUtil.error("회원가입 실패", "x", "x");
    	}
    }

    @FXML
    void initialize() {
        assert inputID != null : "fx:id=\"inputID\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert inputName != null : "fx:id=\"inputName\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert inputGender != null : "fx:id=\"inputGender\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert inputRegNo1 != null : "fx:id=\"inputRegNo1\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert inputRegNo2 != null : "fx:id=\"inputRegNo2\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert inputTel != null : "fx:id=\"inputTel\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert inputMail != null : "fx:id=\"inputMail\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert inputAddr1 != null : "fx:id=\"inputAddr1\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert inputAddr2 != null : "fx:id=\"inputAddr2\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert signupBtn != null : "fx:id=\"signupBtn\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert checkIDBtn != null : "fx:id=\"checkIDBtn\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert inputPW != null : "fx:id=\"inputPW\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert inputRePW != null : "fx:id=\"inputRePW\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert regID != null : "fx:id=\"regID\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert regPW != null : "fx:id=\"regPW\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert regRePW != null : "fx:id=\"regRePW\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert regName != null : "fx:id=\"regName\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert regGender != null : "fx:id=\"regGender\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert regRegNo1 != null : "fx:id=\"regRegNo1\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert regTel != null : "fx:id=\"regTel\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert regAddr1 != null : "fx:id=\"regAddr1\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert regMail != null : "fx:id=\"regMail\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert regRegNo2 != null : "fx:id=\"regRegNo2\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert regAddr2 != null : "fx:id=\"regAddr2\" was not injected: check your FXML file 'SignUp.fxml'.";
        
        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			memberService = (IMemberService) reg.lookup("memberService");
			mcService = (IMedicalCertficateService) reg.lookup("medicalCertficateService");
			inbodyService = (IInbodyService) reg.lookup("inbodyService");
			mrService = (IMedicalReportService) reg.lookup("medicalReportService");
			preService = (IPrescriptionService) reg.lookup("prescriptionService");
			scService = (ISurgicalConfirmationService) reg.lookup("surgicalConfirmationService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
        
        signupBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        checkIDBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        inputGender.getItems().addAll("남자", "여자");
        inputGender.setValue("남자");
        
        signupBtn.setDisable(true);
        
        inputID.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					boolean result = Pattern.matches(Reg.regID, inputID.getText());
					if(result) {
						regID.setText("");
					}else {
						regID.setText("시작은 영문,'_'를 제외한 특수문자 안되며 영문,\n숫자,'_'으로만 이루어진 5 ~ 12자 이하로 입력하세요");
			    		regID.setStyle("-fx-text-fill:#ff847c");
			    		inputID.clear();
					}
				}
			}
        });
        
        inputPW.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					boolean result = Pattern.matches(Reg.regPW, inputPW.getText());
					if(result) {
						regPW.setText("");
					}else {
						regPW.setText("최소 8자리에 숫자, 문자, 특수문자 각각\n1개 이상 포함하여 입력하세요");
			    		regPW.setStyle("-fx-text-fill:#ff847c");
			    		inputPW.clear();
					}
				}
			}
		});
        
        inputRePW.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					if(inputPW.getText().equals(inputRePW.getText())) {
						regRePW.setText("");
					}else {
						regRePW.setText("비밀번호가 일치하지않습니다.");
						regRePW.setStyle("-fx-text-fill:#ff847c");
			    		inputRePW.clear();
					}
				}
			}
		});
        
        inputName.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					boolean result = Pattern.matches(Reg.regName, inputName.getText());
					if(result) {
						regName.setText("");
					}else {
						regName.setText("한글 최소 한 자 이상 (숫자, 특수문자 비허용)\n 입력하세요");
						regName.setStyle("-fx-text-fill:#ff847c");
						inputName.clear();
					}
				}
			}
		});
        
        inputAddr1.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					boolean result = Pattern.matches(Reg.regName, inputAddr1.getText());
					if(result) {
						regAddr1.setText("");
					}else {
						regAddr1.setText("한글 최소 한 자 이상\n입력하세요");
						regAddr1.setStyle("-fx-text-fill:#ff847c");
						inputAddr1.clear();
					}
				}
			}
		});
        
        inputAddr2.focusedProperty().addListener(new ChangeListener<Boolean>() {
        	@Override
        	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        		if(newValue) {
        		}else {
        			boolean result = Pattern.matches(Reg.regName, inputAddr2.getText());
        			if(result) {
        				regAddr2.setText("");
        			}else {
        				regAddr2.setText("한글 최소 한 자 이상\n입력하세요");
        				regAddr2.setStyle("-fx-text-fill:#ff847c");
        				inputAddr2.clear();
        			}
        		}
        	}
        });
        
        inputMail.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					boolean result = Pattern.matches(Reg.regMail, inputMail.getText());
					if(result) {
						regMail.setText("");
					}else {
						regMail.setText("이메일 형식에 맞추어 입력해주세요");
						regMail.setStyle("-fx-text-fill:#ff847c");
						inputMail.clear();
					}
				}
			}
		});
        
        inputTel.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					boolean result = Pattern.matches(Reg.regTel, inputTel.getText());
					if(result) {
						regTel.setText("");
					}else {
						regTel.setText("핸드폰 번호를 정확히 입력해주세요\n'-'을 포함해서 입력하세요");
						regTel.setStyle("-fx-text-fill:#ff847c");
						inputTel.clear();
					}
				}
			}
		});
        
        inputRegNo1.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					boolean result = Pattern.matches(Reg.regRegNo1, inputRegNo1.getText());
					if(result) {
						regRegNo1.setText("");
					}else {
						regRegNo1.setText("주민번호를 정확히\n입력해주세요");
						regRegNo1.setStyle("-fx-text-fill:#ff847c");
						inputRegNo1.clear();
					}
				}
			}
		});
        
        inputRegNo2.focusedProperty().addListener(new ChangeListener<Boolean>() {
        	@Override
        	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        		if(newValue) {
        		}else {
        			boolean result = Pattern.matches(Reg.regRegNo2, inputRegNo2.getText());
        			if(result) {
        				regRegNo2.setText("");
        			}else {
        				regRegNo2.setText("주민번호를 정확히\n입력해주세요");
        				regRegNo2.setStyle("-fx-text-fill:#ff847c");
        				inputRegNo2.clear();
        			}
        		}
        	}
        });
        
    }//initialize
}
