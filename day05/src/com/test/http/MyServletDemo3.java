package com.test.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServletDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random r = new Random();
		String data = r.nextInt()+"";
//		response.setHeader("Refresh", "1");//一秒钟刷新一次自己
		response.setHeader("Refresh", "3;URL=/day05/index.jsp");//3秒后刷新到其他页面
		response.getOutputStream().write(data.getBytes());
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
