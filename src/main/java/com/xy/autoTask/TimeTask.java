package com.xy.autoTask;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.stereotype.Component;

import com.xy.service.BookService;

@Component
public class TimeTask extends Thread {

	private BookService bookService;

	public TimeTask(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(15000); // 每隔5000ms执行一次

			tasks();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void tasks() {
		System.out.println("进入定时");
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				try {
					System.out.println(new Date()+"：定时任务开始执行");
					bookService.qryborrowBooksBystateService(1);// 逾期处理
					
				} catch (Exception e) {
					e.printStackTrace();
					e.getMessage();
				}

			}
		};
		// 设置执行时间
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);// 每天
		// 定制每天的23:00:00执行，
		calendar.set(year, month, day, 23, 00, 00);
		Date date = calendar.getTime();
		Timer timer = new Timer();

		// int period = 2 * 1000;
		// 每天的date时刻执行task，每隔2秒重复执行
		// timer.schedule(task, date, period);
		// 每天的date时刻执行task, 仅执行一次
		// flag = true;
		timer.schedule(task, date);
	}

}
