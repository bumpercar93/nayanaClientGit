package nayana.vo;

import java.io.Serializable;

public class REResultVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1633552185207828938L;
	private int rer_seq;
	private String ra_code_age;
	private String rer_code_body;
	private String res_code_situ;
	private String rd_code_dss;
	private String rer_code_exe;
	private String rer_name;
	private String rer_content;
	
	public int getRer_seq() {
		return rer_seq;
	}
	public void setRer_seq(int rer_seq) {
		this.rer_seq = rer_seq;
	}
	public String getRa_code_age() {
		return ra_code_age;
	}
	public void setRa_code_age(String ra_code_age) {
		this.ra_code_age = ra_code_age;
	}
	public String getRer_code_body() {
		return rer_code_body;
	}
	public void setRer_code_body(String rer_code_body) {
		this.rer_code_body = rer_code_body;
	}
	public String getRes_code_situ() {
		return res_code_situ;
	}
	public void setRes_code_situ(String res_code_situ) {
		this.res_code_situ = res_code_situ;
	}
	public String getRd_code_dss() {
		return rd_code_dss;
	}
	public void setRd_code_dss(String rd_code_dss) {
		this.rd_code_dss = rd_code_dss;
	}
	public String getRer_code_exe() {
		return rer_code_exe;
	}
	public void setRer_code_exe(String rer_code_exe) {
		this.rer_code_exe = rer_code_exe;
	}
	public String getRer_name() {
		return rer_name;
	}
	public void setRer_name(String rer_name) {
		this.rer_name = rer_name;
	}
	public String getRer_content() {
		return rer_content;
	}
	public void setRer_content(String rer_content) {
		this.rer_content = rer_content;
	}
	
}
