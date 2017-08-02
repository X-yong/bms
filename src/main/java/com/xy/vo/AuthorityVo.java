package com.xy.vo;

import java.io.Serializable;

public class AuthorityVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String u_id;
	private String  authority_id;
	private String  authority_powertime;
	private String authority_powerperson ;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAuthority_powerperson() {
		return authority_powerperson;
	}
	public void setAuthority_powerperson(String authority_powerperson) {
		this.authority_powerperson = authority_powerperson;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getAuthority_id() {
		return authority_id;
	}
	public void setAuthority_id(String authority_id) {
		this.authority_id = authority_id;
	}
	public String getAuthority_powertime() {
		return authority_powertime;
	}
	public void setAuthority_powertime(String authority_powertime) {
		this.authority_powertime = authority_powertime;
	}
	
}
