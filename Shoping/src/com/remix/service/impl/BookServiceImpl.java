package com.remix.service.impl;

import java.util.Map;

import com.remix.dao.BookDao;
import com.remix.dao.impl.BookDaoImpl;
import com.remix.domain.Book;
import com.remix.domain.Cart;
import com.remix.domain.CartItem;
import com.remix.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao dao = new BookDaoImpl();
	public Map<String, Book> findAllBooks() {
		return dao.findAllBooks();
	}
	public Book findBookById(String bookId) {
		return dao.findBookById(bookId);
	}
	public void addBook2Cart(Cart cart, Book book) {
		cart.addBook2Cart(book);
	}
	public void changeCartItemNum(String bookId, Cart cart, int num) {
		CartItem item = cart.getItems().get(bookId);
		item.setNum(num);
	}
	public void delOneItem(Cart cart, String bookId) {
		cart.getItems().remove(bookId);
	}

}
