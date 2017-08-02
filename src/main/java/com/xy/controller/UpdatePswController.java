package com.xy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.constants.constants;
import com.xy.entity.User;
import com.xy.service.UserService;
import com.xy.vo.UserVo;

@Controller
@RequestMapping("updatePswController")
public class UpdatePswController {

	@Resource
	private UserService userService;

	@RequestMapping("resetPsw")
	@ResponseBody
	public String resetPsw(HttpServletRequest request, UserVo userVo) {
		try {
           String u_rpassword = request.getParameter(constants.u_rpassword);
           String u_spassword = request.getParameter("u_spassword");
			List rlist = userService.selectUserInfoService(userVo);
            User ruser = (User) rlist.get(0);
            String psw = ruser.getU_password();
            if(u_spassword != null) {
               if (!userVo.getU_password().equals(psw)) {
			     return "noAccordant";
			   }
            }
            userVo.setU_password(u_rpassword);
			Integer rInteger = userService.updateUserByIdService(userVo);
			if (rInteger == null) {
				return "fail";
			}
		} catch (Exception e) {
			e.getMessage();
			return "fail";
		}
		request.getSession().removeAttribute(constants.loginInfo);
		return "success";
	}

}
