package com.xy.autoTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xy.service.BookService;

public class AutoTask extends HttpServlet  implements  ServletContextListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void contextDestroyed(ServletContextEvent arg0) {
		System.err.println("调用关闭");
		
	}

	public void contextInitialized(ServletContextEvent arg1) {
		
		System.out.println("调用开始");	
		ServletContext sc = arg1.getServletContext();
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);  
		BookService bookService = (BookService) ac.getBean("bookService");// 这里就可以直接取出所需要的service层中的Bean了  
		TimeTask  timeTask = new TimeTask(bookService);
		timeTask.start();
			
	}

}
