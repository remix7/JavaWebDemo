package cc.cynara.bookstore.service.impl;

import java.util.List;
import java.util.UUID;

import javax.print.attribute.standard.PageRanges;

import cc.cynara.bookstore.dao.BookDao;
import cc.cynara.bookstore.dao.CategoryDao;
import cc.cynara.bookstore.dao.OrdersDao;
import cc.cynara.bookstore.dao.UserDao;
import cc.cynara.bookstore.dao.impl.BookDaoImpl;
import cc.cynara.bookstore.dao.impl.CategoryDaoImpl;
import cc.cynara.bookstore.dao.impl.OrdersDaoImpl;
import cc.cynara.bookstore.dao.impl.UserDaoImpl;
import cc.cynara.bookstore.domain.Book;
import cc.cynara.bookstore.domain.Cart;
import cc.cynara.bookstore.domain.Category;
import cc.cynara.bookstore.domain.OrderItem;
import cc.cynara.bookstore.domain.Orders;
import cc.cynara.bookstore.domain.Page;
import cc.cynara.bookstore.domain.User;
import cc.cynara.bookstore.service.BusnessService;
import cc.cynara.bookstore.util.OrdersId;

public class BusnessServiceImpl implements BusnessService {
	private CategoryDao cd = new CategoryDaoImpl();
	private BookDao bd = new BookDaoImpl();
	private UserDao ud = new UserDaoImpl();
	private OrdersDao od = new OrdersDaoImpl();
	public void addCategory(Category c) {
		c.setId(UUID.randomUUID().toString());
		cd.addCategory(c);
	}

	public void delCategory(String categoryId) {
		cd.delCategory(categoryId);

	}

	public List<Category> findAllCategory() {
		return cd.findAllCategory();
	}

	public Category findCategoryById(String categoryId) {
		return cd.findCategoryById(categoryId);
	}

	public void updateCategory(Category c) {
		cd.updateCategory(c);
	}

	public void addBook(Book book) {
		book.setId(UUID.randomUUID().toString());
		bd.addBook(book);
		
	}

	public List<Book> findAllBook() {
		return bd.findAllBook();
	}

	public Page findPageRecords(String pagenum) {
		int num = 1;
		if(pagenum!=null&&!"".equals(pagenum)){
			num = Integer.parseInt(pagenum);
		}
		int totalrecords = bd.getTotalRecord();
		Page page = new Page(num, totalrecords);
		List records = bd.findPageBooks(page.getStartindex(), page.getPagesize());
		page.setRecords(records);
		
		return page;
	}

	public Page findPageRecords(String pagenum, String categoryId) {
		int num = 1;
		if(pagenum!=null&&!"".equals(pagenum)){
			num = Integer.parseInt(pagenum);
		}
		int totalrecords = bd.getTotalRecord(categoryId);
		Page page = new Page(num, totalrecords);
		List records = bd.findPageBooks(page.getStartindex(), page.getPagesize(),categoryId);
		page.setRecords(records);
		
		return page;
	}

	public Book findBookById(String bookId) {
		return bd.findBookById(bookId);
	}

	public void regist(User user) {
		user.setId(UUID.randomUUID().toString());
		ud.addUser(user);
	}

	public User findUser(String username, String password) {
		return ud.findUser(username, password);
	}

	public void addOrders(Orders orders, User user) {
		orders.setId(UUID.randomUUID().toString());
		orders.setOrdernum(OrdersId.getOrderId());
		//购物项 添加id
		List<OrderItem> items = orders.getItems();
		for (OrderItem orderItem : items) {
			orderItem.setId(UUID.randomUUID().toString());
		}
		od.addOrders(orders,user);
	}

	public List<Orders> findOrdersByUserId(String id) {
		return od.findOrdersByUserId(id);
	}

	public Orders findORdersById(String orderId) {
		return od.findORdersById(orderId);
	}

	public List<Orders> findOrdersByState(int i) {
		return od.findOrdersByState(i);
	}

	public void updateOrder(String orderId) {
		 od.updateOrder(orderId);
	}


}
