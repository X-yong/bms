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
@RequestMapping("qryBorrowAndReturnBookController")
public class QryBorrowAndReturnBookController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("qryBorrowAndReturnBook")
	public String  qryBorrowAndReturnBook(HttpServletRequest request, BorrowBookVo borrowBookVo) {
		try {
			request.setAttribute(constants.echo,borrowBookVo);
			/************************分页**********************************/
			String cPage = request.getParameter(constants.currPage);
			if (cPage == null) {
				cPage = "1";
			}
			Integer currPage = Integer.valueOf(cPage);
			Integer allRows = bookService.getAllBorrowBookRowService();
			Integer allPage = allRows%10 ==0?allRows/10:allRows/10+1;
			Integer startPage = (currPage-1)*10;
			borrowBookVo.setStart(startPage);
			
			List result = bookService.qryReturnAndBorrowBookService(borrowBookVo);
			if(result.size() > 0) {
				request.setAttribute(constants.result,result);
				request.setAttribute(constants.allPage, allPage);
				request.setAttribute(constants.currPage, currPage);
			} else {
				request.setAttribute(constants.mess,"未查询到信息");
			}
		} catch (Exception e) {
			e.printStackTrace();
            e.getMessage();
            return "books/qryBorrowBook"; 
	    }
	
		return "books/qryBorrowBook"; 
	}
	
	
}
