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
		request.setCharacterEncoding("UTF-8");//���ֱ�д������
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//��֤�û���������  123  321
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		String sessionCode = (String) request.getSession().getAttribute("code");
		//�ж���֤��
		if(!code.equalsIgnoreCase(sessionCode)){
			out.write("�������֤�롣<a href='/day08/login.html'>���ص�¼ҳ��</a>");
			return;
		}
		StringBuffer sb = new StringBuffer(password);
		password = sb.reverse().toString();
		if(username.equals(password)){
			//��֤ͨ��  �ŵ�session��
			User user = new User(username, password);
			request.getSession().setAttribute("user", user);
			out.write("��¼�ɹ���2�����ת����ҳ");
		}else{
			out.write("������û��������롣2�����ת����ҳ");
		}
		response.setHeader("Refresh", "2;URL=/day08");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
