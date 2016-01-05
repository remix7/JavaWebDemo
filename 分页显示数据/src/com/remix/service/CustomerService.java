package com.remix.service;

import java.util.List;

import com.remix.domain.Customer;
import com.remix.domain.Page;
import com.remix.exception.IdIsNullException;

public interface CustomerService {
	/**
	 * 添加客户信息
	 * @param c
	 */
	void addCustomer(Customer c);
	/**
	 * 根据用户Id来删除用户
	 * @param customerId
	 */
	void delCustomerById(String customerId);
	/**
	 * 更新用户信息
	 * @param c
	 * @throws IdIsNullException 如果c的id为null 抛出异常
	 */
	void updateCustomer(Customer c)throws IdIsNullException;
	/**
	 * 查询所有用户的信息
	 * @return
	 */
	List<Customer> findAll();
	/**
	 * 根据Id查询客户信息
	 * @param customerId
	 * @return
	 */
	Customer findCustomerById(String customerId);
	//以下与分页有关
	/**
	 *根据用户要看的页码返回封装分页有关数据的对象
	 */
	Page findPageRecords(String pagenum);
}
