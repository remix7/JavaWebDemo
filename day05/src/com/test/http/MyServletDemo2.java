package com.test.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServletDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		byte[] b = str.getBytes();
		System.out.println("ѹ��ǰ�Ĵ�С"+b.length);
		
		//GZIPѹ��
		ByteArrayOutputStream out = new ByteArrayOutputStream();//���л�����ֽ��ڴ������
		GZIPOutputStream gout = new GZIPOutputStream(out);
		gout.write(b);
		gout.close();
		
		b = out.toByteArray();
		System.out.println("ѹ����Ĵ�С"+b.length);
		response.setHeader("Content-Encoding", "gzip");//֪ͨ�ͻ�������ѹ���ı���
		response.setHeader("Content-Lenth", b.length+"");//֪ͨ�ͻ����������ݵĴ�С
		response.getOutputStream().write(b);
		response.getOutputStream().print("<hr/>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
