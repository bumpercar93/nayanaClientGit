package nayana.vo;

import java.io.Serializable;

public class REBodyVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4277500496915587406L;
	private int reb_seq;
	private String reb_code_body;
	private String reb_cate_body;
	
	public int getReb_seq() {
		return reb_seq;
	}
	public void setReb_seq(int reb_seq) {
		this.reb_seq = reb_seq;
	}
	public String getReb_code_body() {
		return reb_code_body;
	}
	public void setReb_code_body(String reb_code_body) {
		this.reb_code_body = reb_code_body;
	}
	public String getReb_cate_body() {
		return reb_cate_body;
	}
	public void setReb_cate_body(String reb_cate_body) {
		this.reb_cate_body = reb_cate_body;
	}
	
}
