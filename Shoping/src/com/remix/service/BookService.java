package com.remix.service;

import java.util.Map;

import com.remix.domain.Book;
import com.remix.domain.Cart;

public interface BookService {
	Map<String , Book> findAllBooks();

	Book findBookById(String bookId);

	void addBook2Cart(Cart cart, Book book);

	void changeCartItemNum(String bookId, Cart cart, int num);

	void delOneItem(Cart cart, String bookId);


	
}
