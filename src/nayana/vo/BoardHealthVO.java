package nayana.vo;

import java.io.Serializable;

public class BoardHealthVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 841479158542973648L;
	private int bh_seq;
	private String bh_title;
	private String bh_content;
	private String bh_mem_id;
	private String bh_date;
	private String bh_updatewt;
	private String bh_update;
	private int bh_cnt;
	private String bh_status;
	
	public int getBh_seq() {
		return bh_seq;
	}
	public void setBh_seq(int bh_seq) {
		this.bh_seq = bh_seq;
	}
	public String getBh_title() {
		return bh_title;
	}
	public void setBh_title(String bh_title) {
		this.bh_title = bh_title;
	}
	public String getBh_content() {
		return bh_content;
	}
	public void setBh_content(String bh_content) {
		this.bh_content = bh_content;
	}
	public String getBh_mem_id() {
		return bh_mem_id;
	}
	public void setBh_mem_id(String bh_mem_id) {
		this.bh_mem_id = bh_mem_id;
	}
	public String getBh_date() {
		return bh_date;
	}
	public void setBh_date(String bh_date) {
		this.bh_date = bh_date;
	}
	public String getBh_updatewt() {
		return bh_updatewt;
	}
	public void setBh_updatewt(String bh_updatewt) {
		this.bh_updatewt = bh_updatewt;
	}
	public String getBh_update() {
		return bh_update;
	}
	public void setBh_update(String bh_update) {
		this.bh_update = bh_update;
	}
	public int getBh_cnt() {
		return bh_cnt;
	}
	public void setBh_cnt(int bh_cnt) {
		this.bh_cnt = bh_cnt;
	}
	public String getBh_status() {
		return bh_status;
	}
	public void setBh_status(String bh_status) {
		this.bh_status = bh_status;
	}
	
}
