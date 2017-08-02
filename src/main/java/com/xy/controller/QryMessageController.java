package com.xy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.entity.User;
import com.xy.service.UserService;
import com.xy.vo.MessageVo;
import com.xy.vo.UserVo;
/**
 * 查询消息
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("qryMessageController")
public class QryMessageController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("qryMessage")
	public String  qryMessage(HttpServletRequest request, UserVo userVo) {
		try {
			HttpSession session = request.getSession();
		    User user = (User) session.getAttribute(constants.loginInfo);
		    MessageVo messageVo = new MessageVo();
		    String ru_id = user.getU_id();
		    messageVo.setRu_id(ru_id);
	      
	        /************************分页**********************************/
			String cPage = request.getParameter(constants.currPage);
			System.err.println(cPage);
			if (cPage == null) {
				cPage = "1";
			}
			Integer currPage = Integer.valueOf(cPage);
			Integer allRows = userService.getAllMessageRowsService(ru_id);
			Integer allPage = allRows%10 ==0?allRows/10:allRows/10+1;
			Integer startPage = (currPage-1)*10;
			messageVo.setStart(startPage);
	        
	        List rlList = userService.getMessageService(messageVo);
	        if (rlList.size() > 0) {
	        	request.setAttribute("s_message", rlList);	
	        	request.setAttribute(constants.allPage, allPage);
				request.setAttribute(constants.currPage, currPage);
			} 
		} catch (Exception e) {
			request.setAttribute(constants.mess, "发生系统错误");
			e.printStackTrace();
			e.getMessage();
			return "user/getmessage";
	    }
		return "user/getmessage";
	}
}
