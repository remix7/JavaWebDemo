package cc.cynara.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.cynara.autologin.MD5Util;
import cc.cynara.autologin.User;
import cc.cynara.autologin.UserDB;

import sun.misc.BASE64Encoder;

//处理来自autoLogin/login.jsp提交过来的数据
public class AutoLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = UserDB.findUser(username, password);
		if(user!=null){
			request.getSession().setAttribute("user", user);
			String autoLogin = request.getParameter("autoLogin");
			if(autoLogin!=null){
				Cookie c = new Cookie("loginInfo", new BASE64Encoder().encode(username.getBytes())+"_"+MD5Util.Md5(password));
				c.setMaxAge(Integer.MAX_VALUE);
				c.setPath(request.getContextPath());
				response.addCookie(c);
			}
		}
		response.sendRedirect(request.getContextPath()+"/autoLogin/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
