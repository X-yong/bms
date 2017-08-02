package com.xy.enums;

public enum BookTypeEnum {
	literature("1", "文学","lr"),
	novel("2", "小说","nv"),
	youth("3", "青春","yt"),
	art("4", "艺术","at"),
	comic("5", "动漫","cm"),
	amusement("6", "娱乐","am"),
	tour("7", "旅游","to"),
	geography("8", "地理","go"),
	lift("9", "生活","lf"),
	sports("10", "体育","sp"),
	admin("11", "管理","am"),
	economic("12", "经济","em"),
	philosophy("13", "哲学","pl"),
	law("14", "法律","la"),
	science("15", "科学","sc"),
	computer("16", "计算机","cp");

	private String value;
	private String code;
	private String shortName;

	
	private BookTypeEnum(String value, String code, String shortName) {
		this.value = value;
		this.code = code;
		this.setShortName(shortName);
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public static String getValuesByCode(String id) {
		StringBuffer str = new StringBuffer();
		for (BookTypeEnum date : BookTypeEnum.values()) {
			if (id != null && id.indexOf(date.value) != -1) {
			   str.append(date.code);
			} 
		}
		return str.toString();
	}
     /**
	  * 通过ID获取简称
	  * @param id
	  * @return
	  */
	public static String getshortNameByCode(String id) {
		
		for (BookTypeEnum date : BookTypeEnum.values()) {
			if (id != null && id.equals(date.value)) {
				  return date.shortName;
			} 
		}
		return "";
	}

}
