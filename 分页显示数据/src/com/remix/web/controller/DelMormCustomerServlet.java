package com.remix.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.remix.service.CustomerService;
import com.remix.service.impl.CustomerServiceImpl;
//删除用户选中的数据
public class DelMormCustomerServlet extends HttpServlet {

	private CustomerService s = new CustomerServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids[] = request.getParameterValues("ids");
		if(ids!=null&&ids.length>0){
			for(String customerId:ids){
				s.delCustomerById(customerId);
			}
		}
//		request.setAttribute("message", "删除成功!");
//		request.getRequestDispatcher("/message.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
