package com.xy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.enums.BookTypeEnum;
import com.xy.service.BookService;
import com.xy.vo.BookVo;
	
@Controller
@RequestMapping("addBookController")
public class AddBookController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("addBook")
	public String  addBook(HttpServletRequest request, BookVo bookVo) {
		try {
			
		    String shortName = BookTypeEnum.getshortNameByCode(bookVo.getB_type());
			bookVo.setB_id(shortName);
			bookVo.setB_kind(1);//设置种类为纸质图书
		    bookService.addBookService(bookVo);
			
		} catch (Exception e) {
			request.setAttribute(constants.echo, bookVo);//回显
			e.printStackTrace();
            e.getMessage();
            return "books/addBook"; 
	    }
	
		return "books/bookInfo"; 
	}
	
	
}
