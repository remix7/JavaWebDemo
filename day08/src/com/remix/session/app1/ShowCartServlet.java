package com.remix.session.app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if (session == null) {
			out.write("����δ�����");
		} else {
			List<Book> cart = (List<Book>) session.getAttribute("cart");
			if (cart == null) {
				out.write("����δ�����");
			} else {
				out.write("�������Ʒ����</br>");
				for (Book b : cart) {
					out.write(b.getName() + "</br>");

				}
			}
		}
		String url = "/day08/servlet/ShowAllBooksServlet";
		url = response.encodeURL(url);
		out.write("<a href='"+url+"'>��������</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
