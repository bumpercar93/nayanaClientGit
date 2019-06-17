package nayana.vo;

import java.io.Serializable;

public class MyFileVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3616825581918402213L;
	/**
	 * 
	 */
	
	private int file_seq;
	private String file_bd_code;
	private int file_bd_num;
	private String file_original_name;
	private String file_server_name;
	private String file_extension;
	private String file_size;
	
	public int getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}
	public String getFile_bd_code() {
		return file_bd_code;
	}
	public void setFile_bd_code(String file_bd_code) {
		this.file_bd_code = file_bd_code;
	}
	public int getFile_bd_num() {
		return file_bd_num;
	}
	public void setFile_bd_num(int file_bd_num) {
		this.file_bd_num = file_bd_num;
	}
	public String getFile_original_name() {
		return file_original_name;
	}
	public void setFile_original_name(String file_original_name) {
		this.file_original_name = file_original_name;
	}
	public String getFile_server_name() {
		return file_server_name;
	}
	public void setFile_server_name(String file_server_name) {
		this.file_server_name = file_server_name;
	}
	public String getFile_extension() {
		return file_extension;
	}
	public void setFile_extension(String file_extension) {
		this.file_extension = file_extension;
	}
	public String getFile_size() {
		return file_size;
	}
	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}
	
}
