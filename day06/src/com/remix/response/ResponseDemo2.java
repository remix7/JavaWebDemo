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
	//�ַ�����ͻ���������������
	private void test1(HttpServletResponse response) throws IOException {
		String s = "ѧϰҪ����";
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(s);//�����ISO-8859-1��� sun��servlet�淶Ҫ��
	}
	//�ַ�����ͻ���������������
	private void test2(HttpServletResponse response) throws IOException {
		String s = "��Ҫŭ�ŵ�����";
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chatset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(s);//�����ISO-8859-1��� sun��servlet�淶Ҫ��
	}
	//�ַ�����ͻ���������������
	private void test3(HttpServletResponse response) throws IOException {
		String s = "��«�ޣ���«��";
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chatset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(s);//�����ISO-8859-1��� sun��servlet�淶Ҫ��
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
