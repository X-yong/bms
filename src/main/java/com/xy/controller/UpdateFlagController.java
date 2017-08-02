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
import com.xy.vo.BookVo;
import com.xy.vo.MessageVo;
/**
 * 标记消息已读
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("updateFlagController")
public class UpdateFlagController {
	
	@Resource
    private UserService userService;	
	
	@RequestMapping("updateFlag")
	public String updateFlag(HttpServletRequest request, BookVo bookVo) {
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute(constants.loginInfo);
	    
	    String[] id = request.getParameterValues(constants.checks);
		try { 
			Map map = new HashMap();
			map.put(constants.flag, 1);
			for (int i = 0; i < id.length; i++) {
				map.put(constants.ID, id[i]);
				userService.updateMessageByIdService(map);
			}
		
	        String ru_id = user.getU_id();

			Integer currPage = 1;
			Integer allRows = userService.getAllMessageRowsService(ru_id);
			Integer allPage = allRows%10 ==0?allRows/10:allRows/10+1;
			MessageVo messageVo = new MessageVo();
			messageVo.setRu_id(ru_id);
			
	        List rlList = userService.getMessageService(messageVo);
	        if (rlList.size() > 0) {
	        	request.setAttribute("s_message", rlList);	
	        	request.setAttribute(constants.allPage, allPage);
				request.setAttribute(constants.currPage, currPage);
			} 
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return "user/getmessage";
		}
		return "user/getmessage";
	}
	
}
