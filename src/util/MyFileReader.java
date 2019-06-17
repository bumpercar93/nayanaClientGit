package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.net.ftp.FTPClient;

public class MyFileReader {
	public Map<String, String> fileRead(String regNo1, String regNo2, String fileName){
		Map<String, String> map = new HashMap<String, String>();
		FTPClient mdms = null;
		try {
			File file = new File("D:\\MDMS\\" + regNo1 + "-" + regNo2 + "\\" + fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			
			String temp = "";
			
			for (int i = 1; (temp = br.readLine()) != null; i++) {
				int gubun = temp.indexOf(":");
				String key = temp.substring(0, gubun);
				String value = temp.substring(gubun+1);
				map.put(key, value);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
}
