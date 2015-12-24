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

//servlet读取其他资源文件的方法
public class ServletDemo7 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		test7();
		
	}

	//利用ServletContext读取a1.properties
	private void test1() throws IOException, FileNotFoundException {
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/WEB-INF/a1.properties");
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		String value = props.getProperty("username");
		System.out.println(value);
	}
	//利用ServletContext读取a2.properties
	private void test2() throws IOException, FileNotFoundException {
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/WEB-INF/classes/a2.properties");
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		String value = props.getProperty("username");
		System.out.println(value);
	}
	//利用ServletContext读取a3.properties
	private void test3() throws IOException, FileNotFoundException {
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/WEB-INF/classes/com/remix/resourse/a3.properties");
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		String value = props.getProperty("username");
		System.out.println(value);
	}
	//==
	//利用ResourceBundle读取a2.properties  局限性很大  只能读取类目录下的properties文件
	private void test4() throws IOException, FileNotFoundException {
		ResourceBundle rb = ResourceBundle.getBundle("a2");
		String value = rb.getString("username");
		System.out.println(value);
	}
	//利用ResourceBundle读取a3.properties  局限性很大  只能读取类目录下的properties文件
	private void test5() throws IOException, FileNotFoundException {
		ResourceBundle rb = ResourceBundle.getBundle("com.remix.resourse.a3");
		String value = rb.getString("username");
		System.out.println(value);
	}
	//===
	//利用类加载器读取a2.properties
	private void test6() throws IOException, FileNotFoundException {
		ClassLoader cl = ServletDemo7.class.getClassLoader();
		InputStream in = cl.getResourceAsStream("a2.properties");
		Properties pr = new Properties();
		pr.load(in);
		String value = pr.getProperty("username");
		System.out.println(value);
	}	
	//利用类加载器读取a3.properties
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
