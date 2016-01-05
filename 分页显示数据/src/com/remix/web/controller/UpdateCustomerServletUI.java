package com.remix.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//修改用户数据

import com.remix.domain.Customer;
import com.remix.service.CustomerService;
import com.remix.service.impl.CustomerServiceImpl;
public class UpdateCustomerServletUI extends HttpServlet {

	private CustomerService s = new CustomerServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customerId = request.getParameter("customerId");
		Customer c = s.findCustomerById(customerId);
		request.setAttribute("c", c);
		request.getRequestDispatcher("/editCustomer.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
