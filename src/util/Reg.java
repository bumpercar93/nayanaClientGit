package util;

public class Reg {
	
	// 시작은 영문으로만, '_'를 제외한 특수문자 안되며 영문, 숫자, '_'으로만 이루어진 5 ~ 12자 이하
	public static String regID = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
	
	public static String regMail = "^[A-Za-z][-_.\\\\A-Za-z0-9]*@\\w{1,7}[.][A-Za-z]{2,3}([.]kr)?";
	
	// 가장 많이 사용되는 최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함
	public static String regPW = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$";
	
	// 한글 최소 한 자 이상 (숫자, 특수문자 비허용)
	public static String regName = "[가-힣]+";
	
	// 숫자 3 - 숫자 4 - 숫자 4
	public static String regTel = "\\d{3}-\\d{4}-\\d{4}";
	
	// 숫자 6자리
	public static String regRegNo1 = "\\d{6}";
	
	// 숫자 7자리
	public static String regRegNo2 = "\\d{7}";
	
	public static String regAddr = "[가-힣]+";
	
}
