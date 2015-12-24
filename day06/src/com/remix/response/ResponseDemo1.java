package com.remix.response;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		test4(response);
	}
	//��Ĭ�ϱ������ֽ�����������������
	private void test1(HttpServletResponse response) throws IOException {
		String s = "�Ҹ���ʲô��";
		ServletOutputStream out = response.getOutputStream();
		out.write(s.getBytes());
	}
	//��UTF-8�������ֽ�����������������
	private void test2(HttpServletResponse response) throws IOException {
		String s = "�Ҹ�����ƶ���޹أ�";
		//֪ͨ�ͻ���ʹ��UTF-8
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		ServletOutputStream out = response.getOutputStream();
		out.write(s.getBytes("UTF-8"));
	}
	//��UTF-8�������ֽ�����������������
	private void test3(HttpServletResponse response) throws IOException {
		String s = "����������";
		
		ServletOutputStream out = response.getOutputStream();
		out.write("<meta http-equiv='Content-Type' content='text/html;charset=UTF-8'>".getBytes("UTF-8"));
		out.write(s.getBytes("UTF-8"));
	}
	//��UTF-8�������ֽ�����������������
	private void test4(HttpServletResponse response) throws IOException {
		String s = "��������";
		response.setContentType("text/html;charset=UTF-8");
		ServletOutputStream out = response.getOutputStream();
		out.write(s.getBytes("UTF-8"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
