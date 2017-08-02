package com.xy.enums;

public enum BorrowBookSteteEnum {
	borrow("0", "借阅中"),
	returned("1", "已归还"),
	outdate("2", "已逾期");
	

	private String value;
	private String code;
	

	
	private BorrowBookSteteEnum(String value, String code) {
		this.value = value;
		this.code = code;
		
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

	public static String getshortNameByCode(String id) {
		for (BorrowBookSteteEnum date : BorrowBookSteteEnum.values()) {
			if (id != null && id.equals(date.value)) {
				  return date.code;
			} 
		}
		return "";
	}

}
