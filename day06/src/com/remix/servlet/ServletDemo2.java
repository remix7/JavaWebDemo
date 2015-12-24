package com.remix.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletDemo2 extends HttpServlet {
	private ServletConfig config;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test();
		test1();
	}
	public void test() {
		//得到ServletConfig指定参数aaa的值
		String value1 = config.getInitParameter("aaa");
		System.out.println(value1);
	}
	//得到所有的参数的值
	public void test1() {
		Enumeration e = config.getInitParameterNames();
		while(e.hasMoreElements()){
			String pramName = (String)e.nextElement();
			System.out.println(pramName+"="+config.getInitParameter(pramName));
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
}	

