package com.xy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.entity.User;
import com.xy.service.UserService;
import com.xy.vo.MessageVo;
/**
 * 发送消息
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("saveMessageController")
public class SaveMessageController {
  
	@Resource
	private UserService userService;
   	
	@RequestMapping("saveMessage")
	public String saveMessage(HttpServletRequest request) {
		
		try {
			String[] ru_id  = request.getParameterValues("ru_id");
			String s_content = request.getParameter(constants.s_content);
		    User user = (User)request.getSession().getAttribute(constants.loginInfo); 
		    String su_id = user.getU_id();
		    Map map = new HashMap();
		    map.put("su_id", su_id);
		    map.put("s_content", s_content);
		    for (int i = 0; i < ru_id.length; i++) {
				map.put("ru_id", ru_id[i]);
				userService.insertMessageService(map);
			}	
		    
		    String ruid = user.getU_id();

			Integer currPage = 1;
			Integer allRows = userService.getAllMessageRowsService(ruid);
			Integer allPage = allRows%10 ==0?allRows/10:allRows/10+1;
			MessageVo messageVo = new MessageVo();
			messageVo.setRu_id(ruid);
			
	        List rlList = userService.getMessageService(messageVo);
		    request.setAttribute(constants.mess, "回复成功");
		    request.setAttribute("s_message", rlList);	
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return "user/getmessage";
		} 
		return "user/getmessage";
	}
	
}
