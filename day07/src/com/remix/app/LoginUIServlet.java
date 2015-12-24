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
		//��ȡ��ס���û���
		String username = "";
		String checked = "";//checked='checked
		Cookie[] cs = request.getCookies();
		for(int i=0;cs!=null&&i<cs.length;i++){
			Cookie c = cs[i];
			if("userinfo".equals(c.getName())){
				String value = c.getValue();//�û���
				username = value;
				checked = "checked='checked'";
				break;
			}
		}
		//�ṩ��¼����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<form action='/day07/servlet/LoginServlet' method='post'>");
		//�����Ȳ�Ҫʹ������   
		out.write("�û���:<input type='text' name='username' value='"+username+"'/></br>");
		out.write("����:<input type='password' name='password' value=''/></br>");
		out.write("<input type='checkbox' name='remember'"+checked+"  />�Ƿ�Ҫ��ס�û���</br>");
		out.write("<input type='submit' value='�ύ'/>");
		out.write("</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
