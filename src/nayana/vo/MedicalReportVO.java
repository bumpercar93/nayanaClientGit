package nayana.vo;

import java.io.Serializable;

public class MedicalReportVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6204847381318957120L;
	private int mr_seq;
	private String mem_id;
	private String mr_medi_part;
	private String mr_serial_num;
	private String mr_writer;
	private String mr_date;
	private String mr_pt_regno;
	private String mr_pt_addr;
	private String mr_pt_name;
	private String mr_pt_gen;
	private String mr_pt_bir;
	private String mr_pt_age;
	private String mr_pt_dss_name;
	private String mr_tt_finding;
	
	public int getMr_seq() {
		return mr_seq;
	}
	public void setMr_seq(int mr_seq) {
		this.mr_seq = mr_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMr_medi_part() {
		return mr_medi_part;
	}
	public void setMr_medi_part(String mr_medi_part) {
		this.mr_medi_part = mr_medi_part;
	}
	public String getMr_serial_num() {
		return mr_serial_num;
	}
	public void setMr_serial_num(String mr_serial_num) {
		this.mr_serial_num = mr_serial_num;
	}
	public String getMr_writer() {
		return mr_writer;
	}
	public void setMr_writer(String mr_writer) {
		this.mr_writer = mr_writer;
	}
	public String getMr_date() {
		return mr_date;
	}
	public void setMr_date(String mr_date) {
		this.mr_date = mr_date;
	}
	public String getMr_pt_regno() {
		return mr_pt_regno;
	}
	public void setMr_pt_regno(String mr_pt_regno) {
		this.mr_pt_regno = mr_pt_regno;
	}
	public String getMr_pt_addr() {
		return mr_pt_addr;
	}
	public void setMr_pt_addr(String mr_pt_addr) {
		this.mr_pt_addr = mr_pt_addr;
	}
	public String getMr_pt_name() {
		return mr_pt_name;
	}
	public void setMr_pt_name(String mr_pt_name) {
		this.mr_pt_name = mr_pt_name;
	}
	public String getMr_pt_gen() {
		return mr_pt_gen;
	}
	public void setMr_pt_gen(String mr_pt_gen) {
		this.mr_pt_gen = mr_pt_gen;
	}
	public String getMr_pt_bir() {
		return mr_pt_bir;
	}
	public void setMr_pt_bir(String mr_pt_bir) {
		this.mr_pt_bir = mr_pt_bir;
	}
	public String getMr_pt_age() {
		return mr_pt_age;
	}
	public void setMr_pt_age(String mr_pt_age) {
		this.mr_pt_age = mr_pt_age;
	}
	public String getMr_pt_dss_name() {
		return mr_pt_dss_name;
	}
	public void setMr_pt_dss_name(String mr_pt_dss_name) {
		this.mr_pt_dss_name = mr_pt_dss_name;
	}
	public String getMr_tt_finding() {
		return mr_tt_finding;
	}
	public void setMr_tt_finding(String mr_tt_finding) {
		this.mr_tt_finding = mr_tt_finding;
	}
	
}
