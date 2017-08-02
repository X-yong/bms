package com.xy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.service.BookService;
import com.xy.util.CreateTime;
import com.xy.vo.BorrowBookVo;
/**
 * 图书续借
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("reletBookController")
public class ReletBookController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("reletBook")
	public String reletBook(HttpServletRequest request, BorrowBookVo borrowBookVo) {
		try {
            String shtime = borrowBookVo.getSh_time();
		    String sh_time = new CreateTime().getDateAddDay(shtime, borrowBookVo.getB_relet());
	        if (sh_time == null) {
	        	request.setAttribute(constants.mess, "续借图书失败");
	        	return "books/qryBorrowBook";
			}
		    borrowBookVo.setSh_time(sh_time);
	        Integer riInteger = bookService.reletBookService(borrowBookVo);
            if (riInteger == null) {
				request.setAttribute(constants.mess, "续借图书失败");
			}	
		} catch (Exception e) {
			request.setAttribute(constants.mess, "系统发送异常");
			e.getMessage();
			e.printStackTrace();
			return "books/qryBorrowBook";
		}
		return "books/qryBorrowBook";
	}
	
}
