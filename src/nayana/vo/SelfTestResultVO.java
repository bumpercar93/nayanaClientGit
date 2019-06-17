package nayana.vo;

import java.io.Serializable;

public class SelfTestResultVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 729311257632448827L;
	private int self_rs_seq;
	private int self_seq;
	private int self_rs_score;
	private String self_rs_con;
	
	public int getSelf_rs_seq() {
		return self_rs_seq;
	}
	public void setSelf_rs_seq(int self_rs_seq) {
		this.self_rs_seq = self_rs_seq;
	}
	public int getSelf_seq() {
		return self_seq;
	}
	public void setSelf_seq(int self_seq) {
		this.self_seq = self_seq;
	}
	public int getSelf_rs_score() {
		return self_rs_score;
	}
	public void setSelf_rs_score(int self_rs_score) {
		this.self_rs_score = self_rs_score;
	}
	public String getSelf_rs_con() {
		return self_rs_con;
	}
	public void setSelf_rs_con(String self_rs_con) {
		this.self_rs_con = self_rs_con;
	}
	
}
