package com.xy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.service.BookService;
import com.xy.service.UserService;
import com.xy.vo.BookVo;
import com.xy.vo.UserVo;

@Controller
@RequestMapping("updateBookController")
public class UpdateBookController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("updateBook")
	public String updateBook(HttpServletRequest request, BookVo bookVo) {
		try { 
		   Integer rInteger = bookService.updateBookService(bookVo);
			if (rInteger == 0) {
				request.setAttribute(constants.mess, "修改图书信息失败！");
				return "books/updateBook";
			} else {
				request.setAttribute(constants.mess, "修改图书信息成功！");
			}
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return "books/updateBook";
		}
		return "books/bookInfo";
	}
	
}
