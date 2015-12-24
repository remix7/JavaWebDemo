package com.remix.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test3(response);
		
	}
	//字符流想客户端浏览器输出数据
	private void test1(HttpServletResponse response) throws IOException {
		String s = "学习要认真";
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(s);//查的是ISO-8859-1码表 sun的servlet规范要求
	}
	//字符流想客户端浏览器输出数据
	private void test2(HttpServletResponse response) throws IOException {
		String s = "想要怒放的生命";
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chatset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(s);//查的是ISO-8859-1码表 sun的servlet规范要求
	}
	//字符流想客户端浏览器输出数据
	private void test3(HttpServletResponse response) throws IOException {
		String s = "葫芦娃，葫芦娃";
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chatset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(s);//查的是ISO-8859-1码表 sun的servlet规范要求
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
