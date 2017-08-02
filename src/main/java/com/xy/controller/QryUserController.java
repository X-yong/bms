package com.xy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.constants.constants;
import com.xy.entity.User;
import com.xy.service.UserService;
import com.xy.vo.UserVo;
	
@Controller
@RequestMapping("qryUserController")
public class QryUserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("qryUserInfo")
	public String  qryUserInfo(HttpServletRequest request, UserVo userVo) {
		try {
			HttpSession session = request.getSession();
			String startDate = request.getParameter(constants.startDate);
			String endDate = request.getParameter(constants.endDate);
		
	        userVo.setU_startDate(startDate);
	        userVo.setU_endDate(endDate);
	        request.setAttribute(constants.echo,userVo);
	        
	        //Integer root = (Integer) session.getAttribute(constants.root);
	        userVo.setRoot(UserVo.root);;
	        /************************分页**********************************/
			
	        String cPage = request.getParameter(constants.currPage);
			if (cPage == null) {
				cPage = "1";
			}
			Integer currPage = Integer.valueOf(cPage);
			Integer allRows = userService.getAllUserRowsDao(userVo.getU_role());
			Integer allPage = allRows%10 ==0?allRows/10:allRows/10+1;
			Integer startPage = (currPage-1)*10;
			userVo.setStart(startPage);
	        
	        List rlList = userService.selectUserInfoService(userVo);
	        if (rlList.size() > 0) {
	        	request.setAttribute(constants.result, rlList);	
	        	request.setAttribute(constants.allPage, allPage);
				request.setAttribute(constants.currPage, currPage);
			} 
		} catch (Exception e) {
            e.printStackTrace();
			e.getMessage();
          
	    }
		if ("3".equals(userVo.getU_role())) {
			 return "user/userInfo";
		} else {
			 return "user/authorInfo";
		}
		 
	}
	
	@RequestMapping("qryRepeat")
	@ResponseBody
	public String  qryRepeat(HttpServletRequest request, UserVo userVo) {
		try {
			String root = request.getParameter(constants.root);
		    userVo.setRoot(Integer.parseInt(root));
	        List rlList = userService.selectUserInfoService(userVo);
	        if (rlList.size() == 0) {
	        	 return "yes";
			} 
		} catch (Exception e) {
            e.getMessage();
          
	    }
		  return "no";
	}
}
