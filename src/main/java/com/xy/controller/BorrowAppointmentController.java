package com.xy.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
import com.xy.entity.User;
import com.xy.service.BookService;
import com.xy.service.UserService;
import com.xy.vo.BookVo;
import com.xy.vo.BorrowBookVo;
/**
 * 预约借阅
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("borrowAppointmentController")
public class BorrowAppointmentController {

	@Resource
	private BookService bookService;

	@Resource
	private UserService userService;

	@RequestMapping("borrowAppointment")
	public String borrowAppointment(HttpServletRequest request, BorrowBookVo borrowBookVo) {
		try {
			User user = (User) request.getSession().getAttribute(constants.loginInfo);
			String bid[] = request.getParameterValues(constants.checks);	
			borrowBookVo.setU_id(user.getU_id());
		
			User ruser = userService.getUserInfoByIdService(user.getU_id());
			Integer u_state = ruser.getU_state();
			if (u_state != 1) {
				request.setAttribute(constants.mess, "该用户已锁定，无法预约,请找管理员解锁！");
				return "relatedmy/searchBook";
			}
			for (int i = 0; i < bid.length; i++) {
				borrowBookVo.setB_id(bid[i]);	
				Integer stock = bookService.getBookStockService(bid[i]);
				if (stock <= 0) {
					request.setAttribute(constants.mess, "图书id:"+bid[i] +"库存为0无法预约");
					return "relatedmy/searchBook";
				}				
				List rlist = bookService.qryAppointmentService(borrowBookVo);
				if(rlist.size() > 0) {
					request.setAttribute(constants.mess, "图书id:"+bid[i] +"已预约无法再次预约");
					return "relatedmy/searchBook";
				}
				Map map = new HashMap();
				map.put(constants.b_id, bid[i]);
				map.put(constants.bo_state, 1);
				map.put(constants.u_id, user.getU_id());
				List bList = bookService.qryBookByBorrowService(map);
				if (bList.size() > 0) {
					request.setAttribute(constants.mess, "图书id:"+bid[i] +"已借阅无法预约");
					return "relatedmy/searchBook";
				}
				
				 Calendar cal = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。    
			 	 cal.add(Calendar.DATE, +1);//取当前日期的后一天 
			 	 borrowBookVo.setB_appointtime(cal.getTime());
				
				bookService.insertAppointmentService(borrowBookVo);
				stock = stock - 1;
				BookVo bookVo = new BookVo();
				bookVo.setB_stock(stock);
				bookVo.setB_id(bid[i]);
				bookService.updateStockService(bookVo);
			}
			request.setAttribute(constants.mess, "预约成功,请在24小时之内到柜台办理借书，过时预约自动撤销");
		} catch (Exception e) {
			request.setAttribute(constants.mess, "预约失败");
			e.printStackTrace();
			e.getMessage();
			return "relatedmy/searchBook";
		}

		return "relatedmy/searchBook";
	}

}
