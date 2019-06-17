package util;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MyImageViewEventHandler implements EventHandler<MouseEvent>{

	@Override
	public void handle(final MouseEvent event) {
		Object obj = event.getSource();
		
		ImageView imgView = (ImageView) obj;
		imgView.setCursor(Cursor.HAND);
	}

}
