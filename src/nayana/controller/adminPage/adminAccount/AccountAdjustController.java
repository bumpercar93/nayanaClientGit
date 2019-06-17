package nayana.controller.adminPage.adminAccount;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import nayana.member.service.IMemberService;
import nayana.vo.MemberVO;
import util.MyButtonEventHandler;
import util.Reg;

public class AccountAdjustController  {
	private IMemberService memberService ;
	
	private Stage adjustStage ;
	
	
	public Stage getAdjustStage() {
		return adjustStage;
	}

	public void setAdjustStage(Stage adjustStage) {
		this.adjustStage = adjustStage;
	}

	public static MemberVO memVO;
	
	
    public static MemberVO getMemVO() {
		return memVO;
	}

	public static void setMemVO(MemberVO memVO) {
		AccountAdjustController.memVO = memVO;
	}

	private AccountMainController accountmaincontroller;
	
	
	
    public AccountMainController getAccountmaincontroller() {
		return accountmaincontroller;
	}

	public void setAccountmaincontroller(AccountMainController accountmaincontroller) {
		this.accountmaincontroller = accountmaincontroller;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button registBtn;

    @FXML
    private TextField passTxt;

    @FXML
    private TextField passTxtCh;

    @FXML
    private TextField telTxt;

    @FXML
    private TextField siTxt;

    @FXML
    private TextField guTxt;

    @FXML
    private Button cancelBtn;

    @FXML
    private Label regTel;

    @FXML
    private Label regPass;

    @FXML
    private Label regGu;

    @FXML
    private Label regPassCh;

    @FXML
    private Label regSi;

    @FXML
    private TextField mailTxt;

    @FXML
    private Label regMail;

    @FXML
    void cancel(ActionEvent event) {
    	adjustStage.close();
    	
    	
    }

    @FXML
    void regist(ActionEvent event) {

    	if(passTxt.getText().trim().length() < 1) {
    		regPass.setText("필수 입력사항 입니다");
    		regPass.setStyle("-fx-text-fill:#ff847c");
    		passTxt.requestFocus();
    		return;
    	}else if(passTxtCh.getText().trim().length() < 1) {
    		regPass.setText("필수 입력사항 입니다");
    		regPass.setStyle("-fx-text-fill:#ff847c");
    		passTxtCh.requestFocus();
    		return;
    	}else if(telTxt.getText().trim().length() < 1) {
    		regTel.setText("필수 입력사항 입니다");
    		regTel.setStyle("-fx-text-fill:#ff847c");
    		telTxt.requestFocus();
    		return;
    	}
    	
    	if(memVO.getMem_right().equals("U")) {
	    	if(siTxt.getText().trim().length() < 1) {
	    		regSi.setText("필수 입력사항 입니다");
	    		regSi.setStyle("-fx-text-fill:#ff847c");
	    		siTxt.requestFocus();
	    		return;
	    	}else if(guTxt.getText().trim().length() < 1) {
	    		regGu.setText("필수 입력사항 입니다");
	    		regGu.setStyle("-fx-text-fill:#ff847c");
	    		guTxt.requestFocus();
	    		return;
	    	}
    	}
    	
    	MemberVO memvo = new MemberVO();
    	memvo.setMem_id(memVO.getMem_id());
    	memvo.setMem_pw(passTxt.getText());
    	memvo.setMem_phone(telTxt.getText());
    	memvo.setMem_addr1(siTxt.getText());
    	memvo.setMem_addr2(guTxt.getText());
    	memvo.setMem_email(mailTxt.getText());
    	
    	int cnt = 0 ;
    	try {
			cnt = memberService.updateMember(memvo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	
    	if(cnt >0) {
    		Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
        	alertConfirm.setTitle("수정완료");
        	alertConfirm.setHeaderText("수정이 완료되었습니다");
        	alertConfirm.showAndWait();
        	adjustStage.close();
    	}else {
    		Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
        	alertConfirm.setTitle("수정실패");
        	alertConfirm.setHeaderText("수정에 실패했습니다");
        	alertConfirm.showAndWait();
    	}
    	
    	accountmaincontroller.settingList();
    	
    	
    	
    }

    @FXML
    void initialize() {
	   assert registBtn != null : "fx:id=\"registBtn\" was not injected: check your FXML file 'AccountAdjust.fxml'.";
       assert passTxt != null : "fx:id=\"passTxt\" was not injected: check your FXML file 'AccountAdjust.fxml'.";
       assert passTxtCh != null : "fx:id=\"passTxtCh\" was not injected: check your FXML file 'AccountAdjust.fxml'.";
       assert telTxt != null : "fx:id=\"telTxt\" was not injected: check your FXML file 'AccountAdjust.fxml'.";
       assert siTxt != null : "fx:id=\"siTxt\" was not injected: check your FXML file 'AccountAdjust.fxml'.";
       assert guTxt != null : "fx:id=\"guTxt\" was not injected: check your FXML file 'AccountAdjust.fxml'.";
       assert cancelBtn != null : "fx:id=\"cancelBtn\" was not injected: check your FXML file 'AccountAdjust.fxml'.";
       assert regTel != null : "fx:id=\"regTel\" was not injected: check your FXML file 'AccountAdjust.fxml'.";
       assert regPass != null : "fx:id=\"regPass\" was not injected: check your FXML file 'AccountAdjust.fxml'.";
       assert regGu != null : "fx:id=\"regGu\" was not injected: check your FXML file 'AccountAdjust.fxml'.";
       assert regPassCh != null : "fx:id=\"regPassCh\" was not injected: check your FXML file 'AccountAdjust.fxml'.";
       assert regSi != null : "fx:id=\"regSi\" was not injected: check your FXML file 'AccountAdjust.fxml'.";
       assert mailTxt != null : "fx:id=\"mailTxt\" was not injected: check your FXML file 'AccountAdjust.fxml'.";
       assert regMail != null : "fx:id=\"regMail\" was not injected: check your FXML file 'AccountAdjust.fxml'.";
       
       try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			memberService = (IMemberService) reg.lookup("memberService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
       
       registBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
       cancelBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
       
        
        if(memVO.getMem_right().equals("U")) {
	        telTxt.setText(memVO.getMem_phone());
	        siTxt.setText(memVO.getMem_addr1());
	        guTxt.setText(memVO.getMem_addr2());
	        mailTxt.setText(memVO.getMem_email());
	        
	        siTxt.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if(newValue) {
					}else {
						boolean result = Pattern.matches(Reg.regName, siTxt.getText());
						if(result) {
							regSi.setText("");
						}else {
							regSi.setText("한글 최소 한 자 이상\n입력하세요");
							regSi.setStyle("-fx-text-fill:#ff847c");
							siTxt.clear();
						}
					}
				}
			});
	        
	        guTxt.focusedProperty().addListener(new ChangeListener<Boolean>() {
	        	@Override
	        	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
	        		if(newValue) {
	        		}else {
	        			boolean result = Pattern.matches(Reg.regName, guTxt.getText());
	        			if(result) {
	        				regGu.setText("");
	        			}else {
	        				regGu.setText("한글 최소 한 자 이상\n입력하세요");
	        				regGu.setStyle("-fx-text-fill:#ff847c");
	        				guTxt.clear();
	        			}
	        		}
	        	}
	        });
        }else if(memVO.getMem_right().equals("A")) {
        	siTxt.setDisable(true);
        	guTxt.setDisable(true);
        	telTxt.setText(memVO.getMem_phone());
        	mailTxt.setText(memVO.getMem_email());
        }
        
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
        
        
        
        mailTxt.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue) {
				}else {
					boolean result = Pattern.matches(Reg.regMail, mailTxt.getText());
					if(result) {
						regMail.setText("");
					}else {
						regMail.setText("이메일 형식에 맞추어 입력해주세요");
						regMail.setStyle("-fx-text-fill:#ff847c");
						mailTxt.clear();
					}
				}
			}
		});
        
        
    }
}
