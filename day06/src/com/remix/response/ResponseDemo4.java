package com.remix.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��������Զ�ˢ��
public class ResponseDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test2(response);
	}
	//��ʱˢ�µ��Լ�
	private void test1(HttpServletResponse response) throws IOException {
		Random r = new Random();
		int i = r.nextInt();
//		response.setHeader("Refresh", "1");
		response.setIntHeader("Refresh", 1);
		response.getOutputStream().write((i+"").getBytes());
	}
	//һ��ʱ�����ת�����ҳ��
	private void test2(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Refresh", "2;URL=/day06/hello.html");
		out.write("��¼�ɹ�!2���ӽ��Զ���ת����ҳ����û����ת����<a href='/day06/hello.html'>����!</a>");
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
