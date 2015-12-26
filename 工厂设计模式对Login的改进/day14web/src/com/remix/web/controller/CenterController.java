package com.remix.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.remix.domain.User;
import com.remix.exception.UsernameExistException;
import com.remix.service.UserService;
import com.remix.service.impl.UserServiceImpl;
import com.remix.util.WebFormBeanUtils;
import com.remix.web.formbean.LoginFormBean;
import com.remix.web.formbean.RegistFormBean;

public class CenterController extends HttpServlet {

	private UserService s = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String operation = request.getParameter("operation");
		if ("regist".equals(operation)) {
			regist(request, response);
		} else if ("login".equals(operation)) {
			login(request, response);
		} else if ("logOff".equals(operation)) {
			logOff(request, response, out);
		}
	}

	// 注销登录
	private void logOff(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) {
		// request.getSession().invalidate();
		request.getSession().removeAttribute("user");
		out.write("注销成功2秒后跳转到主页");
		response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "");
	}

	// 用户登录
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String username = request.getParameter("username");
		// String password = request.getParameter("password");

		LoginFormBean formBean = null;
		String result = "";
		formBean = WebFormBeanUtils.fillFormBean(request, LoginFormBean.class);
		if (!formBean.validate()) {
			// 验证不通过：数据回显示 还要提示具体的错误信息
			request.setAttribute("formBean", formBean);
			result = "/login.jsp";
		} else {
			User user = s.login(formBean.getUsername(), formBean.getPassword());
			if (user == null) {
//				formBean.getErrors().put("message", "对不起，用户不存再或用户名密码错误");
				request.setAttribute("message", "对不起，用户不存再或用户名密码错误");
				request.setAttribute("formBean", formBean);
				result = "/login.jsp";
			} else {
				// request.setAttribute("message", user.getNick()+"：欢迎您");
				// result = "/message.jsp";
				request.getSession().setAttribute("user", user);
				// formBean.getErrors().put("message",
				// "欢迎您"+formBean.getUsername());
				request.setAttribute("formBean", formBean);
				result = "/index.jsp";
			}
		}
		// System.out.println(username+password);
		request.getRequestDispatcher(result).forward(request, response);
	}

	// 用户注册
	private void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RegistFormBean formBean = null;
		String result = "";// 结果页面的URl
		try {
			// 获取用户输入的数据
			formBean = WebFormBeanUtils.fillFormBean(request,
					RegistFormBean.class);
			// 封装，验证 RegistFormBean
			if (!formBean.validate()) {
				// 验证不通过：数据回显示 还要提示具体的错误信息
				request.setAttribute("formBean", formBean);
				result = "/regist.jsp";
			} else {
				User user = new User();
				// 注册类型转换器
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				// 把ForkBean中的数据转移到User中 填充模型
				BeanUtils.copyProperties(user, formBean);
				s.regist(user);
				request.setAttribute("message", "保存成功&nbsp;&nbsp;<a href="
						+ request.getContextPath() + ">主页</a>");
				result = "/message.jsp";
			}
		} catch (UsernameExistException e) {
			formBean.getErrors().put("username", "用户名被占用！");
			request.setAttribute("formBean", formBean);
			result = "/regist.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "对不起！服务器忙");
			result = "/message.jsp";
		}

		request.getRequestDispatcher(result).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
