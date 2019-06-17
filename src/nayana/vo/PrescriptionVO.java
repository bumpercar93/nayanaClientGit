package nayana.vo;

import java.io.Serializable;

public class PrescriptionVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4868049793944323075L;
	private int ps_seq;
	private String mem_id;
	private String ps_pt_name;
	private String ps_pt_regno;
	private String ps_isu_date;
	private String ps_isu_agency;
	private String ps_hp_tel;
	private String ps_hp_fax;
	private String ps_dss_num;
	private String ps_dr_name;
	private String ps_dr_num;
	private String ps_medicine;
	private String ps_doses_medi;
	private String ps_doses_num;
	private String ps_all_doses_day;
	private String ps_usage;
	
	public int getPs_seq() {
		return ps_seq;
	}
	public void setPs_seq(int ps_seq) {
		this.ps_seq = ps_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getPs_pt_name() {
		return ps_pt_name;
	}
	public void setPs_pt_name(String ps_pt_name) {
		this.ps_pt_name = ps_pt_name;
	}
	public String getPs_pt_regno() {
		return ps_pt_regno;
	}
	public void setPs_pt_regno(String ps_pt_regno) {
		this.ps_pt_regno = ps_pt_regno;
	}
	public String getPs_isu_date() {
		return ps_isu_date;
	}
	public void setPs_isu_date(String ps_isu_date) {
		this.ps_isu_date = ps_isu_date;
	}
	public String getPs_isu_agency() {
		return ps_isu_agency;
	}
	public void setPs_isu_agency(String ps_isu_agency) {
		this.ps_isu_agency = ps_isu_agency;
	}
	public String getPs_hp_tel() {
		return ps_hp_tel;
	}
	public void setPs_hp_tel(String ps_hp_tel) {
		this.ps_hp_tel = ps_hp_tel;
	}
	public String getPs_hp_fax() {
		return ps_hp_fax;
	}
	public void setPs_hp_fax(String ps_hp_fax) {
		this.ps_hp_fax = ps_hp_fax;
	}
	public String getPs_dss_num() {
		return ps_dss_num;
	}
	public void setPs_dss_num(String ps_dss_num) {
		this.ps_dss_num = ps_dss_num;
	}
	public String getPs_dr_name() {
		return ps_dr_name;
	}
	public void setPs_dr_name(String ps_dr_name) {
		this.ps_dr_name = ps_dr_name;
	}
	public String getPs_dr_num() {
		return ps_dr_num;
	}
	public void setPs_dr_num(String ps_dr_num) {
		this.ps_dr_num = ps_dr_num;
	}
	public String getPs_medicine() {
		return ps_medicine;
	}
	public void setPs_medicine(String ps_medicine) {
		this.ps_medicine = ps_medicine;
	}
	public String getPs_doses_medi() {
		return ps_doses_medi;
	}
	public void setPs_doses_medi(String ps_doses_medi) {
		this.ps_doses_medi = ps_doses_medi;
	}
	public String getPs_doses_num() {
		return ps_doses_num;
	}
	public void setPs_doses_num(String ps_doses_num) {
		this.ps_doses_num = ps_doses_num;
	}
	public String getPs_all_doses_day() {
		return ps_all_doses_day;
	}
	public void setPs_all_doses_day(String ps_all_doses_day) {
		this.ps_all_doses_day = ps_all_doses_day;
	}
	public String getPs_usage() {
		return ps_usage;
	}
	public void setPs_usage(String ps_usage) {
		this.ps_usage = ps_usage;
	}
	
}
