package nayana.controller.healthInfoPage;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

class MyFrame extends JFrame{
	MyFrame(){
		initUI();
	}
	
	public final void initUI(){
		JButton btn = new JButton("Click");
		btn.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				JButton btn = (JButton) e.getSource();
				if(btn.getText().equals("Click"))
					btn.setText("Hello");
				else 
					btn.setText("Click");
			}
		});
		add(btn); //컨테이너에 배치
		pack();
		setResizable(false); //사이즈 변경 불가능
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우의 x를 누르면 종료
		setVisible(true); //보이게 할지 여부
	}
}

public class test {
	public static void main(String[] args){
		new MyFrame();
	}
}