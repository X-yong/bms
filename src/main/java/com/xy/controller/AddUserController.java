package com.xy.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.xy.constants.constants;
import com.xy.service.AuthorityService;
import com.xy.service.UserService;
import com.xy.vo.AuthorityVo;
import com.xy.vo.UserVo;

@Controller
@RequestMapping("addUserController")
public class AddUserController {
	
	@Resource
	private UserService userService;

	@Resource
	private AuthorityService authorityService;
	
	@RequestMapping("addUser")
	public String addUser(HttpServletRequest request ,UserVo userVo, MultipartFile file ) {
		try {
			request.setAttribute(constants.echo, userVo);
			String u_role = request.getParameter(constants.u_role);
			/***********************图片上传*****************************/
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		    String date = sdf.format(new Date());  //设置时间格式
			String path = request.getServletContext().getRealPath("/");//获取项目的绝对路径
		    System.out.println(path+"upload/"+date+file.getOriginalFilename());	
		    if (!file.isEmpty()) {
		    	 String p = "/upload/img/"+date+file.getOriginalFilename(); 
				 userVo.setU_photo(p);//将图片路径存到数据库
			} else {
				 userVo.setU_photo("");
			}
		    AuthorityVo authorityVo = new AuthorityVo();
		    authorityVo.setU_id(userVo.getU_id());
		    authorityVo.setAuthority_id(u_role);
		    authorityVo.setAuthority_powerperson("");
		    //校验账户是否存在
		    UserVo iVo = new UserVo();
		    iVo.setU_idCard(userVo.getU_idCard());
		    List rList = userService.selectUserInfoService(iVo);
		    
			if (rList.size() <= 0) {
				
			} else {
				  request.setAttribute("mess", "该身份证号已存在！！");
				  return "user/register";
			}
			Integer rInteger = userService.userRegistrationService(userVo);
			authorityService.insertAuthorityService(authorityVo);
		    if (rInteger != null && !file.isEmpty()) {
				   file.transferTo(new File(path+"/upload/img/"+date+file.getOriginalFilename()));
			}
		} catch (Exception e) {
			e.getMessage();
			return "user/register";
		}
	    request.setAttribute("mess", "注册成功");
		return "login";
	}
	
	
}
