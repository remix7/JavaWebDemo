package com.remix.session.app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//显示所有商品
//提供购买链接
//提供查看购物车
public class ShowAllBooksServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//显示所有商品提供购买链接
		out.write("<h1>本站有如下商品</h1>");
		Map<String, Book> books = BookDB.findAllBooks();
		request.getSession();//***
		for(Map.Entry<String, Book> me:books.entrySet()){
			String url = "/day08/servlet/BuyServlet?id="+me.getKey();
			url = response.encodeURL(url);
			out.write(me.getValue().getName()+"&nbsp;&nbsp;<a href='"+url+"'>购买</a></br>");
		}
		String url = "/day08/servlet/ShowCartServlet";
		url = response.encodeURL(url);//***URL重写
		out.write("<a href='"+url+"'>查看购物车</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
