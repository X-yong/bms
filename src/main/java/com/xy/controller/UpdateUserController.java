package com.xy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.service.UserService;
import com.xy.vo.UserVo;

@Controller
@RequestMapping("updateUserController")
public class UpdateUserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("updateUser")

	public String updateUser(HttpServletRequest request, UserVo userVo) {
		try {  
            String auth_id = request.getParameter(constants.auth_id);
			Integer uInteger = userService.updateUserByIdService(userVo);
            if (uInteger != 0 ) {
            	if ( "3".equals(auth_id)) {
            		return "user/userInfo";
				} else if ("2".equals(auth_id)) {
					return "user/authorInfo";
				}
				
			} else {
				request.setAttribute(constants.result, userVo);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return "user/updateInfo";
	}
	
}
