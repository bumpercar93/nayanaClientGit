package nayana.vo;

import java.io.Serializable;

public class REVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6697430014324119081L;
	private int re_seq;
	private String re_code_exe;
	private String re_cate_exe;
	
	public int getRe_seq() {
		return re_seq;
	}
	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}
	public String getRe_code_exe() {
		return re_code_exe;
	}
	public void setRe_code_exe(String re_code_exe) {
		this.re_code_exe = re_code_exe;
	}
	public String getRe_cate_exe() {
		return re_cate_exe;
	}
	public void setRe_cate_exe(String re_cate_exe) {
		this.re_cate_exe = re_cate_exe;
	}
	
}
