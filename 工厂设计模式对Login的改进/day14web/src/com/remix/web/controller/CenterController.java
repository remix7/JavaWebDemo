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

	// ע����¼
	private void logOff(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) {
		// request.getSession().invalidate();
		request.getSession().removeAttribute("user");
		out.write("ע���ɹ�2�����ת����ҳ");
		response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "");
	}

	// �û���¼
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String username = request.getParameter("username");
		// String password = request.getParameter("password");

		LoginFormBean formBean = null;
		String result = "";
		formBean = WebFormBeanUtils.fillFormBean(request, LoginFormBean.class);
		if (!formBean.validate()) {
			// ��֤��ͨ�������ݻ���ʾ ��Ҫ��ʾ����Ĵ�����Ϣ
			request.setAttribute("formBean", formBean);
			result = "/login.jsp";
		} else {
			User user = s.login(formBean.getUsername(), formBean.getPassword());
			if (user == null) {
//				formBean.getErrors().put("message", "�Բ����û������ٻ��û����������");
				request.setAttribute("message", "�Բ����û������ٻ��û����������");
				request.setAttribute("formBean", formBean);
				result = "/login.jsp";
			} else {
				// request.setAttribute("message", user.getNick()+"����ӭ��");
				// result = "/message.jsp";
				request.getSession().setAttribute("user", user);
				// formBean.getErrors().put("message",
				// "��ӭ��"+formBean.getUsername());
				request.setAttribute("formBean", formBean);
				result = "/index.jsp";
			}
		}
		// System.out.println(username+password);
		request.getRequestDispatcher(result).forward(request, response);
	}

	// �û�ע��
	private void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RegistFormBean formBean = null;
		String result = "";// ���ҳ���URl
		try {
			// ��ȡ�û����������
			formBean = WebFormBeanUtils.fillFormBean(request,
					RegistFormBean.class);
			// ��װ����֤ RegistFormBean
			if (!formBean.validate()) {
				// ��֤��ͨ�������ݻ���ʾ ��Ҫ��ʾ����Ĵ�����Ϣ
				request.setAttribute("formBean", formBean);
				result = "/regist.jsp";
			} else {
				User user = new User();
				// ע������ת����
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				// ��ForkBean�е�����ת�Ƶ�User�� ���ģ��
				BeanUtils.copyProperties(user, formBean);
				s.regist(user);
				request.setAttribute("message", "����ɹ�&nbsp;&nbsp;<a href="
						+ request.getContextPath() + ">��ҳ</a>");
				result = "/message.jsp";
			}
		} catch (UsernameExistException e) {
			formBean.getErrors().put("username", "�û�����ռ�ã�");
			request.setAttribute("formBean", formBean);
			result = "/regist.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "�Բ��𣡷�����æ");
			result = "/message.jsp";
		}

		request.getRequestDispatcher(result).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
