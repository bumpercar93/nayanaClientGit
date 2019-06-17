package nayana.vo;

import java.io.Serializable;

public class RDiseaseVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1494140737770303387L;
	private int rd_seq;
	private String rd_code_dss;
	private String rd_cate_dss;
	private String rd_flag;
	
	public int getRd_seq() {
		return rd_seq;
	}
	public void setRd_seq(int rd_seq) {
		this.rd_seq = rd_seq;
	}
	public String getRd_code_dss() {
		return rd_code_dss;
	}
	public void setRd_code_dss(String rd_code_dss) {
		this.rd_code_dss = rd_code_dss;
	}
	public String getRd_cate_dss() {
		return rd_cate_dss;
	}
	public void setRd_cate_dss(String rd_cate_dss) {
		this.rd_cate_dss = rd_cate_dss;
	}
	public String getRd_flag() {
		return rd_flag;
	}
	public void setRd_flag(String rd_flag) {
		this.rd_flag = rd_flag;
	}
	
}
