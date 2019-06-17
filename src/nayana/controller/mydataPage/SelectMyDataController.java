package nayana.controller.mydataPage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import nayana.Inbody.service.IInbodyService;
import nayana.MedicalCertficate.service.IMedicalCertficateService;
import nayana.MedicalReport.service.IMedicalReportService;
import nayana.Prescription.service.IPrescriptionService;
import nayana.SurgicalConfirmation.service.ISurgicalConfirmationService;
import nayana.docDown.service.IDocDownService;
import nayana.vo.DocDownVO;
import nayana.vo.MemberVO;
import util.AlertUtil;
import util.MyButtonEventHandler;
import util.MyFTP;
import util.MyPOI;

public class SelectMyDataController {
	
	private static MemberVO memVO;

    public static MemberVO getMemVO() {
		return memVO;
	}

	public static void setMemVO(MemberVO memVO) {
		SelectMyDataController.memVO = memVO;
	}
	
	private List<String> headerList;
	private List<String> rowList;
	private IMedicalCertficateService mcService;
	private IInbodyService inbodyService;
	private IMedicalReportService mrService;
	private IPrescriptionService PreService;
	private ISurgicalConfirmationService scService;
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox name;

    @FXML
    private CheckBox tel;

    @FXML
    private CheckBox gender;

    @FXML
    private CheckBox regNo;

    @FXML
    private CheckBox age;

    @FXML
    private CheckBox addr;

    @FXML
    private CheckBox inbodyScore;

    @FXML
    private CheckBox mbRate;

    @FXML
    private CheckBox height;

    @FXML
    private CheckBox weight;

    @FXML
    private CheckBox bmi;

    @FXML
    private CheckBox muscle;

    @FXML
    private CheckBox fat;

    @FXML
    private CheckBox fatRate;

    @FXML
    private CheckBox abdRate;

    @FXML
    private CheckBox dssName;

    @FXML
    private CheckBox afterOpinion;

    @FXML
    private CheckBox dssDate;

    @FXML
    private CheckBox opName;

    @FXML
    private CheckBox opPart;

    @FXML
    private CheckBox opHZDate;

    @FXML
    private CheckBox opCon;

    @FXML
    private CheckBox opDate;

    @FXML
    private CheckBox opDrName;

    @FXML
    private CheckBox medicine;

    @FXML
    private CheckBox dosesMedi;

    @FXML
    private CheckBox dosesNum;

    @FXML
    private CheckBox dosesDay;

    @FXML
    private CheckBox usage;

    @FXML
    private Button downloadBtn;

    @FXML
    private Label downloadDate;

