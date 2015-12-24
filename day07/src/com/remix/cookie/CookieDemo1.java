package com.remix.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test1(request, response);

	}

	private void test1(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("���ϴη��ʵ�ʱ���ǣ�");

		Cookie[] cs = request.getCookies();
		for (int i = 0; cs != null && i < cs.length; i++) {
			Cookie c = cs[i];
			if ("lastAccessTime".equals(c.getName())) {
				String value = c.getValue();
				long time = Long.parseLong(value);
				out.print(new Date(time).toLocaleString());
			}
		}
		// �ѵ�ǰ�ķ���ʱ��д��ȥ
		Cookie c = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
		c.setMaxAge(30*24*60*60);
		response.addCookie(c);
		c.setPath(request.getContextPath());
		c.setMaxAge(Integer.MAX_VALUE);
		out.write("<a href='/day07/servlet/CookieDemo2'>clear</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
