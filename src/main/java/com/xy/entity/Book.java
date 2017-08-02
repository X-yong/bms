package com.xy.entity;

import java.io.Serializable;

public class Book implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String b_id;
	private String b_name;
	private String b_type;
	private String b_authorid;
	private String b_author;
	private String b_press;
	private String b_enterTime;
	private Double b_price;
	private Integer b_state;//图书状态 : 连载 0 ;已完结 1;
	private Integer b_kind;//图书类型  电子书 0 ;纸质书 1;
	private String b_url;
	private String b_imgurl;
	private String b_remark;
	private String b_isbn;
	private String b_revision;
	private Integer b_stock;
	private String typid;
	private String typename;
	private String b_operateTime;
	private Integer b_account = 0 ;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypid() {
		return typid;
	}
	public void setTypid(String typid) {
		this.typid = typid;
	}
	
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_type() {
		return b_type;
	}
	public void setB_type(String b_type) {
		this.b_type = b_type;
	}
	public String getB_author() {
		return b_author;
	}
	public void setB_author(String b_author) {
		this.b_author = b_author;
	}
	public String getB_press() {
		return b_press;
	}
	public void setB_press(String b_press) {
		this.b_press = b_press;
	}
	public Double getB_price() {
		return b_price;
	}
	public void setB_price(Double b_price) {
		this.b_price = b_price;
	}
	public Integer getB_state() {
		return b_state;
	}
	public void setB_state(Integer b_state) {
		this.b_state = b_state;
	}
	public Integer getB_kind() {
		return b_kind;
	}
	public void setB_kind(Integer b_kind) {
		this.b_kind = b_kind;
	}
	public String getB_url() {
		return b_url;
	}
	public void setB_url(String b_url) {
		this.b_url = b_url;
	}
	public String getB_remark() {
		return b_remark;
	}
	public void setB_remark(String b_remark) {
		this.b_remark = b_remark;
	}
	public String getB_isbn() {
		return b_isbn;
	}
	public void setB_isbn(String b_isbn) {
		this.b_isbn = b_isbn;
	}
	public String getB_revision() {
		return b_revision;
	}
	public void setB_revision(String b_revision) {
		this.b_revision = b_revision;
	}
	
	public String getB_enterTime() {
		return b_enterTime;
	}
	public void setB_enterTime(String b_enterTime) {
		this.b_enterTime = b_enterTime;
	}
	public Integer getB_stock() {
		return b_stock;
	}
	public void setB_stock(Integer b_stock) {
		this.b_stock = b_stock;
	}
	public String getB_operateTime() {
		return b_operateTime;
	}
	public void setB_operateTime(String b_operateTime) {
		this.b_operateTime = b_operateTime;
	}
	public Integer getB_account() {
		return b_account;
	}
	public void setB_account(Integer b_account) {
		this.b_account = b_account;
	}
	public String getB_imgurl() {
		return b_imgurl;
	}
	public void setB_imgurl(String b_imgurl) {
		this.b_imgurl = b_imgurl;
	}
	public String getB_authorid() {
		return b_authorid;
	}
	public void setB_authorid(String b_authorid) {
		this.b_authorid = b_authorid;
	}
	
	
}
