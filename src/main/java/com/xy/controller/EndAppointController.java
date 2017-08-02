package com.xy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.service.BookService;
/**
 * 预约结束
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("endAppointController")
public class EndAppointController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("endAppoint")
	public String endAppoint(HttpServletRequest request) {
		try {
			String id[] =request .getParameterValues(constants.checks);
			String b_id[] =request .getParameterValues(constants.b_id);
			
			bookService.deleteAppointmentService(id,b_id);
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return "books/qryAppointment";
		}
		return "books/qryAppointment";
	}
	
}
