package com.remix.dao;

import java.util.List;

import com.remix.domain.Customer;
import com.remix.exception.IdIsNullException;

public interface CustomerDao {
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
	@Deprecated
	List<Customer> findAll();
	/**
	 * ����Id��ѯ�ͻ���Ϣ
	 * @param customerId
	 * @return
	 */
	Customer findCustomerById(String customerId);
	//�������ҳ�й�
	/**
	 * ��ѯ��¼������
	 */
	int getTotalRecords();
	/**
	 * ��ѯ��ҳ����
	 * @param startIndex  ÿҳ��ʼ�ļ�¼
	 * @param pagesize ÿҳ��ʾ������
	 * @return
	 */
	List<Customer> findPageRecords(int startIndex,int pagesize);
}
