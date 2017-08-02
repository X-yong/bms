package com.xy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 权限管理
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("auth")
public class AuthorityController {
	
	@RequestMapping("empower")
	public String empowerView() {	
		System.out.println("授权");
		return "main";
	}
	@RequestMapping("cancel")
	public String cancelView() {	
		System.out.println("撤销");
		return "main";
	}
	@RequestMapping("qryAuth")
	public String qryAuthority() {
		System.out.println("查询");
		return "main";
	}
	
}
