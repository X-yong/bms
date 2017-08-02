package com.xy.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xy.constants.constants;
/**
 * 图书导入模板下载
 * @author soonsmile
 *
 */
@Controller
@RequestMapping("templeDoloadController")
public class TempleDoload {

	@RequestMapping("templeDoload")
	public void templeDoload(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 获得请求文件名
			String filename = request.getParameter("filename");
			if ("bookImportTemplate".equals(filename)) {
				filename = constants.bookImportTemplate;
			}
			// 获取目标文件的绝对路径
			String fullFileName = request.getSession().getServletContext().getRealPath("/template/" + filename);
			// System.out.println(fullFileName);
			filename = URLEncoder.encode(filename, "UTF-8");
			// 设置文件MIME类型
			response.setContentType(request.getSession().getServletContext().getMimeType(filename));
			// 设置Content-Disposition
			response.setHeader("Content-Disposition", "attachment;filename=" + filename);
			// 读取目标文件，通过response将目标文件写到客户端
			// 读取文件
			InputStream in = new FileInputStream(fullFileName);
			OutputStream out = response.getOutputStream();
			// 写文件
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