    @FXML
    void clickDownloadBtn(ActionEvent event) {
    	headerList.clear();
    	rowList.clear();
    	
    	if(name.isSelected()) {
    		String header = name.getText();
    		String row = null;
			try {
				row = mcService.getName(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(tel.isSelected()) {
    		String header = tel.getText();
    		String row = null;
			try {
				row = mcService.getTel(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(gender.isSelected()) {
    		String header = gender.getText();
    		String row = null;
			try {
				row = mcService.getGender(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(age.isSelected()) {
    		String header = age.getText();
    		String row = null;
			try {
				row = mcService.getAge(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(addr.isSelected()) {
    		String header = addr.getText();
    		String row = null;
			try {
				row = mcService.getAddr(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(regNo.isSelected()) {
    		String header = regNo.getText();
    		String row = null;
			try {
				row = mrService.getRegNo(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(dssName.isSelected()) {
    		String header = dssName.getText();
    		String row = null;
			try {
				row = mcService.getDssName(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(afterOpinion.isSelected()) {
    		String header = afterOpinion.getText();
    		String row = null;
			try {
				row = mcService.getAfterOpinion(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(dssDate.isSelected()) {
    		String header = dssDate.getText();
    		String row = null;
			try {
				row = mcService.getOnsetDate(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(height.isSelected()) {
    		String header = height.getText();
    		String row = null;
			try {
				row = inbodyService.getHeight(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(weight.isSelected()) {
    		String header = weight.getText();
    		String row = null;
			try {
				row = inbodyService.getWeight(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}else if(muscle.isSelected()) {
    		String header = muscle.getText();
    		String row = null;
			try {
				row = inbodyService.getMuscle(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(fat.isSelected()) {
    		String header = fat.getText();
    		String row = null;
			try {
				row = inbodyService.getFat(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(bmi.isSelected()) {
    		String header = bmi.getText();
    		String row = null;
			try {
				row = inbodyService.getBmi(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(fatRate.isSelected()) {
    		String header = fatRate.getText();
    		String row = null;
			try {
				row = inbodyService.getFatRate(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(abdRate.isSelected()) {
       		String header = abdRate.getText();
    		String row = null;
			try {
				row = inbodyService.getAbdRate(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(inbodyScore.isSelected()) {
       		String header = inbodyScore.getText();
    		String row = null;
			try {
				row = inbodyService.getScore(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(mbRate.isSelected()) {
       		String header = mbRate.getText();
    		String row = null;
			try {
				row = inbodyService.getMbRate(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(medicine.isSelected()) {
      		String header = medicine.getText();
    		String row = null;
			try {
				row = PreService.getMedicine(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(dosesMedi.isSelected()) {
      		String header = dosesMedi.getText();
    		String row = null;
			try {
				row = PreService.getDosesMedi(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(dosesNum.isSelected()) {
      		String header = dosesNum.getText();
    		String row = null;
			try {
				row = PreService.getDosesNum(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(dosesDay.isSelected()) {
    		String header = dosesDay.getText();
    		String row = null;
			try {
				row = PreService.getAllDosesDay(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(usage.isSelected()) {
    		String header = usage.getText();
    		String row = null;
			try {
				row = PreService.getUsage(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(opName.isSelected()) {
    		String header = opName.getText();
    		String row = null;
			try {
				row = scService.getDgsName(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(opCon.isSelected()) {
    		String header = opCon.getText();
    		String row = null;
			try {
				row = scService.getDgsCon(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(opPart.isSelected()) {
    		String header = opPart.getText();
    		String row = null;
			try {
				row = scService.getHzPart(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(opHZDate.isSelected()) {
    		String header = opHZDate.getText();
    		String row = null;
			try {
				row = scService.getHzDate(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(opDrName.isSelected()) {
    		String header = opDrName.getText();
    		String row = null;
			try {
				row = scService.getDrName(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	if(opDate.isSelected()) {
    		String header = opDate.getText();
    		String row = null;
			try {
				row = scService.getOpDate(memVO.getMem_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		headerList.add(header);
    		rowList.add(row);
    	}
    	
    	MyPOI mp = new MyPOI();
    	mp.xlsxWiter(headerList, rowList);
    	
    	Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", memVO.getMem_id());
		map.put("down_item_con", "myData");
		try {
			String res = docDownService.selectDocDown(map);
			if(res == null) {
				DocDownVO ddVO = new DocDownVO();
				ddVO.setMem_id(memVO.getMem_id());
				ddVO.setDown_item_con("myData");
				docDownService.insertDocDown(ddVO);
			}else {
				docDownService.updateDocDown(map);
			}
			String docDay = docDownService.selectDocDown(map);
			downloadDate.setText(docDay);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	AlertUtil.information("성공", "다운로드 성공", memVO.getMem_name() + "님의 MyData 파일이 성공적으로 다운로드 되었습니다"
    			+ "\n\n다운로드 경로 : C:\\NAYANA");
    }
    
    IDocDownService docDownService;
    
    @FXML
    void initialize() {
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert tel != null : "fx:id=\"tel\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert gender != null : "fx:id=\"gender\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert regNo != null : "fx:id=\"regNo\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert age != null : "fx:id=\"age\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert addr != null : "fx:id=\"addr\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert inbodyScore != null : "fx:id=\"inbodyScore\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert mbRate != null : "fx:id=\"mbRate\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert height != null : "fx:id=\"height\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert weight != null : "fx:id=\"weight\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert bmi != null : "fx:id=\"bmi\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert muscle != null : "fx:id=\"muscle\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert fat != null : "fx:id=\"fat\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert fatRate != null : "fx:id=\"fatRate\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert abdRate != null : "fx:id=\"abdRate\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert dssName != null : "fx:id=\"dssName\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert afterOpinion != null : "fx:id=\"afterOpinion\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert dssDate != null : "fx:id=\"dssDate\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert opName != null : "fx:id=\"opName\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert opPart != null : "fx:id=\"opPart\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert opHZDate != null : "fx:id=\"opHZDate\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert opCon != null : "fx:id=\"opCon\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert opDate != null : "fx:id=\"opDate\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert opDrName != null : "fx:id=\"opDrName\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert medicine != null : "fx:id=\"medicine\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert dosesMedi != null : "fx:id=\"dosesMedi\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert dosesNum != null : "fx:id=\"dosesNum\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert dosesDay != null : "fx:id=\"dosesDay\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert usage != null : "fx:id=\"usage\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert downloadBtn != null : "fx:id=\"downloadBtn\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        assert downloadDate != null : "fx:id=\"downloadDate\" was not injected: check your FXML file 'SelectMyData.fxml'.";
        
        downloadBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
        headerList = new ArrayList<String>();
        rowList = new ArrayList<String>();
        
        try {
  			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
  			mcService = (IMedicalCertficateService) reg.lookup("medicalCertficateService");
  			inbodyService = (IInbodyService) reg.lookup("inbodyService");
  			mrService = (IMedicalReportService) reg.lookup("medicalReportService");
  			PreService = (IPrescriptionService) reg.lookup("prescriptionService");
  			scService = (ISurgicalConfirmationService) reg.lookup("surgicalConfirmationService");
  			docDownService = (IDocDownService) reg.lookup("docDownService");
  		} catch (RemoteException e) {
  			e.printStackTrace();
  		} catch (NotBoundException e) {
  			e.printStackTrace();
  		}
        
        MyFTP mf = new MyFTP();
		String[] fileArr = mf.mdmsDirectoryRead("/" + memVO.getMem_regno1() + "-" + memVO.getMem_regno2());
		for (int i = 0; i < fileArr.length; i++) {
			if (fileArr[i].contains("수술확인서.txt")) {
				opName.setDisable(false);
				opPart.setDisable(false);
				opHZDate.setDisable(false);
				opCon.setDisable(false);
				opDate.setDisable(false);
				opDrName.setDisable(false);
			}
		}
		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("mem_id", memVO.getMem_id());
		map1.put("down_item_con", "myData");
		try {
			String res = docDownService.selectDocDown(map1);
			if(res == null) {
				downloadDate.setText("다운로드 기록 없음");
			}else {
				downloadDate.setText(res);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
    }// initialize
}
