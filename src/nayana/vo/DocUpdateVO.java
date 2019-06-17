package nayana.vo;

import java.io.Serializable;

public class DocUpdateVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9015570010257197679L;
	private int du_ud_seq;
	private String mem_id;
	private String du_date;
	private String du_update;
	
	public int getDu_ud_seq() {
		return du_ud_seq;
	}
	public void setDu_ud_seq(int du_ud_seq) {
		this.du_ud_seq = du_ud_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getDu_date() {
		return du_date;
	}
	public void setDu_date(String du_date) {
		this.du_date = du_date;
	}
	public String getDu_update() {
		return du_update;
	}
	public void setDu_update(String du_update) {
		this.du_update = du_update;
	}
	
}
