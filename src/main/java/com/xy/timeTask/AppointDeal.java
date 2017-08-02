package com.xy.timeTask;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xy.service.BookService;

@Component
public class AppointDeal  {

	@Resource
	private BookService bookService;

	@Scheduled(cron = "0 0 */2 * * ?")//每2小时执行一次
	public void appointDeal() {
		try {
			bookService.appointmentService(); // 预约处理
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
