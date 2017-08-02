package com.xy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.entity.User;
import com.xy.service.AuthorityService;
import com.xy.service.UserService;
import com.xy.vo.AuthorityVo;
import com.xy.vo.UserVo;

@Controller
@RequestMapping("grantPowerController")
/**
 * 授权
 * @author soonsmile
 *
 */
public class GrantPowerController {

	@Resource
	private AuthorityService authorityService;
	
	@Resource
	private UserService userService;

	@RequestMapping("grantPower")
	
	public String grantPower(HttpServletRequest request, AuthorityVo authorityVo) {
		try {
		    HttpSession session = request.getSession();
		    User user = (User) session.getAttribute(constants.loginInfo);
			String u_role[] = request.getParameterValues(constants.u_role);
			StringBuffer auth_id = new StringBuffer();
			for (int i = 0; i < u_role.length; i++) {
				auth_id.append(u_role[i]);
			}
			authorityVo.setAuthority_id(auth_id.toString());
            authorityVo.setAuthority_powerperson(user.getU_name());
          
            authorityService.grantAuthorityService(authorityVo);
		} catch (Exception e) {
			e.getMessage();
			return "authority/grantPower";
		}
		
		return "authority/userPowerInfo";
	}

}
