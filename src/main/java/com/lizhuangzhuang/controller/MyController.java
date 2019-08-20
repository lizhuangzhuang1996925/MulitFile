package com.lizhuangzhuang.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MyController {
	@RequestMapping("toMulitFile")
	@ResponseBody
	public Object toMulitFile(MultipartFile file) throws IllegalStateException, IOException {
		if(!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			String name=UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));
			File file2=new File("D:/class/1701B-CMS/mulitfile/src/main/webapp/pi/"+name);
			file.transferTo(file2);
			Map<String, String> map=new HashMap<String, String>();
			map.put("name", name);
			return map;
		}
		return false;
	}
	@RequestMapping("downLoad")
	public void download(HttpServletRequest request,HttpServletResponse response,String filename) throws FileNotFoundException {
		 /* // 下载本地文件
	    String fileName = "Operator.doc".toString(); // 文件的默认保存名
*/	    // 读到流中
	    InputStream inStream = new FileInputStream("D:\\class\\1701B-CMS\\mulitfile\\src\\main\\webapp\\pi\\"+filename);// 文件的存放路径
	    // 设置输出的格式
	    response.reset();
	    response.setContentType("bin");
	    response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
	    // 循环取出流中的数据
	    byte[] b = new byte[1024];
	    int len;
	    try {
	      while ((len = inStream.read(b)) > 0)
	        response.getOutputStream().write(b, 0, len);
	      inStream.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
			}

}
