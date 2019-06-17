package util;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.ButtonBase;
import javafx.scene.input.MouseEvent;

public class MyButtonEventHandler implements EventHandler<MouseEvent> {

	@Override
	public void handle(final MouseEvent ME) {
		Object obj = ME.getSource();
		
		ButtonBase button = (ButtonBase) obj;
		button.setCursor(Cursor.HAND);
	}

}
