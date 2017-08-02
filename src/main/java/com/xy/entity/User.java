package com.xy.entity;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 账号id
	 */
	private Integer id;
	/**
	 * 账号
	 */
	private String u_id;
	/**
	 *身份证号
	 */
	private String u_idCard;
	/**
	 * 户名
	 */
	private String u_name;
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
	 *创建时间 
	 */
	private String u_createTime;
	/**
	 *创建时间 
	 */
	private String u_operateTime;
	/**
	 * 图像地址
	 */
	private String u_photo;
	/**
	 * 用户状态
	 */
	private Integer u_state;
	
	/**
	 * 用户余额
	 */
	private Double u_balance;
	/**
	 * 信用值
	 */
	private Integer u_credit;
	/**
	 * 权限
	 */
	private Authority authority;
	
	
	
	public Authority getAuthority() {
		return authority;
	}
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
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
	public String getU_createTime() {
		return u_createTime;
	}
	public void setU_createTime(String u_createTime) {
		this.u_createTime = u_createTime;
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
	public String getU_photo() {
		return u_photo;
	}
	public void setU_photo(String u_photo) {
		this.u_photo = u_photo;
	}

	public Integer getU_state() {
		return u_state;
	}
	public void setU_state(Integer u_state) {
		this.u_state = u_state;
	}
	public Double getU_balance() {
		return u_balance;
	}
	public void setU_balance(Double u_balance) {
		this.u_balance = u_balance;
	}
	public String getU_operateTime() {
		return u_operateTime;
	}
	public void setU_operateTime(String u_operateTime) {
		this.u_operateTime = u_operateTime;
	}


	public Integer getU_credit() {
		return u_credit;
	}
	public void setU_credit(Integer u_credit) {
		this.u_credit = u_credit;
	}


	public String getU_idCard() {
		return u_idCard;
	}
	public void setU_idCard(String u_idCard) {
		this.u_idCard = u_idCard;
	}

}
