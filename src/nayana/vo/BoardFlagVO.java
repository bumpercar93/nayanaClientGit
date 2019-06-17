package nayana.vo;

import java.io.Serializable;

public class BoardFlagVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7852168005993249971L;
	private String bd_code;
	private String bc_name;
	
	public String getBd_code() {
		return bd_code;
	}
	public void setBd_code(String bd_code) {
		this.bd_code = bd_code;
	}
	public String getBc_name() {
		return bc_name;
	}
	public void setBc_name(String bc_name) {
		this.bc_name = bc_name;
	}
	
}
