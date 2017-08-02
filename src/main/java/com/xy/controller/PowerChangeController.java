package com.xy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.service.UserService;
import com.xy.vo.UserVo;
/**
 * 权限修改	
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("powerChangeController")
public class PowerChangeController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("powerChange")
	public String  powerChange(HttpServletRequest request, UserVo userVo) {
		try {
			HttpSession session = request.getSession();
			String startDate = request.getParameter(constants.startDate);
			String endDate = request.getParameter(constants.endDate);
	        userVo.setU_startDate(startDate);
	        userVo.setU_endDate(endDate);
	        request.setAttribute(constants.echo,userVo);	
	      //  Integer root = (Integer) session.getAttribute(constants.root);
	        userVo.setRoot(UserVo.root);
	        List rlList = userService.selectUserInfoService(userVo);
	        if (rlList.size() > 0) {
	        	request.setAttribute(constants.result, rlList);	
			} 
		} catch (Exception e) {
            e.getMessage();
          
	    }
		  return "authority/userPowerInfo";
	}
	
}
