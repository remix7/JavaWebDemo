package com.remix.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//HttpServletRequest常用的简单方法
public class RequestDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		Method(request, response);
	}

	private void Method(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter(); 
		String url = request.getRequestURL().toString(); //获取访问的URL地址
		String uti = request.getRequestURI();//获取访问的资源地址
		String qs = request.getQueryString();//获取get请求的字符串
		
		String remoteAddr = request.getRemoteAddr();//获取客户端访问的IP地址
		int remotePort = request.getRemotePort();//获取客户端访问的
		String method = request.getMethod();//获取请求方式
		
		out.println("url:"+url);
		out.println("uti:"+uti);
		out.println("qs:"+qs);
		out.println("remoteAddr:"+remoteAddr);
		out.println("remotePort:"+remotePort);
		out.println("method:"+method);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
