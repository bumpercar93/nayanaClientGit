package nayana.controller.adminPage;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import nayana.member.service.IMemberService;

public class TotalStatsController {

	private IMemberService memberService;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<String, Number> genderGraph;

    @FXML
    private LineChart<?, ?> memTotalGraph;

    
    private void genderTotal() {
    	int men=0;
    	int women=0;
    	
    	try {
			men = memberService.genderCount("M");
			women = memberService.genderCount("W");
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
    	
    	XYChart.Series<String, Number> menc= new XYChart.Series<String,Number>();
    	menc.setName("남");
    	menc.getData().add(new XYChart.Data<>("남녀 통계",men));
    	
    	XYChart.Series<String, Number> womenc= new XYChart.Series<String,Number>();
    	womenc.setName("여");
    	womenc.getData().add(new XYChart.Data<>("남녀 통계",men));
    	
    	genderGraph.getData().addAll(menc,womenc);
    	
    	
    }
    
    private void memCount() {
    	
    	
    	
    	
    	
    	
    	
    }
    
    
    
    
    
    
    
    @FXML
    void initialize() {
        assert genderGraph != null : "fx:id=\"genderGraph\" was not injected: check your FXML file 'TotalStats.fxml'.";
        assert memTotalGraph != null : "fx:id=\"memTotalGraph\" was not injected: check your FXML file 'TotalStats.fxml'.";

        genderTotal();
        
        
    }
}
