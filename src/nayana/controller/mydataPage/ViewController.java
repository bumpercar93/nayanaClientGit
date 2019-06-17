package nayana.controller.mydataPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import util.MyImageViewEventHandler;

public class ViewController {
	private static String regNo;
	private static String fileName;

    public static String getRegNo() {
		return regNo;
	}

	public static void setRegNo(String regNo) {
		ViewController.regNo = regNo;
	}

	public static String getFileName() {
		return fileName;
	}

	public static void setFileName(String fileName) {
		ViewController.fileName = fileName;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imgView;
    
    private Image img;
    @FXML
    void initialize() throws MalformedURLException {
        assert imgView != null : "fx:id=\"imgView\" was not injected: check your FXML file 'View.fxml'.";
        img = new Image("file:///D:/MDMS/"+ regNo + "/" + regNo + "_" + fileName);
        imgView.setImage(img);
    }
}
