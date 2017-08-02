package com.xy.entity;

public class BorrowBook {
	private Integer id;
	private String u_id;
	private String b_id;
	private String br_time;//借书日期
	private String re_time;//还书日期
	private String sh_time;//应还日期日期
	private Integer bo_state;//0,借阅中；1,已归还; 2,已逾期

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getBr_time() {
		return br_time;
	}

	public void setBr_time(String br_time) {
		this.br_time = br_time;
	}

	public Integer getBo_state() {
		return bo_state;
	}

	public void setBo_state(Integer bo_state) {
		this.bo_state = bo_state;
	}

	public String getRe_time() {
		return re_time;
	}

	public void setRe_time(String re_time) {
		this.re_time = re_time;
	}

	public String getSh_time() {
		return sh_time;
	}

	public void setSh_time(String sh_time) {
		this.sh_time = sh_time;
	}
}
