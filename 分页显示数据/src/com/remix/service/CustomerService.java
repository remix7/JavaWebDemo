package com.remix.service;

import java.util.List;

import com.remix.domain.Customer;
import com.remix.domain.Page;
import com.remix.exception.IdIsNullException;

public interface CustomerService {
	/**
	 * ��ӿͻ���Ϣ
	 * @param c
	 */
	void addCustomer(Customer c);
	/**
	 * �����û�Id��ɾ���û�
	 * @param customerId
	 */
	void delCustomerById(String customerId);
	/**
	 * �����û���Ϣ
	 * @param c
	 * @throws IdIsNullException ���c��idΪnull �׳��쳣
	 */
	void updateCustomer(Customer c)throws IdIsNullException;
	/**
	 * ��ѯ�����û�����Ϣ
	 * @return
	 */
	List<Customer> findAll();
	/**
	 * ����Id��ѯ�ͻ���Ϣ
	 * @param customerId
	 * @return
	 */
	Customer findCustomerById(String customerId);
	//�������ҳ�й�
	/**
	 *�����û�Ҫ����ҳ�뷵�ط�װ��ҳ�й����ݵĶ���
	 */
	Page findPageRecords(String pagenum);
}
