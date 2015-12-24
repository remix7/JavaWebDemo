package com.remix.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ��ȡ�û���
//��ɵ�¼  �����Ƿ�Ҫ��ס�û���������Cookie
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		//��֤�û���������
		User user = UserDB.findUser(username, password);
		if(user==null){
			out.write("������û���������");
			return;
		}
		//����cookie  userinfo
		Cookie c = new Cookie("userinfo", username);
		if(remember==null){
			//ɾ��cookie
			c.setMaxAge(0);
		}else{
			//��סcookie
			c.setMaxAge(Integer.MAX_VALUE);
		}
		response.addCookie(c);
		out.print("��ϲ�㣬��¼�ɹ�");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
