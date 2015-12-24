package com.remix.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setAttribute("p", "ppp555");
		response.getWriter().write("����");
		//��һ�ַ���
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/servlet/RequestDemo6");
		rd.forward(request, response);
		
		// �ڶ��ַ��� ����ת��  һ������  �ɷ���������ת��
//		RequestDispatcher rd = request.getRequestDispatcher("/servlet/RequestDemo6");
//		rd.forward(request, response);
		//�����ض���  ��������
//		response.sendRedirect("/day07/servlet/RequestDemo6");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
