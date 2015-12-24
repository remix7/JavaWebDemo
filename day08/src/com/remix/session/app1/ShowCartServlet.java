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
			out.write("您还未曾购物！");
		} else {
			List<Book> cart = (List<Book>) session.getAttribute("cart");
			if (cart == null) {
				out.write("您还未曾购物！");
			} else {
				out.write("购买的商品如下</br>");
				for (Book b : cart) {
					out.write(b.getName() + "</br>");

				}
			}
		}
		String url = "/day08/servlet/ShowAllBooksServlet";
		url = response.encodeURL(url);
		out.write("<a href='"+url+"'>继续购物</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
