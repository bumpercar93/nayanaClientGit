package nayana.vo;

import java.io.Serializable;

public class RDFoodVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4696616199122454847L;
	private int rdf_seq;
	private String rdf_code_food;
	private String rdf_cate_food;
	
	public int getRdf_seq() {
		return rdf_seq;
	}
	public void setRdf_seq(int rdf_seq) {
		this.rdf_seq = rdf_seq;
	}
	public String getRdf_code_food() {
		return rdf_code_food;
	}
	public void setRdf_code_food(String rdf_code_food) {
		this.rdf_code_food = rdf_code_food;
	}
	public String getRdf_cate_food() {
		return rdf_cate_food;
	}
	public void setRdf_cate_food(String rdf_cate_food) {
		this.rdf_cate_food = rdf_cate_food;
	}
	
}
