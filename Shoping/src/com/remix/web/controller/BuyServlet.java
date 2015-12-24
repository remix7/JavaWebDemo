package com.remix.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.remix.domain.Book;
import com.remix.domain.Cart;
import com.remix.service.BookService;
import com.remix.service.impl.BookServiceImpl;

public class BuyServlet extends HttpServlet {
	private BookService s = new BookServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String bookId = request.getParameter("bookId");
		Book book = s.findBookById(bookId);
		//放入购物车
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart==null){
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		s.addBook2Cart(cart,book);//放入购物车  通过业务层
		out.write("["+book.getName()+"]"+"已经放入你的购物车!<a href='"+request.getContextPath()+"'>继续购物</a>");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
