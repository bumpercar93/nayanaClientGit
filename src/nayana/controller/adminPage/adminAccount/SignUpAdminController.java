package nayana.controller.adminPage.adminAccount;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nayana.controller.loginPage.SignUpCompleteController;
import nayana.member.service.IMemberService;
import nayana.vo.MemberVO;
import util.AlertUtil;
import util.MyButtonEventHandler;
import util.Reg;

public class SignUpAdminController {

	private IMemberService memberService;
	
	private Stage signUpStage;
	
	 public Stage getSignUpStage() {
			return signUpStage;
		}

	public void setSignUpStage(Stage signUpStage) {
		this.signUpStage = signUpStage;
	}

	private AccountMainController accountmaincontroller;
	
	
	
    public AccountMainController getAccountmaincontroller() {
		return accountmaincontroller;
	}

	public void setAccountmaincontroller(AccountMainController accountmaincontroller) {
		this.accountmaincontroller = accountmaincontroller;
	}

	@FXML
    private Button idChBtn;

    @FXML
    private TextField idTxt;

    @FXML
    private TextField passTxt;

    @FXML
    private TextField passTxtCh;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private Button cancelBtn;

    @FXML
    private Label regPassCh;

    @FXML
    private Label regID;

    @FXML
    private Label regEmail;

    @FXML
    private Label regPass;

    @FXML
    private Label regName;

    @FXML
    private Button registBtn;

    @FXML
    private TextField telTxt;

    @FXML
    private Label regTel;


    @FXML
    void cancel(ActionEvent event) {
    	signUpStage.close();
    }

