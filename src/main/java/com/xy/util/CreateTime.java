package com.xy.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateTime {
	public String createtime(){
		Date date = new Date();
		DateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
		String time = dt1.format(date); 
		return  time;
	}
	public String getReturnBookTime(Integer a) {
		
		Calendar cal = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。
		if (a == null) {
			cal.add(Calendar.MONTH, 1);    
		} else {
			cal.add(Calendar.DAY_OF_MONTH, +a);//取当前日期的后a天. 
		}
		SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");    
	    return format.format(cal.getTime());   
	}
	/**
	 * 将一个指定的时间加上指定的天数
	 * 
	 * @param a
	 * @return
	 */
      public String getDateAddDay(String sDate, Integer a) {

		if (sDate == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		try {
			Date date = sdf.parse(sDate);

			calendar.setTime(date);
			if (a == null) {
				calendar.add(Calendar.MONTH, 1);
			} else {
				calendar.add(Calendar.DAY_OF_MONTH, +a);// 取当前日期的后a天.
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sdf.format(calendar.getTime());
	}
	/**
	 * 计算日期差
	 * 参数 ：Calendar startDate, Calendar endDate
	 */
      public Integer countTwoDate(Calendar startDate, Calendar endDate) {   
        
    	  if (startDate != null && endDate != null) {
	    	  long time1 = startDate.getTimeInMillis();   
	          long time2 = endDate.getTimeInMillis(); 
	          long between_days=(time2-time1)/(1000*3600*24); 
          return Integer.parseInt(String.valueOf(between_days)); 
    	  }
		return null;
      } 	
}
