package com.xy.timeTask;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.xy.constants.constants;
import com.xy.entity.User;
import com.xy.service.BookService;
import com.xy.service.UserService;

@Component
public class AutoChangeMessages extends Thread {

	@Resource
	private BookService bookService;

	private UserService userService;
	private static HttpSession sess;
    public static boolean exit = true;
	
	public void run() {

		while (exit) {
				User user = (User) sess.getAttribute(constants.loginInfo);
				String ru_id = user.getU_id();
				try {
					Integer count = userService.getAllMessageRowsService(ru_id);
					if (count != null) {
						sess.setAttribute("count", count);
					}
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	public static HttpSession getSess() {
		return sess;
	}

	public static void setSess(HttpSession sess) {
		AutoChangeMessages.sess = sess;
	}
    public AutoChangeMessages(UserService userService) {
    	this.userService = userService;
    } 
}
