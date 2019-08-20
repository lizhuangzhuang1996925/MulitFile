package com.lizhuangzhuang.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

public class DownFileUtils {
	public static void download(String realPath,HttpServletRequest request,HttpServletResponse response,String filename) throws FileNotFoundException {
		 /* // 下载本地文件
	    String fileName = "Operator.doc".toString(); // 文件的默认保存名
*/	    // 读到流中
	    InputStream inStream = new FileInputStream(realPath+filename);// 文件的存放路径
	    // 设置输出的格式
	    response.reset();
	    response.setContentType("bin");
	    response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
	    // 循环取出流中的数据
	    byte[] b = new byte[100];
	    int len;
	    try {
	      while ((len = inStream.read(b)) > 0)
	        response.getOutputStream().write(b, 0, len);
	      inStream.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
			}
	public static void main(String[] args) {
		float i=1.1f;
		int b=5;
		System.out.println((i++)*(--b));
		System.out.println(b);
		System.err.println(i);
		
	}

}
