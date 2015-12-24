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

//读取资源文件  文件下载
public class ServletDemo6 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sinpleDownloadFile1(response);
	}

	// 最简单的文件下载
	private void sinpleDownloadFile(HttpServletResponse response)
			throws FileNotFoundException, IOException {
		// 得到要下载的资源文件
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/IMG_1470.JPG");// 得到文件的真实路径
		// 构建输入流
		InputStream in = new FileInputStream(path);
		// 通知客户端以下载的方式打开 设置头文件 让客户端以下载的方式打开
		response.setHeader("Content-Disposition",
				"attachment;filename=IMG_1470.JPG");
		response.setHeader("Content-Type", "application/octet-stream");
		// 得到输出流
		OutputStream out = response.getOutputStream();
		int len = -1;
		byte[] b = new byte[1024];
		while ((len = in.read()) != -1) {
			out.write(b, 0, len);
		}
		in.close();
		out.close();
	}
	//最简单的中文名资源文件下载
	private void sinpleDownloadFile1(HttpServletResponse response)
			throws FileNotFoundException, IOException {
		// 得到要下载的资源文件
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/你好.JPG");// 得到文件的真实路径
		System.out.println(path);
		String name = path.substring(path.lastIndexOf("\\")+1);
		System.out.println(name);
		// 构建输入流
		InputStream in = new FileInputStream(path);
		// 通知客户端以下载的方式打开 设置头文件 让客户端以下载的方式打开
		response.setHeader("Content-Disposition",
				"attachment;filename="+URLEncoder.encode(name, "UTF-8"));
		response.setHeader("Content-Type", "application/octet-stream");
		// 得到输出流
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
