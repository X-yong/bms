package com.xy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.service.BookService;
import com.xy.service.UserService;
import com.xy.vo.BorrowBookVo;
/**
 * 还书
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("returnUserBorrowBookController")
public class ReturnUserBorrowBookController {

	@Resource
	private BookService bookService;

	@Resource
	private UserService userService;

	@RequestMapping("returnUserBorrowBook")
	public String returnUserBorrowBook(HttpServletRequest request, BorrowBookVo borrowBookVo) {
		try {
			
			String[] id = request.getParameterValues(constants.checks);
			String[] bids = request.getParameterValues("bids");
			
			List<String> idList = new ArrayList<String>();
			for (int i = 0; i < id.length; i++) {
				idList.add(id[i]);
			}
			List<String> iList = new ArrayList<String>();
			for (int i = 0; i < bids.length; i++) {
				iList.add(bids[i]);
			}
			borrowBookVo.setIdList(idList);
			borrowBookVo.setBidList(iList);
			
		  Integer rInteger =  bookService.returnBookService(borrowBookVo);
		  if (rInteger !=  null) {
			  request.setAttribute(constants.mess, "还书成功，欢迎再次借阅");
		  } else {
			  request.setAttribute(constants.mess, "还书失败");
		  }
		   
		} catch (Exception e) {
			 request.setAttribute(constants.mess, "发生系统错误");
			e.printStackTrace();
			e.getMessage();
			return "books/returnBook";
		}

		return "books/returnBook";
	}

}
