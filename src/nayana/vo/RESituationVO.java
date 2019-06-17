package nayana.vo;

import java.io.Serializable;

public class RESituationVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2011833165278585764L;
	private int res_seq;
	private String res_code_situ;
	private String res_cate_situ;
	
	public int getRes_seq() {
		return res_seq;
	}
	public void setRes_seq(int res_seq) {
		this.res_seq = res_seq;
	}
	public String getRes_code_situ() {
		return res_code_situ;
	}
	public void setRes_code_situ(String res_code_situ) {
		this.res_code_situ = res_code_situ;
	}
	public String getRes_cate_situ() {
		return res_cate_situ;
	}
	public void setRes_cate_situ(String res_cate_situ) {
		this.res_cate_situ = res_cate_situ;
	}
	
}
