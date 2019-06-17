package util;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;

public class MyMenuButtonEventHandler implements EventHandler<MouseEvent>{

	@Override
	public void handle(MouseEvent event) {
		Object obj = event.getSource();
		
		MenuButton mb = (MenuButton) obj;
		mb.setCursor(Cursor.HAND);
	}

}
