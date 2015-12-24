package com.remix.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��ȡ��Դ�ļ�  �ļ�����
public class ServletDemo6 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sinpleDownloadFile1(response);
	}

	// ��򵥵��ļ�����
	private void sinpleDownloadFile(HttpServletResponse response)
			throws FileNotFoundException, IOException {
		// �õ�Ҫ���ص���Դ�ļ�
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/IMG_1470.JPG");// �õ��ļ�����ʵ·��
		// ����������
		InputStream in = new FileInputStream(path);
		// ֪ͨ�ͻ��������صķ�ʽ�� ����ͷ�ļ� �ÿͻ��������صķ�ʽ��
		response.setHeader("Content-Disposition",
				"attachment;filename=IMG_1470.JPG");
		response.setHeader("Content-Type", "application/octet-stream");
		// �õ������
		OutputStream out = response.getOutputStream();
		int len = -1;
		byte[] b = new byte[1024];
		while ((len = in.read()) != -1) {
			out.write(b, 0, len);
		}
		in.close();
		out.close();
	}
	//��򵥵���������Դ�ļ�����
	private void sinpleDownloadFile1(HttpServletResponse response)
			throws FileNotFoundException, IOException {
		// �õ�Ҫ���ص���Դ�ļ�
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/���.JPG");// �õ��ļ�����ʵ·��
		System.out.println(path);
		String name = path.substring(path.lastIndexOf("\\")+1);
		System.out.println(name);
		// ����������
		InputStream in = new FileInputStream(path);
		// ֪ͨ�ͻ��������صķ�ʽ�� ����ͷ�ļ� �ÿͻ��������صķ�ʽ��
		response.setHeader("Content-Disposition",
				"attachment;filename="+URLEncoder.encode(name, "UTF-8"));
		response.setHeader("Content-Type", "application/octet-stream");
		// �õ������
		OutputStream out = response.getOutputStream();
		int len = -1;
		byte[] b = new byte[1024];
		while ((len = in.read(b)) != -1) {
			out.write(b, 0, len);
		}
		in.close();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
