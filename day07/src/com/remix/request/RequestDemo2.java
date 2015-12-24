package com.remix.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��ȡ�ͻ����ύ��������Ϣͷ
public class RequestDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡָ��ͷ����Ϣ Accept-Encoding
		PrintWriter out = response.getWriter();
		test3(request, out);
	}
	//��ȡָ��ͷ����Ϣ Accept-Encoding
	private void test1(HttpServletRequest request, PrintWriter out) {
		String value = request.getHeader("Accept-Encoding");
		out.write(value);
	}
	//��ȡ����ͷ��ֵ
	private void test2(HttpServletRequest request, PrintWriter out) {
		Enumeration e = request.getHeaders("Cookie");
		while(e.hasMoreElements()){
			String value = (String)e.nextElement();
			out.write(value);
		}
	}
	//��ȡ���е�����ͷ��ֵ
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
