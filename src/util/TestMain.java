package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {

	public static void main(String[] args) {
//		MyFileReader mfr = new MyFileReader();
//		
//		Map<String, String> map = new HashMap<String, String>();
//		map = mfr.fileRead("340606", "1305189", "340606-1305189_진단서.txt");
//		System.out.println(map.get("환자성명"));
//		
//		MyFTP mf = new MyFTP();
//		mf.FtpDownLoad("520202", "2105412", "520202-2105412_진단서.txt");
//		String[] result = mf.mdmsDirectoryRead("/540808-2106512");
//		for (int i = 0; i < result.length; i++) {
//			System.out.println(result[i]);
//		}
		
//		MyPOI mp = new MyPOI();
//		List<String> headerList = new ArrayList<String>();
//		List<String> rowList = new ArrayList<String>();
//		headerList.add("이름");
//		headerList.add("나이");
//		headerList.add("주소");
//		headerList.add("성별");
//		rowList.add("김범휘");
//		rowList.add("27");
//		rowList.add("대전시");
//		rowList.add("남");
//		mp.xlsxWiter(headerList, rowList);
		
		MyMail mm = new MyMail();
		mm.sendMail("youbi89@naver.com", "kim52");
		
	}
		

}
