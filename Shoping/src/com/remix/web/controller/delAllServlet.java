package com.remix.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delAllServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����Ƚ�����  ȫ���ݻ�
//		request.getSession().invalidate();
		request.getSession().removeAttribute("cart");
		//ת������ʾ���ﳵ��ҳ��
		request.getRequestDispatcher("/WEB-INF/pages/showCart.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
