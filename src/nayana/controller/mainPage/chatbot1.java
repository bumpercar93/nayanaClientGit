package nayana.controller.mainPage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class chatbot1 extends JFrame{
   
	static JFrame f;

   // Typring Area :
   private JTextField txtEnter = new JTextField();
   
   // Chat Area :
   private JTextArea txtChat = new JTextArea();
   
   public chatbot1() {
      // Frame Attributes :
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(600, 600);
      this.setVisible(true);
      this.setResizable(false);
      this.setLayout(null);
      this.setTitle("3조 챗봇 테스트");
      
      // txtEnter Attributes
      txtEnter.setLocation(2, 540);
      txtEnter.setSize(590, 30);
      
      // txtEnter Action Event :
      txtEnter.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String uText = txtEnter.getText();
            txtChat.append("You: " + uText + "\n");
            
            if(uText.contains("공지사항")) {
               botSay("Hello there!");
            
            }else if(uText.contains("how are you")) {
              
               int decider =  (int) (Math.random()*2+1);
               if(decider==1) {
                  botSay("I'm doing well, thanks");
               }
               else if(decider ==2){
                  botSay("Not too bad");
               }
            }else{
               int decider =  (int) (Math.random()*3+1);
               if(decider==1) {
                  botSay("I didn't get that");
               }else if(decider ==2){
                  botSay("Please rephase that");
               }else if(decider ==3) {
                  botSay("???");
               }
            }
            
            txtEnter.setText("");
         }
      });
      
      // txtChat Attributes :
      txtChat.setLocation(15, 5);
      txtChat.setSize(560, 510);
      txtChat.setEditable(false);
      
      // Add Items To Frame :
      this.add(txtEnter);
      this.add(txtChat);
   }
   
   public void botSay(String s){
      txtChat.append("AI: " + s + "\n");
   }
   
   public static void main(String[] args) {
      new chatbot1();
   }
   
}