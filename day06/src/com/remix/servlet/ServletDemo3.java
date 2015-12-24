package com.remix.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * ServletContext
 * 实现servletDemo3和ServletDemo4之间的数据共享
 * @author REMIX-7
 *
 */
public class ServletDemo3 extends HttpServlet {
//	private ServletConfig config;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		ServletContext context = config.getServletContext();
		ServletContext context = getServletContext();
		context.setAttribute("p", "ppp");
		response.getOutputStream().write("out done".getBytes());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

//	public void init(ServletConfig config) throws ServletException {
//		this.config = config;
//	}
}
