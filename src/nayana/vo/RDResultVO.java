package nayana.vo;

import java.io.Serializable;

public class RDResultVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3883733973928983573L;
	private int rdr_seq;
	private String ra_code_age;
	private String rd_code_dss;
	private String rdw_code_wt;
	private String rdf_code_food;
	private String rdr_name;
	private String rdr_content;
	
	public int getRdr_seq() {
		return rdr_seq;
	}
	public void setRdr_seq(int rdr_seq) {
		this.rdr_seq = rdr_seq;
	}
	public String getRa_code_age() {
		return ra_code_age;
	}
	public void setRa_code_age(String ra_code_age) {
		this.ra_code_age = ra_code_age;
	}
	public String getRd_code_dss() {
		return rd_code_dss;
	}
	public void setRd_code_dss(String rd_code_dss) {
		this.rd_code_dss = rd_code_dss;
	}
	public String getRdw_code_wt() {
		return rdw_code_wt;
	}
	public void setRdw_code_wt(String rdw_code_wt) {
		this.rdw_code_wt = rdw_code_wt;
	}
	public String getRdf_code_food() {
		return rdf_code_food;
	}
	public void setRdf_code_food(String rdf_code_food) {
		this.rdf_code_food = rdf_code_food;
	}
	public String getRdr_name() {
		return rdr_name;
	}
	public void setRdr_name(String rdr_name) {
		this.rdr_name = rdr_name;
	}
	public String getRdr_content() {
		return rdr_content;
	}
	public void setRdr_content(String rdr_content) {
		this.rdr_content = rdr_content;
	}
		
}