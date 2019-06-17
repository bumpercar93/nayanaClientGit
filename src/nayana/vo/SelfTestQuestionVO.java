package nayana.vo;

import java.io.Serializable;

public class SelfTestQuestionVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8960396497887179737L;
	private int self_que_seq;
	private int self_seq;
	private String self_que_con;
	private int self_que_num;
	
	public int getSelf_que_seq() {
		return self_que_seq;
	}
	public void setSelf_que_seq(int self_que_seq) {
		this.self_que_seq = self_que_seq;
	}
	public int getSelf_seq() {
		return self_seq;
	}
	public void setSelf_seq(int self_seq) {
		this.self_seq = self_seq;
	}
	public String getSelf_que_con() {
		return self_que_con;
	}
	public void setSelf_que_con(String self_que_con) {
		this.self_que_con = self_que_con;
	}
	public int getSelf_que_num() {
		return self_que_num;
	}
	public void setSelf_que_num(int self_que_num) {
		this.self_que_num = self_que_num;
	}
	
}
