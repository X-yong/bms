package com.xy.controller;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.xy.constants.constants;
import com.xy.service.BookService;
import com.xy.util.ReadExcelXSSF;
	
@Controller
@RequestMapping("importBookController")
public class ImportBookController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("importBook")
	public String  importBook(HttpServletRequest request,  MultipartFile file) {
		try {
			InputStream in = file.getInputStream();
			ReadExcelXSSF readExcelXSSF = new ReadExcelXSSF();
			String[] head = {"b_id","b_name","b_author","b_press","b_type","b_price",
					           "b_isbn","b_kind","b_revision","b_stock","b_remark"};
			List list = readExcelXSSF.readXls(in, head);
			Integer rInteger =  bookService.importBookService(list);
			if (rInteger == 1) {
				request.setAttribute(constants.mess,"导入成功");
			} else {
				request.setAttribute(constants.mess, "导入失败！");
			}
			List typeList = bookService.getBookTypeService();
		    request.setAttribute(constants.bookType, typeList);
		} catch (Exception e) {
			e.printStackTrace();
            e.getMessage();
            return "books/bookInfo"; 
	    }
		
		return "books/bookInfo"; 
	}
	
	
}
