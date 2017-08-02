package com.xy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 传统方式采用HSSFWorkbook读取xls文件内容，数据量大时报内存溢出
 * 
 * @author mrt
 *
 */
public class ReadExcelXSSF {

	public List<Map> readXls(InputStream in, String[] head) {
		List<Map> list = null;
		try {
			// 创建xssf的workbook，将文件流传入workbook
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
			// 解析workbook的内容，getNumberOfSheets()得到所有sheet的个数
		//	for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
				// 得到workbook某个 的sheet，numSheet是sheet 的序号，序号从0开始
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
				/*if (xssfSheet == null) {
					continue;
				}*/
				// 循环行Row
				list = new ArrayList<Map>();
				System.out.println("所有行记录数" + xssfSheet.getLastRowNum());
				for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
					// 读取每一行数据 ,rowNum指定行下标 从0开始
					XSSFRow xssfRow = xssfSheet.getRow(rowNum);
					Map<String, Object> map = new HashMap<String, Object>();
					// 读取单元格内容
					for (int i = 0; i < head.length; i++) {
						map.put(head[i], xssfRow.getCell(i));
					}
					list.add(map);
				}
				xssfWorkbook.close();
			//}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}
