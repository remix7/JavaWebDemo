package com.remix.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//HttpServletRequest���õļ򵥷���
public class RequestDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		Method(request, response);
	}

	private void Method(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter(); 
		String url = request.getRequestURL().toString(); //��ȡ���ʵ�URL��ַ
		String uti = request.getRequestURI();//��ȡ���ʵ���Դ��ַ
		String qs = request.getQueryString();//��ȡget������ַ���
		
		String remoteAddr = request.getRemoteAddr();//��ȡ�ͻ��˷��ʵ�IP��ַ
		int remotePort = request.getRemotePort();//��ȡ�ͻ��˷��ʵ�
		String method = request.getMethod();//��ȡ����ʽ
		
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
