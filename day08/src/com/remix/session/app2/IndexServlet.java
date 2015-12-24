package com.remix.session.app2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//��ΪĬ����ҳ
public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			out.write("<a href='login.html'>��¼</a><hr/>");
		}else{
			out.write("��ӭ��"+user.getUsername()+"&nbsp;&nbsp;<a href='/day08/servlet/LogoutServlet'>ע��</a><br/>");
		}
		
		out.write("������ҳ");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
