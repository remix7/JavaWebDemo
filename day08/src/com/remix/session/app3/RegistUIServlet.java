package com.remix.session.app3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//提供一个主场页面
public class RegistUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
//		String token = ""+System.currentTimeMillis()+new Random().nextLong();
//		token = Md5Util.md5(token);
		String token = UUID.randomUUID().toString();//UUID表示通用唯一比标识符
		System.out.println(token);
		request.getSession().setAttribute("token", token);
		
		out.write("<form id ='f1' action='"+request.getContextPath()+"/servlet/RegistServlet' method='post'");
		out.write("name:<input type='text' name='name'/><rb/>");
		out.write("name:<input type='text' name='name'/><br/>");
//		out.write("<input type='submit' value='REGIST'/><form>");
		out.write("<input type='hidden' name='token' value='"+token+"'/>");
		out.write("<input id='bt1' type='button' value='REGIST' onclick='toSubmit()'/></form>");
		out.write("<script type='text/javascript'>function toSubmit(){document.getElementById('f1').submit();document.getElementById('bt1').disable=true;}</script>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
