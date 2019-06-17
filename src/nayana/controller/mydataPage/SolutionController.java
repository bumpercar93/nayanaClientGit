package nayana.controller.mydataPage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import nayana.vo.MemberVO;

public class SolutionController {
	
	private static MemberVO memVO;
	
    public static MemberVO getMemVO() {
		return memVO;
	}

	public static void setMemVO(MemberVO memVO) {
		SolutionController.memVO = memVO;
	}
	
    @FXML
    private Label MustLabel;

    @FXML
    private Label MustLabelRes;

    @FXML
    private Label GoodFood;

    @FXML
    private Label GoodFoodRes;
	
	@FXML
    private Label pieLabelFisrt;

    @FXML
    private Label pieChartLabel2;

    @FXML
    private Label barChartFirst;

    @FXML
    private Label barChartLabel2;
    
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart pieChart;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private Label pieChartLabel;

    @FXML
    private Label barChartLabel;

    @FXML
    void initialize() {
        assert pieChart != null : "fx:id=\"pieChart\" was not injected: check your FXML file 'Solution.fxml'.";
        assert barChart != null : "fx:id=\"barChart\" was not injected: check your FXML file 'Solution.fxml'.";
        assert pieChartLabel != null : "fx:id=\"pieChartLabel\" was not injected: check your FXML file 'Solution.fxml'.";
        assert barChartLabel != null : "fx:id=\"barChartLabel\" was not injected: check your FXML file 'Solution.fxml'.";
        assert pieLabelFisrt != null : "fx:id=\"pieLabelFisrt\" was not injected: check your FXML file 'Solution.fxml'.";
        assert pieChartLabel2 != null : "fx:id=\"pieChartLabel2\" was not injected: check your FXML file 'Solution.fxml'.";
        assert barChartFirst != null : "fx:id=\"barChartFirst\" was not injected: check your FXML file 'Solution.fxml'.";
        assert barChartLabel2 != null : "fx:id=\"barChartLabel2\" was not injected: check your FXML file 'Solution.fxml'.";
        assert MustLabel != null : "fx:id=\"MustLabel\" was not injected: check your FXML file 'Solution.fxml'.";
        assert MustLabelRes != null : "fx:id=\"MustLabelRes\" was not injected: check your FXML file 'Solution.fxml'.";
        assert GoodFood != null : "fx:id=\"GoodFood\" was not injected: check your FXML file 'Solution.fxml'.";
        assert GoodFoodRes != null : "fx:id=\"GoodFoodRes\" was not injected: check your FXML file 'Solution.fxml'.";
        
        String memAge = "19";
        String memRegNo = memVO.getMem_regno1().substring(0, 2);
        memAge += memRegNo;
        int sysDate = 2019;
        int age = sysDate - Integer.parseInt(memAge);
        
        String first = "";
        String secend = "";
        String third = "";
        
        String mustEat = "";
        String goodFood = "";
        String old = "";
        
        switch (age/10) {
		case 0:
			first = "운수사고";
			secend = "암";
			third = "선천기형";
			old = "0";
			break;
		case 1:
			first = "자살";
			secend = "운수사고";
			third = "암";
			goodFood = "달걀, 요거트";
			mustEat = "칼슘";
			old = "10대";
			break;
		case 2:
			first = "자살";
			secend = "운수사고";
			third = "암";
			goodFood = "달걀, 요거트";
			mustEat = "칼슘";
			old = "20대";
			break;
		case 3:
			first = "자살";
			secend = "암";
			third = "운수사고";
			goodFood = "시금치, 아스파라거스";
			mustEat = "철분, 엽산";
			old = "30대";
			break;
		case 4:
			first = "암";
			secend = "자살";
			third = "간질환";
			goodFood = "호두, 콩";
			mustEat = "칼륨, 섬유소";
			old = "40대";
			break;
		case 5:
			first = "암";
			secend = "자살";
			third = "간질환";
			goodFood = "연어, 고구마";
			mustEat = "비타민, 오메가3 지방산";
			old = "50대";
			break;
		case 6:
			first = "암";
			secend = "뇌혈관질환";
			third = "심장질환";
			goodFood = "연어, 고구마";
			mustEat = "비타민, 오메가3 지방산";
			old = "60대";
			break;
		default:
			first = "암";
			secend = "뇌혈관질환";
			third = "심장질환";
			goodFood = "연어, 고구마";
			mustEat = "비타민, 오메가3 지방산";
			old = "60대 이상";
			break;
		}
        
        MustLabel.setText(old + "의 필수 섭취 영양소는");
        MustLabelRes.setText(mustEat);
        GoodFood.setText(old + "의 건강에 좋은 음식은");
        GoodFoodRes.setText(goodFood);
        
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
        		new PieChart.Data(first, 3),
        		new PieChart.Data(secend, 2),
        		new PieChart.Data(third, 1)
        		);
        
        pieChart.setData(pieData);
        pieChart.setLegendSide(Side.TOP);
        pieChartLabel.setText(memVO.getMem_name() + "님 연령대의 가장 높은 사망원인은");
        pieLabelFisrt.setText(first);
        
        String die1 = "";
        String die2 = "";
        String die3 = "";
        String die4 = "";
        String die5 = "";
        String die6 = "";
        String die7 = "";
        String die8 = "";
        String die9 = "";
        String die10 = "";
        String gender = "";
        if(memVO.getMem_gen().equals("M")) {
        	gender = "남성";
        	die1 = "암";
        	die2 = "심장질환";
        	die3 = "뇌혈관질환";
        	die4 = "자살";
        	die5 = "폐렴";
        	die6 = "당뇨병";
        	die7 = "간질환";
        	die8 = "만성하기도질환";
        	die9 = "운수사고";
        	die10 = "추락";
        }else {
        	gender = "여성";
        	die1 = "암";
        	die2 = "심장질환";
        	die3 = "뇌혈관질환";
        	die4 = "폐렴";
        	die5 = "당뇨병";
        	die6 = "자살";
        	die7 = "알츠하이머병";
        	die8 = "고혈압성질환";
        	die9 = "만성하기도질환";
        	die10 = "패혈증";
        }
        
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<String, Number>(die1, 187));
        series1.getData().add(new XYChart.Data<String, Number>(die2, 55));
        series1.getData().add(new XYChart.Data<String, Number>(die3, 46));
        series1.getData().add(new XYChart.Data<String, Number>(die4, 37));
        series1.getData().add(new XYChart.Data<String, Number>(die5, 23));
        series1.getData().add(new XYChart.Data<String, Number>(die6, 21));
        series1.getData().add(new XYChart.Data<String, Number>(die7, 20));
        series1.getData().add(new XYChart.Data<String, Number>(die8, 18));
        series1.getData().add(new XYChart.Data<String, Number>(die9, 15));
        series1.getData().add(new XYChart.Data<String, Number>(die10, 6));
        
        barChart.getData().add(series1);
        barChart.setBarGap(3);
        barChart.setLegendVisible(false);
        
        barChartLabel.setText(gender + "의 가장 높은 사망원인은");
        barChartFirst.setText(die1);
        
    }
}
