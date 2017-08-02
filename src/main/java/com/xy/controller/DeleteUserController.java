package com.xy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.constants.constants;
import com.xy.service.UserService;
import com.xy.vo.UserVo;

@Controller
@RequestMapping("deleteUserController")
public class DeleteUserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("deleteUser")
	@ResponseBody
	public String deleteUser(HttpServletRequest request ,UserVo userVo) {
		try {
			String u_id[] =request .getParameterValues(constants.checks);
			List iList = new ArrayList();
			for (int i = 0; i < u_id.length; i++) {
				iList.add(u_id[i]);
			}
			Integer rInteger = userService.deleteUserByIdService(iList);
			if (rInteger != null) {
				return "success";
			}
		} catch (Exception e) {
			if(e instanceof RuntimeException) {
			    String mess =  e.getMessage();
		        return mess;	
			}
			e.printStackTrace();
		}
		return "fail";
	}
	
}
