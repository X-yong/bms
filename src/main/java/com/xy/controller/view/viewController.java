/**
 * 
 */
/**
 * @author soonsmile
 *
 */
package com.xy.controller.view;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.entity.Book;
import com.xy.entity.User;
import com.xy.enums.AuthorityEnum;
import com.xy.service.BookService;
import com.xy.service.UserService;
import com.xy.timeTask.AutoChangeMessages;
import com.xy.vo.BookVo;
import com.xy.vo.BorrowBookVo;
import com.xy.vo.UserVo;

@Controller
@RequestMapping("view")
public class viewController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private BookService bookService;
	/**
	 * 主界面
	 * @return
	 */
	@RequestMapping("mainView")
	public String mainView(){	
		return "main";
	}
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("login")
	public String login(HttpServletRequest request){
		HttpSession longinSession = request.getSession();
         if (longinSession.getAttribute(constants.loginInfo) != null ) {
        	 return "main";
		}
		return "login";
	}
	/**
	 * 退出
	 * @return
	 */
	@RequestMapping("exit")
	public String exit(HttpServletRequest request){
		HttpSession longinSession = request.getSession();
		longinSession.invalidate();
		AutoChangeMessages.exit = false;
		return "login";
	}
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("register")
	public String register(){	
		return "user/register";
	}
	//密码找回、重置
	@RequestMapping("getBackPsw")
	public String getBackPsw() {
		return "user/getBackPsw";
	}
	@RequestMapping("userInfo")
	public String userInfo() {
		return "user/userInfo";
	}
	//修改
	@RequestMapping("updateInfo")
	public String updateInfo(HttpServletRequest request, UserVo userVo ) {
		try {
			List result = userService.selectUserInfoService(userVo);
			if (result.size() > 0) {
				User rUserVo = (User) result.get(0);
				String auth_id = rUserVo.getAuthority().getAuthority_id();
				String authName = AuthorityEnum.getValuesByCode(auth_id);
				request.setAttribute(constants.result,rUserVo);
				request.setAttribute(constants.u_role,authName);
				request.setAttribute(constants.auth_id,auth_id);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		return "user/updateInfo";
	}
	//新增
	@RequestMapping("addUserInfo")
	public String addUserInfo() {
		return "user/addUserInfo";
	}
	
	//用户信息
	@RequestMapping("persionInfo")
	public String persionInfo() {
		
		return "user/persionInfo";
	}
	//密码修改
		@RequestMapping("resetPsw")
		public String resetPsw() {
			return "user/resetPsw";
		}
	/************作者信息*******************/
	@RequestMapping("authorInfo")
	public String authorInfo() {
		return "user/authorInfo";
	}
	/************权限管理***************************/
	
	@RequestMapping("userPowerInfo")
	public String userPowerInfo() {
		return "authority/userPowerInfo";
	}
	@RequestMapping("grantPower")
	public String grantPower(HttpServletRequest request, UserVo userVo) {
		String auth_id = request.getParameter(constants.auth_id);
		String authName = AuthorityEnum.getValuesByCode(auth_id);
		request.setAttribute(constants.userVo, userVo);
		request.setAttribute(constants.u_role, authName);
		return "authority/grantPower";
	}
	/**************图书管理************************/
	@RequestMapping("bookInfo")
	public String bookInfo(HttpServletRequest request) {
		List rList = bookService.getBookTypeService();
		request.setAttribute(constants.bookType, rList);
		return "books/bookInfo";
	}
	@RequestMapping("addBook")
	public String addBook(HttpServletRequest request) {
		List rList = bookService.getBookTypeService();
		request.setAttribute(constants.bookType, rList);
		return "books/addBook";
	}
	@RequestMapping("updateBookInfo")
	public String updateBookInfo(HttpServletRequest request, BookVo bookVo) {
		List typeList = bookService.getBookTypeService();
		List rList = bookService.selectBookInfoService(bookVo);
		Book book = (Book) rList.get(0);
		request.setAttribute(constants.bookType, typeList);
		request.setAttribute(constants.result,book);
		return "books/updateBook";
	}
	//借书
	@RequestMapping("borrowBook")
	public String borrowBook() {
		return "books/borrowBook";
	}
	//还书
	@RequestMapping("returnBook")
	public String returnBook() {
		return "books/returnBook";
	}
	//借阅查询
	@RequestMapping("qryBorrowBook")
	public String qryBorrowBook() {
		return "books/qryBorrowBook";
	}
	@RequestMapping("qryAppointment")
	public String qryAppointment() {
		return "books/qryAppointment";
	}
	
	//图书续借
	@RequestMapping("reletBook")
	public String reletBook(HttpServletRequest request,BorrowBookVo borrowBookVo) {
		List rlList = bookService.qryReturnAndBorrowBookService(borrowBookVo);
		if (rlList.size() > 0) {
			Map map = (Map) rlList.get(0);
			request.setAttribute(constants.result,map);
		}
		return "books/reletBook";
	}
	//电子书信息
	@RequestMapping("eBook")
	public String eBook(HttpServletRequest request) {
		List typeList = bookService.getBookTypeService();
		request.setAttribute(constants.bookType, typeList);
		return "books/eBook";
	}
	/**********************与我相关**********************************/
	//借阅查询
	@RequestMapping("searchBook")
	public String searchBook(HttpServletRequest request) {
		List typeList = bookService.getBookTypeService();
		request.setAttribute(constants.bookType, typeList);
		return "relatedmy/searchBook";
	}
	//我的书架
	@RequestMapping("myBookStack")
	public String myBookStack(HttpServletRequest request, BorrowBookVo borrowBookVo) {
		User  user =  (User) request.getSession().getAttribute(constants.loginInfo);
		String u_id = user.getU_id();
		borrowBookVo.setU_id(u_id);
		List rlList = bookService.qryReturnAndBorrowBookService(borrowBookVo);
		if (rlList.size() > 0) {
			request.setAttribute(constants.result, rlList);
		} else {
			request.setAttribute(constants.mess, "你还未借过书哦，赶紧去看看吧！");
		}
		return "relatedmy/myBookStack";
	}
	//电子书列表
	@RequestMapping("eBookList")
	public String eBookList(HttpServletRequest request) {
		List typeList = bookService.getBookTypeService();
		request.setAttribute(constants.bookType, typeList);
		return "relatedmy/eBookList";
	}
	//电子书下载
	@RequestMapping("eBookDownload")
	public String eBookDownload(HttpServletRequest request ) {
		String b_id = request.getParameter(constants.b_id);
		Book ebookInfo = bookService.getBookInfoByidService(b_id);
		
		request.setAttribute(constants.result,ebookInfo);
        List rlList = bookService.qryBookCommentDao(b_id);
		if (rlList.size() > 0) {
			request.setAttribute(constants.comment, rlList);
		}
		return "relatedmy/eBookDownload";
	}
	
	/**********************我的图书**********************************/
	//查询已上传的图书
	@RequestMapping("myBook")
	public String myBook(HttpServletRequest request) {
		List typeList = bookService.getBookTypeService();
		request.setAttribute(constants.bookType, typeList);
		return "mybook/myBook";
	}
	
	//图书上传
	@RequestMapping("uploadBook")
	public String uploadBook(HttpServletRequest request) {
		List typeList = bookService.getBookTypeService();
		request.setAttribute(constants.bookType, typeList);
		return "mybook/upLoadBook";
	}
	//图书写作
	@RequestMapping("writeBook")
	public String writeBook(HttpServletRequest request) {
		String b_url = request.getParameter("burl");
		if (b_url == null || b_url == "") {
			return "mybook/writeBook";
		}
		BufferedReader br = null;
		try {
			String s;
			StringBuffer content = new StringBuffer(); 
			 String path = request.getServletContext().getRealPath("/");//获取项目的绝对路径
			 System.err.println(path+b_url);
			 br = new BufferedReader( new InputStreamReader(new FileInputStream(path+b_url),"UTF-8"));
		while ((s = br.readLine()) != null ) {
		     content.append(s);
		     content.append("\r\n");		
		}
		request.setAttribute(constants.content,content.toString());
		
		}  catch (IOException e) {
			e.printStackTrace();
			request.setAttribute(constants.mess, "系统发生异常");
			return "mybook/myBook";
		}
		return "mybook/writeBook";
	}
	/**************消息*********************/
	//查询消息
	@RequestMapping("getmessage")
	public String getmessage(HttpServletRequest request) {
		
		return "user/getmessage";
	}
	//留言
	@RequestMapping("leaveMessage")
	public String leaveMessage(HttpServletRequest request) {
		
		return "user/leaveMessage";
	}
	
}