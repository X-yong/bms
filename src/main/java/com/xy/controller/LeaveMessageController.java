package com.xy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.entity.User;
import com.xy.service.UserService;
/**
 * 留言
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("leaveMessageController")
public class LeaveMessageController {
  
	@Resource
	private UserService userService;
   	
	@RequestMapping("leaveMessage")
	public String leaveMessage(HttpServletRequest request) {
		
		try {
			String s_content = request.getParameter(constants.s_content);
		    User user = (User)request.getSession().getAttribute(constants.loginInfo); 
		    String su_id = user.getU_id();
		    Map map = new HashMap();
		    map.put("su_id", su_id);
		    map.put("s_content", s_content);
		    map.put("ru_id", "001");
	
			userService.insertMessageService(map);	
		    request.setAttribute(constants.mess, "留言成功");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return "user/leaveMessage";
		} 
		return "user/leaveMessage";
	}
	
}
