package com.remix.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.remix.domain.Book;
import com.remix.domain.Cart;
import com.remix.service.BookService;
import com.remix.service.impl.BookServiceImpl;
//�޸Ĺ����������
public class changeNumServlet extends HttpServlet {

	private BookService s = new BookServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			String bookId = request.getParameter("bookId");
			String newnum = request.getParameter("newnum");
			
			
//			Book book = s.findBookById(bookId);
			
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			int num = Integer.parseInt(newnum);
			if(num<1){
				request.setAttribute("message", "<script type='text/javascript'>alert('��������������')</script>");
			}else{
				s.changeCartItemNum(bookId,cart,num);
			}
		} catch (NumberFormatException e) {
			request.setAttribute("message", "<script type='text/javascript'>alert('��������ȷ�����֣�')</script>");
		}
		//ת������ʾ���ﳵ��ҳ��
		request.getRequestDispatcher("/WEB-INF/pages/showCart.jsp").forward(request, response);
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
