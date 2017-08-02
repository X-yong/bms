package com.xy.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.xy.constants.constants;
import com.xy.entity.User;
import com.xy.service.UserService;
import com.xy.vo.UserVo;

@Controller
@RequestMapping("updatePersionController")
public class UpdatePersionController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("updatePersion")
	public String updateUser(HttpServletRequest request, UserVo userVo,MultipartFile file) {
		try { 
			HttpSession session = request.getSession();
			/***********************图片上传*****************************/
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		    String date = sdf.format(new Date());  //设置时间格式
			String path = request.getServletContext().getRealPath("/");//获取项目的绝对路径
		    System.out.println(path+"upload/"+date+file.getOriginalFilename());	
		    if (!file.isEmpty()) {
		    	 String p = "/upload/img/"+date+file.getOriginalFilename(); 
				 userVo.setU_photo(p);//将图片路径存到数据库
				 file.transferTo(new File(path+"upload/img/"+date+file.getOriginalFilename()));
			} else {
				 userVo.setU_photo("");
			}			
			Integer uInteger = userService.updateUserByIdService(userVo);
            if (uInteger != null) {
            	request.setAttribute(constants.mess,"信息修改成功");
            	UserVo userVo2 = new UserVo();
            	userVo2.setU_id(userVo.getU_id());
			    List rList = userService.selectUserInfoService(userVo2);
                if (rList.size() > 0) {
					User user = (User) rList.get(0);
					session.setAttribute(constants.loginInfo, user);
				}			 
            }
			
		} catch (Exception e) {
			e.getMessage();
			return "user/persionInfo";
		}
		return "user/persionInfo";
	}
	
}
