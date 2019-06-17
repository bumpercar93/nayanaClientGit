package nayana.vo;

import java.io.Serializable;

public class RAgeVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1531090491341227406L;
	private int ra_seq;
	private String ra_code_age;
	private String ra_cate_age;
	private String ra_flag;
	
	public int getRa_seq() {
		return ra_seq;
	}
	public void setRa_seq(int ra_seq) {
		this.ra_seq = ra_seq;
	}
	public String getRa_code_age() {
		return ra_code_age;
	}
	public void setRa_code_age(String ra_code_age) {
		this.ra_code_age = ra_code_age;
	}
	public String getRa_cate_age() {
		return ra_cate_age;
	}
	public void setRa_cate_age(String ra_cate_age) {
		this.ra_cate_age = ra_cate_age;
	}
	public String getRa_flag() {
		return ra_flag;
	}
	public void setRa_flag(String ra_flag) {
		this.ra_flag = ra_flag;
	}
	
}
