package com.remix.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//读取记住的用户名
		String username = "";
		String checked = "";//checked='checked
		Cookie[] cs = request.getCookies();
		for(int i=0;cs!=null&&i<cs.length;i++){
			Cookie c = cs[i];
			if("userinfo".equals(c.getName())){
				String value = c.getValue();//用户名
				username = value;
				checked = "checked='checked'";
				break;
			}
		}
		//提供登录界面
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<form action='/day07/servlet/LoginServlet' method='post'>");
		//现在先不要使用中文   
		out.write("用户名:<input type='text' name='username' value='"+username+"'/></br>");
		out.write("密码:<input type='password' name='password' value=''/></br>");
		out.write("<input type='checkbox' name='remember'"+checked+"  />是否要记住用户名</br>");
		out.write("<input type='submit' value='提交'/>");
		out.write("</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
