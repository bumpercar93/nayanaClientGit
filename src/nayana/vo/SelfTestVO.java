package nayana.vo;

import java.io.Serializable;

public class SelfTestVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1948439469454954444L;
	private int self_seq;
	private String self_title;
	private String self_date;
	private String self_update;
	private String mem_id;
	private String self_status;
	
	public int getSelf_seq() {
		return self_seq;
	}
	public void setSelf_seq(int self_seq) {
		this.self_seq = self_seq;
	}
	public String getSelf_title() {
		return self_title;
	}
	public void setSelf_title(String self_title) {
		this.self_title = self_title;
	}
	public String getSelf_date() {
		return self_date;
	}
	public void setSelf_date(String self_date) {
		this.self_date = self_date;
	}
	public String getSelf_update() {
		return self_update;
	}
	public void setSelf_update(String self_update) {
		this.self_update = self_update;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getSelf_status() {
		return self_status;
	}
	public void setSelf_status(String self_status) {
		this.self_status = self_status;
	}
	
}
