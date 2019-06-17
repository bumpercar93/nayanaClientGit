package nayana.vo;

import java.io.Serializable;

public class BoardFreeVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4137245286089304677L;
	private int bf_seq; //시퀀스
	private String bf_title; //게시판 제목
	private String bf_content; //게시판 내용
	private String mem_id; //작성자 아이디
	private String bf_date; //작성날짜
	private String bf_updatewt; //수정자
	private String bf_update; //수정일
	private int bf_cnt; //조회수
	private String bf_status; //글상태
	
	public int getBf_seq() {
		return bf_seq;
	}
	public void setBf_seq(int bf_seq) {
		this.bf_seq = bf_seq;
	}
	public String getBf_title() {
		return bf_title;
	}
	public void setBf_title(String bf_title) {
		this.bf_title = bf_title;
	}
	public String getBf_content() {
		return bf_content;
	}
	public void setBf_content(String bf_content) {
		this.bf_content = bf_content;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBf_date() {
		return bf_date;
	}
	public void setBf_date(String bf_date) {
		this.bf_date = bf_date;
	}
	public String getBf_updatewt() {
		return bf_updatewt;
	}
	public void setBf_updatewt(String bf_updatewt) {
		this.bf_updatewt = bf_updatewt;
	}
	public String getBf_update() {
		return bf_update;
	}
	public void setBf_update(String bf_update) {
		this.bf_update = bf_update;
	}
	public int getBf_cnt() {
		return bf_cnt;
	}
	public void setBf_cnt(int bf_cnt) {
		this.bf_cnt = bf_cnt;
	}
	public String getBf_status() {
		return bf_status;
	}
	public void setBf_status(String bf_status) {
		this.bf_status = bf_status;
	}
	
}
