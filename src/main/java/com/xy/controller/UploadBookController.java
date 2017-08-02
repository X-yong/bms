package com.xy.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.xy.constants.constants;
import com.xy.enums.BookTypeEnum;
import com.xy.service.BookService;
import com.xy.service.UserService;
import com.xy.vo.BookVo;
/**
 * 图书上传	
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("uploadBookController")
public class UploadBookController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private BookService bookService;

	@RequestMapping("uploadBook")
	public String uploadBook(HttpServletRequest request , MultipartFile[] file ,BookVo bookVo) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		    String date = sdf.format(new Date());  //设置时间格式
			String path = request.getServletContext().getRealPath("/");//获取项目的绝对路径
			
		    System.out.println(path+"upload/img/"+"date"+file[0].getOriginalFilename());	
		    String shortName = BookTypeEnum.getshortNameByCode(bookVo.getB_type());
		    String imgPath ="upload/img/"+date+file[0].getOriginalFilename();//图片路径
		    String docPath = "upload/doc/"+date+file[1].getOriginalFilename();//文档路径
		    bookVo.setB_url(docPath);
		    bookVo.setB_imgurl(imgPath);
		 	bookVo.setB_id(shortName);
		 	bookVo.setB_kind(0);//设置种类为纸质图书
		    Integer rInteger = bookService.addBookService(bookVo);
		    if (rInteger > 0) {
	    	    file[0].transferTo(new File(path+"upload/img/"+date+file[0].getOriginalFilename()));//封面
			    file[1].transferTo(new File(path+"upload/doc/"+date+file[1].getOriginalFilename()));//文档
			    request.setAttribute(constants.mess, "图书上传成功");
			}
		    
			List typeList = bookService.getBookTypeService();
			request.setAttribute(constants.bookType, typeList); 
		
		} catch (Exception e) {
			request.setAttribute(constants.mess, "系统发生异常");
			e.printStackTrace();
			e.getMessage();
			return "mybook/upLoadBook";
		}
		return "mybook/upLoadBook";
	}
	
	
}
