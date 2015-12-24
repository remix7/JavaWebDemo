package com.remix.cookie.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowBooksServlet extends HttpServlet {
	// 显示所有的书
	// 显示用户最近的浏览记录cookie 1-2-3
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<h1>有以下好书!</h1>");
		Map<String, Book> books = BookDB.findAllBooks();
		for (Map.Entry<String, Book> me : books.entrySet()) {
			out.write(me.getValue().getName() + "&nbsp;&nbsp;<a href='"
					+ request.getContextPath()
					+ "/servlet/ShowBookDetailServlet?id=" + me.getKey()
					+ "'>查看详情</a><br/>");
		}
		out.write("<hr/><h3>您最近的商品浏览记录！</h3><br/>");
		Cookie[] cs = request.getCookies();
		for(int i = 0;cs!=null&&i<cs.length;i++){
			if(Constant.BOOK_HISTORY.equals(cs[i].getName())){
				String value = cs[i].getValue();
				String[] ids = value.split("\\-");
				for(String id :ids){
					out.write(BookDB.findBookById(id).getName()+"<br/>");
				}
				break;
			}
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
