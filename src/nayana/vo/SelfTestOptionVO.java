package nayana.vo;

import java.io.Serializable;

public class SelfTestOptionVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4862202860575815255L;
	private int self_sel_seq;
	private int self_que_seq;
	private String self_ot_score;
	private String self_ot_con;
	
	public int getSelf_sel_seq() {
		return self_sel_seq;
	}
	public void setSelf_sel_seq(int self_sel_seq) {
		this.self_sel_seq = self_sel_seq;
	}
	public int getSelf_que_seq() {
		return self_que_seq;
	}
	public void setSelf_que_seq(int self_que_seq) {
		this.self_que_seq = self_que_seq;
	}
	public String getSelf_ot_score() {
		return self_ot_score;
	}
	public void setSelf_ot_score(String self_ot_score) {
		this.self_ot_score = self_ot_score;
	}
	public String getSelf_ot_con() {
		return self_ot_con;
	}
	public void setSelf_ot_con(String self_ot_con) {
		this.self_ot_con = self_ot_con;
	}
	
}
