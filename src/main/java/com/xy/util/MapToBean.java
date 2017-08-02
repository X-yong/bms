package com.xy.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class MapToBean {
   public static Object mapToBean(Map map, Object obj)  {
	   if (map == null)  
           return null;  
      try {
		BeanUtils.populate(obj, map);
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		e.printStackTrace();
	};  
 
	   return obj;
   } 
}
