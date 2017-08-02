package com.xy.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.constants.constants;
import com.xy.service.BookService;

@Controller
@RequestMapping("saveBookController")
public class SaveBookController {
	
	@Resource
	private BookService bookService;
	
	
	@RequestMapping("saveBook")
	@ResponseBody
	public String saveBook(HttpServletRequest request) {
		  FileWriter fw= null;
		  BufferedWriter bw = null;
		  BufferedReader br = null;
		try {
		  String content = request.getParameter(constants.content);
		 // content = content.replaceAll(" ", "\n");
		  String b_name = request.getParameter(constants.b_name);
		  String path = request.getServletContext().getRealPath("/");//获取项目的绝对路径
		   br = new BufferedReader(new StringReader(content));
		   fw = new FileWriter(path+"upload/doc/"+b_name+".txt", true);
           bw = new BufferedWriter(fw);
           String txt ;
		   while((txt = br.readLine()) != null) {
			   bw.write(txt); 
			   bw.newLine();
		   }
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return "fail";
		} finally {
			  try {
				  br.close();
				  bw.close();
				  fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "success";
	}
	
}
