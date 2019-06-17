package nayana.vo;

import java.io.Serializable;

public class SelfTestInfoVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1074176455980320524L;
	private int self_test_seq;
	private int self_seq;
	private int self_test_score;
	private String mem_id;
	private String self_test_date;
	
	public int getSelf_test_seq() {
		return self_test_seq;
	}
	public void setSelf_test_seq(int self_test_seq) {
		this.self_test_seq = self_test_seq;
	}
	public int getSelf_seq() {
		return self_seq;
	}
	public void setSelf_seq(int self_seq) {
		this.self_seq = self_seq;
	}
	public int getSelf_test_score() {
		return self_test_score;
	}
	public void setSelf_test_score(int self_test_score) {
		this.self_test_score = self_test_score;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getSelf_test_date() {
		return self_test_date;
	}
	public void setSelf_test_date(String self_test_date) {
		this.self_test_date = self_test_date;
	}
	
}
