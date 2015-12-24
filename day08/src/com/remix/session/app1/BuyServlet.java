package com.remix.session.app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//��ɹ���ṩ������������
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		Book book = BookDB.findBookById(id);
		//�ȸ�һ�㹺�ﳵ û�и���һ��  ��ֱ����
		HttpSession session = request.getSession();
		List<Book> cart = (List<Book>) session.getAttribute("cart");
		if(cart==null){
			cart = new ArrayList<Book>();
			session.setAttribute("cart", cart);
		}
		cart.add(book);
		out.write(book.getName()+"�Ѿ��������Ĺ��ﳵ��</br>");
		String url = "/day08/servlet/ShowAllBooksServlet";
		url = response.encodeURL(url);
		out.write("<a href='"+url+"'>��������</a>");
		
		//�Լ�дcookie
//		Cookie c = new Cookie("JSESSION",session.getId());
//		c.setPath(request.getContextPath());
//		c.setMaxAge(Integer.MAX_VALUE);
//		response.addCookie(c);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
