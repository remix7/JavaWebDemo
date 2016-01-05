package com.remix.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.remix.domain.Customer;
import com.remix.domain.Page;
import com.remix.service.CustomerService;
import com.remix.service.impl.CustomerServiceImpl;
//查询所有的客户信息
public class ShowAllCustomerServlet extends HttpServlet {
	private CustomerService s = new CustomerServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		List<Customer> customerList = s.findAll();
//		request.setAttribute("customerList", customerList);
//		request.getRequestDispatcher("/listCustomer.jsp").forward(request, response);
		//分页操作
		String pagenum = request.getParameter("pagenum");
		Page page = s.findPageRecords(pagenum);
		page.setServletUrl("/servlet/ShowAllCustomerServlet");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/listCustomer.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
