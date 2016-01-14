package cc.cynara.bookstore.dao;

import java.util.List;

import cc.cynara.bookstore.domain.Book;

public interface BookDao {
	/**
	 * 添加图书
	 * @param book
	 */
	void addBook(Book book);
	/**
	 * 查询所有图书
	 * @return
	 */
	List<Book> findAllBook();
	/**
	 * 查询所有记录条数
	 * @return
	 */
	int getTotalRecord();
	/**
	 * 
	 * @param startIndex
	 * @param pagesize
	 * @return
	 */
	List<Book> findPageBooks(int startIndex,int pagesize);
	/**
	 * 获取categoryId对用的那本书
	 * @param categoryId
	 * @return
	 */
	int getTotalRecord(String categoryId);
	
	List findPageBooks(int startindex, int pagesize, String categoryId);
	/**
	 * 根据ID查书
	 * @param bookId
	 * @return
	 */
	Book findBookById(String bookId);
}
