package cc.cynara.bookstore.service;

import java.util.List;

import cc.cynara.bookstore.domain.Book;
import cc.cynara.bookstore.domain.Cart;
import cc.cynara.bookstore.domain.Category;
import cc.cynara.bookstore.domain.Orders;
import cc.cynara.bookstore.domain.Page;
import cc.cynara.bookstore.domain.User;

public interface BusnessService {
	/**
	 * 添加分类
	 * @param c
	 */
	void addCategory(Category c);
	/**
	 * 查询所有分类
	 * @return 返回所有分类
	 */
	List<Category> findAllCategory();
	/**
	 * 修改分类
	 * @param c
	 */
	void updateCategory(Category c);
	/**
	 * 根据id删除分类
	 * @param categoryId
	 */
	void delCategory(String categoryId);
	/**
	 * 根据id查询分类
	 * @param categoryId
	 * @return 没有则返回null
	 */
	Category findCategoryById(String categoryId);
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
	 * 后台查询图书
	 * @param pagenum
	 * @return
	 */
	Page findPageRecords(String pagenum);
	/**
	 * 根据页数 和categoryId来查询图书
	 * @param pagenum
	 * @param categoryId
	 * @return
	 */
	Page findPageRecords(String pagenum, String categoryId);
	/**
	 * 根据Id查书
	 * @param bookId
	 * @return
	 */
	Book findBookById(String bookId);
	/**
	 * 新用户注册
	 * @param user
	 */
	void regist(User user);
	/**
	 * 根据用户名和密码查询用户
	 * @param username
	 * @param password
	 * @return
	 */
	User findUser(String username, String password);
	/**
	 * 生成订单
	 * @param cart
	 * @param user
	 */
	void addOrders(Orders orders, User user);
	/**
	 * 用户查看修改订单  根据用户的Id
	 * @param id
	 * @return
	 */
	List<Orders> findOrdersByUserId(String id);
	/**
	 * 根据订单号查询出订单和用户的信息
	 * @param orderId
	 * @return
	 */
	Orders findORdersById(String orderId);
	/**
	 * 根据编码查询订单信息
	 * @param i
	 * @return
	 */
	List<Orders> findOrdersByState(int i);
	/**
	 * 将订单标记为已发货
	 * @param orderId
	 */
	void updateOrder(String orderId);
}
