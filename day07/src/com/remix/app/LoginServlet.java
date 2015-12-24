package com.remix.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 读取用户名
//完成登录  根据是否要记住用户名来保存Cookie
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		//验证用户名和密码
		User user = UserDB.findUser(username, password);
		if(user==null){
			out.write("错误的用户名或密码");
			return;
		}
		//处理cookie  userinfo
		Cookie c = new Cookie("userinfo", username);
		if(remember==null){
			//删除cookie
			c.setMaxAge(0);
		}else{
			//记住cookie
			c.setMaxAge(Integer.MAX_VALUE);
		}
		response.addCookie(c);
		out.print("恭喜你，登录成功");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
