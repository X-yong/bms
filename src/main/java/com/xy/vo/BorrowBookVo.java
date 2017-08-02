package com.xy.vo;

import java.util.Date;
import java.util.List;

public class BorrowBookVo {
	private Integer id;
	private String u_id;
	private String u_credit; //用户信用值
	private String b_id;
	private String b_name;
	private String br_time;//借书日期
	private String re_time;//还书日期
	private String sh_time;//应还日期日期
	private String bo_state;//0,借阅中；1,已归还; 2,已逾期
	private List idList;
	private List<String> bidList;
	private Integer b_time;//借阅天数
	private Integer b_relet;//续租天数
	private Date b_appointtime;//预约时间
	private Integer page=1;//第几页
	private Integer rows = 10 ;//每页多少条记录
	private Integer start = 0;//从哪一行开始查询
	
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

	public String getBo_state() {
		return bo_state;
	}

	public void setBo_state(String bo_state) {
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

	public List getIdList() {
		return idList;
	}

	public void setIdList(List idList) {
		this.idList = idList;
	}

	public Integer getB_time() {
		return b_time;
	}

	public void setB_time(Integer b_time) {
		this.b_time = b_time;
	}

	public List getBidList() {
		return bidList;
	}

	public void setBidList(List bidList) {
		this.bidList = bidList;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public Integer getB_relet() {
		return b_relet;
	}

	public void setB_relet(Integer b_relet) {
		this.b_relet = b_relet;
	}

	public String getU_credit() {
		return u_credit;
	}

	public void setU_credit(String u_credit) {
		this.u_credit = u_credit;
	}

	public Date getB_appointtime() {
		return b_appointtime;
	}

	public void setB_appointtime(Date b_appointtime) {
		this.b_appointtime = b_appointtime;
	}

	
}
