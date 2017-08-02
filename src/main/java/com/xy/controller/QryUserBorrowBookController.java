package com.xy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.service.BookService;
import com.xy.vo.BorrowBookVo;
/**
 * 用户借阅查询	
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("qryUserBorrowBookController")
public class QryUserBorrowBookController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("qryUserBorrowBook")
	public String  qryUserBorrowBook(HttpServletRequest request, BorrowBookVo borrowBookVo) {
		try {
			request.setAttribute(constants.echo,borrowBookVo);
		    List result = bookService.qryReturnAndBorrowBookService(borrowBookVo);
			if(result.size() > 0) {
				request.setAttribute(constants.result,result);
			} else {
				request.setAttribute(constants.mess,"未查询到信息");
			}
		} catch (Exception e) {
			e.printStackTrace();
            e.getMessage();
            return "books/returnBook"; 
	    }
	
		return "books/returnBook"; 
	}
	
	
}
