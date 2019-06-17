package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyPOI {
	public void xlsxWiter(List<String> headerList, List<String> rowList) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("MyData");
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell;
		
		for (int i = 0; i < headerList.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue(headerList.get(i));
		}
		
		row = sheet.createRow(1);

		for (int i = 0; i < rowList.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue(rowList.get(i));
		}
		
		File f = new File("c:\\NAYANA");
		f.mkdir();
		
		File file = new File("c:\\NAYANA\\myData.xlsx");
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(workbook != null) workbook.close();
				if(fos != null) fos.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
}
