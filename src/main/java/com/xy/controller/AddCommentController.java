package com.xy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.constants.constants;
import com.xy.entity.User;
import com.xy.service.BookService;
/**
 *插入评论 
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("addCommentController")

public class AddCommentController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("addComment")
	@ResponseBody
	public String addComment(HttpServletRequest request) {
		try {
		    String b_id = request.getParameter(constants.b_id); 
			String c_comment = request.getParameter(constants.comment);
		    User user = (User) request.getSession().getAttribute(constants.loginInfo);
			String u_id = user.getU_id();
			String u_name = user.getU_name();
		    Map map = new HashMap();
		    map.put(constants.b_id, b_id);
		    map.put(constants.comment, c_comment);
		    map.put(constants.u_id, u_id);
		    map.put(constants.u_name, u_name);
		    map.put(constants.c_reply, "");
		    Integer rInteger = bookService.addCommentService(map);
			if (rInteger != null) {
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
            e.getMessage();
            return "fail"; 
	    }
	
		return "fail"; 
	}
	
	
}
