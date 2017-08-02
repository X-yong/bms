package com.xy.vo;

public class MessageVo {
	
	private String su_id;
	private String ru_id;
	private String s_content;
	private Integer s_flag;
	private Integer page=1;//第几页
	private Integer rows = 10 ;//每页多少条记录
	private Integer start = 0;//从哪一行开始查询
	
	
	public String getSu_id() {
		return su_id;
	}
	public void setSu_id(String su_id) {
		this.su_id = su_id;
	}
	public String getRu_id() {
		return ru_id;
	}
	public void setRu_id(String ru_id) {
		this.ru_id = ru_id;
	}
	public String getS_content() {
		return s_content;
	}
	public void setS_content(String s_content) {
		this.s_content = s_content;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getS_flag() {
		return s_flag;
	}
	public void setS_flag(Integer s_flag) {
		this.s_flag = s_flag;
	}
	
	
}
