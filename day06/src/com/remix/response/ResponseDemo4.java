package com.remix.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//让浏览器自动刷新
public class ResponseDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test2(response);
	}
	//定时刷新到自己
	private void test1(HttpServletResponse response) throws IOException {
		Random r = new Random();
		int i = r.nextInt();
//		response.setHeader("Refresh", "1");
		response.setIntHeader("Refresh", 1);
		response.getOutputStream().write((i+"").getBytes());
	}
	//一定时间后跳转到别的页面
	private void test2(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Refresh", "2;URL=/day06/hello.html");
		out.write("登录成功!2秒钟将自动跳转到主页，若没有跳转请点击<a href='/day06/hello.html'>这里!</a>");
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
