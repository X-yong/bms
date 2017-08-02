package com.xy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.service.BookService;
import com.xy.vo.BookVo;
/**
 * 查询借书信息
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("qryBookBorrowController")
public class QryBookBorrowController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("qryBookBorrow")
	public String  qryBookBorrow(HttpServletRequest request, BookVo bookVo) {
		try {
			request.setAttribute(constants.echo,bookVo);
			List rlist = bookService.selectBookInfoService(bookVo);
			if (rlist.size() > 0) {
				request.setAttribute(constants.result, rlist);
			} else {
				request.setAttribute(constants.mess, "该图书信息不存在");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
            e.getMessage();
	    }
	
		return "books/borrowBook"; 
	}
	
	
}
