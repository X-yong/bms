package com.xy.enums;

public enum AuthorityEnum {
	admin("1", "系统管理员"), author("2", "作者"), reader("3", "读者");

	private String value;
	private String code;

	private AuthorityEnum(String value, String code) {
		this.setValue(value);
		this.setCode(code);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static String getValuesByCode(String id) {
		StringBuffer str = new StringBuffer();
		for (AuthorityEnum date : AuthorityEnum.values()) {
			if (id != null && id.indexOf(date.value) != -1) {
				str.append(date.code);
				str.append(" ");
			} 
		}
		return str.toString();
	}

}
