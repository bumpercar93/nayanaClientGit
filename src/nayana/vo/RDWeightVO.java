package nayana.vo;

import java.io.Serializable;

public class RDWeightVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4553737083690449102L;
	private int rdw_seq;
	private String rdw_code_wt;
	private String rdw_cate_wt;
	
	public int getRdw_seq() {
		return rdw_seq;
	}
	public void setRdw_seq(int rdw_seq) {
		this.rdw_seq = rdw_seq;
	}
	public String getRdw_code_wt() {
		return rdw_code_wt;
	}
	public void setRdw_code_wt(String rdw_code_wt) {
		this.rdw_code_wt = rdw_code_wt;
	}
	public String getRdw_cate_wt() {
		return rdw_cate_wt;
	}
	public void setRdw_cate_wt(String rdw_cate_wt) {
		this.rdw_cate_wt = rdw_cate_wt;
	}
	
	
	
}
