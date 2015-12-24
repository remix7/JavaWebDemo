package com.remix.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.remix.domain.Cart;
import com.remix.service.BookService;
import com.remix.service.impl.BookServiceImpl;
//删除一项
public class delOneServlet extends HttpServlet {
	private BookService s = new BookServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String bookId = request.getParameter("bookId");
		
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart==null){
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		s.delOneItem(cart,bookId);
		
		//转发到显示购物车的页面
		request.getRequestDispatcher("/WEB-INF/pages/showCart.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
