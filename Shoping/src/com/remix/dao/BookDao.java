package com.remix.dao;

import java.util.Map;

import com.remix.domain.Book;

/**
 * 书籍操作dao接口
 * @author REMIX-7
 *
 */
public interface BookDao {
	/**
	 * 查询所有的书
	 * @return  map key书的id  value是书对象
	 */
	Map<String , Book> findAllBooks();
	
	/**
	 * 根据书的Id查书
	 * @param bookId
	 * @return
	 */
	Book findBookById(String bookId);
	
}
