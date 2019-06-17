package nayana.controller.mainPage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ChatBotController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtField;

    @FXML
    private Button submitBtn;
    
    @FXML
    void sendChat(KeyEvent event) {

    }
    
    @FXML
    void submitBtnClicked(ActionEvent event) {
    	
		String uText = txtField.getText();
			txtArea.appendText("YOU : " + uText + "\n");
		
		String utext = txtField.getText();
		
		//
//		switch (uText) {
//		
//		case 1:
//
//			break;
//
//		case 2:
//
//			break;
//
//		default:
//			System.out.println("");
//		}	
		//
		
		if(uText.contains("공지")) {
		    		
			txtArea.appendText("현재 공지 사항은 3조 화이팅 입니다");
		    		
		}else if(uText.contains("날씨") || uText.contains("비")) {
		            
			txtArea.appendText("Bot :걷기 좋은 날씨야");
		            
		}else if(uText.contains("식단")){
		        	
			txtArea.appendText("Bot :오늘 ~님의 식단은 ~입니다");
			         	
		}else if(uText.contains("운동")) {
		        	 
			txtArea.appendText("오늘 ~님의 추천 운동은 ~입니다");
		            
		}else if(uText.contains("자가진단")) {
			
			txtArea.appendText("오늘 ~님의 추천 운동은 ~입니다");
		}else if(uText.contains("병원 위치 조회")) {
			
		}else if(uText.contains("헬스케어 콘텐츠")) {
			
		}else if(uText.contains("공지")) {
			
		}
	    	
	    	txtField.setText("");
	    	txtArea.appendText("\n\n");
	    	txtField.requestFocus();
    	
    } // submitBtnClicked 끝

    @FXML
    void txtFieldClicked(ActionEvent event) {

    }
    
    @FXML
    void initialize() {
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'chatbot.fxml'.";
        assert txtField != null : "fx:id=\"txtField\" was not injected: check your FXML file 'chatbot.fxml'.";
        assert submitBtn != null : "fx:id=\"submitBtn\" was not injected: check your FXML file 'chatbot.fxml'.";
        
        txtArea.appendText("채팅으로 요청 하셨습니다.\n");
        txtArea.appendText("아래에 문의할 텍스트를 입력해주세요.\n\n");
        txtArea.setFocusTraversable(false);
        txtField.requestFocus();
        
        submitBtn.setDefaultButton(true);
        
//        txtField.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent event) {
//				if(event.getCode() == KeyCode.ENTER) {
//					String text = txtField.getText();
//					
//					txtArea.appendText(text + "\n");
//					
//					txtField.clear();
//				}
//			
//			}
//			
//		});
        
//        @FXML
//        private TextArea chatbotTxtArea;
//
//        @FXML
//        private TextField chatbotTxtField;
//
//        @FXML
//        private Button chatbotBtn;
        
    }
}

