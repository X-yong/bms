package com.xy.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.constants.constants;
import com.xy.service.BookService;

@Controller
@RequestMapping("deleteBookController")
public class DeleteBookController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("deleteBook")
	@ResponseBody
	public String deleteBook(HttpServletRequest request,HttpServletResponse response) {
		try {
			String b_id[] =request .getParameterValues(constants.checks);
			List iList = new ArrayList();
			for (int i = 0; i < b_id.length; i++) {
				iList.add(b_id[i]);
			}
			Integer rInteger = bookService.deleteBookService(iList);
			if (rInteger != null) {
				return "success";
			}
			
		} catch (Exception e) {
			if(e instanceof RuntimeException) {
			    String mess =  e.getMessage();
		        return mess;	
			}
				e.printStackTrace();					
		}
		return "fail";
	}
	
}
