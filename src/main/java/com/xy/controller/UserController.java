package com.xy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.constants.constants;
import com.xy.entity.User;
import com.xy.enums.AuthorityEnum;
import com.xy.service.AuthorityService;
import com.xy.service.UserService;
import com.xy.timeTask.AutoChangeMessages;
import com.xy.vo.UserVo;

@Controller
@RequestMapping("userLoginController")
public class UserController {
	
	@Resource
	private UserService userService;
	@Resource
	private AuthorityService authorityService ;
	
	
	/**
	 * 登录验证
	 * @return
	 */
	@RequestMapping("checkLogin")
	@ResponseBody
	public String checkLogin(UserVo userVo, HttpServletRequest request){
		System.out.println("登录校验");
		HttpSession longinSession = request.getSession();
		
		request.setAttribute("loginInfo", userVo);

		User rLogin = userService.loginService(userVo);
		if (rLogin != null ) {
			String auth_id = rLogin.getAuthority().getAuthority_id();
			String authName = AuthorityEnum.getValuesByCode(auth_id);
		    if (auth_id != null && auth_id != "" ) {
			    longinSession.setAttribute("auth",auth_id);
		    } else {
			    longinSession.setAttribute("auth", "");
		    }
			   longinSession.setAttribute(constants.loginInfo, rLogin);
			   AutoChangeMessages.setSess(longinSession);
			   AutoChangeMessages thread = new AutoChangeMessages(userService);
			   AutoChangeMessages.exit = true;
			   thread.start();
			   longinSession.setAttribute(constants.u_role,authName);
			   if ("001".equals(userVo.getU_id())) {
				   UserVo.root = 1;
			   } else {
				   UserVo.root = null;
			   }
			return "success";
		} else {
			return "fail";
		}
			
	}
	
}
