package com.remix.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//获取客户端提交的请求消息头
public class RequestDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取指定头的信息 Accept-Encoding
		PrintWriter out = response.getWriter();
		test3(request, out);
	}
	//获取指定头的信息 Accept-Encoding
	private void test1(HttpServletRequest request, PrintWriter out) {
		String value = request.getHeader("Accept-Encoding");
		out.write(value);
	}
	//获取重名头的值
	private void test2(HttpServletRequest request, PrintWriter out) {
		Enumeration e = request.getHeaders("Cookie");
		while(e.hasMoreElements()){
			String value = (String)e.nextElement();
			out.write(value);
		}
	}
	//获取所有的请求头和值
	private void test3(HttpServletRequest request, PrintWriter out) {
		Enumeration e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String headername = (String)e.nextElement();
			String headerValue = request.getHeader(headername);
			out.write(headername+":"+headerValue+"<br/>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
