/*package com.xy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

*//**
 * 传统方式采用HSSFWorkbook读取xls文件内容，数据量大时报内存溢出
 * 
 * @author mrt
 *
 *//*
public class ReadExcelHSSF {

	public List readXls(InputStream in,String[] head) throws IOException {
		List<Map> list = null;
		// 文件输入流
		//InputStream is = new FileInputStream("F:abc.xls");
		// 创建hssf的workbook，将文件流传入workbook
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(in);
		// 解析workbook的内容，getNumberOfSheets()得到所有sheet的个数
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			// 得到workbook某个 的sheet，numSheet是sheet 的序号，序号从0开始
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// 循环行Row
			list = new ArrayList<Map>();
			System.out.println("所有行" + hssfSheet.getLastRowNum());
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				// 读取每一行数据 ,rowNum指定行下标 从0开始
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				// System.out.println("hssfRow"+hssfRow.getRowNum());
				Map<String, Object> map = new HashMap<String, Object>();
				// 读取单元格内容
				for (int i = 0; i < head.length; i++) {
					map.put(head[i], hssfRow.getCell(i));
					list.add(map);
				}
			}
			System.err.println(list);

		}
		return list;

	}

}
*/