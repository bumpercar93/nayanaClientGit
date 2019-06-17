package nayana.controller.adminPage.mainPageA;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import nayana.member.service.IMemberService;

public class AMainCenterController {

	private IMemberService memberService;
	
	
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane borderpane;

    @FXML
    private AnchorPane centerPage;

    @FXML
    private BarChart<?, ?> siGraph;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private LineChart<?, ?> ageGraph;

    @FXML
    private PieChart genderGraph;

    @FXML
    void initialize() {
        assert borderpane != null : "fx:id=\"borderpane\" was not injected: check your FXML file 'AMainCenter.fxml'.";
        assert centerPage != null : "fx:id=\"centerPage\" was not injected: check your FXML file 'AMainCenter.fxml'.";
        assert siGraph != null : "fx:id=\"siGraph\" was not injected: check your FXML file 'AMainCenter.fxml'.";
        assert xAxis != null : "fx:id=\"xAxis\" was not injected: check your FXML file 'AMainCenter.fxml'.";
        assert yAxis != null : "fx:id=\"yAxis\" was not injected: check your FXML file 'AMainCenter.fxml'.";
        assert ageGraph != null : "fx:id=\"ageGraph\" was not injected: check your FXML file 'AMainCenter.fxml'.";
        assert genderGraph != null : "fx:id=\"genderGraph\" was not injected: check your FXML file 'AMainCenter.fxml'.";

    }
}
