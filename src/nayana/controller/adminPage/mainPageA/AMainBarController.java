package nayana.controller.adminPage.mainPageA;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class AMainBarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane topBorderpane;

    @FXML
    private ImageView maingogoTxt;

    @FXML
    private Label nameTxt;

    @FXML
    private ImageView logoutBtn;

    @FXML
    private MenuButton accountManageList;

    @FXML
    private MenuItem memberManageMenu;

    @FXML
    private MenuItem adminManageMenu;

    @FXML
    private MenuButton healthGiveList;

    @FXML
    private MenuItem foodCucheonMenu;

    @FXML
    private MenuItem sportsCucheonMenu;

    @FXML
    private MenuItem meTestMenu;

    @FXML
    private MenuButton communityList;

    @FXML
    private MenuItem HealthcareDataMenu;

    @FXML
    private MenuItem noticeMenu;

    @FXML
    void FoodCucheon(ActionEvent event) {

    }

    @FXML
    void HealthcareData(ActionEvent event) {

    }

    @FXML
    void Logout(MouseEvent event) {

    }

    @FXML
    void MainGOGO(MouseEvent event) {

    }

    @FXML
    void MyTest(ActionEvent event) {

    }

    @FXML
    void Notice(ActionEvent event) {

    }

    @FXML
    void SportsCucheon(ActionEvent event) {

    }

    @FXML
    void adminManage(ActionEvent event) {

    }

    @FXML
    void memberManage(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert topBorderpane != null : "fx:id=\"topBorderpane\" was not injected: check your FXML file 'AMainBar.fxml'.";
        assert maingogoTxt != null : "fx:id=\"maingogoTxt\" was not injected: check your FXML file 'AMainBar.fxml'.";
        assert nameTxt != null : "fx:id=\"nameTxt\" was not injected: check your FXML file 'AMainBar.fxml'.";
        assert logoutBtn != null : "fx:id=\"logoutBtn\" was not injected: check your FXML file 'AMainBar.fxml'.";
        assert accountManageList != null : "fx:id=\"accountManageList\" was not injected: check your FXML file 'AMainBar.fxml'.";
        assert memberManageMenu != null : "fx:id=\"memberManageMenu\" was not injected: check your FXML file 'AMainBar.fxml'.";
        assert adminManageMenu != null : "fx:id=\"adminManageMenu\" was not injected: check your FXML file 'AMainBar.fxml'.";
        assert healthGiveList != null : "fx:id=\"healthGiveList\" was not injected: check your FXML file 'AMainBar.fxml'.";
        assert foodCucheonMenu != null : "fx:id=\"foodCucheonMenu\" was not injected: check your FXML file 'AMainBar.fxml'.";
        assert sportsCucheonMenu != null : "fx:id=\"sportsCucheonMenu\" was not injected: check your FXML file 'AMainBar.fxml'.";
        assert meTestMenu != null : "fx:id=\"meTestMenu\" was not injected: check your FXML file 'AMainBar.fxml'.";
        assert communityList != null : "fx:id=\"communityList\" was not injected: check your FXML file 'AMainBar.fxml'.";
        assert HealthcareDataMenu != null : "fx:id=\"HealthcareDataMenu\" was not injected: check your FXML file 'AMainBar.fxml'.";
        assert noticeMenu != null : "fx:id=\"noticeMenu\" was not injected: check your FXML file 'AMainBar.fxml'.";

    }
}
