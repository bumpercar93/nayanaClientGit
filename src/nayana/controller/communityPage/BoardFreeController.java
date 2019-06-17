package nayana.controller.communityPage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BoardFreeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pagination pagination;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> num;

    @FXML
    private TableColumn<?, ?> title;

    @FXML
    private TableColumn<?, ?> writer;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private TableColumn<?, ?> cnt;

    @FXML
    private TextField searchField;

    @FXML
    private ComboBox<?> searchList;

    @FXML
    private Button searchBtn;

    @FXML
    void Search(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert pagination != null : "fx:id=\"pagination\" was not injected: check your FXML file 'BoardFree.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'BoardFree.fxml'.";
        assert num != null : "fx:id=\"num\" was not injected: check your FXML file 'BoardFree.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'BoardFree.fxml'.";
        assert writer != null : "fx:id=\"writer\" was not injected: check your FXML file 'BoardFree.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'BoardFree.fxml'.";
        assert cnt != null : "fx:id=\"cnt\" was not injected: check your FXML file 'BoardFree.fxml'.";
        assert searchField != null : "fx:id=\"searchField\" was not injected: check your FXML file 'BoardFree.fxml'.";
        assert searchList != null : "fx:id=\"searchList\" was not injected: check your FXML file 'BoardFree.fxml'.";
        assert searchBtn != null : "fx:id=\"searchBtn\" was not injected: check your FXML file 'BoardFree.fxml'.";

    }
}

