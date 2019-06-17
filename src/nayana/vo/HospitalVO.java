package nayana.vo;

import java.io.Serializable;

public class HospitalVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6786612350427175599L;
	private int hp_seq; 			//병원 시퀀스
	private String hp_cate; 		//병원 분류
	private String hp_name;			//병원 이름
	private String hp_addr;			//병원 주소
	private String hp_tel;			//병원 전화번호
	private String mem_id;			//병원 정보 작성자
	private String hp_date;			//병원 정보 작성일
	private String hp_updatewt;		//병원 정보 수정자
	private String hp_update;		//병원 정보 수정일

	
	public int getHp_seq() {
		return hp_seq;
	}
	public void setHp_seq(int hp_seq) {
		this.hp_seq = hp_seq;
	}
	public String getHp_cate() {
		return hp_cate;
	}
	public void setHp_cate(String hp_cate) {
		this.hp_cate = hp_cate;
	}
	public String getHp_name() {
		return hp_name;
	}
	public void setHp_name(String hp_name) {
		this.hp_name = hp_name;
	}
	public String getHp_addr() {
		return hp_addr;
	}
	public void setHp_addr(String hp_addr) {
		this.hp_addr = hp_addr;
	}
	public String getHp_tel() {
		return hp_tel;
	}
	public void setHp_tel(String hp_tel) {
		this.hp_tel = hp_tel;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getHp_date() {
		return hp_date;
	}
	public void setHp_date(String hp_date) {
		this.hp_date = hp_date;
	}
	public String getHp_updatewt() {
		return hp_updatewt;
	}
	public void setHp_updatewt(String hp_updatewt) {
		this.hp_updatewt = hp_updatewt;
	}
	public String getHp_update() {
		return hp_update;
	}
	public void setHp_update(String hp_update) {
		this.hp_update = hp_update;
	}
	
}
