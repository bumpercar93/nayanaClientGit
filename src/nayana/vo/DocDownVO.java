package nayana.vo;

import java.io.Serializable;

public class DocDownVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -358925340181048981L;
	private int down_seq;
	private String mem_id;
	private String down_item_con;
	private String down_date;
	
	public int getDown_seq() {
		return down_seq;
	}
	public void setDown_seq(int down_seq) {
		this.down_seq = down_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getDown_item_con() {
		return down_item_con;
	}
	public void setDown_item_con(String down_item_con) {
		this.down_item_con = down_item_con;
	}
	public String getDown_date() {
		return down_date;
	}
	public void setDown_date(String down_date) {
		this.down_date = down_date;
	}
	
}
