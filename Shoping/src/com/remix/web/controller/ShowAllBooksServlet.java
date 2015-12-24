package com.remix.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.remix.domain.Book;
import com.remix.service.BookService;
import com.remix.service.impl.BookServiceImpl;
//查询所有的书籍
public class ShowAllBooksServlet extends HttpServlet {
	private BookService s = new BookServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, Book> books = s.findAllBooks();
		request.setAttribute("books", books);
		request.getRequestDispatcher("/WEB-INF/pages/listBooks.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
