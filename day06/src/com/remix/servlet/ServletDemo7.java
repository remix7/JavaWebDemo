package com.remix.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet��ȡ������Դ�ļ��ķ���
public class ServletDemo7 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		test7();
		
	}

	//����ServletContext��ȡa1.properties
	private void test1() throws IOException, FileNotFoundException {
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/WEB-INF/a1.properties");
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		String value = props.getProperty("username");
		System.out.println(value);
	}
	//����ServletContext��ȡa2.properties
	private void test2() throws IOException, FileNotFoundException {
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/WEB-INF/classes/a2.properties");
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		String value = props.getProperty("username");
		System.out.println(value);
	}
	//����ServletContext��ȡa3.properties
	private void test3() throws IOException, FileNotFoundException {
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/WEB-INF/classes/com/remix/resourse/a3.properties");
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		String value = props.getProperty("username");
		System.out.println(value);
	}
	//==
	//����ResourceBundle��ȡa2.properties  �����Ժܴ�  ֻ�ܶ�ȡ��Ŀ¼�µ�properties�ļ�
	private void test4() throws IOException, FileNotFoundException {
		ResourceBundle rb = ResourceBundle.getBundle("a2");
		String value = rb.getString("username");
		System.out.println(value);
	}
	//����ResourceBundle��ȡa3.properties  �����Ժܴ�  ֻ�ܶ�ȡ��Ŀ¼�µ�properties�ļ�
	private void test5() throws IOException, FileNotFoundException {
		ResourceBundle rb = ResourceBundle.getBundle("com.remix.resourse.a3");
		String value = rb.getString("username");
		System.out.println(value);
	}
	//===
	//�������������ȡa2.properties
	private void test6() throws IOException, FileNotFoundException {
		ClassLoader cl = ServletDemo7.class.getClassLoader();
		InputStream in = cl.getResourceAsStream("a2.properties");
		Properties pr = new Properties();
		pr.load(in);
		String value = pr.getProperty("username");
		System.out.println(value);
	}	
	//�������������ȡa3.properties
	private void test7() throws IOException, FileNotFoundException {
		ClassLoader cl = ServletDemo7.class.getClassLoader();
		InputStream in = cl.getResourceAsStream("com/remix/resourse/a3.properties");
		Properties pr = new Properties();
		pr.load(in);
		String value = pr.getProperty("username");
		System.out.println(value);
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
