package com.remix.session.app2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//主持表单写入中文
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//验证用户名和密码  123  321
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		String sessionCode = (String) request.getSession().getAttribute("code");
		//判断验证码
		if(!code.equalsIgnoreCase(sessionCode)){
			out.write("错误的验证码。<a href='/day08/login.html'>返回登录页面</a>");
			return;
		}
		StringBuffer sb = new StringBuffer(password);
		password = sb.reverse().toString();
		if(username.equals(password)){
			//验证通过  放到session中
			User user = new User(username, password);
			request.getSession().setAttribute("user", user);
			out.write("登录成功。2秒后跳转到主页");
		}else{
			out.write("错误的用户名或密码。2秒后跳转到主页");
		}
		response.setHeader("Refresh", "2;URL=/day08");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
