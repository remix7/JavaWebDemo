package cc.cynara.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//将用户剔除
public class TirenServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = getServletContext();
		Map<String, HttpSession> users = (Map<String, HttpSession>) sc.getAttribute("users");
		if(users!=null){
			String username = request.getParameter("username");
			username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
			HttpSession s = users.get(username);
			s.invalidate();
			users.remove(username);
		}
		response.sendRedirect(request.getContextPath()+"/onlineUser.jsp");
		
	}
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
