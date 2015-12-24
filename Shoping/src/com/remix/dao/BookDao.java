package com.remix.dao;

import java.util.Map;

import com.remix.domain.Book;

/**
 * �鼮����dao�ӿ�
 * @author REMIX-7
 *
 */
public interface BookDao {
	/**
	 * ��ѯ���е���
	 * @return  map key���id  value�������
	 */
	Map<String , Book> findAllBooks();
	
	/**
	 * �������Id����
	 * @param bookId
	 * @return
	 */
	Book findBookById(String bookId);
	
}