    @FXML
    void idCheck(ActionEvent event) {

    	String result = "";
    	try {
    		result = memberService.idCheck(idTxt.getText());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	if(result == null) {
    		regID.setText("사용가능한 ID입니다");
    		regID.setStyle("-fx-text-fill:#4ab834");
    		idChBtn.setDisable(false);
    	}else {
    		regID.setText("중복된 ID입니다");
    		regID.setStyle("-fx-text-fill:#ff847c");
    		idTxt.clear();
    	}
    }

    @FXML
    void regist(ActionEvent event) {

    	if(idTxt.getText().trim().length() < 1) {
    		regID.setText("필수 입력사항 입니다");
    		regID.setStyle("-fx-text-fill:#ff847c");
    		idTxt.requestFocus();
    		return;
    	}else if(passTxt.getText().trim().length() < 1) {
    		regPass.setText("필수 입력사항 입니다");
    		regPass.setStyle("-fx-text-fill:#ff847c");
    		passTxt.requestFocus();
    		return;
    	}else if(passTxtCh.getText().trim().length() < 1) {
    		regPassCh.setText("필수 입력사항 입니다");
    		regPassCh.setStyle("-fx-text-fill:#ff847c");
    		passTxtCh.requestFocus();
    		return;
    	}else if(nameTxt.getText().trim().length() < 1) {
    		regName.setText("필수 입력사항 입니다");
    		regName.setStyle("-fx-text-fill:#ff847c");
    		nameTxt.requestFocus();
    		return;
    	}else if(emailTxt.getText().trim().length() < 1) {
    		regEmail.setText("필수 입력사항 입니다");
    		regEmail.setStyle("-fx-text-fill:#ff847c");
    		emailTxt.requestFocus();
    		return;
    	}else if(telTxt.getText().trim().length() < 1) {
    		regTel.setText("필수 입력사항 입니다");
    		regTel.setStyle("-fx-text-fill:#ff847c");
    		telTxt.requestFocus();
    		return;
    	}
    	
    	String name = nameTxt.getText();
    	
    	MemberVO memvo = new MemberVO();
    	memvo.setMem_id(idTxt.getText());
    	memvo.setMem_pw(passTxt.getText());
    	memvo.setMem_name(nameTxt.getText());
    	memvo.setMem_gen("0");
    	memvo.setMem_regno1("0");
    	memvo.setMem_regno2("0");
    	memvo.setMem_phone(telTxt.getText());
    	memvo.setMem_email(emailTxt.getText());
    	memvo.setMem_addr1("0");
    	memvo.setMem_addr2("0");
    	memvo.setMem_status("N");
    	memvo.setMem_right("A");

    	int cnt = 0;
    	try {
			cnt = memberService.signUp(memvo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
		if(cnt>0) {
	    	alertConfirm.setTitle("계정등록완료");
	    	alertConfirm.setHeaderText("계정등록에 성공하였습니다");
	    	alertConfirm.showAndWait();
			signUpStage.close();
		}else {
			AlertUtil.error("계정등록 실패", "x", "x");
			alertConfirm.showAndWait();
		}
			
		accountmaincontroller.settingList();
    	
    }

    @FXML
    void initialize() {
    	 assert idChBtn != null : "fx:id=\"idChBtn\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
         assert idTxt != null : "fx:id=\"idTxt\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
         assert passTxt != null : "fx:id=\"passTxt\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
         assert passTxtCh != null : "fx:id=\"passTxtCh\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
         assert nameTxt != null : "fx:id=\"nameTxt\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
         assert emailTxt != null : "fx:id=\"emailTxt\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
         assert cancelBtn != null : "fx:id=\"cancelBtn\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
         assert regPassCh != null : "fx:id=\"regPassCh\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
         assert regID != null : "fx:id=\"regID\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
         assert regEmail != null : "fx:id=\"regEmail\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
         assert regPass != null : "fx:id=\"regPass\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
         assert regName != null : "fx:id=\"regName\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
         assert registBtn != null : "fx:id=\"registBtn\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
         assert telTxt != null : "fx:id=\"telTxt\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
         assert regTel != null : "fx:id=\"regTel\" was not injected: check your FXML file 'SignUpAdmin.fxml'.";
    	
        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			memberService = (IMemberService) reg.lookup("memberService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
        
        idChBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        cancelBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        registBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        
        
        idTxt.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					boolean result = Pattern.matches(Reg.regID, idTxt.getText());
					if(result) {
						regID.setText("");
					}else {
						regID.setText("시작은 영문,'_'를 제외한 특수문자 안되며 영문,\n숫자,'_'으로만 이루어진 5 ~ 12자 이하로 입력하세요");
						regID.setStyle("-fx-text-fill:#ff847c");
			    		idTxt.clear();
					}
				}
			}
        });
        
        passTxt.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					boolean result = Pattern.matches(Reg.regPW, passTxt.getText());
					if(result) {
						regPass.setText("");
					}else {
						regPass.setText("최소 8자리에 숫자, 문자, 특수문자 각각\n1개 이상 포함하여 입력하세요");
						regPass.setStyle("-fx-text-fill:#ff847c");
			    		passTxt.clear();
					}
				}
			}
		});
        
        passTxtCh.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					if(passTxt.getText().equals(passTxtCh.getText())) {
						regPassCh.setText("");
					}else {
						regPassCh.setText("비밀번호가 일치하지않습니다.");
						regPassCh.setStyle("-fx-text-fill:#ff847c");
						passTxtCh.clear();
					}
				}
			}
		});
        
        nameTxt.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					boolean result = Pattern.matches(Reg.regName, nameTxt.getText());
					if(result) {
						regName.setText("");
					}else {
						regName.setText("한글 최소 한 자 이상 (숫자, 특수문자 비허용)\n 입력하세요");
						regName.setStyle("-fx-text-fill:#ff847c");
						nameTxt.clear();
					}
				}
			}
		});
        
        emailTxt.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					boolean result = Pattern.matches(Reg.regMail, emailTxt.getText());
					if(result) {
						regEmail.setText("");
					}else {
						regEmail.setText("이메일 형식에 맞추어 입력해주세요");
						regEmail.setStyle("-fx-text-fill:#ff847c");
						emailTxt.clear();
					}
				}
			}
		});
        
        telTxt.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					boolean result = Pattern.matches(Reg.regTel, telTxt.getText());
					if(result) {
						regTel.setText("");
					}else {
						regTel.setText("핸드폰 번호를 정확히 입력해주세요\n'-'을 포함해서 입력하세요");
						regTel.setStyle("-fx-text-fill:#ff847c");
						telTxt.clear();
					}
				}
			}
		});
        
        
        
    }
        
    
}
