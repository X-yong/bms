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
 * 电子图书信息查询	
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("qryEBookController")
public class QryEBookController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("qryEBook")
	public String qryEBook(HttpServletRequest request, BookVo bookVo) {
		try {
			request.setAttribute(constants.echo, bookVo);
			List rList = bookService.getBookTypeService();
			request.setAttribute(constants.bookType, rList);
			
			/************************分页**********************************/
			String cPage = request.getParameter(constants.currPage);
			if (cPage == null) {
				cPage = "1";
			}
			Integer currPage = Integer.valueOf(cPage);
			Integer allRows = bookService.getAllBookRowsService("0");//1表示纸质书
			Integer allPage = allRows%10 ==0?allRows/10:allRows/10+1;
			Integer startPage = (currPage-1)*10;
			bookVo.setStart(startPage);
					
			List rlist = bookService.selectBookInfoService(bookVo);
			if (rlist.size() > 0) {
				request.setAttribute(constants.result, rlist);
				request.setAttribute(constants.allPage, allPage);
				request.setAttribute(constants.currPage, currPage);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
            e.getMessage();
	    }
	
		return "books/eBook"; 
	}
	
	
}
