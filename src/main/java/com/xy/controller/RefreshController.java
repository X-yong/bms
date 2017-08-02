package com.xy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
	
@Controller
@RequestMapping("refreshController")

public class RefreshController {
	
	@RequestMapping("refresh")
	@ResponseBody
	public Integer  refresh(HttpServletRequest request) {
		HttpSession session = request.getSession();
	    Integer count = (Integer)session.getAttribute("count");
		return count; 
	}
	
	
}
