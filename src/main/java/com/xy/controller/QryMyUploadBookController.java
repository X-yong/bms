package com.xy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.entity.User;
import com.xy.service.BookService;
import com.xy.vo.BookVo;
/**
 * 已上传图书信息查询	
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("qryMyUploadBookController")
public class QryMyUploadBookController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("qryMyUploadBook")
	public String  qryMyUploadBook(HttpServletRequest request, BookVo bookVo) {
		try {
			request.setAttribute(constants.echo,bookVo);
			User user = (User) request.getSession().getAttribute(constants.loginInfo);
			String u_id = user.getU_id();
			bookVo.setB_authorid(u_id);
		
			List rList = bookService.getBookTypeService();
			request.setAttribute(constants.bookType, rList);
			List rlist = bookService.selectBookInfoService(bookVo);
			if (rlist.size() > 0) {
				request.setAttribute(constants.result, rlist);
				request.setAttribute(constants.allrow,rlist.size() );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
            e.getMessage();
	    }
	
		return "mybook/myBook"; 
	}
	
	
}
