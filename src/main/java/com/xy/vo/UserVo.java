/**
 * 
 */
/**
 * @author soonsmile
 *
 */
package com.xy.vo;

import java.io.Serializable;

public class UserVo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String u_id;
	/**
	 * 户名
	 */
	private String u_name;
	/**
	 *身份证号
	 */
	private String u_idCard;
	
	/**
	 *开始时间 
	 */
	private String u_startDate;
	/**
	 *结束时间 
	 */
	private String u_endDate;
	/**
	 *用户状态 
	 */
	private Integer u_state;
	/**
	 * 图像路径
	 */
	private String u_photo;
	
	/**
	 * 用户余额
	 */
	private Double u_balance;
	/**
	 * 密码
	 */
	private String u_password;
	/**
	 *电话号码
	 */
	private String u_phone;
	/**
	 * 邮箱地址
	 */
	private String u_email;
	/**
	 * 权限值
	 */
	private String u_role;
	/**
	 * 信用值
	 */
	private Integer u_credit;
	/**
	 * 系统管理员标记
	 */
	public static Integer root;
	private Integer page=1;//第几页
	private Integer rows = 10 ;//每页多少条记录
	private Integer start = 0;//从哪一行开始查询
	
	public UserVo() {
		super();
	}
	
	public UserVo(Integer page, Integer rows) {
		super();
		this.page = page;
		this.rows = rows;
		this.setStart((page-1)*rows);
	}
	
	
	public Integer getU_credit() {
		return u_credit;
	}

	public void setU_credit(Integer u_credit) {
		this.u_credit = u_credit;
	}

	public String getU_photo() {
		return u_photo;
	}
	public void setU_photo(String u_photo) {
		this.u_photo = u_photo;
	}
	
	public Double getU_balance() {
		return u_balance;
	}

	public void setU_balance(Double u_balance) {
		this.u_balance = u_balance;
	}

	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
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
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_startDate() {
		return u_startDate;
	}

	public void setU_startDate(String u_startDate) {
		this.u_startDate = u_startDate;
	}

	public String getU_endDate() {
		return u_endDate;
	}

	public void setU_endDate(String u_endDate) {
		this.u_endDate = u_endDate;
	}

	public Integer getU_state() {
		return u_state;
	}

	public void setU_state(Integer u_state) {
		this.u_state = u_state;
	}

	public String getU_role() {
		return u_role;
	}

	public void setU_role(String u_role) {
		this.u_role = u_role;
	}

	public Integer getRoot() {
		return root;
	}

	public void setRoot(Integer root) {
		this.root = root;
	}

	public String getU_idCard() {
		return u_idCard;
	}

	public void setU_idCard(String u_idCard) {
		this.u_idCard = u_idCard;
	}
	
}
