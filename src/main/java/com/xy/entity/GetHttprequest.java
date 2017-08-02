package com.xy.entity;

import javax.servlet.http.HttpServletRequest;

public class GetHttprequest {
	private static HttpServletRequest request;
	private static HttpServletRequest reponse;
	private static GetHttprequest instance;
	public static String s ;
	
	public static HttpServletRequest getRequest() {
		return request;
	}
	public static void setRequest(HttpServletRequest request) {
		GetHttprequest.request = request;
	}
	public static HttpServletRequest getReponse() {
		return reponse;
	}
	public static void setReponse(HttpServletRequest reponse) {
		GetHttprequest.reponse = reponse;
	}
	public static GetHttprequest getInstance() {
		if (instance == null) {
			instance = new GetHttprequest();
		}
		return instance;
	}
	public static void setInstance(GetHttprequest instance) {
		GetHttprequest.instance = instance;
	}
	public static String getS() {
		return s;
	}
	public static void setS(String s) {
		GetHttprequest.s = s;
	}
	
	

}
