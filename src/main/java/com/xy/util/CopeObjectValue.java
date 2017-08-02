package com.xy.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/**
 * 将前对象的属性的值复制到后者上
 * @author soonsmile
 *
 */
public class CopeObjectValue {
	
	public static void copeObjectValue(Object a, Object b) {
		Map<String, Object> srcMap = new HashMap<String, Object>();

		Field[] srcFields = a.getClass().getDeclaredFields();
		for (Field fd : srcFields) {
			try {
				srcMap.put(fd.getName(), fd.get(a)); // 获取属性值
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Field[] destFields = b.getClass().getDeclaredFields();
		for (Field fd : destFields) {
			if (srcMap.get(fd.getName()) == null) {
				continue;
			}
			try {
				fd.set(b, srcMap.get(fd.getName())); // 给属性赋值
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
