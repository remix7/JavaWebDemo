package com.remix.service.impl;

import java.util.List;
import java.util.UUID;

import com.remix.dao.CustomerDao;
import com.remix.dao.impl.CustomerDaoImpl;
import com.remix.domain.Customer;
import com.remix.domain.Page;
import com.remix.exception.IdIsNullException;
import com.remix.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao cd = new CustomerDaoImpl();
	public void addCustomer(Customer c) {
		c.setId(UUID.randomUUID().toString());
		cd.addCustomer(c);
	}

	public void delCustomerById(String customerId) {
		cd.delCustomerById(customerId);
	}

	public List<Customer> findAll() {
		return cd.findAll();
	}

	public Customer findCustomerById(String customerId) {
		return cd.findCustomerById(customerId);
	}

	public void updateCustomer(Customer c) throws IdIsNullException {
		cd.updateCustomer(c);
	}

	public Page findPageRecords(String pagenum) {
		/**
		 * 如果用户传进来的是null货空字符 说明第一次访问 默认页码是1
		 */
		int num = 1;
		if(pagenum!=null&&!"".equals(pagenum.trim())){
			num = Integer.parseInt(pagenum);
		}
		int totalRecords = cd.getTotalRecords();
		Page page = new Page(num, totalRecords);//构造page对象 需要当前页码和总条数
		List records = cd.findPageRecords(page.getStartIndex(), page.getPagesize());
		page.setRecords(records);
		return page;
	}

}
