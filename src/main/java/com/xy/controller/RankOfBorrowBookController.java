package com.xy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.service.BookService;
/**
 * 图书借阅排行
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("rankOfBorrowBookController")
public class RankOfBorrowBookController {

	@Resource
	private BookService bookService;

	@RequestMapping("rankOfBorrowBook")
	public String rankOfBorrowBook(HttpServletRequest request) {
		try {
			String b_kind = request.getParameter(constants.b_kind);
		    List rlList = bookService.rankOfBorrowService(b_kind);
			if (rlList.size() > 0) {
				request.setAttribute(constants.result, rlList);
			}
		} catch (Exception e) {
			request.setAttribute(constants.mess, "系统出现异常");
			e.printStackTrace();
			e.getMessage();
			return "books/rankOfBorrowBook";
		}

		return "books/rankOfBorrowBook";
	}

}
