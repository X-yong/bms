package com.xy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.entity.User;
import com.xy.service.BookService;
import com.xy.service.UserService;
import com.xy.util.CreateTime;
import com.xy.vo.BorrowBookVo;
import com.xy.vo.UserVo;
/**
 * 用户借书
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("borrowBookController")
public class BorrowBookController {

	@Resource
	private BookService bookService;

	@Resource
	private UserService userService;

	@RequestMapping("borrowBook")
	public String borrowBook(HttpServletRequest request, BorrowBookVo borrowBookVo) {
		try {
			request.setAttribute(constants.echo, borrowBookVo);
			String[] b_id = request.getParameterValues(constants.checks);
			String u_id = borrowBookVo.getU_id();
			UserVo userVo = new UserVo();
			userVo.setU_id(u_id);
			List rlList = userService.selectUserInfoService(userVo);
			if (rlList.size() == 0) {
				request.setAttribute(constants.mess, "该借阅者ID不存在！");
				return "books/borrowBook";
			}
			//校验用户信用值
			User user = userService.getUserInfoByIdService(u_id);
			Integer u_state = user.getU_state();
			if (u_state != 1) {
				request.setAttribute(constants.mess, "该用户已锁定，无法借阅,请找管理员解锁！");
				return "books/borrowBook";
			}
		    Integer u_credit = user.getU_credit();
			if (u_credit == 0 || u_credit < b_id.length) {
				request.setAttribute(constants.mess, "用户信用值为"+u_credit+",不足以支持本次借阅" );
				return "books/borrowBook";
			}
			String sh_time = new CreateTime().getReturnBookTime(borrowBookVo.getB_time());// 获取应该还书日期
			borrowBookVo.setSh_time(sh_time);

			List<String> idList = new ArrayList<String>();
			for (int i = 0; i < b_id.length; i++) {
				//校验用户是否已经借阅相同图书
				List bLsit = bookService.getUserBorrowBookOnReturnService(u_id,b_id[i]);
				if (bLsit.size() > 0) {
					request.setAttribute(constants.mess,"图书ID："+b_id[i]+"用户："+u_id+"已借阅未归还，请确认");
					return "books/borrowBook";
				}
				Integer stock =	bookService.getBookStockService(b_id[i]);
			    if (stock == 0) {
			    	request.setAttribute(constants.mess, "图书ID："+b_id[i]+"库存为0，无法借阅");
			    	return "books/borrowBook";
				}
				idList.add(b_id[i]);
			}
			borrowBookVo.setIdList(idList);
			Integer rInteger = bookService.borrowBookService(borrowBookVo);
			if (rInteger == null) {
				request.setAttribute(constants.mess, "借书失败");
			} else {
				request.setAttribute(constants.mess, "借书成功,欢迎再次借阅");
			}
		} catch (Exception e) {
			request.setAttribute(constants.mess, "借书失败");
			e.printStackTrace();
			e.getMessage();
			return "books/borrowBook";
		}

		return "books/borrowBook";
	}

}
