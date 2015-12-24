package com.remix.session.app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��ʾ������Ʒ
//�ṩ��������
//�ṩ�鿴���ﳵ
public class ShowAllBooksServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//��ʾ������Ʒ�ṩ��������
		out.write("<h1>��վ��������Ʒ</h1>");
		Map<String, Book> books = BookDB.findAllBooks();
		request.getSession();//***
		for(Map.Entry<String, Book> me:books.entrySet()){
			String url = "/day08/servlet/BuyServlet?id="+me.getKey();
			url = response.encodeURL(url);
			out.write(me.getValue().getName()+"&nbsp;&nbsp;<a href='"+url+"'>����</a></br>");
		}
		String url = "/day08/servlet/ShowCartServlet";
		url = response.encodeURL(url);//***URL��д
		out.write("<a href='"+url+"'>�鿴���ﳵ</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
