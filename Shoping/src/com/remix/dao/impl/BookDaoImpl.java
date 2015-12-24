package com.remix.dao.impl;

import java.util.Map;

import com.remix.dao.BookDao;
import com.remix.db.BookDB;
import com.remix.domain.Book;

public class BookDaoImpl implements BookDao {

	public Map<String, Book> findAllBooks() {
		return BookDB.findAllBooks();
	}

	public Book findBookById(String bookId) {
		return BookDB.findBookById(bookId);
	}

}
