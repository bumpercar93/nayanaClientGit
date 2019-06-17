package nayana.vo;

import java.io.Serializable;

public class BoardNoticeVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4720620891262684255L;
	private int bn_seq; // 공지사항 시퀸스
	private String bn_title; // 공지사항 제목
	private String bn_content; // 공지사항 내용
	private String mem_id; // 공지사항 작성자
	private String bn_date; // 공지사항 작성일
	private String bn_updatewt; // 공지사항 수정자
	private String bn_update; // 공지사항 수정일
	private int bn_cnt; // 공지사항 조회수
	private String bn_status; // 공지사항 글 상태
	
	public int getBn_seq() {
		return bn_seq;
	}
	public void setBn_seq(int bn_seq) {
		this.bn_seq = bn_seq;
	}
	public String getBn_title() {
		return bn_title;
	}
	public void setBn_title(String bn_title) {
		this.bn_title = bn_title;
	}
	public String getBn_content() {
		return bn_content;
	}
	public void setBn_content(String bn_content) {
		this.bn_content = bn_content;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBn_date() {
		return bn_date;
	}
	public void setBn_date(String bn_date) {
		this.bn_date = bn_date;
	}
	public String getBn_updatewt() {
		return bn_updatewt;
	}
	public void setBn_updatewt(String bn_updatewt) {
		this.bn_updatewt = bn_updatewt;
	}
	public String getBn_update() {
		return bn_update;
	}
	public void setBn_update(String bn_update) {
		this.bn_update = bn_update;
	}
	public int getBn_cnt() {
		return bn_cnt;
	}
	public void setBn_cnt(int bn_cnt) {
		this.bn_cnt = bn_cnt;
	}
	public String getBn_status() {
		return bn_status;
	}
	public void setBn_status(String bn_status) {
		this.bn_status = bn_status;
	}
	
}