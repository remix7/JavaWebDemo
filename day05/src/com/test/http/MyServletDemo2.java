package com.test.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServletDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		byte[] b = str.getBytes();
		System.out.println("压缩前的大小"+b.length);
		
		//GZIP压缩
		ByteArrayOutputStream out = new ByteArrayOutputStream();//带有缓存的字节内存输出流
		GZIPOutputStream gout = new GZIPOutputStream(out);
		gout.write(b);
		gout.close();
		
		b = out.toByteArray();
		System.out.println("压缩后的大小"+b.length);
		response.setHeader("Content-Encoding", "gzip");//通知客户端数据压缩的编码
		response.setHeader("Content-Lenth", b.length+"");//通知客户端正文数据的大小
		response.getOutputStream().write(b);
		response.getOutputStream().print("<hr/>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
