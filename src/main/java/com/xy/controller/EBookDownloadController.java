package com.xy.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.entity.Book;
import com.xy.entity.User;
import com.xy.service.BookService;
import com.xy.service.UserService;
/**
 *电子 图书下载
 * @author soonsmile	
 *
 */
@Controller
@RequestMapping("eBookDownloadController")
public class EBookDownloadController {

	@Resource 
	private BookService bookService;
	@Resource 
	private UserService userService;
	
	@RequestMapping("eBookDownload")
	public String eBookDownload(HttpServletRequest request, HttpServletResponse response) {
		InputStream   in = null;
		OutputStream  out = null;
		try {
			// 获得请求文件名
			String filePath = request.getParameter("filePath");	
			String b_id = request.getParameter(constants.b_id);
			
			User user = (User) request.getSession().getAttribute(constants.loginInfo);
			User ruser = userService.getUserInfoByIdService(user.getU_id());
			Double balance = ruser.getU_balance();
			Book  book = bookService.getBookInfoByidService(b_id);
			Double price  = book.getB_price();
			if(balance <= price) {
				request.setAttribute(constants.mess, "对不起，此图书为付费图书，您的余额不足");
				return null;
			}
			// 获取目标文件的绝对路径
			String fullFileName = request.getSession().getServletContext().getRealPath(filePath);
		    // 读取文件	
			in = new FileInputStream(fullFileName);
			// 读取目标文件，通过response将目标文件写到客户端
			out = response.getOutputStream();
			String fileName = filePath.substring(11);
			// 设置文件MIME类型
			response.setContentType(request.getSession().getServletContext().getMimeType(fileName));
			// 设置Content-Disposition
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			
			// 写文件
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			out.flush();
			in.close();
			out.close();
			
			bookService.downloadBookService(b_id);
		    
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(constants.mess, "系统异常");
			return "relatedmy/eBookDownload" ;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if(out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
