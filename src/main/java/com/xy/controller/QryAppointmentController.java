package com.xy.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.service.BookService;
import com.xy.vo.BorrowBookVo;
/**
 * 预约查询
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("qryAppointmentController")
public class QryAppointmentController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("qryAppointment")
	public String  qryAppointment(HttpServletRequest request, BorrowBookVo borrowBookVo) {
		try {
	       
	        /************************分页**********************************/
			String cPage = request.getParameter(constants.currPage);
			if (cPage == null) {
				cPage = "1";
			}
			Integer currPage = Integer.valueOf(cPage);
			Integer allRows = bookService.getAppointmentCountService();
			Integer allPage = allRows%10 ==0?allRows/10:allRows/10+1;
			Integer startPage = (currPage-1)*10;
			borrowBookVo.setStart(startPage);

			
			DateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			List rList =  bookService.qryAppointmentService(borrowBookVo);
	        if (rList.size() > 0) {
	        	for (int i = 0; i < rList.size(); i++) {
	        		BorrowBookVo r = (BorrowBookVo) rList.get(i);
	        		String time = dt1.format(r.getB_appointtime()); 
	        		r.setBr_time(time);
				}      	
	        	request.setAttribute(constants.result, rList);	
	        	request.setAttribute(constants.allPage, allPage);
				request.setAttribute(constants.currPage, currPage);
			} else {
				request.setAttribute(constants.mess, "没有预约记录");
			}
		} catch (Exception e) {
			request.setAttribute(constants.mess, "发生系统错误");
			e.printStackTrace();
			e.getMessage();
			return "books/qryAppointment";
	    }
		return "books/qryAppointment";
	}
}
