package cc.cynara.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;
import cc.cynara.autologin.MD5Util;
/**
 * 标识同一个cookie  cookie名和路径相同时
 * @author REMIX-7
 *
 */
public class LogOutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie c = new Cookie("loginInfo",null);
		c.setMaxAge(0);
		c.setPath(request.getContextPath());
		response.addCookie(c);
		request.getSession().invalidate();
		request.getSession().removeAttribute("user");
		
		response.sendRedirect(request.getContextPath()+"/autoLogin/index.jsp");
//		request.getRequestDispatcher("/autoLogin/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
